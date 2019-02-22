package com.sut.se.g03.G03;

import com.sut.se.g03.entity.Bill;
import com.sut.se.g03.entity.Member;
import com.sut.se.g03.entity.PaidStatus;
import com.sut.se.g03.repository.MemberRepository;
import com.sut.se.g03.repository.PaidStatusRepository;
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
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BillTest {
	@Autowired
	private TestEntityManager entityManager;
	@Autowired
	private PaidStatusRepository paidStatusRepository;
	@Autowired
	private MemberRepository memberRepository;

	private Validator validator;

	@Before
	public void setup(){
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void billPositiveTest(){
		Member m = memberRepository.findByUserName("zzzz");
		PaidStatus p = paidStatusRepository.getOne(1L);
		Date d = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
		Bill b = new Bill();
		b.setPaidStatus(p);
		b.setMember(m);
		b.setTotalPrice(1);
		b.setDate(d);
		try {
			entityManager.persistAndFlush(b);
			System.out.println("bill test pass");
		}catch (Exception e){
			Assert.fail("test fail when pass this line");
			printError("bill test fail", e);
		}
	}

	@Test
	public void billNullDateTest(){
		Member m = memberRepository.findByUserName("zzzz");
		PaidStatus p = paidStatusRepository.getOne(1L);
		Bill b = new Bill();
		b.setPaidStatus(p);
		b.setMember(m);
		b.setTotalPrice(1);
		b.setDate(null);
		try{
			entityManager.persistAndFlush(b);
			fail("test bill date null not pass");
		}
		catch (ConstraintViolationException e){
			printError("bill date null test", e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void billtotalPriceTest(){
		Member m = memberRepository.findByUserName("zzzz");
		PaidStatus p = paidStatusRepository.getOne(1L);
		Date d = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
		Bill b = new Bill();
		b.setPaidStatus(p);
		b.setMember(m);
		b.setTotalPrice(-1);
		b.setDate(d);
		try{
			entityManager.persistAndFlush(b);
			fail("test bill total price not pass");
		}
		catch (ConstraintViolationException e){
			printError("test bill total price", e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void billPaidStatusNullTest(){
		Member m = memberRepository.findByUserName("zzzz");
		Date d = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
		Bill b = new Bill();
		b.setPaidStatus(null);
		b.setMember(m);
		b.setTotalPrice(1);
		b.setDate(d);
		try{
			entityManager.persistAndFlush(b);
			fail("test bill paid-status null not pass");
		}
		catch (ConstraintViolationException e){
			printError("test bill paid status", e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void billMemberNullTest(){
		PaidStatus p = paidStatusRepository.getOne(1L);
		Date d = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
		Bill b = new Bill();
		b.setPaidStatus(p);
		b.setMember(null);
		b.setTotalPrice(1);
		b.setDate(d);
		try{
			entityManager.persistAndFlush(b);
			fail("test bill member null not pass");
		}
		catch (ConstraintViolationException e){
			printError("test bill member null", e);
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
