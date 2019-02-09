package com.sut.se.g03.G03;

import com.sut.se.g03.entity.ItemType;
import com.sut.se.g03.repository.ItemTypeRepository;
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
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemTypeTest {

	@Autowired
	private ItemTypeRepository itemTypeRepository;

	@Autowired
	private TestEntityManager entityManager;

	private Validator validator;

	@Before
	public void setup(){
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void positiveTestItemType(){
		try{
			entityManager.persist(new ItemType("abcdef"));
			entityManager.flush();
			printTestCause("positive test not found error");
		}catch(javax.validation.ConstraintViolationException e){
			printTestCause("positive test found exception",e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 0);
		}catch (Exception e){
			printTestCause("positive test found exception",e);
			System.out.println("positive test found exception");
			fail("Should not pass to this line");
		}
	}

	@Test
	public void nullTestItemType(){
		try{
			entityManager.persist(new ItemType(null));
			entityManager.flush();
			fail("Should not pass to this line");
		}catch(javax.validation.ConstraintViolationException e){
			printTestCause("test ItemType not be null",e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void patternTestItemType(){
		try{
			entityManager.persist(new ItemType("abcde fgh"));
			entityManager.flush();
			fail("Should not pass to this line");
		}catch(javax.validation.ConstraintViolationException e){
			printTestCause("test pattern item type",e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void maxSizeTestItemType(){
		try{
			entityManager.persist(new ItemType("abcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxy"));
			entityManager.flush();
			fail("Should not pass to this line");
		}catch(javax.validation.ConstraintViolationException e){
			printTestCause("test item type max size", e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void minSizeTestItemType(){
		try{
			entityManager.persist(new ItemType("a"));
			entityManager.flush();
			fail("Should not pass to this line");
		}catch(javax.validation.ConstraintViolationException e){
			printTestCause("test item type min size", e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test(expected=javax.persistence.PersistenceException.class)
	public void testUniqItemType(){
		entityManager.persist(new ItemType("abcde"));
		entityManager.flush();
		try{
			entityManager.persist(new ItemType("abcde"));
			entityManager.flush();
			fail("Should not pass to this line");
		}catch (javax.persistence.PersistenceException e){
			printTestCause("test item type uniq", e);
			throw new javax.persistence.PersistenceException();
		}
	}

	private void printTestCause(String cause){
		System.out.println();
		System.out.println();
		System.out.println(cause);
		System.out.println();
		System.out.println();
	}

	private void printTestCause(String cause, Exception e){
		System.out.println();
		System.out.println();
		System.out.println(cause);
		System.out.println(e);
		System.out.println();
		System.out.println();
	}

	private void printTestCause(String cause, String e){
		System.out.println();
		System.out.println();
		System.out.println(cause);
		System.out.println(e);
		System.out.println();
		System.out.println();
	}
}
