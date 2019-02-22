package com.sut.se.g03.G03;

import com.sut.se.g03.entity.Payment;
import com.sut.se.g03.repository.BillRepository;
import com.sut.se.g03.repository.CreditTypeRepository;
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
import java.util.Date;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PaymentTest {
    @Autowired
    private TestEntityManager entityManager;
    private Validator validator;
    @Autowired
    CreditTypeRepository creditTypeRepository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    BillRepository billRepository;
    @Autowired
    PaidStatusRepository paidStatusRepository;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void test05(){}

    //Date = null
    @Test
    public void testDateCannotNull(){
        Payment p =  new Payment();
        p.setDate(null);
        p.setPrice(555);
        p.setReceive("aaaaaaaaaa");
        p.setCredit(creditTypeRepository.findById(1L).get());
        p.setMember(memberRepository.findById(1L).get());
        p.setBill(billRepository.findById(1L).get());
        p.setPaidStatus(paidStatusRepository.findById(1L).get());
        try {
            entityManager.persist(p);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println(" Date is Null");
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);


        }
    }

    //Receive = null
    @Test
    public void testPriceCannotNull(){
        Payment p =  new Payment();
        p.setDate(new Date());
        p.setPrice(555);
        p.setReceive(null);
        p.setCredit(creditTypeRepository.findById(1L).get());
        p.setMember(memberRepository.findById(1L).get());
        p.setBill(billRepository.findById(1L).get());
        p.setPaidStatus(paidStatusRepository.findById(1L).get());
        try {
            entityManager.persist(p);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println(" Price is Null");
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);


        }
    }

    //CreditType = null
    @Test
    public void testCreditTypeCannotNull(){
        Payment p =  new Payment();
        p.setDate(new Date());
        p.setPrice(555);
        p.setReceive("aaaaaa");
        p.setCredit(null);
        p.setMember(memberRepository.findById(1L).get());
        p.setBill(billRepository.findById(1L).get());
        p.setPaidStatus(paidStatusRepository.findById(1L).get());
        try {
            entityManager.persist(p);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println(" CreditType is Null");
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);


        }
    }

    //Member = null
    @Test
    public void testMemberCannotNull(){
        Payment p =  new Payment();
        p.setDate(new Date());
        p.setPrice(555);
        p.setReceive("aaaaaa");
        p.setCredit(creditTypeRepository.findById(1L).get());
        p.setMember(null);
        p.setBill(billRepository.findById(1L).get());
        p.setPaidStatus(paidStatusRepository.findById(1L).get());
        try {
            entityManager.persist(p);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println(" Member is  Null");
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);


        }
    }

    //Bill = null
    @Test
    public void testBillCannotNull(){
        Payment p =  new Payment();
        p.setDate(new Date());
        p.setPrice(555);
        p.setReceive("aaaaaa");
        p.setCredit(creditTypeRepository.findById(1L).get());
        p.setMember(memberRepository.findById(1L).get());
        p.setBill(null);
        p.setPaidStatus(paidStatusRepository.findById(1L).get());
        try {
            entityManager.persist(p);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println(" Bill is  Null");
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);


        }
    }

    //PaidStatus = null
    @Test
    public void testPaidStatusCannotNull(){
        Payment p =  new Payment();
        p.setDate(new Date());
        p.setPrice(555);
        p.setReceive("aaaaaa");
        p.setCredit(creditTypeRepository.findById(1L).get());
        p.setMember(memberRepository.findById(1L).get());
        p.setBill(billRepository.findById(1L).get());
        p.setPaidStatus(null);
        try {
            entityManager.persist(p);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println(" PaidStatus is  Null");
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    //Receive =  min
    @Test
    public void testReceiveMin(){
        Payment p =  new Payment();
        p.setDate(new Date());
        p.setPrice(555);
        p.setReceive("a");
        p.setCredit(creditTypeRepository.findById(1L).get());
        p.setMember(memberRepository.findById(1L).get());
        p.setBill(billRepository.findById(1L).get());
        p.setPaidStatus(paidStatusRepository.findById(1L).get());

        try {
            entityManager.persist(p);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println(" Receive is  Min");
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    //Receive =  max
    @Test
    public void testReceiveMax(){
        Payment p =  new Payment();
        p.setDate(new Date());
        p.setPrice(555);
        p.setReceive("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        p.setCredit(creditTypeRepository.findById(1L).get());
        p.setMember(memberRepository.findById(1L).get());
        p.setBill(billRepository.findById(1L).get());
        p.setPaidStatus(paidStatusRepository.findById(1L).get());

        try {
            entityManager.persist(p);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println(" Receive is  Max");
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }


    //Price =  Negative
    @Test
    public void testPricePositiveOrZero(){
        Payment p =  new Payment();
        p.setDate(new Date());
        p.setPrice(-555);
        p.setReceive("aaaaaaaaaa");
        p.setCredit(creditTypeRepository.findById(1L).get());
        p.setMember(memberRepository.findById(1L).get());
        p.setBill(billRepository.findById(1L).get());
        p.setPaidStatus(paidStatusRepository.findById(1L).get());

        try {
            entityManager.persist(p);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println(" Receive  is  Negative");
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

}
