package com.sut.se.g03.G03;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Collections;
import java.util.OptionalInt;
import java.sql.Time;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;

import com.sut.se.g03.entity.*;
import com.sut.se.g03.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@RunWith(SpringRunner.class)

@DataJpaTest
public class CourseTimeTest {

	@Autowired
    private CourseTimeRepository courseTimeRepository;
   
    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
   
  @Test
    public void testCourseTimeCorrect() {
        CourseTime ct = new CourseTime();
	Time t1 = Time.valueOf("00:00:00");
	Time t2 = Time.valueOf("01:00:00");
    ct.setDay("วันจันทร์");
	ct.setStart(t1);
	ct.setEnd(t2);
        try {
            entityManager.persist(ct);
            entityManager.flush();
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println("");
            System.out.println("");
            System.out.println("Test CourseTimeCorrect Pass");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 0);
        } catch(Exception e){
            fail("Should not pass to this line");
            e.printStackTrace();
       }
    }
   
	@Test
    public void testCourseTimeDayCannotBeNull() {
        CourseTime ct = new CourseTime();
	Time t1 = Time.valueOf("00:00:00");
	Time t2 = Time.valueOf("01:00:00");
        ct.setDay(null);
	    ct.setStart(t1);
	    ct.setEnd(t2);
       
        try {
            entityManager.persist(ct);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println("");
            System.out.println("");
            System.out.println("Test CourseTimeDayCannotBeNull Pass");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

   @Test
    public void testCourseTimeStartCannotBeNull() {
        CourseTime ct = new CourseTime();
	Time t1 = Time.valueOf("00:00:00");
	Time t2 = Time.valueOf("01:00:00");
        ct.setDay("วันจันทร์");
	    ct.setStart(null);
	    ct.setEnd(t2);
       
        try {
            entityManager.persist(ct);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println("");
            System.out.println("");
            System.out.println("Test CourseTimeStartCannotBeNull Pass");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

@Test
    public void testCourseTimeEndCannotBeNull() {
        CourseTime ct = new CourseTime();
	Time t1 = Time.valueOf("00:00:00");
	Time t2 = Time.valueOf("01:00:00");
        ct.setDay("วันจันทร์");
	    ct.setStart(t1);
	    ct.setEnd(null);
       
        try {
            entityManager.persist(ct);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println("");
            System.out.println("");
            System.out.println("Test CourseTimeEndCannotBeNull Pass");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }




}


