package com.sut.se.g03.G03;

import com.sut.se.g03.entity.Member;
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
public class MemberTest {
    @Autowired
    private TestEntityManager entityManager;
    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Test
    public void testUserNameCannotNull() {
        Member m = new Member();
        m.setUserName(null);
        m.setPassword("aaaaaaaaaa");
        try {
            entityManager.persist(m);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println(" Username is null");
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);


        }
    }

    @Test
    public void testPasswordCannotNull() {
        Member m = new Member();
        m.setUserName("zzzz");
        m.setPassword(null);
        try {
            entityManager.persist(m);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println(" Password is null");
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);


        }
    }

    @Test
    public void testUniqueUserName() {
        Member m1 = new Member();
        Member m2 = new Member();

        m1.setUserName("zzzz");
        m1.setPassword("aaaaaaaaaa");

        m2.setUserName("zzzz");
        m2.setPassword("bbbbbbbcc");
        try {
            entityManager.persist(m1);
            entityManager.flush();
            entityManager.persist(m2);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.persistence.PersistenceException e) {
            System.out.println(" --------------------- " + e + "Err Unique --------------------------------");
        }
    }
}



