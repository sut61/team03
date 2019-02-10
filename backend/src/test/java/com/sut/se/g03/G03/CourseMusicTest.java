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
public class CourseMusicTest {

	@Autowired
    private CourseMusicRepository courseMusicRepository;
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
   public void CourseMusicTest() {
       
   }
  
    @Test
    public void testCourseMusicFnameCannotBeNull() {
        CourseMusic cm = new CourseMusic();
        cm.setFname(null);
        cm.setLname("จันทวัติกุล");
        cm.setNickname("ฟี่");
        cm.setTelephone("0986270527");
        cm.setClassroom(classroomRepository.findById(1L).get());


        try {
            entityManager.persist(cm);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println("");
            System.out.println("");
            System.out.println("Test FnameCannotBeNull Pass");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

   @Test
    public void testCourseMusicLnameCannotBeNull() {
        CourseMusic cm = new CourseMusic();
        cm.setFname("ภัทรพล");
        cm.setLname(null);
        cm.setNickname("ฟี่");
        cm.setTelephone("0986270527");
        cm.setClassroom(classroomRepository.findById(1L).get());


        try {
            entityManager.persist(cm);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println("");
            System.out.println("");
            System.out.println("Test LnameCannotBeNull Pass");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testCourseMusicNicknameCannotBeNull() {
        CourseMusic cm = new CourseMusic();
        cm.setFname("ภัทรพล");
        cm.setLname("จันทวัติกุล");
        cm.setNickname(null);
        cm.setTelephone("0986270527");
        cm.setClassroom(classroomRepository.findById(1L).get());


        try {
            entityManager.persist(cm);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println("");
            System.out.println("");
            System.out.println("Test NicknameCannotBeNull Pass");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

   @Test
    public void testCourseMusicTelephoneCannotBeNull() {
        CourseMusic cm = new CourseMusic();
        cm.setFname("ภัทรพล");
        cm.setLname("จันทวัติกุล");
        cm.setNickname("ฟี่");
        cm.setTelephone(null);
        cm.setClassroom(classroomRepository.findById(1L).get());


        try {
            entityManager.persist(cm);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println("");
            System.out.println("");
            System.out.println("Test TelephoneCannotBeNull Pass");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testCourseMusicFnameCannotMorethanTwenty() {
        CourseMusic cm = new CourseMusic();
        cm.setFname("ภัทรพลเทพซ่าจีจีจีจีจี");
        cm.setLname("จันทวัติกุล");
        cm.setNickname("ฟี่");
        cm.setTelephone("0986270527");
       cm.setClassroom(classroomRepository.findById(1L).get());

        try {
            entityManager.persist(cm);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println("");
            System.out.println("");
            System.out.println("Test FnameCannotMorethanTwelve Pass");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testCourseMusicFnameCannotLessthanThree() {
        CourseMusic cm = new CourseMusic();
        cm.setFname("คน");
        cm.setLname("จันทวัติกุล");
        cm.setNickname("ฟี่");
        cm.setTelephone("0986270527");
        cm.setClassroom(classroomRepository.findById(1L).get());


        try {
            entityManager.persist(cm);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println("");
            System.out.println("");
            System.out.println("Test FnameCannotLessthanThree Pass");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testCourseMusicFnameCannotBeNumber() {
        CourseMusic cm = new CourseMusic();
        cm.setFname("ภัทรพล789");
        cm.setLname("จันทวัติกุล");
        cm.setNickname("ฟี่");
        cm.setTelephone("0986270527");
        cm.setClassroom(classroomRepository.findById(1L).get());


        try {
            entityManager.persist(cm);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println("");
            System.out.println("");
            System.out.println("Test FnameCannotBeNumber Pass");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }


    @Test
    public void testCourseMusicLnameCannotMorethanTwentyFive() {
        CourseMusic cm = new CourseMusic();
        cm.setFname("ภัทรพล");
        cm.setLname("จันทวัติกุลเทพซ่าไหมล่ะฮ่าฮ่า");
        cm.setNickname("ฟี่");
        cm.setTelephone("0986270527");
        cm.setClassroom(classroomRepository.findById(1L).get());


        try {
            entityManager.persist(cm);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println("");
            System.out.println("");
            System.out.println("Test LnameCannotMorethanTwentyFive Pass");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testCourseMusicLnameCannotLessthanThree() {
        CourseMusic cm = new CourseMusic();
        cm.setFname("ภัทรพล");
        cm.setLname("คน");
        cm.setNickname("ฟี่");
        cm.setTelephone("0986270527");
        cm.setClassroom(classroomRepository.findById(1L).get());


        try {
            entityManager.persist(cm);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println("");
            System.out.println("");
            System.out.println("Test LnameCannotCannotLessthanThree Pass");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testCourseMusicLnameCannotBeNumber() {
        CourseMusic cm = new CourseMusic();
        cm.setFname("ภัทรพล");
        cm.setLname("จันทวัติกุล789");
        cm.setNickname("ฟี่");
        cm.setTelephone("0986270527");
        cm.setClassroom(classroomRepository.findById(1L).get());


        try {
            entityManager.persist(cm);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println("");
            System.out.println("");
            System.out.println("Test LnameCannotBeNumber Pass");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testCourseMusicNicknameCannotMorethanEight() {
        CourseMusic cm = new CourseMusic();
        cm.setFname("ภัทรพล");
        cm.setLname("จันทวัติกุล");
        cm.setNickname("ท๊อฟฟี่เทพซ่า");
        cm.setTelephone("0986270527");
        cm.setClassroom(classroomRepository.findById(1L).get());


        try {
            entityManager.persist(cm);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println("");
            System.out.println("");
            System.out.println("Test NicknameCannotMorethanEight Pass");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testCourseMusicNicknameCannotBeNumber() {
        CourseMusic cm = new CourseMusic();
        cm.setFname("ภัทรพล");
        cm.setLname("จันทวัติกุล");
        cm.setNickname("ท๊อฟฟี่7");
        cm.setTelephone("0986270527");
        cm.setClassroom(classroomRepository.findById(1L).get());


        try {
            entityManager.persist(cm);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println("");
            System.out.println("");
            System.out.println("Test NicknameCannotBeNumber Pass");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testCourseMusicTelephoneEqualTenString() {
        CourseMusic cm = new CourseMusic();
        cm.setFname("ภัทรพล");
        cm.setLname("จันทวัติกุล");
        cm.setNickname("ท๊อฟฟี่");
        cm.setTelephone("0986270527123456");
        cm.setClassroom(classroomRepository.findById(1L).get());


        try {
            entityManager.persist(cm);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println("");
            System.out.println("");
            System.out.println("Test TelephoneEqualTenString Pass");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testCourseMusicTelephoneFirstNumberEqualZero() {
        CourseMusic cm = new CourseMusic();
        cm.setFname("ภัทรพล");
        cm.setLname("จันทวัติกุล");
        cm.setNickname("ท๊อฟฟี่");
        cm.setTelephone("3986270527");
        cm.setClassroom(classroomRepository.findById(1L).get());


        try {
            entityManager.persist(cm);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println("");
            System.out.println("");
            System.out.println("Test TelephoneFirstNumberEqualZero Pass");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testCourseMusicClassroomCannotBeNull() {
        CourseMusic cm = new CourseMusic();
        cm.setFname("ภัทรพล");
        cm.setLname("จันทวัติกุล");
        cm.setNickname("ท๊อฟฟี่");
        cm.setTelephone("0986270527");
        cm.setClassroom(null);


        try {
            entityManager.persist(cm);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println("");
            System.out.println("");
            System.out.println("Test ClassroomCannotBeNull Pass");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

   
    

   


}
