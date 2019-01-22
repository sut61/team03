package com.sut.se.g03;

import com.sut.se.g03.entity.*;
import com.sut.se.g03.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Time;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class G03Application {

	public static void main(String[] args) {
		SpringApplication.run(G03Application.class, args);
	}

	private static final Logger logger = LoggerFactory.getLogger(G03Application.class);

	@Autowired	private TimePeriodRepository timePeriodRepository;
	@Autowired  private ScheduleRepository scheduleRepository;
	@Autowired  private MemberRepository memberRepository;
	@Autowired	private MemberInfoRepository memberInfoRepository;
	@Autowired	private RoomRepository roomRepository;
	@Autowired	private RoomTypeRepository roomTypeRepository;
	@Autowired	private RoomSizeRepository roomSizeRepository;
	@Autowired	private StatusRoomRepository statusRoomRepository;
	@Autowired	private TimeTableRepository timeTableRepository;


	@Bean
	ApplicationRunner init(){
		return args -> {
			createNewUser("1234","zzzz");
			createNewUser("admin","admin");
			createPeriodTable();
			createScheduleTable();
			createRoom();
			createTimeTable();
			logger.info("Initializing Complete");
		};
	}

	private void createNewUser(String plainPassword,String userName) throws Exception {
		memberRepository.save(new Member(userName,plainPassword));
	}

	private void createPeriodTable(){
		for(int i = 0 ; i < 12 ; i++) {
			Time start = Time.valueOf("10:00:00");
			Time end = Time.valueOf("11:00:00");
			timePeriodRepository.save(new TimePeriod(Time.valueOf(start.toLocalTime().plusHours(i)),
					Time.valueOf(end.toLocalTime().plusHours(i))));
		}
		timePeriodRepository.save(new TimePeriod(Time.valueOf("10:00:00"),Time.valueOf("22:00:00")));
	}

	private void createScheduleTable(){
		LocalDate localDate = LocalDate.now();
		for(int i = 0 ; i < 7 ; i++) {
			scheduleRepository.save(new Schedule(Date.from(localDate.plusDays(i).atStartOfDay()
					.atZone(ZoneId.systemDefault()).toInstant())));
		}
	}

	private void createRoom(){
		RoomSize size5 = roomSizeRepository.save(new RoomSize(5));
		RoomSize size7 = roomSizeRepository.save(new RoomSize(7));
		RoomSize size9 = roomSizeRepository.save(new RoomSize(9));
		RoomType rec = roomTypeRepository.save(new RoomType("record"));
		RoomType pra = roomTypeRepository.save(new RoomType("practice"));
		StatusRoom open = statusRoomRepository.save(new StatusRoom("ใช้งาน"));
		StatusRoom close = statusRoomRepository.save(new StatusRoom("ปิดใช้งาน"));
		roomRepository.save(new Room("R101",200,size5,rec,open));
		roomRepository.save(new Room("R102",250,size7,rec,open));
		roomRepository.save(new Room("R103",200,size5,rec,open));
		roomRepository.save(new Room("R104",300,size9,rec,open));
		roomRepository.save(new Room("P101",100,size5,pra,close));
		roomRepository.save(new Room("P102",150,size7,pra,close));
		roomRepository.save(new Room("P103",100,size5,pra,close));
		roomRepository.save(new Room("P104",190,size9,pra,close));
	}

	private void createTimeTable(){
		List<Room> rooms = roomRepository.findAll();
		List<Schedule> schedules = scheduleRepository.findAll();
		List<TimePeriod> timePeriods = timePeriodRepository.findAll();
		RoomType record = roomTypeRepository.findByType("record");
		Room[] room = rooms.toArray(new Room[0]);
		Schedule[] schedule = schedules.toArray(new Schedule[0]);
		TimePeriod[] timePeriod = timePeriods.toArray(new TimePeriod[0]);
		for(Room r:room){
			for(Schedule s:schedule) {
				if (r.getRoomType().equals(record)) {
					timeTableRepository.save(new TimeTable(s,timePeriod[timePeriod.length-1],r));
				} else {
					for (int i = 0; i < timePeriod.length-1 ; i++) {
						timeTableRepository.save(new TimeTable(s,timePeriod[i],r));
					}
				}
			}
		}
	}

}

