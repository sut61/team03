package com.sut.se.g03.G03;

import com.sut.se.g03.entity.*;
import com.sut.se.g03.repository.*;
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
public class FixMainTest {
    @Autowired
    private FixMainRepository fixMainRepository;
    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    //test
    @Test
    public void testBeforeDoAnything() {
    }

    //test Cost = Null
    @Test
    public void TestCostCannotNull() {
        FixMain f = new FixMain();
        f.setCost(null);
        f.setItemFix(entityManager.persist(new ItemFix("aaaaaaaaaa")));
        f.setCustomerFix(entityManager.persist(new CustomerFix("1123456789")));
        f.setDatainfo(entityManager.persist(new Datainfo("aaaaaaaaaa")));
        f.setInstruType(entityManager.persist(new InstruType("aaaaaaaaaa")));
        f.setManagerinfo(entityManager.persist(new Managerinfo("aaaaaaaaaa")));
        try {
            entityManager.persist(f);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println(" Cost Null");
            System.out.println(e);
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);

        }
    }

    //test ItemFix = Null
    @Test
    public void TestItemFixCannotNull() {
        FixMain f = new FixMain();
        f.setCost(1000000);
        f.setItemFix(null);
        f.setCustomerFix(entityManager.persist(new CustomerFix("1123456789")));
        f.setDatainfo(entityManager.persist(new Datainfo("aaaaaaaaaa")));
        f.setInstruType(entityManager.persist(new InstruType("aaaaaaaaaa")));
        f.setManagerinfo(entityManager.persist(new Managerinfo("aaaaaaaaaa")));
        try {
            entityManager.persist(f);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println(" Item Null");
            System.out.println(e);
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);

        }
    }
    /*
     //test CustomerFix = Null
     @Test
     public void TestCustomerFixCannotNull(){
         FixMain f = new FixMain();
         f.setCost(1000);
         f.setItemFix(entityManager.persist(new ItemFix ("aaaaaaaaaa")));
         f.setCustomerFix(null);
         f.setDatainfo(entityManager.persist(new Datainfo("aaaaaaaaaa")));
         f.setInstruType(entityManager.persist(new InstruType("aaaaaaaaaa")));
         f.setManagerinfo(entityManager.persist(new Managerinfo("aaaaaaaaaa")));
         try {
             entityManager.persist(f);
             entityManager.flush();

             fail("Should not pass to this line");
         } catch(javax.validation.ConstraintViolationException e) {
             System.out.println(e.getMessage());
             System.out.println();
             System.out.println(" Customer Null");
             System.out.println(e);
             System.out.println();

             Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
             assertEquals(violations.isEmpty(), false);

         }
     }*/
    //test Datainfo = Null
    @Test
    public void TestDatainfoCannotNull() {
        FixMain f = new FixMain();
        f.setCost(1000000);
        f.setItemFix(entityManager.persist(new ItemFix("aaaaaaaaaa")));
        f.setCustomerFix(entityManager.persist(new CustomerFix("1123456789")));
        f.setDatainfo(null);
        f.setInstruType(entityManager.persist(new InstruType("aaaaaaaaaa")));
        f.setManagerinfo(entityManager.persist(new Managerinfo("aaaaaaaaaa")));
        try {
            entityManager.persist(f);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println(" Datainfo Null");
            System.out.println(e);
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);

        }
    }//test InstruType = Null

    @Test
    public void TestInstruTypeCannotNull() {
        FixMain f = new FixMain();
        f.setCost(1000000);
        f.setItemFix(entityManager.persist(new ItemFix("aaaaaaaaaa")));
        f.setCustomerFix(entityManager.persist(new CustomerFix("1123456789")));
        f.setDatainfo(entityManager.persist(new Datainfo("aaaaaaaaaa")));
        f.setInstruType(null);
        f.setManagerinfo(entityManager.persist(new Managerinfo("aaaaaaaaaa")));
        try {
            entityManager.persist(f);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println(" InstruType Null");
            System.out.println(e);
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);

        }
    }

    //test Managerinfo = Null
    @Test
    public void TestManagerinfoCannotNull() {
        FixMain f = new FixMain();
        f.setCost(1000000);
        f.setItemFix(entityManager.persist(new ItemFix("aaaaaaaaaa")));
        f.setCustomerFix(entityManager.persist(new CustomerFix("1123456789")));
        f.setDatainfo(entityManager.persist(new Datainfo("aaaaaaaaaa")));
        f.setInstruType(entityManager.persist(new InstruType("aaaaaaaaaa")));
        f.setManagerinfo(null);
        try {
            entityManager.persist(f);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println(" Managerinfo Null");
            System.out.println(e);
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);

        }
    }

    //test Tel Size Min
    @Test
    public void TestTelSizeMin() {
        FixMain f = new FixMain();
        f.setCost(1000000);
        f.setItemFix(entityManager.persist(new ItemFix("aaaaaaaaaa")));
        f.setCustomerFix(entityManager.persist(new CustomerFix("011")));
        f.setDatainfo(entityManager.persist(new Datainfo("aaaaaaaaaa")));
        f.setInstruType(entityManager.persist(new InstruType("aaaaaaaaaa")));
        f.setManagerinfo(entityManager.persist(new Managerinfo("aaaaaaaaaa")));
        try {
            entityManager.persist(f);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println(" Tel Size Error");
            System.out.println(e);
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void TestTelSizeMax() {
        FixMain f = new FixMain();
        f.setCost(1000000);
        f.setItemFix(entityManager.persist(new ItemFix("aaaaaaaaaa")));
        f.setCustomerFix(entityManager.persist(new CustomerFix("011111111111111111111111111")));
        f.setDatainfo(entityManager.persist(new Datainfo("aaaaaaaaaa")));
        f.setInstruType(entityManager.persist(new InstruType("aaaaaaaaaa")));
        f.setManagerinfo(entityManager.persist(new Managerinfo("aaaaaaaaaa")));
        try {
            entityManager.persist(f);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println(" Tel Size Error");
            System.out.println(e);
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void TestTelPatternError() {
        FixMain f = new FixMain();
        f.setCost(1000000);
        f.setItemFix(entityManager.persist(new ItemFix("aaaaaaaaaa")));
        f.setCustomerFix(entityManager.persist(new CustomerFix("-*/-*/-*/-")));
        f.setDatainfo(entityManager.persist(new Datainfo("aaaaaaaaaa")));
        f.setInstruType(entityManager.persist(new InstruType("aaaaaaaaaa")));
        f.setManagerinfo(entityManager.persist(new Managerinfo("aaaaaaaaaa")));
        try {
            entityManager.persist(f);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println(" Tel Pattern Error");
            System.out.println(e);
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testUniqueTelFix() {
        FixMain f = new FixMain();
        FixMain f1 = new FixMain();
        f.setCost(1000000);
        f.setItemFix(entityManager.persist(new ItemFix("aaaaaaaaaa")));
        f.setCustomerFix(entityManager.persist(new CustomerFix("0123456789")));
        f.setDatainfo(entityManager.persist(new Datainfo("aaaaaaaaaa")));
        f.setInstruType(entityManager.persist(new InstruType("aaaaaaaaaa")));
        f.setManagerinfo(entityManager.persist(new Managerinfo("aaaaaaaaaa")));

        f.setCost(2000000);
        f.setItemFix(entityManager.persist(new ItemFix("bbbbbbbbbb")));
        f.setCustomerFix(entityManager.persist(new CustomerFix("0123456789")));
        f.setDatainfo(entityManager.persist(new Datainfo("bbbbbbbbbb")));
        f.setInstruType(entityManager.persist(new InstruType("bbbbbbbbbb")));
        f.setManagerinfo(entityManager.persist(new Managerinfo("bbbbbbbbbb")));

        try {
            entityManager.persist(f);
            entityManager.flush();
            entityManager.persist(f1);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.persistence.PersistenceException e) {
            System.out.println();
            System.out.println(" --------------------- "+e+"Err Unique Tel FIX --------------------------------");
            System.out.println();
        }
    }

}

