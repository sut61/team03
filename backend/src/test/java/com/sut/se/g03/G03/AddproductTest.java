package com.sut.se.g03.G03;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.Collections;
import java.util.OptionalInt;
import java.util.Set;

import java.util.Date;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.junit.Before;
import org.junit.Test;

import com.sut.se.g03.entity.*;
import com.sut.se.g03.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AddproductTest {

    @Autowired
    private AddproductRepository addproductRepository;
    @Autowired
    private TestEntityManager entityManager;
    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testEntitySuccess() {

        Addproduct a = new Addproduct();
        Product p = new Product();
       
        p.setAddproduct("test");
        a.setNumber(5);
        a.setPrice(10);
        a.setSaleprice(100);
        a.setDate(new Date());

        try {
            entityManager.persist(a);
            entityManager.persist(p);
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
    public void NameproductNull() {
        Addproduct a = new Addproduct();
        Product p = new Product();
        p.setAddproduct(null);
        a.setNumber(5);
        a.setPrice(6);
        a.setSaleprice(100);
        a.setDate(new Date());

        try {
            entityManager.persist(a);
            entityManager.persist(p);
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

    @Test
    public void PriceNegative() {
        Addproduct a = new Addproduct();
        Product p = new Product();
        p.setAddproduct("test");
        a.setNumber(5);
        a.setPrice(-6);
        a.setSaleprice(100);
        a.setDate(new Date());

        try {
            entityManager.persist(a);
            entityManager.persist(p);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Price Negative<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }

    }
    @Test
    public void NumberZero() {
        Addproduct a = new Addproduct();
        Product p = new Product();
        p.setAddproduct("test");
        a.setNumber(0);
        a.setPrice(6);
        a.setSaleprice(100);
        a.setDate(new Date());

        try {
            entityManager.persist(a);
            entityManager.persist(p);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Number Zero<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }

    }
    
    @Test
    public void SalepriceNegative() {
        Addproduct a = new Addproduct();
        Product p = new Product();
        p.setAddproduct("test");
        a.setNumber(5);
        a.setPrice(6);
        a.setSaleprice(-100);
        a.setDate(new Date());

        try {
            entityManager.persist(a);
            entityManager.persist(p);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Sale Price Negative<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }

    }
    
    @Test
    public void TestNamePatternError() {
        Addproduct a = new Addproduct();
        Product p = new Product();
        p.setAddproduct("*#@!@#$");
        a.setNumber(5);
        a.setPrice(6);
        a.setSaleprice(100);
        a.setDate(new Date());

        try {
            entityManager.persist(a);
            entityManager.persist(p);
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
    public void NameproductSizeMin() {
        Addproduct a = new Addproduct();
        Product p = new Product();
        p.setAddproduct("hh");
        a.setNumber(5);
        a.setPrice(6);
        a.setSaleprice(100);
        a.setDate(new Date());
        try {
            entityManager.persist(a);
            entityManager.persist(p);
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
    public void TestnameproductSizeMax() {
        Addproduct a = new Addproduct();
        Product p = new Product();
        p.setAddproduct("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        a.setNumber(5);
        a.setPrice(6);
        a.setSaleprice(100);
        a.setDate(new Date());
        try {
            entityManager.persist(a);
            entityManager.persist(p);
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
    public void NumberNegative() {
        Addproduct a = new Addproduct();
        Product p = new Product();
        p.setAddproduct("test");
        a.setNumber(-5);
        a.setPrice(6);
        a.setSaleprice(100);
        a.setDate(new Date());

        try {
            entityManager.persist(a);
            entityManager.persist(p);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test number Negative<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }

    }
    @Test
    public void Testnulltypeproducrt () {
        Typeproduct t = new Typeproduct();
        t.setTypeproduct(null);
        try {
            entityManager.persist(t);
            entityManager.flush();

           // fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Null type product<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
 
    @Test
    public void Datenull() {
        Addproduct a = new Addproduct();
        Product p = new Product();
        p.setAddproduct("test");
        a.setNumber(5);
        a.setPrice(10);
        a.setSaleprice(100);
        a.setDate(null);

        try {
            entityManager.persist(a);
            entityManager.persist(p);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Date not null<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }

    }
 


}