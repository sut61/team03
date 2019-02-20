package com.sut.se.g03.G03;

import com.sut.se.g03.entity.Bill;
import com.sut.se.g03.entity.BillInfo;
import com.sut.se.g03.repository.BillRepository;
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
public class BillInfoTest {
	@Autowired
	private BillRepository billRepository;
	@Autowired
	private TestEntityManager entityManager;

	private Validator validator;

	@Before
	public void setup(){
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void billInfoPositiveTest(){
		BillInfo info = new BillInfo();
		Bill b = billRepository.getOne(1L);
		info.setBill(b);
		info.setContent("abcdefghijklmnopqrstuvwxyz");
		info.setPrice(1);
		try{
			entityManager.persistAndFlush(info);
			System.out.println("test bill info pass");
		}catch (Exception e){
			Assert.fail("bill-info test fail");
			System.out.println(e);
		}
	}

	@Test
	public void billInfoContentNullTest(){
		BillInfo info = new BillInfo();
		Bill b = billRepository.getOne(1L);
		info.setBill(b);
		info.setContent(null);
		info.setPrice(1);
		try{
			entityManager.persistAndFlush(info);
			fail("test bill-info content null fail");
		}catch(ConstraintViolationException e){
			printError("bill-info content null test", e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void billInfoContentMinSizeTest(){
		BillInfo info = new BillInfo();
		Bill b = billRepository.getOne(1L);
		info.setBill(b);
		info.setContent("abcd");
		info.setPrice(1);
		try{
			entityManager.persistAndFlush(info);
			fail("test bill-info content min-size fail");
		}catch(ConstraintViolationException e){
			printError("bill-info content min-size test", e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void billInfoContentMaxSizeTest(){
		BillInfo info = new BillInfo();
		Bill b = billRepository.getOne(1L);
		info.setBill(b);
		info.setContent("abcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxy" +
				"abcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxy" +
				"abcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxy" +
				"abcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxy" +
				"abcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxy" +
				"abcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxy");
		info.setPrice(1);
		try{
			entityManager.persistAndFlush(info);
			fail("test bill-info content max-size fail");
		}catch(ConstraintViolationException e){
			printError("bill-info content max-size test", e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void billInfoContentPatternTest(){
		BillInfo info = new BillInfo();
		Bill b = billRepository.getOne(1L);
		info.setBill(b);
		info.setContent("1abcd");
		info.setPrice(1);
		try{
			entityManager.persistAndFlush(info);
			fail("test bill-info content pattern fail");
		}catch(ConstraintViolationException e){
			printError("bill-info content pattern test", e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void billInfoPricePositiveOrZeroTest(){
		BillInfo info = new BillInfo();
		Bill b = billRepository.getOne(1L);
		info.setBill(b);
		info.setContent("abcdefghijklmnopqrstuvwxyz");
		info.setPrice(-1);
		try{
			entityManager.persistAndFlush(info);
			fail("test bill-info price positive or zero fail");
		}catch(ConstraintViolationException e){
			printError("bill-info price positive or zero test", e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void billInfoBillNullTest(){
		BillInfo info = new BillInfo();
		info.setBill(null);
		info.setContent("abcdefghijklmnopqrstuvwxyz");
		info.setPrice(1);
		try{
			entityManager.persistAndFlush(info);
			fail("test bill-info bull null fail");
		}catch(ConstraintViolationException e){
			printError("bill-info bill null test", e);
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
