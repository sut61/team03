package com.sut.se.g03.G03;

import com.sut.se.g03.entity.Classify;
import com.sut.se.g03.entity.ClassifyStatus;
import com.sut.se.g03.repository.ClassifyRepository;
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
public class ClassifyTest {

	@Autowired
	private ClassifyRepository classifyRepository;
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
	public void positiveTestClassify(){
		ClassifyStatus classifyStatus = classifyStatusRepository.findAllByStatus("ใช้งาน");
		try{
			entityManager.persist(new Classify("abcdef", "abcdef", classifyStatus));
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
	public void nullTestClassifyName(){
		ClassifyStatus classifyStatus = classifyStatusRepository.findAllByStatus("ใช้งาน");
		try{
			entityManager.persist(new Classify(null, "abcdef", classifyStatus));
			entityManager.flush();
			fail("Should not pass to this line");
		}catch(ConstraintViolationException e){
			printTestCause("test name not be null",e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void patternTestClassifyName(){
		ClassifyStatus classifyStatus = classifyStatusRepository.findAllByStatus("ใช้งาน");
		try{
			entityManager.persist(new Classify("abc def", "abcdef", classifyStatus));
			entityManager.flush();
			fail("Should not pass to this line");
		}catch(ConstraintViolationException e){
			printTestCause("test pattern name",e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void maxSizeTestClassifyName(){
		ClassifyStatus classifyStatus = classifyStatusRepository.findAllByStatus("ใช้งาน");
		try{
			entityManager.persist(new Classify("abcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxy", "abcdef",classifyStatus));
			entityManager.flush();
			fail("Should not pass to this line");
		}catch(ConstraintViolationException e){
			printTestCause("test name max size", e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void minSizeTestClassifyName(){
		ClassifyStatus classifyStatus = classifyStatusRepository.findAllByStatus("ใช้งาน");
		try{
			entityManager.persist(new Classify("a", "abcdef",classifyStatus));
			entityManager.flush();
			fail("Should not pass to this line");
		}catch(ConstraintViolationException e){
			printTestCause("test name min size", e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test(expected=javax.persistence.PersistenceException.class)
	public void testUniqClassifyName(){
		ClassifyStatus classifyStatus = classifyStatusRepository.findAllByStatus("ใช้งาน");
		entityManager.persist(new Classify("abcde", "abcdef", classifyStatus));
		entityManager.flush();
		try{
			entityManager.persist(new Classify("abcde", "abcdefghi", classifyStatus));
			entityManager.flush();
		fail("Should not pass to this line");
		}catch (javax.persistence.PersistenceException e){
			printTestCause("test name uniq", e);
			throw new javax.persistence.PersistenceException();
		}
	}

	@Test
	public void nullTestClassifyDetail(){
		ClassifyStatus classifyStatus = classifyStatusRepository.findAllByStatus("ใช้งาน");
		try{
			entityManager.persist(new Classify("abcdef", null, classifyStatus));
			entityManager.flush();
			fail("Should not pass to this line");
		}catch(ConstraintViolationException e){
			printTestCause("test detail not be null",e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void patternTestClassifyDetail(){
		ClassifyStatus classifyStatus = classifyStatusRepository.findAllByStatus("ใช้งาน");
		try{
			entityManager.persist(new Classify("abcdef", "abcdef*", classifyStatus));
			entityManager.flush();
			fail("Should not pass to this line");
		}catch(ConstraintViolationException e){
			printTestCause("test pattern detail",e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void maxSizeTestClassifyDetail(){
		ClassifyStatus classifyStatus = classifyStatusRepository.findAllByStatus("ใช้งาน");
		try{
			entityManager.persist(new Classify("abcdef", "abcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvw" +
					"xyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstu" +
					"vwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrs" +
					"tuvwxyabcdefghijklmnopqrstuvwxy",classifyStatus));
			entityManager.flush();
			fail("Should not pass to this line");
		}catch(ConstraintViolationException e){
			printTestCause("test max detail size", e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	//problem
	@Test
	public void minSizeTestClassifyDetail(){
		ClassifyStatus classifyStatus = classifyStatusRepository.findAllByStatus("ใช้งาน");
		try{
			entityManager.persist(new Classify("abcdef", "aaaa",classifyStatus));
			entityManager.flush();
			fail("Should not pass to this line");
		}catch(ConstraintViolationException e){
			printTestCause("test min detail size", e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test(expected=javax.persistence.PersistenceException.class)
	public void testUniqClassifyDetail(){
		ClassifyStatus classifyStatus = classifyStatusRepository.findAllByStatus("ใช้งาน");
		entityManager.persist(new Classify("abcdef", "abcdef", classifyStatus));
		entityManager.flush();
		try{
			entityManager.persist(new Classify("abcde", "abcdef", classifyStatus));
			entityManager.flush();
			fail("Should not pass to this line");
		}catch (javax.persistence.PersistenceException e){
			printTestCause("test detail uniq", e);
			throw new javax.persistence.PersistenceException();
		}
	}

	@Test
	public void statusNullTestClassify(){
		try{
			entityManager.persist(new Classify("abcde", "abcdef",null));
			entityManager.flush();
			fail("Should not pass to this line");
		}catch(ConstraintViolationException e){
			printTestCause("test status null", e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void amountTestClassify(){
		ClassifyStatus classifyStatus = classifyStatusRepository.findAllByStatus("ใช้งาน");
		try{
			entityManager.persist(new Classify("abcde", "abcdef",-1, classifyStatus));
			entityManager.flush();
			fail("Should not pass to this line");
		}catch(ConstraintViolationException e){
			printTestCause("test amount", e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
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
