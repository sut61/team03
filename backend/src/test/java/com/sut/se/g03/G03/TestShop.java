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
public class TestShop {
    @Autowired
    private ShopRepository shopRepository;
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
    public void testBeforeDoAnything2() {
    }
    //test Subdist = Null
    @Test
    public void TestSubdistCannotNull() {
        Shop f = new Shop();
        f.setItemNum(2);
        f.setSubdist(null);
        f.setCustomerName("aaaaaaaaaaaaaaa");
        f.setEmail("khnan@gmail.com");
        f.setTel("0111111111");
        f.setDistrictShop(entityManager.persist(new District("aaaaaaaaaaaaaa")));
        try {
            entityManager.persist(f);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println(" Subdist Shop Null");
            System.out.println(e);
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);

        }
    }
    //test CustomerName = Null
    @Test
    public void TestCustomerNameShopCannotNull() {
        Shop f = new Shop();
        f.setItemNum(2);
        f.setSubdist("aaaaaaaaaaaaaaa");
        f.setCustomerName(null);
        f.setEmail("khnan@gmail.com");
        f.setTel("0111111111");
        f.setDistrictShop(entityManager.persist(new District("aaaaaaaaaaaaaa")));
        try {
            entityManager.persist(f);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println(" CustomerName Shop Null");
            System.out.println(e);
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);

        }
    }
    //test Email = Null
    @Test
    public void TestEmailShopCannotNull() {
        Shop f = new Shop();
        f.setItemNum(2);
        f.setSubdist("aaaaaaaaaaaaaaa");
        f.setCustomerName("aaaaaaaaaaaaaaa");
        f.setEmail(null);
        f.setTel("0111111111");
        f.setDistrictShop(entityManager.persist(new District("aaaaaaaaaaaaaa")));
        try {
            entityManager.persist(f);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println(" Email Shop Null");
            System.out.println(e);
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);

        }
    }
    //test Tel = Null
    @Test
    public void TestTelShopCannotNull() {
        Shop f = new Shop();
        f.setItemNum(2);
        f.setSubdist("aaaaaaaaaaaaaaa");
        f.setCustomerName("aaaaaaaaaaaaaaa");
        f.setEmail("khnan@gmail.com");
        f.setTel(null);
        f.setDistrictShop(entityManager.persist(new District("aaaaaaaaaaaaaa")));
        try {
            entityManager.persist(f);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println(" Tel Shop Null");
            System.out.println(e);
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);

        }
    }
    //test District = Null
    @Test
    public void TestDistrictCannotNull() {
        Shop f = new Shop();
        f.setItemNum(2);
        f.setSubdist("aaaaaaaaaaaaaaa");
        f.setCustomerName("aaaaaaaaaaaaaaa");
        f.setEmail("khnan@gmail.com");
        f.setTel("0111111111");
        f.setDistrictShop(entityManager.persist(new District(null)));
        try {
            entityManager.persist(f);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println(" District Null");
            System.out.println(e);
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);

        }
    }
    //test Subdist = Size Min
    @Test
    public void TestSubdistSizeMin() {
        Shop f = new Shop();
        f.setItemNum(2);
        f.setSubdist("aa");
        f.setCustomerName("aaaaaaaaaaaaaaa");
        f.setEmail("khnan@gmail.com");
        f.setTel("0111111111");
        f.setDistrictShop(entityManager.persist(new District("aaaaaaaaaaaaaaa")));
        try {
            entityManager.persist(f);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println(" Subdist Size Min");
            System.out.println(e);
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    //test Subdist = Size Max
    @Test
    public void TestSubdistSizeMax() {
        Shop f = new Shop();
        f.setItemNum(2);
        f.setSubdist("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        f.setCustomerName("aaaaaaaaaaaaaaa");
        f.setEmail("khnan@gmail.com");
        f.setTel("0111111111");
        f.setDistrictShop(entityManager.persist(new District("aaaaaaaaaaaaaaa")));
        try {
            entityManager.persist(f);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println(" Subdist Size Max");
            System.out.println(e);
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    //test Tel Shop = Pattern
    @Test
    public void TestTelShopPatternError() {
        Shop f = new Shop();
        f.setItemNum(2);
        f.setSubdist("aaaaaaaaaaaaaaa");
        f.setCustomerName("aaaaaaaaaaaaaaa");
        f.setEmail("khnan@gmail.com");
        f.setTel("aaaa222222");
        f.setDistrictShop(entityManager.persist(new District("aaaaaaaaaaaaaaa")));
        try {
            entityManager.persist(f);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println(" Tel Shop = Pattern Error");
            System.out.println(e);
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testUniqueEmail() {
        Shop f = new Shop();
        Shop f1 = new Shop();
        f.setItemNum(2);
        f.setSubdist("aaaaaaaaaaaaaaa");
        f.setCustomerName("aaaaaaaaaaaaaaa");
        f.setEmail("khnan@gmail.com");
        f.setTel("0123456689");
        f.setDistrictShop(entityManager.persist(new District("aaaaaaaaaaaaaaa")));

        f1.setItemNum(2);
        f1.setSubdist("bbbbbbbbbbbbbbb");
        f1.setCustomerName("bbbbbbbbbbbbbbb");
        f1.setEmail("khnan@gmail.com");
        f1.setTel("0123456789");
        f1.setDistrictShop(entityManager.persist(new District("bbbbbbbbbbbbbbb")));

        try {
            entityManager.persist(f);
            entityManager.flush();
            entityManager.persist(f1);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.persistence.PersistenceException e) {
            System.out.println();
            System.out.println(" --------------------- "+e+"Err Unique --------------------------------");
            System.out.println();
        }
    }
}
