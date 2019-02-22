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
public class ClassroomTest {

	@Autowired
    private ClassroomRepository classroomRepository;
   
    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
   
  @Test
    public void testClassroomCorrect() {
        Classroom cr = new Classroom();
        cr.setName("C1Keyboard");
        try {
            entityManager.persist(cr);
            entityManager.flush();
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println("");
            System.out.println("");
            System.out.println("Test ClassroomCorrect Pass");
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
    public void testClassroomNameCannotBeNull() {
        Classroom cr = new Classroom();
        cr.setName(null);
       
        try {
            entityManager.persist(cr);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println("");
            System.out.println("");
            System.out.println("Test ClassroomNameCannotBeNull Pass");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

   


}
