package com.sut.se.g03.G03;

import com.sut.se.g03.entity.Bill;
import com.sut.se.g03.repository.BillRepository;
import com.sut.se.g03.repository.MemberRepository;
import com.sut.se.g03.repository.PaidStatusRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


@RunWith(SpringRunner.class)
@DataJpaTest
public class RoomReserveTest {

	@Autowired
	private BillRepository billRepository;
	@Autowired
	private PaidStatusRepository paidStatusRepository;
	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private TestEntityManager entityManager;

	private Validator validator;

	@Before
	public void setup(){
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void positiveTest(){
		Date date = Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		float price = 100;
		String bookingName = "Abc Def";
		Bill bill = new Bill();
		bill.setBookingName(bookingName);
		bill.setDate(date);
		bill.setTotalPrice(price);
		bill.setMember(memberRepository.findByUserName("zzzz"));
		bill.setPaidStatus(paidStatusRepository.findById(2L).get());
		try{
			entityManager.persist(bill);
			entityManager.flush();
		}catch(javax.validation.ConstraintViolationException e){
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 0);
		}
	}

	@Test
	public void testBookingNameNull(){
		Date date = Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		float price = 100;
		String bookingName = null;
		Bill bill = new Bill();
		bill.setBookingName(bookingName);
		bill.setDate(date);
		bill.setTotalPrice(price);
		bill.setMember(memberRepository.findByUserName("zzzz"));
		bill.setPaidStatus(paidStatusRepository.findById(2L).get());
		try{
			entityManager.persist(bill);
			entityManager.flush();
			fail("Should not pass to this line");
		}catch(javax.validation.ConstraintViolationException e){
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void testBookingLong(){
		Date date = Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		float price = 100;
		String bookingName = "abcdefghijklmnopqrstuvwxy abcdefghijklmnopqrstuvwxy";
		Bill bill = new Bill();
		bill.setBookingName(bookingName);
		bill.setDate(date);
		bill.setTotalPrice(price);
		bill.setMember(memberRepository.findByUserName("zzzz"));
		bill.setPaidStatus(paidStatusRepository.findById(2L).get());
		try{
			entityManager.persist(bill);
			entityManager.flush();
			fail("Should not pass to this line");
		}catch(javax.validation.ConstraintViolationException e){
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void testBookingPattern(){
		Date date = Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		float price = 100;
		String bookingName = "AbcDef";
		Bill bill = new Bill();
		bill.setBookingName(bookingName);
		bill.setDate(date);
		bill.setTotalPrice(price);
		bill.setMember(memberRepository.findByUserName("zzzz"));
		bill.setPaidStatus(paidStatusRepository.findById(2L).get());
		try{
			entityManager.persist(bill);
			entityManager.flush();
			fail("Should not pass to this line");
		}catch(javax.validation.ConstraintViolationException e){
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}
}
