package com.sut.se.g03.G03;

import com.sut.se.g03.entity.PaidStatus;
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

@RunWith(SpringRunner.class)
@DataJpaTest
public class PaidStatusTest {

	@Autowired
	private TestEntityManager entityManager;

	private Validator validator;

	@Before
	public void setup(){
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void positivePaidStatusTest(){
		try {
			entityManager.persistAndFlush(new PaidStatus("abcdefghi"));
		}catch (Exception e){
			System.out.println("\n\n\n"+e+"\n\n\n");
			Assert.fail("you should fail test this line");
		}
	}

	@Test
	public void paidStatusPatternTest(){
		try {
			entityManager.persistAndFlush(new PaidStatus("abcdefghi    "));
		}catch (ConstraintViolationException e){
			System.out.println("\n\n\n");
			System.out.println("paid status pattern test");
			System.out.println(e+"\n\n\n");
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void paidStatusNullTest(){
		try {
			entityManager.persistAndFlush(new PaidStatus(null));
		}catch (ConstraintViolationException e){
			System.out.println("\n\n\n");
			System.out.println("paid status null test");
			System.out.println(e+"\n\n\n");
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void paidStatusMaxSizeTest(){
		try {
			entityManager.persistAndFlush(new PaidStatus("abcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuv" +
					"wxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijkl" +
					"mnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyab" +
					"cdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxy"));
		}catch (ConstraintViolationException e){
			System.out.println("\n\n\n");
			System.out.println("paid status max-size test");
			System.out.println(e+"\n\n\n");
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

}
