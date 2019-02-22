package com.sut.se.g03.G03;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Collections;
import java.util.OptionalInt;
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
public class PaymentTypeTest {

	@Autowired
    private PaymentTypeRepository paymentTypeRepository;
   
    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
   
   @Test
    public void testPaymentTypeCorrect() {
       PaymentType pt = new PaymentType();
        pt.setName("จ่ายค่าห้อง");
	    pt.setPrice(900f);


        try {
            entityManager.persist(pt);
            entityManager.flush();
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println("");
            System.out.println("");
            System.out.println("Test PaymentTypeCorrect Pass");
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
    public void testPaymentTypeNameCannotBeNull() {
        PaymentType pt = new PaymentType();
        pt.setName(null);
	    pt.setPrice(900f);
       
        try {
            entityManager.persist(pt);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println("");
            System.out.println("");
            System.out.println("Test PaymentTypeNameCannotBeNull Pass");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

 @Test
    public void testPaymentTypePriceCannotBeNull() {
        PaymentType pt = new PaymentType();
        pt.setName("จ่ายรายวัน");
	    pt.setPrice(null);
       
        try {
            entityManager.persist(pt);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println("");
            System.out.println("");
            System.out.println("Test PaymentTypePriceCannotBeNull Pass");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

   
    


}
