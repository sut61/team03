package com.sut.se.g03.controller;

import com.sut.se.g03.controller.model.BookingModel;
import com.sut.se.g03.entity.*;
import com.sut.se.g03.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, value = "")
@CrossOrigin(origins = "http://localhost:4200")
public class RoomReserveController {

    @Autowired private RoomTypeRepository roomTypeRepository;
    @Autowired private RoomSizeRepository roomSizeRepository;
    @Autowired private RoomRepository roomRepository;
    @Autowired private ScheduleRepository scheduleRepository;
    @Autowired private TimeTableRepository timeTableRepository;
    @Autowired private TimePeriodRepository timePeriodRepository;
    @Autowired private MemberRepository memberRepository;
    @Autowired private BillRepository billRepository;
    @Autowired private BillRoomRepository billRoomRepository;
    @Autowired private BillInfoRepository billInfoRepository;
    @Autowired private RoomInstrumentRepository roomInstrumentRepository;
    @Autowired private PaidStatusRepository paidStatusRepository;
    @Autowired private StatusRoomRepository statusRoomRepository;
    @Autowired private ContactRepository contactRepository;

    private final String PRACTICE_ROOM_TYPE_NAME = "practice";
    private final String RECORD_ROOM_TYPE_NAME = "record";
    private final String NOT_PAID_STATUS_NAME = "ยังไม่จ่ายเงิน";

    private final String OPENED_ROOM = "ใช้งาน";

    private boolean isPracticeRoom(RoomType roomType){
        return roomTypeRepository.findByType(PRACTICE_ROOM_TYPE_NAME) == roomType;
    }
    private boolean isRecordRoom(RoomType roomType){
        return roomTypeRepository.findByType(RECORD_ROOM_TYPE_NAME) == roomType;
    }

    @GetMapping("/reserve/type")
    public List<RoomType> getAllRoomType(){
        return roomTypeRepository.findAll();
    }

    @GetMapping("/reserve/size")
    public List<RoomSize> getAllRoomSize(){
        return roomSizeRepository.findAll();
    }

    @GetMapping("/reserve/room/{roomID}")
    public RoomType getRoomTypeByRoom(@PathVariable Long roomID){
        return roomRepository.getOne(roomID).getRoomType();
    }

    @GetMapping("/reserve/{roomID}")
    public Optional<Room> getRoomById(@PathVariable Long roomID){
        return roomRepository.findById(roomID);
    }

    @GetMapping("/reserve/date")
    public List<Schedule> getAllSchedule(){
        return scheduleRepository.findAll();
    }

    @GetMapping("/reserve/select/{roomID}/{dateID}")
    public Collection<TimeTable> getTimeByDateAndRoom(@PathVariable Long roomID,
													  @PathVariable Long dateID){
        return timeTableRepository.findAllByRoomAndAndSchedule(roomRepository.findById(roomID),
                scheduleRepository.findById(dateID));
    }

    @GetMapping("/reserve/rooms/{typeId}/{sizeId}")
    public Collection<Room> getRooms(@PathVariable Long typeId, @PathVariable Long sizeId){
        return roomRepository.findAllByRoomSizeAndRoomTypeAndStatusRoom(roomSizeRepository.findById(sizeId)
                ,roomTypeRepository.findById(typeId), statusRoomRepository.findByName(OPENED_ROOM));
    }

    @PutMapping("/reserve/reserve/{roomID}/{dateID}")
    @Transactional
    public ResponseEntity<Object> reserve(@PathVariable Long roomID,
                                          @PathVariable Long dateID,
                                          @RequestBody BookingModel booking){
        final int DAYHOUR = 12;
        float price;
        final boolean RESERVE_STATUS = true;
        PaidStatus notPaid = paidStatusRepository.findByName(NOT_PAID_STATUS_NAME).get();
        Room room = roomRepository.getOne(roomID);
        Schedule schedule = scheduleRepository.getOne(dateID);
        Member member = memberRepository.findByUserName(booking.getUsername());
        String content;
            if (isPracticeRoom(room.getRoomType())) {
            	// loop to set all time in array
                for (Long t : booking.getTimeData()) {
                    TimeTable timeTable = timeTableRepository.getOne(t);
                    if (timeTable.isReserve())// to restore to previous state
                        throw new RuntimeException();
                    timeTable.setReserve(RESERVE_STATUS);
                    timeTable.setMember(member);
                    timeTableRepository.saveAndFlush(timeTable);
                }
                price = booking.getTimeData().length * room.getRate();
                content = createContent(booking.getTimeData().length, room.getRoomType(),room.getName());
            } else {
            	//record room
                TimeTable timeTable = timeTableRepository.findByRoomAndSchedule(room, schedule);
                if (timeTable.isReserve())
                    throw new RuntimeException();
                timeTable.setReserve(RESERVE_STATUS);
                timeTable.setMember(member);
                timeTableRepository.saveAndFlush(timeTable);
                price = DAYHOUR * room.getRate();
                content = createContent(DAYHOUR, room.getRoomType(), room.getName());
            }
            Date localDate = Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
            Bill bill = billRepository.save(new Bill(localDate, price, member, notPaid));
            contactRepository.save(new Contact(booking.getBookingName(), booking.getBookingTel(), bill));
            contactRepository.save(new Contact(booking.getBookingNameSecond(), booking.getBookingTelSecond(), bill));
            billInfoRepository.save(new BillInfo(content, price, bill));
            billRoomRepository.save(new BillRoom(room, bill));
        return new ResponseEntity<>("booking complete",HttpStatus.ACCEPTED);
    }

    private String createContent(int hour, RoomType roomType, String roomname){
        if (isPracticeRoom(roomType))
            return "จองห้องซ้อม " + roomname + " " + hour + " ชั่วโมง";
        else if(isRecordRoom(roomType))
            return "จองห้องบันทึก " + roomname;
        else
            throw new RuntimeException();
    }

}
