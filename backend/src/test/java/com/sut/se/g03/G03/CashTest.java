package com.sut.se.g03.G03;

import com.sut.se.g03.entity.Cash;
import com.sut.se.g03.repository.BillRepository;
import com.sut.se.g03.repository.MemberRepository;
import com.sut.se.g03.repository.PaidStatusRepository;
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
public class CashTest {
    @Autowired
    private TestEntityManager entityManager;
    private Validator validator;

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    BillRepository billRepository;
    @Autowired
    PaidStatusRepository paidStatusRepository;

    @Before
    public void setup(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testcash(){}

    @Test
    public void testCashReceiveCannotNull(){
         Cash c =  new Cash();
         c.setCashreceive(null);
         c.setCashprice(555);
         c.setMem(memberRepository.findById(1L).get());
         c.setBill(billRepository.findById(1L).get());
         c.setPaidStatus(paidStatusRepository.findById(1L).get());
        try {
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println(" CashReceive is Null");
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);


        }
    }

    @Test
    public void testCashMemberCannotNull(){
        Cash c = new Cash();
        c.setCashreceive("aaaaa");
        c.setCashprice(555);
        c.setMem(null);
        c.setBill(billRepository.findById(1L).get());
        c.setPaidStatus(paidStatusRepository.findById(1L).get());
        try {
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println(" cashReceive is Null");
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);


        }
    }

    @Test
    public void testCashBillCannotNull(){
        Cash c = new Cash();
        c.setCashreceive("aaaaa");
        c.setCashprice(555);
        c.setMem(memberRepository.findById(1L).get());
        c.setBill(null);
        c.setPaidStatus(paidStatusRepository.findById(1L).get());
        try {
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println(" CashBill is Null");
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);


        }
    }

    @Test
    public void testCashPaidStatusCannotNull(){
        Cash c = new Cash();
        c.setCashreceive("aaaaa");
        c.setCashprice(555);
        c.setMem(memberRepository.findById(1L).get());
        c.setBill(billRepository.findById(1l).get());
        c.setPaidStatus(null);
        try {
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println(" PaidStatus is Null");
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);


        }
    }

    @Test
    public void testCashPricePositiveOrZero(){
        Cash c = new Cash();
        c.setCashreceive("aaaaa");
        c.setCashprice(-555);
        c.setMem(memberRepository.findById(1L).get());
        c.setBill(billRepository.findById(1l).get());
        c.setPaidStatus(paidStatusRepository.findById(1L).get());
        try {
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println(" CashPrice is PositiveOrZero");
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);


        }
    }

    @Test
    public void testCashReceiveSizeMin(){
        Cash c = new Cash();
        c.setCashreceive("a");
        c.setCashprice(555);
        c.setMem(memberRepository.findById(1L).get());
        c.setBill(billRepository.findById(1l).get());
        c.setPaidStatus(paidStatusRepository.findById(1L).get());
        try {
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println(" CashReceive is SizeMin");
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);


        }
    }

    @Test
    public void testCashReceiveSizeMax(){
        Cash c = new Cash();
        c.setCashreceive("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        c.setCashprice(555);
        c.setMem(memberRepository.findById(1L).get());
        c.setBill(billRepository.findById(1l).get());
        c.setPaidStatus(paidStatusRepository.findById(1L).get());
        try {
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println(" CashReceive is SizeMax");
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);


        }
    }

    @Test
    public void testCashReceivePattern(){
        Cash c = new Cash();
        c.setCashreceive("-*/-*/-*/-");
        c.setCashprice(555);
        c.setMem(memberRepository.findById(1L).get());
        c.setBill(billRepository.findById(1l).get());
        c.setPaidStatus(paidStatusRepository.findById(1L).get());
        try {
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println(" CashReceive in Pattern");
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);


        }
    }
}




