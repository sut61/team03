package com.sut.se.g03.G03;

import com.sut.se.g03.entity.Room;
import com.sut.se.g03.entity.Schedule;
import com.sut.se.g03.entity.TimePeriod;
import com.sut.se.g03.entity.TimeTable;
import com.sut.se.g03.repository.RoomRepository;
import com.sut.se.g03.repository.ScheduleRepository;
import com.sut.se.g03.repository.TimePeriodRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.*;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TimeTableTest {
	@Autowired
	private ScheduleRepository scheduleRepository;
	@Autowired
	private TimePeriodRepository timePeriodRepository;
	@Autowired
	private RoomRepository roomRepository;
	@Autowired
	private TestEntityManager entityManager;

	private Validator validator;

	@Before
	public void setup(){
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void timeTablePositiveTest(){
		Schedule s = scheduleRepository.getOne(1L);
		TimePeriod p = timePeriodRepository.getOne(1L);
		Room r = roomRepository.getOne(1L);
		TimeTable t = new TimeTable();
		t.setSchedule(s);
		t.setTimePeriod(p);
		t.setRoom(r);
		try{
			entityManager.persistAndFlush(t);
		}catch (Exception e){
			Assert.fail("time table test fail");
			printError("time table test error", e);
		}
	}

	@Test
	public void timeTableScheduleNullTest(){
		TimePeriod p = timePeriodRepository.getOne(1L);
		Room r = roomRepository.getOne(1L);
		TimeTable t = new TimeTable();
		t.setSchedule(null);
		t.setTimePeriod(p);
		t.setRoom(r);
		try {
			entityManager.persistAndFlush(t);
			fail("test time-table schedule null test fail");
		}catch(ConstraintViolationException e){
			printError("test time table schedule null", e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void timeTableTimePeriodNullTest(){
		Schedule s = scheduleRepository.getOne(1L);
		Room r = roomRepository.getOne(1L);
		TimeTable t = new TimeTable();
		t.setSchedule(s);
		t.setTimePeriod(null);
		t.setRoom(r);
		try {
			entityManager.persistAndFlush(t);
			fail("test time-table time-period null fail");
		}catch(ConstraintViolationException e){
			printError("test time-table time-period null", e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void timeTableRoomNullTest(){
		Schedule s = scheduleRepository.getOne(1L);
		TimePeriod p = timePeriodRepository.getOne(1L);
		TimeTable t = new TimeTable();
		t.setSchedule(s);
		t.setTimePeriod(p);
		t.setRoom(null);
		try {
			entityManager.persistAndFlush(t);
			fail("test time-table room null fail");
		}catch(ConstraintViolationException e){
			printError("test time-table room null", e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	private void printError(String comment, Exception e){
		System.out.println("\n\n"+comment);
		System.out.println("\n"+e+"\n\n\n");
	}

}
