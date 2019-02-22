package com.sut.se.g03.G03;

import com.sut.se.g03.entity.Bill;
import com.sut.se.g03.entity.Contact;
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
public class ContactTest {

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
	public void contactPositiveTest(){
		Bill b = billRepository.getOne(1L);
		Contact c = new Contact();
		c.setBill(b);
		c.setName("abcd efgh");
		c.setTel("0812345678");
		try{
			entityManager.persistAndFlush(c);
		}catch (Exception e){
			Assert.fail("test fail");
			System.out.println("\n\n\n" + e + "\n\n\n");
		}
	}

	@Test
	public void contactNameNullTest(){
		Bill b = billRepository.getOne(1L);
		Contact c = new Contact();
		c.setBill(b);
		c.setName(null);
		c.setTel("0812345678");
		try {
			entityManager.persistAndFlush(c);
			fail("test contact name null fail");
		}catch (ConstraintViolationException e){
				printError("contact name null test", e);
				Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
				assertEquals(violations.isEmpty(), false);
				assertEquals(violations.size(), 1);
			}
	}

	@Test
	public void contactNameMaxTest(){
		Bill b = billRepository.getOne(1L);
		Contact c = new Contact();
		c.setBill(b);
		c.setName("abcdefghijklmnopqrstuvwxy abcdefghijklmnopqrstuvwxy");
		c.setTel("0812345678");
		try {
			entityManager.persistAndFlush(c);
			fail("test contact name max fail");
		}catch (ConstraintViolationException e){
			printError("contact name max test", e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void contactNameMinTest(){
		Bill b = billRepository.getOne(1L);
		Contact c = new Contact();
		c.setBill(b);
		c.setName("a a");
		c.setTel("0812345678");
		try {
			entityManager.persistAndFlush(c);
			fail("test contact name min fail");
		}catch (ConstraintViolationException e){
			printError("contact name min test", e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void contactNamePatternTest(){
		Bill b = billRepository.getOne(1L);
		Contact c = new Contact();
		c.setBill(b);
		c.setName("abcdefg");
		c.setTel("0812345678");
		try {
			entityManager.persistAndFlush(c);
			fail("test contact name pattern fail");
		}catch (ConstraintViolationException e){
			printError("contact name pattern test", e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void contactTelNullTest(){
		Bill b = billRepository.getOne(1L);
		Contact c = new Contact();
		c.setBill(b);
		c.setName("abcdefg abcdefg");
		c.setTel(null);
		try {
			entityManager.persistAndFlush(c);
			fail("test contact tel null fail");
		}catch (ConstraintViolationException e){
			printError("contact tel null test", e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void contactTelMaxSizeTest(){
		Bill b = billRepository.getOne(1L);
		Contact c = new Contact();
		c.setBill(b);
		c.setName("abcdefg abcdefg");
		c.setTel("08123456789");
		try {
			entityManager.persistAndFlush(c);
			fail("test contact tel max size fail");
		}catch (ConstraintViolationException e){
			printError("contact tel max size test", e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void contactTelMinSizeTest(){
		Bill b = billRepository.getOne(1L);
		Contact c = new Contact();
		c.setBill(b);
		c.setName("abcdefg abcdefg");
		c.setTel("081");
		try {
			entityManager.persistAndFlush(c);
			fail("test contact tel min size fail");
		}catch (ConstraintViolationException e){
			printError("contact tel min size test", e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void contactTelPatternTest(){
		Bill b = billRepository.getOne(1L);
		Contact c = new Contact();
		c.setBill(b);
		c.setName("abcdefg abcdefg");
		c.setTel("1234567890");
		try {
			entityManager.persistAndFlush(c);
			fail("test contact tel pattern fail");
		}catch (ConstraintViolationException e){
			printError("contact tel pattern test", e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void contactBillNullTest(){
		Contact c = new Contact();
		c.setBill(null);
		c.setName("abcdefg abcdefg");
		c.setTel("0812345678");
		try {
			entityManager.persistAndFlush(c);
			fail("test contact bill null fail");
		}catch (ConstraintViolationException e){
			printError("contact bill null test", e);
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
