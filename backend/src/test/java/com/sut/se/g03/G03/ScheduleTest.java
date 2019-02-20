package com.sut.se.g03.G03;

import com.sut.se.g03.entity.Schedule;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ScheduleTest {
	@Autowired
	private TestEntityManager entityManager;

	private Validator validator;

	@Before
	public void setup(){
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void positiveScheduleTest(){
		Date localDate = Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		try {
			entityManager.persistAndFlush(new Schedule(localDate));
		}catch (Exception e){
			Assert.fail("you should when pass this line");
			System.out.println("\n\n\n"+e+"\n\n\n");
		}
	}

	@Test
	public void scheduleNullTest(){
		try {
			entityManager.persistAndFlush(new Schedule(null));
		}catch (ConstraintViolationException e) {
			System.out.println("\n test schedule null \n\n"+e+"\n\n\n");
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	//@Test
	public void schedulePastTest(){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Date d = Date.from(LocalDate.parse("11/11/1997",formatter).atStartOfDay(ZoneId.systemDefault()).toInstant());
		try {
			entityManager.persistAndFlush(d);
		}catch (ConstraintViolationException e) {
			System.out.println("\n test schedule cannort be past\n\n"+e+"\n\n\n");
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

}
