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
import java.util.stream.Stream;

@SpringBootApplication
public class G03Application {

	public static void main(String[] args) {
		SpringApplication.run(G03Application.class, args);
	}

	private static final Logger logger = LoggerFactory.getLogger(G03Application.class);

	@Autowired
	private TimePeriodRepository timePeriodRepository;
	@Autowired
	private ScheduleRepository scheduleRepository;
	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private MemberInfoRepository memberInfoRepository;
	@Autowired
	private RoomRepository roomRepository;
	@Autowired
	private RoomTypeRepository roomTypeRepository;
	@Autowired
	private RoomSizeRepository roomSizeRepository;
	@Autowired
	private StatusRoomRepository statusRoomRepository;
	@Autowired
	private TimeTableRepository timeTableRepository;
	@Autowired
	private InstrumentRepository instrumentRepository;
	@Autowired
	private PaidStatusRepository paidStatusRepository;
	@Autowired
	private CreditTypeRepository creditTypeRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private ProvinceRepository provinceRepository;
	@Autowired
	private DistrictRepository districtRepository;
	@Autowired
	private BillRepository billRepository;
	@Autowired
	private BillInfoRepository billInfoRepository;
	@Autowired
	private BillRoomRepository billRoomRepository;
	@Autowired
	private StatusCourseRepository statusCourseRepository;
	@Autowired
	private ScoreRepository scoreRepository;
	@Autowired
	private ServiceTypeRepository serviceTypeRepository;

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private PromotionRepository promotionRepository;
	@Autowired
	private StaffRepository staffRepository;
	@Autowired
	private TypepromotionRepository typepromotionRepository;
	@Autowired
	private ClassifyStatusRepository classifyStatusRepository;
	@Autowired
	private ClassifyRepository classifyRepository;
	@Autowired
	private ItemTypeRepository itemTypeRepository;
	@Autowired  
	private CourseMusicRepository courseMusicRepository;
	@Autowired  
	private PaymentTypeRepository paymentTypeRepository;
	@Autowired  
	private CourseTimeRepository courseTimeRepository;
	@Autowired  
	private ClassroomRepository classroomRepository;

	@Autowired
	private InstruTypeRepository instruTypeRepository;
	@Autowired
	private CustomerFixRepository customerFixRepository;
	@Autowired
	private ItemFixRepository itemFixRepository;
	@Autowired
	private DatainfoRepository datainfoRepository;
	@Autowired
	private ManagerinfoRepository managerinfoRepository;
	@Autowired
	private FixMainRepository fixMainRepository;
	@Autowired
	private ContactRepository contactRepository;

	@Bean
	ApplicationRunner init() {
		return args -> {
			createNewUser("1234", "zzzz");
			createNewUser("admin", "admin");
			createPeriodTable();
			createScheduleTable();
			createRoom();
			createTimeTable();
			createCourseMusic();
			createPaidStatus("จ่ายแล้ว");
			createPaidStatus("ยังไม่จ่ายเงิน");
			createStatusCourse("ยืนยันการจอง");
			Bill b = new Bill(new Date(), 1200f, memberRepository.findById(1L).get(),
					paidStatusRepository.findByName("จ่ายแล้ว").get());
			billRepository.save(b);
			contactRepository.save(new Contact("abcde fghij", "0823456789", b));
			contactRepository.save(new Contact("abcde fghijk", "0923456789", b));
			billRoomRepository.save(new BillRoom(roomRepository.findById(1L).get(), billRepository.findById(1L).get()));
			billInfoRepository.save(new BillInfo("จ่ายค่าห้อง 1000", 1000f, billRepository.findById(1L).get()));
			ClassifyStatus used = classifyStatusRepository.save(new ClassifyStatus("ใช้งาน"));
			classifyStatusRepository.save(new ClassifyStatus("ไม่ใช้งาน"));
			classifyRepository.save(new Classify("เครื่องดนตรี", "เครื่องดนตรีที่ขายภสยในร้าน", used));
			classifyRepository.save(new Classify("ของใช้", "อุปกรณ์ปรับเปลี่ยนของเครื่องดนตรี", used));
			itemTypeRepository.save(new ItemType("กลองชุด"));
			itemTypeRepository.save(new ItemType("กีต้า"));
			courseMusicRepository.save(new CourseMusic("อาจารย์ฟี่","จอมยุทธ์","ฟี่ซ่า","0986270527",memberRepository.findById(2L).get(),classroomRepository.findById(6L).get(),paymentTypeRepository.findById(1L).get(),instrumentRepository.findById(1L).get(),courseTimeRepository.findById(1L).get()));
		};
	}

	@Bean
	ApplicationRunner init2() {
		return args -> {
			CreditType c1 = new CreditType();
			c1.setType("กรุงเทพ");
			CreditType c2 = new CreditType();
			c2.setType("กสิกรไทย");
			CreditType c3 = new CreditType();
			c3.setType("กรุงไทย");
			CreditType c4 = new CreditType();
			c4.setType("ไทยพาณิชย์");
			creditTypeRepository.save(c1);
			creditTypeRepository.save(c2);
			creditTypeRepository.save(c3);
			creditTypeRepository.save(c4);

		};
	}

	@Bean
	ApplicationRunner init6() {
		return args -> {
			ServiceType st1 = new ServiceType();
			st1.setTypeService("บริการเช้าห้องซ้อมดนตรี");
			serviceTypeRepository.save(st1);
			ServiceType st2 = new ServiceType();
			st2.setTypeService("บริการร้านค้าซื้ออุปกรณ์ดนตรี");
			serviceTypeRepository.save(st2);
		};
	}

	@Bean
	ApplicationRunner innit7() {
		return args -> {
			Score s1 = new Score();
			Score s2 = new Score();
			Score s3 = new Score();
			Score s4 = new Score();
			Score s5 = new Score();
			s1.setScore(1);
			s2.setScore(2);
			s3.setScore(3);
			s4.setScore(4);
			s5.setScore(5);
			scoreRepository.save(s1);
			scoreRepository.save(s2);
			scoreRepository.save(s3);
			scoreRepository.save(s4);
			scoreRepository.save(s5);

		};
	}

	@Bean
	ApplicationRunner init5() {
		return args -> {
			Stream.of("นครราชสีมา", "ขอนแก่น", "ชัยภูมิ").forEach(province -> {
				Province provinceshop = new Province();
				provinceshop.setProvince(province);
				provinceRepository.save(provinceshop);
			});

			Stream.of("Mr.brain", "Mr.Doggy").forEach(managerName -> {
				Managerinfo managerinfo = new Managerinfo();
				managerinfo.setManagerName(managerName);
				if(managerName == "Mr.brain"){
					managerinfoRepository.save(managerinfo);
				}
				if(managerName == "Mr.Doggy"){
					managerinfoRepository.save(managerinfo);
				}
			});

			Stream.of("String Instruments", "Woodwind Instruments","Brass Instruments", "Keyboard Instruments","Percussion Instruments").forEach(instumentType -> {
				InstruType instruType = new InstruType();
				instruType.setInstumentType(instumentType);
				if(instumentType == "String Instruments"){
					instruTypeRepository.save(instruType);
				}
				if(instumentType == "Woodwind Instruments"){
					instruTypeRepository.save(instruType);
				}
				if(instumentType == "Brass Instruments"){
					instruTypeRepository.save(instruType);
				}
				if(instumentType == "Keyboard Instruments"){
					instruTypeRepository.save(instruType);
				}
				if(instumentType == "Percussion Instruments"){
					instruTypeRepository.save(instruType);
				}

			});

			Stream.of("สวยพี่สวย", "ก็มาดิครับ").forEach(data -> {
				Datainfo datainfo = new Datainfo();
				datainfo.setData(data);
				if(data == "สวยพี่สวย"){
					datainfoRepository.save(datainfo);
				}
				if(data == "ก็มาดิครับ"){
					datainfoRepository.save(datainfo);
				}
			});

			Stream.of("อำเภอแก้งสนามนาง", "อำเภอขามทะเลสอ", "อำเภอขามสะแกแสง", "อำเภอคง", "อำเภอครบุรี", "อำเภอจักราช",
					"อำเภอเฉลิมพระเกียรติ", "อำเภอโชคชัย", "อำเภอชุมพวง", "อำเภอด่านขุนทด", "อำเภอเทพารักษ์",
					"อำเภอโนนไทย", "อำเภอโนนสูง", "อำเภอโนนแดง", "อำเภอบัวลาย", "อำเภอบัวใหญ่", "อำเภอบ้านเหลื่อม",
					"อำเภอประทาย", "อำเภอปักธงชัย", "อำเภอปากช่อง", "อำเภอพระทองคำ", "อำเภอพิมาย",
					"อำเภอเมืองนครราชสีมา", "อำเภอเมืองยาง", "อำเภอลำทะเมนชัย", "อำเภอวังน้ำเขียว", "อำเภอเสิงสาง",
					"อำเภอสีคิ้ว", "อำเภอสีดา", "อำเภอสูงเนิน", "อำเภอหนองบุญมาก", "อำเภอห้วยแถลง")
					.forEach(district -> {
						Province provinceshop = provinceRepository.findById(1L);
						District districtshop = new District();
						districtshop.setDistrict(district);
						districtRepository.save(districtshop);
						provinceshop.getDistrictTran().add(districtshop);
						provinceRepository.save(provinceshop);
					});

			Stream.of("อำเภอกระนวน", "อำเภอเขาสวนกวาง", "อำเภอโคกโพธิ์ไชย", "อำเภอชนบท", "อำเภอชุมแพ", "อำเภอซำสูง",
					"อำเภอน้ำพอง", "อำเภอโนนศิลา", "อำเภอบ้านไผ่", "อำเภอบ้านฝาง", "อำเภอบ้านแฮด", "อำเภอเปือยน้อย",
					"อำเภอพระยืน", "อำเภอพล", "อำเภอภูผาม่าน", "อำเภอภูเวียง", "อำเภอเมืองขอนแก่น", "อำเภอมัญจาคีรี",
					"อำเภอแวงน้อย", "อำเภอแวงใหญ่", "อำเภอเวียงเก่า", "อำเภอสีชมพู", "อำเภอหนองนาคำ", "อำเภอหนองเรือ",
					"อำเภอหนองสองห้อง", "อำเภออุบลรัตน์").forEach(district -> {
						Province provinceshop = provinceRepository.findById(2L);
						District districtshop = new District();
						districtshop.setDistrict(district);
						districtRepository.save(districtshop);
						provinceshop.getDistrictTran().add(districtshop);
						provinceRepository.save(provinceshop);
					});

			Stream.of("อำเภอเกษตรสมบูรณ์", "อำเภอแก้งคร้อ", "อำเภอคอนสวรรค์", "อำเภอคอนสาร", "อำเภอจัตุรัส",
					"อำเภอซับใหญ่", "อำเภอเทพสถิต", "อำเภอเนินสง่า", "อำเภอบ้านเขว้า", "อำเภอบ้านแท่น",
					"อำเภอบำเหน็จณรงค์", "อำเภอภักดีชุมพล", "อำเภอภูเขียว", "อำเภอเมืองชัยภูมิ", "อำเภอหนองบัวแดง",
					"อำเภอหนองบัวระเหว").forEach(district -> {
						Province provinceshop = provinceRepository.findById(3L);
						District districtshop = new District();
						districtshop.setDistrict(district);
						districtRepository.save(districtshop);
						provinceshop.getDistrictTran().add(districtshop);
						provinceRepository.save(provinceshop);
					});

			Stream.of("dekd123", "deklnw1234").forEach(username -> {
				Customer customer = new Customer();
				customer.setUsername(username);
				if (username == "dekd123") {
					customer.setPassword("12345");
					customer.setCustomerName("Mr.Bryan Saoju");
					customer.setTel("0987654321");
					customer.setEmail("sdf@gmail.com");
					customerRepository.save(customer);
				}
				if (username == "deklnw1234") {
					customer.setPassword("123");
					customer.setCustomerName("Mr.Pornhub Sajai");
					customer.setTel("0897687934");
					customer.setEmail("qweqw@gmail.com");
					customerRepository.save(customer);
				}

			});

			Stream.of("Fantasia F100N 41", "Fantasia F100BK 41", "Yamaha F-310", "Yamaha FS100C", "Carlsbro CSD230",
					"ECHOSLAP ST04436", "DW Design6 6-Piece Lacquer Shell Pack",
					"MK 61 Key Electronic Teaching Keyboard").forEach(itemName -> {
						Item item = new Item();
						item.setItemName(itemName);
						if (itemName == "Fantasia F100N 41") {
							item.setPrice(1690);
							item.setItemNum(7);
							item.setPic("https://i1378.photobucket.com/albums/ah101/khnan369/pic3_zpsaoqbnfhq.png");
							itemRepository.save(item);
						}
						if (itemName == "Fantasia F100BK 41") {
							item.setPrice(1690);
							item.setItemNum(5);
							item.setPic("https://i1378.photobucket.com/albums/ah101/khnan369/pic4_zpswv93o1sz.png");
							itemRepository.save(item);
						}
						if (itemName == "Yamaha F-310") {
							item.setPrice(4800);
							item.setItemNum(7);
							item.setPic("http://i1378.photobucket.com/albums/ah101/khnan369/pic5_zpsilrwetkt.png");
							itemRepository.save(item);
						}
						if (itemName == "Yamaha FS100C") {
							item.setPrice(5290);
							item.setItemNum(6);
							item.setPic("https://i1378.photobucket.com/albums/ah101/khnan369/pic6_zpsu7darbrd.png");
							itemRepository.save(item);
						}
						if (itemName == "Carlsbro CSD230") {
							item.setPrice(18000);
							item.setItemNum(6);
							item.setPic("https://i1378.photobucket.com/albums/ah101/khnan369/pic7_zpsw4ee9osx.png");
							itemRepository.save(item);
						}
						if (itemName == "ECHOSLAP ST04436") {
							item.setPrice(23200);
							item.setItemNum(4);
							item.setPic("https://i1378.photobucket.com/albums/ah101/khnan369/pic8_zpsoihdwobz.png");
							itemRepository.save(item);
						}
						if (itemName == "DW Design6 6-Piece Lacquer Shell Pack") {
							item.setPrice(67590);
							item.setItemNum(3);
							item.setPic("http://i1378.photobucket.com/albums/ah101/khnan369/pic9_zpsukju8oo5.png");
							itemRepository.save(item);
						}
						if (itemName == "MK 61 Key Electronic Teaching Keyboard") {
							item.setPrice(1790);
							item.setItemNum(6);
							item.setPic("http://i1378.photobucket.com/albums/ah101/khnan369/pic10_zpsq9ftgae2.png");
							itemRepository.save(item);
						}

					});
		};
	}

	@Bean
	ApplicationRunner init3() {
		return args -> {
			MemberInfo in1 = new MemberInfo();
			in1.setFname("Inw Fee");
			in1.setLname("FeeFee");
			in1.setPhone("012345678");
			in1.setEmail("DR@gg.com");
			memberInfoRepository.save(in1);
			MemberInfo in2 = new MemberInfo();
			in2.setFname("Bear");
			in2.setLname("Grew");
			in2.setPhone("012345678");
			in2.setEmail("Br@gg.com");
			memberInfoRepository.save(in2);
		};
	}

	private void createCourseMusic(){
		courseTimeRepository.save(new CourseTime("วันจันทร์",Time.valueOf("17:00:00"),Time.valueOf("19:00:00")));
		courseTimeRepository.save(new CourseTime("วันจันทร์",Time.valueOf("19:00:00"),Time.valueOf("21:00:00")));
		courseTimeRepository.save(new CourseTime("วันอังคาร",Time.valueOf("17:00:00"),Time.valueOf("19:00:00")));
		courseTimeRepository.save(new CourseTime("วันอังคาร",Time.valueOf("19:00:00"),Time.valueOf("21:00:00")));
		courseTimeRepository.save(new CourseTime("วันพุธ",Time.valueOf("17:00:00"),Time.valueOf("19:00:00")));
		courseTimeRepository.save(new CourseTime("วันพุธ",Time.valueOf("19:00:00"),Time.valueOf("21:00:00")));
		courseTimeRepository.save(new CourseTime("วันพฤหัสบดี",Time.valueOf("17:00:00"),Time.valueOf("19:00:00")));
		courseTimeRepository.save(new CourseTime("วันพฤหัสบดี",Time.valueOf("19:00:00"),Time.valueOf("21:00:00")));
		courseTimeRepository.save(new CourseTime("วันศุกร์",Time.valueOf("17:00:00"),Time.valueOf("19:00:00")));
		courseTimeRepository.save(new CourseTime("วันศุกร์",Time.valueOf("19:00:00"),Time.valueOf("21:00:00")));
		courseTimeRepository.save(new CourseTime("วันเสาร์",Time.valueOf("10:00:00"),Time.valueOf("12:00:00")));
		courseTimeRepository.save(new CourseTime("วันเสาร์",Time.valueOf("13:00:00"),Time.valueOf("15:00:00")));
		courseTimeRepository.save(new CourseTime("วันเสาร์",Time.valueOf("15:00:00"),Time.valueOf("17:00:00")));
		courseTimeRepository.save(new CourseTime("วันเสาร์",Time.valueOf("17:00:00"),Time.valueOf("19:00:00")));
		courseTimeRepository.save(new CourseTime("วันอาทิตย์",Time.valueOf("10:00:00"),Time.valueOf("12:00:00")));
		courseTimeRepository.save(new CourseTime("วันอาทิตย์",Time.valueOf("13:00:00"),Time.valueOf("15:00:00")));
		courseTimeRepository.save(new CourseTime("วันอาทิตย์",Time.valueOf("15:00:00"),Time.valueOf("17:00:00")));
		paymentTypeRepository.save(new PaymentType("รายวัน",900f));
		paymentTypeRepository.save(new PaymentType("รายเดือน",3600f));
		classroomRepository.save(new Classroom("C1Keyboard"));
		classroomRepository.save(new Classroom("C2Keyboard"));
		classroomRepository.save(new Classroom("C3Keyboard"));
		classroomRepository.save(new Classroom("C1GuitarBass"));
		classroomRepository.save(new Classroom("C2GuitarBass"));
		classroomRepository.save(new Classroom("C1Guitar"));
		classroomRepository.save(new Classroom("C2Guitar"));
		classroomRepository.save(new Classroom("C1Drum"));
		classroomRepository.save(new Classroom("C2Drum"));
		classroomRepository.save(new Classroom("C3Drum"));

	}

	private void createPaidStatus(String status) {
		paidStatusRepository.save(new PaidStatus(status));
	}

	private void createNewUser(String plainPassword, String userName) throws Exception {
		memberRepository.save(new Member(userName, plainPassword));
	}

	private void createStatusCourse(String a) {
		statusCourseRepository.save(new StatusCourse(a));
	}

	private void createPeriodTable() {
		for (int i = 0; i < 12; i++) {
			Time start = Time.valueOf("10:00:00");
			Time end = Time.valueOf("11:00:00");
			timePeriodRepository.save(new TimePeriod(Time.valueOf(start.toLocalTime().plusHours(i)),
					Time.valueOf(end.toLocalTime().plusHours(i))));
		}
		timePeriodRepository.save(new TimePeriod(Time.valueOf("10:00:00"), Time.valueOf("22:00:00")));
	}

	private void createScheduleTable() {
		LocalDate localDate = LocalDate.now();
		for (int i = 0; i < 7; i++) {
			scheduleRepository.save(new Schedule(
					Date.from(localDate.plusDays(i).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant())));
		}
	}

	private void createRoom() {
		RoomSize size5 = roomSizeRepository.save(new RoomSize(5));
		RoomSize size7 = roomSizeRepository.save(new RoomSize(7));
		RoomSize size9 = roomSizeRepository.save(new RoomSize(9));
		RoomType rec = roomTypeRepository.save(new RoomType("record"));
		RoomType pra = roomTypeRepository.save(new RoomType("practice"));
		StatusRoom open = statusRoomRepository.save(new StatusRoom("ใช้งาน"));
		StatusRoom close = statusRoomRepository.save(new StatusRoom("ปิดใช้งาน"));
		Instrument guitar = instrumentRepository.save(new Instrument("กีตาร์"));
		Instrument drum = instrumentRepository.save(new Instrument("กลองชุด"));
		Instrument bass = instrumentRepository.save(new Instrument("กีตาร์เบส"));
		Instrument key = instrumentRepository.save(new Instrument("คีย์บอร์ด"));
		roomRepository.save(new Room("R101", 200, size5, rec, open));
		roomRepository.save(new Room("R102", 250, size7, rec, open));
		roomRepository.save(new Room("R103", 200, size5, rec, open));
		roomRepository.save(new Room("R104", 300, size9, rec, open));
		roomRepository.save(new Room("P101", 100, size5, pra, close));

		roomRepository.save(new Room("P102", 150, size7, pra, open));
		roomRepository.save(new Room("P103", 100, size5, pra, close));
		roomRepository.save(new Room("P104", 190, size9, pra, open));
	}

	private void createTimeTable() {
		List<Room> rooms = roomRepository.findAll();
		List<Schedule> schedules = scheduleRepository.findAll();
		List<TimePeriod> timePeriods = timePeriodRepository.findAll();
		RoomType record = roomTypeRepository.findByType("record");
		Room[] room = rooms.toArray(new Room[0]);
		Schedule[] schedule = schedules.toArray(new Schedule[0]);
		TimePeriod[] timePeriod = timePeriods.toArray(new TimePeriod[0]);
		for (Room r : room) {
			for (Schedule s : schedule) {
				if (r.getRoomType().equals(record)) {
					timeTableRepository.save(new TimeTable(s, timePeriod[timePeriod.length - 1], r));
				} else {
					for (int i = 0; i < timePeriod.length - 1; i++) {
						timeTableRepository.save(new TimeTable(s, timePeriod[i], r));
					}
				}
			}
		}
	}

	@Bean
	ApplicationRunner init8(ProductRepository productRepository, PromotionRepository promotionRepository, StaffRepository staffRepository, TypepromotionRepository typepromotionRepository){
		return args -> {
			Product product1 = new Product("guitar");
			Product product2 = new Product("drum");
			Product product3 = new Product("Clarinet");
			Product product4 = new Product("plaster");


			productRepository.save(product1);
			productRepository.save(product2);
			productRepository.save(product3);
			productRepository.save(product4);


			Typepromotion typepromotion1 = new Typepromotion("Buy 1 Free 1");
			Typepromotion typepromotion2 = new Typepromotion("Gold minute");
			Typepromotion typepromotion3 = new Typepromotion("Reduce20%");
			Typepromotion typepromotion4= new Typepromotion("Reduce50%");
			Typepromotion typepromotion5 = new Typepromotion("Reduce80%");
			typepromotionRepository.save(typepromotion1);
			typepromotionRepository.save(typepromotion2);
			typepromotionRepository.save(typepromotion3);
			typepromotionRepository.save(typepromotion4);
			typepromotionRepository.save(typepromotion5);

			Staff staff1 = new Staff("Nuntawat Kaewtajit");
			Staff staff2 = new Staff("Yan Gongthangta");
			Staff staff3 = new Staff("Harenama Pomatola");
			Staff staff4 = new Staff("Koka Koka");
			staffRepository.save(staff1);
			staffRepository.save(staff2);
			staffRepository.save(staff3);
			staffRepository.save(staff4);


		};
	}

	@Bean
	ApplicationRunner init08(TypeproductRepository typeproductRepository){
		return args -> {
			

			Typeproduct typeproduct1 = new Typeproduct("drum");
			Typeproduct typeproduct2 = new Typeproduct(" Guitar and bass");
			Typeproduct typeproduct3 = new Typeproduct("stringed band");

			Typeproduct typeproduct5 = new Typeproduct("Marching instrument");
			Typeproduct typeproduct6 = new Typeproduct("Percussion instrument");
			
			typeproductRepository.save(typeproduct1);
			typeproductRepository.save(typeproduct2);
			typeproductRepository.save(typeproduct3);

			typeproductRepository.save(typeproduct5);
			typeproductRepository.save(typeproduct6);

		

		};
	}

}
