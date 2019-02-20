package com.sut.se.g03.G03;

import com.sut.se.g03.entity.TimePeriod;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.*;
import java.sql.Time;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TimePeriodTest {
	@Autowired
	private TestEntityManager entityManager;

	private Validator validator;

	@Before
	public void setup(){
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void timePeriodPositiveTest(){
		TimePeriod p = new TimePeriod();
		Time t1 = Time.valueOf("00:00:00");
		p.setStart(t1);
		p.setEnd(t1);
		try{
			entityManager.persistAndFlush(p);
		}catch (Exception e){
			Assert.fail("test time-period error");
			printError("time-period test error", e);
		}
	}

	@Test
	public void timePeriodStartNullTest(){
		TimePeriod p = new TimePeriod();
		Time t1 = Time.valueOf("00:00:00");
		p.setStart(null);
		p.setEnd(t1);
		try{
			entityManager.persistAndFlush(p);
			fail("test time-period null start not pass");
		}
		catch (ConstraintViolationException e){
			printError("time-period null start test", e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	//@Test(expected=javax.persistence.PersistenceException.class)
	public void timePeriodStartUniqTest(){
		TimePeriod p1 = new TimePeriod();
		TimePeriod p2 = new TimePeriod();
		Time t1 = Time.valueOf("00:00:00");
		Time t2 = Time.valueOf("01:00:00");
		p1.setStart(t1);
		p1.setEnd(t1);
		p2.setStart(t1);
		p2.setEnd(t2);
		try{
			entityManager.persistAndFlush(p1);
			entityManager.persistAndFlush(p2);
			fail("test time-period start uniq fail");
		}catch (javax.persistence.PersistenceException e){
			printError("time-period start uniq test", e);
			throw new javax.persistence.PersistenceException();
		}
	}

	//@Test(expected=javax.persistence.PersistenceException.class)
	public void timePeriodEndUniqTest(){
		TimePeriod p1 = new TimePeriod();
		TimePeriod p2 = new TimePeriod();
		Time t1 = Time.valueOf("00:00:00");
		Time t2 = Time.valueOf("01:00:00");
		p1.setStart(t1);
		p1.setEnd(t1);
		p2.setStart(t2);
		p2.setEnd(t1);
		try{
			entityManager.persistAndFlush(p1);
			entityManager.persistAndFlush(p2);
			fail("test time-period end uniq fail");
		}catch (javax.persistence.PersistenceException e){
			printError("time-period end uniq test", e);
			throw new javax.persistence.PersistenceException();
		}
	}

	@Test
	public void timePeriodEndNullTest(){
		TimePeriod p = new TimePeriod();
		Time t1 = Time.valueOf("00:00:00");
		p.setStart(t1);
		p.setEnd(null);
		try{
			entityManager.persistAndFlush(p);
			fail("test time-period end null not pass");
		}
		catch (ConstraintViolationException e){
			printError("test time-period end null", e);
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
