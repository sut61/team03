package com.sut.se.g03.controller;

import com.sut.se.g03.G03Application;
import com.sut.se.g03.entity.*;
import com.sut.se.g03.repository.*;
import java.util.*;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.*;
import java.util.stream.Collectors;
import java.security.Timestamp;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class BillController{

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


    

    @GetMapping("/bill")
    public Collection<Bill> bill(){
        return billRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/Bill/{billId}")
    public Optional<Bill> takeinBillByid(@PathVariable Long billId ){
        return billRepository.findById(billId);
    }

    @GetMapping("/PaidStatus")
    public Collection<PaidStatus> paidstatus(){
        return  paidStatusRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/PaidStatus/{paidstatusId}")
    public Optional<PaidStatus> takeinPaidStatusByid(@PathVariable Long paidstatusId ){
        return  paidStatusRepository.findById(paidstatusId);
    }

    @GetMapping("/Room")
    public Collection<Room> room(){
        return  roomRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/Room/{roomId}")
    public Optional<Room> takeinRoomByid(@PathVariable Long roomId ){
        return  roomRepository.findById(roomId);
    }

    @GetMapping("/BillRoom")
    public Collection<BillRoom> billroom(){
        return  billRoomRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/BillRoom/{billRoomId}")
    public Optional<BillRoom> takeinBillRoomByid(@PathVariable Long billRoomId ){
        return  billRoomRepository.findById(billRoomId);
    }

    @PutMapping("/bill/updateBill/{billId}/{date}/{paidStatusId}/{MemberId}")
    public Bill upgradeBill(@PathVariable Long billId, @PathVariable Date date, @PathVariable Long paidStatusId, @PathVariable Long memberId ){
        Bill upgradeBill = new Bill();
        Member member = memberRepository.findById(memberId).get();
        PaidStatus paidstatus = paidStatusRepository.findById(paidStatusId).get();
        upgradeBill.setDate(new Date());
        upgradeBill.setMember(member);
        upgradeBill.setPaidStatus(paidstatus);
       
        
        return billRepository.save(upgradeBill);
    }


   @PostMapping("/bill")
    public BillInfo addBill(BillInfo newBillInfo,@RequestBody Map<String, String> body){
        Optional<Bill> bill = billRepository.findById(Long.valueOf(body.get("billid")));

        newBillInfo.setBill(bill.get());
        newBillInfo.setContent(body.get("comment"));
        newBillInfo.setPrice(Float.valueOf(body.get("price")));

        bill.get().setTotalPrice(Float.valueOf(body.get("price")) + bill.get().getTotalPrice());
        billRepository.save(bill.get());
        
        return billInfoRepository.save(newBillInfo);
    }

    
}