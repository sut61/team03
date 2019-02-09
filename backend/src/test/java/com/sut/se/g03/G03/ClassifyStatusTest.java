package com.sut.se.g03.G03;

import com.sut.se.g03.entity.ClassifyStatus;
import com.sut.se.g03.repository.ClassifyStatusRepository;
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
public class ClassifyStatusTest {

	@Autowired
	private ClassifyStatusRepository classifyStatusRepository;

	@Autowired
	private TestEntityManager entityManager;

	private Validator validator;

	@Before
	public void setup(){
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void positiveTestStatus(){
		try{
			entityManager.persist(new ClassifyStatus("abcdef"));
			entityManager.flush();
			printTestCause("positive test not found error");
		}catch(ConstraintViolationException e){
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
	public void testStatusNotNull(){
		try{
			entityManager.persist(new ClassifyStatus(null));
			entityManager.flush();
			fail("should not pass this line");
		}catch (ConstraintViolationException e){
			printTestCause("test null classify status",e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void patternTestStatus(){
		try{
			entityManager.persist(new ClassifyStatus("abcde fgh"));
			entityManager.flush();
			fail("Should not pass to this line");
		}catch(ConstraintViolationException e){
			printTestCause("test pattern classify status",e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void maxSizeTestStatus(){
		try{
			entityManager.persist(new ClassifyStatus("abcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxy"));
			entityManager.flush();
			fail("Should not pass to this line");
		}catch(ConstraintViolationException e){
			printTestCause("test classify status max size", e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void minSizeTestItemType(){
		try{
			entityManager.persist(new ClassifyStatus("a"));
			entityManager.flush();
			fail("Should not pass to this line");
		}catch(ConstraintViolationException e){
			printTestCause("test classify status min size", e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test(expected=javax.persistence.PersistenceException.class)
	public void testUniqItemType(){
		entityManager.persist(new ClassifyStatus("abcde"));
		entityManager.flush();
		try{
			entityManager.persist(new ClassifyStatus("abcde"));
			entityManager.flush();
			fail("Should not pass to this line");
		}catch (javax.persistence.PersistenceException e){
			printTestCause("test classify status uniq", e);
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
