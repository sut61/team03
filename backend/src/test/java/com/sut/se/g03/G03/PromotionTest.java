package com.sut.se.g03.G03;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import com.sut.se.g03.entity.*;
import com.sut.se.g03.repository.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.OptionalInt;
import java.util.Set;

import java.util.Date;

import org.junit.Before;

@RunWith(SpringRunner.class)
@DataJpaTest
//@SpringBootTest
public class PromotionTest {

	@Autowired
    private PromotionRepository promotionRepository;
    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }



	@Test
	public void contextLoads() {
	}

	
    @Test
    public void testContractEntitySuccess() throws ParseException {
        Promotion a = new Promotion();
        a.setPromotinoName("testname");
		a.setCode("jKJUS");
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2563-12-20");
        a.setStartDate(date);
        a.setStaff(staffRepository.findById(1L).get());
        try {
            entityManager.persist(a);
            entityManager.flush();
            
            //fail("Should not pass to the line")
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("==== testContractEntitySuccess ====");
            System.out.println(e);
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
	}

	@Test
    public void NamepromotionNull() throws ParseException {
        Promotion a = new Promotion();
        a.setPromotinoName(null);
        a.setCode("jKJUS");
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2563-12-20");
        a.setStartDate(date);
        a.setStaff(staffRepository.findById(1L).get());
        try {
            entityManager.persist(a);
            entityManager.flush();
            
            //fail("Should not pass to the line")
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("==== NamePromotion Null ====");
            System.out.println(e);
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
	}

	@Test
    public void CodeNull() throws ParseException {
        Promotion a = new Promotion();
        a.setPromotinoName("Testname");
        a.setCode(null);
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2563-12-20");
        a.setStartDate(date);
        a.setStaff(staffRepository.findById(1L).get());
        try {
            entityManager.persist(a);
            entityManager.flush();
            
            //fail("Should not pass to the line")
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("==== Code Null ====");
            System.out.println(e);
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
	}

	
	@Test
    public void TestNamePatternError() throws ParseException {
        Promotion a = new Promotion();
        a.setPromotinoName("--*-*//-");
        a.setCode("KLAkdfi");
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2563-12-20");
        a.setStartDate(date);
        a.setStaff(staffRepository.findById(1L).get());
        try {
            entityManager.persist(a);
            entityManager.flush();
            
            //fail("Should not pass to the line")
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("==== PatternError ====");
            System.out.println(e);
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
	}

		
	@Test
    public void TestNameMax() throws ParseException {
        Promotion a = new Promotion();
        a.setPromotinoName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaasasaaaaaaaaaaaaaasasassdssssass");
        a.setCode("KLAkdfi");
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2563-12-20");
        a.setStartDate(date);
        a.setStaff(staffRepository.findById(1L).get());
        try {
            entityManager.persist(a);
            entityManager.flush();
            
            //fail("Should not pass to the line")
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("==== name > Max ====");
            System.out.println(e);
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
	}

	@Test
    public void TestNameMin() throws ParseException {
        Promotion a = new Promotion();
        a.setPromotinoName("S");
        a.setCode("KLAkdfi");
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2563-12-20");
        a.setStartDate(date);
        a.setStaff(staffRepository.findById(1L).get());
        try {
            entityManager.persist(a);
            entityManager.flush();
            
            //fail("Should not pass to the line")
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("==== name < Min ====");
            System.out.println(e);
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
	}
	@Test
    public void StartDateNotpast() throws ParseException {
        Promotion a = new Promotion();
        a.setPromotinoName("namepromotion");
        a.setCode("HGDffdf");
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2561-12-20");
        a.setStartDate(date);
        a.setStaff(staffRepository.findById(1L).get());
        try {
            entityManager.persist(a);
            entityManager.flush();
            
            //fail("Should not pass to the line")
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("==== StartDateNotpast ====");
            System.out.println(e);
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
	}

    @Test
    public void StopDateNotpast() throws ParseException {
        Promotion a = new Promotion();
        a.setPromotinoName("namepromotion");
        a.setCode("kjdfdfJIf");
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2561-12-20");
        a.setStopDate(date);
        a.setStaff(staffRepository.findById(1L).get());
        try {
            entityManager.persist(a);
            entityManager.flush();

            //fail("Should not pass to the line")
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("==== StopDateNotpast ====");
            System.out.println(e);
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    
    
    @Test
    public void Staffnotnull() throws ParseException {
        Promotion a = new Promotion();
        a.setPromotinoName("namepromotion");
        a.setCode("kjdfdfJIf");
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2563-12-20");
        a.setStopDate(date);
        a.setStaff(null);
        try {
            entityManager.persist(a);
            entityManager.flush();

            //fail("Should not pass to the line")
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("==== staffNull ====");
            System.out.println(e);
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
	



}
