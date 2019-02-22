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
    private CourseTimeRepository courseTimeRepository;
    @Autowired
    private PaymentTypeRepository paymentTypeRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private InstrumentRepository instrumentRepository;
    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Test
    public void testCourseMusicCorrect() {
        CourseMusic cm = new CourseMusic();
        cm.setFname("ภัทรพล");
        cm.setLname("จันทวัติกุล");
        cm.setNickname("อาจารย์ท๊อฟฟี่");
        cm.setTelephone("0986270527");
        cm.setClassroom(classroomRepository.findById(1L).get());
        cm.setCourseTime(courseTimeRepository.findById(1L).get());
        cm.setPaymentType(paymentTypeRepository.findById(1L).get());
        cm.setMember(memberRepository.findById(1L).get());
        cm.setInstrument(instrumentRepository.findById(1L).get());


        try {
            entityManager.persist(cm);
            entityManager.flush();
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println("");
            System.out.println("");
            System.out.println("Test CourseMusicCorrect Pass");
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
    public void testCourseMusicFnameCannotBeNullAndNotBlank() {
        CourseMusic cm = new CourseMusic();
        cm.setFname(null);
        cm.setLname("จันทวัติกุล");
        cm.setNickname("อาจารย์ท๊อฟฟี่");
        cm.setTelephone("0986270527");
        cm.setClassroom(classroomRepository.findById(1L).get());
        cm.setCourseTime(courseTimeRepository.findById(1L).get());
        cm.setPaymentType(paymentTypeRepository.findById(1L).get());
        cm.setMember(memberRepository.findById(1L).get());
        cm.setInstrument(instrumentRepository.findById(1L).get());
        

        try {
            entityManager.persist(cm);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println("");
            System.out.println("");
            System.out.println("Test CourseMusicFnameCannotBeNullAndNotBlank Pass");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }
    @Test
    public void testCourseMusicLnameCannotBeNullAndNotBlank() {
        CourseMusic cm = new CourseMusic();
        cm.setFname("ภัทรพล");
        cm.setLname(null);
        cm.setNickname("อาจารย์ท๊อฟฟี่");
        cm.setTelephone("0986270527");
        cm.setClassroom(classroomRepository.findById(1L).get());
        cm.setCourseTime(courseTimeRepository.findById(1L).get());
        cm.setPaymentType(paymentTypeRepository.findById(1L).get());
        cm.setMember(memberRepository.findById(1L).get());
        cm.setInstrument(instrumentRepository.findById(1L).get());


        try {
            entityManager.persist(cm);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println("");
            System.out.println("");
            System.out.println("Test CourseMusicLnameCannotBeNullAndNotBlank Pass");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }

    @Test
    public void testCourseMusicNicknameCannotBeNullAndNotBlank() {
        CourseMusic cm = new CourseMusic();
        cm.setFname("ภัทรพล");
        cm.setLname("จันทวัติกุล");
        cm.setNickname(null);
        cm.setTelephone("0986270527");
        cm.setClassroom(classroomRepository.findById(1L).get());
        cm.setCourseTime(courseTimeRepository.findById(1L).get());
        cm.setPaymentType(paymentTypeRepository.findById(1L).get());
        cm.setMember(memberRepository.findById(1L).get());
        cm.setInstrument(instrumentRepository.findById(1L).get());


        try {
            entityManager.persist(cm);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println("");
            System.out.println("");
            System.out.println("Test CourseMusicNicknameCannotBeNullAndNotBlank Pass");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }

   @Test
    public void testCourseMusicTelephoneCannotBeNullAndNotBlank() {
        CourseMusic cm = new CourseMusic();
        cm.setFname("ภัทรพล");
        cm.setLname("จันทวัติกุล");
        cm.setNickname("อาจารย์ท๊อฟฟี่");
        cm.setTelephone(null);
        cm.setClassroom(classroomRepository.findById(1L).get());
        cm.setCourseTime(courseTimeRepository.findById(1L).get());
        cm.setPaymentType(paymentTypeRepository.findById(1L).get());
        cm.setMember(memberRepository.findById(1L).get());
        cm.setInstrument(instrumentRepository.findById(1L).get());


        try {
            entityManager.persist(cm);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println("");
            System.out.println("");
            System.out.println("Test CourseMusicTelephoneCannotBeNullAndNotBlank Pass");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }

    @Test
    public void testCourseMusicFnameCannotBeSpacebar() {
        CourseMusic cm = new CourseMusic();
        cm.setFname(" ");
        cm.setLname("จันทวัติกุล");
        cm.setNickname("อาจารย์ท๊อฟฟี่");
        cm.setTelephone("0986270527");
        cm.setClassroom(classroomRepository.findById(1L).get());
        cm.setCourseTime(courseTimeRepository.findById(1L).get());
        cm.setPaymentType(paymentTypeRepository.findById(1L).get());
        cm.setMember(memberRepository.findById(1L).get());
        cm.setInstrument(instrumentRepository.findById(1L).get());
        

        try {
            entityManager.persist(cm);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println("");
            System.out.println("");
            System.out.println("Test CourseMusicFnameCannotBeSpacebar Pass");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 3);
        }
    }
    @Test
    public void testCourseMusicLnameCannotBeSpacebar() {
        CourseMusic cm = new CourseMusic();
        cm.setFname("ภัทรพล");
        cm.setLname(" ");
        cm.setNickname("อาจารย์ท๊อฟฟี่");
        cm.setTelephone("0986270527");
        cm.setClassroom(classroomRepository.findById(1L).get());
        cm.setCourseTime(courseTimeRepository.findById(1L).get());
        cm.setPaymentType(paymentTypeRepository.findById(1L).get());
        cm.setMember(memberRepository.findById(1L).get());
        cm.setInstrument(instrumentRepository.findById(1L).get());


        try {
            entityManager.persist(cm);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println("");
            System.out.println("");
            System.out.println("Test CourseMusicLnameCannotBeSpacebar Pass");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 3);
        }
    }

    @Test
    public void testCourseMusicNicknameCannotBeSpacebar() {
        CourseMusic cm = new CourseMusic();
        cm.setFname("ภัทรพล");
        cm.setLname("จันทวัติกุล");
        cm.setNickname(" ");
        cm.setTelephone("0986270527");
        cm.setClassroom(classroomRepository.findById(1L).get());
        cm.setCourseTime(courseTimeRepository.findById(1L).get());
        cm.setPaymentType(paymentTypeRepository.findById(1L).get());
        cm.setMember(memberRepository.findById(1L).get());
        cm.setInstrument(instrumentRepository.findById(1L).get());


        try {
            entityManager.persist(cm);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println("");
            System.out.println("");
            System.out.println("Test CourseMusicNicknameCannotBeSpacebar Pass");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 3);
        }
    }

   @Test
    public void testCourseMusicTelephoneCannotBeSpacebar() {
        CourseMusic cm = new CourseMusic();
        cm.setFname("ภัทรพล");
        cm.setLname("จันทวัติกุล");
        cm.setNickname("อาจารย์ท๊อฟฟี่");
        cm.setTelephone(" ");
        cm.setClassroom(classroomRepository.findById(1L).get());
        cm.setCourseTime(courseTimeRepository.findById(1L).get());
        cm.setPaymentType(paymentTypeRepository.findById(1L).get());
        cm.setMember(memberRepository.findById(1L).get());
        cm.setInstrument(instrumentRepository.findById(1L).get());


        try {
            entityManager.persist(cm);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println("");
            System.out.println("");
            System.out.println("Test CourseMusicTelephoneCannotBeSpacebar Pass");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 3);
        }
    }

    @Test
    public void testCourseMusicFnameCannotMorethanTwenty() {
        CourseMusic cm = new CourseMusic();
        cm.setFname("ภัทรพลเทพซ่าจีจีจีจีจี");
        cm.setLname("จันทวัติกุล");
        cm.setNickname("อาจารย์ท๊อฟฟี่");
        cm.setTelephone("0986270527");
       cm.setClassroom(classroomRepository.findById(1L).get());
       cm.setCourseTime(courseTimeRepository.findById(1L).get());
        cm.setPaymentType(paymentTypeRepository.findById(1L).get());
        cm.setMember(memberRepository.findById(1L).get());
        cm.setInstrument(instrumentRepository.findById(1L).get());

        try {
            entityManager.persist(cm);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println("");
            System.out.println("");
            System.out.println("Test CourseMusicFnameCannotMorethanTwenty Pass");
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
        cm.setNickname("อาจารย์ท๊อฟฟี่");
        cm.setTelephone("0986270527");
        cm.setClassroom(classroomRepository.findById(1L).get());
        cm.setCourseTime(courseTimeRepository.findById(1L).get());
        cm.setPaymentType(paymentTypeRepository.findById(1L).get());
        cm.setMember(memberRepository.findById(1L).get());
        cm.setInstrument(instrumentRepository.findById(1L).get());


        try {
            entityManager.persist(cm);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println("");
            System.out.println("");
            System.out.println("Test CourseMusicFnameCannotLessthanThree Pass");
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
        cm.setNickname("อาจารย์ท๊อฟฟี่");
        cm.setTelephone("0986270527");
        cm.setClassroom(classroomRepository.findById(1L).get());
        cm.setCourseTime(courseTimeRepository.findById(1L).get());
        cm.setPaymentType(paymentTypeRepository.findById(1L).get());
        cm.setMember(memberRepository.findById(1L).get());
        cm.setInstrument(instrumentRepository.findById(1L).get());


        try {
            entityManager.persist(cm);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println("");
            System.out.println("");
            System.out.println("Test CourseMusicFnameCannotBeNumber Pass");
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
        cm.setNickname("อาจารย์ท๊อฟฟี่");
        cm.setTelephone("0986270527");
        cm.setClassroom(classroomRepository.findById(1L).get());
        cm.setCourseTime(courseTimeRepository.findById(1L).get());
        cm.setPaymentType(paymentTypeRepository.findById(1L).get());
        cm.setMember(memberRepository.findById(1L).get());
        cm.setInstrument(instrumentRepository.findById(1L).get());


        try {
            entityManager.persist(cm);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println("");
            System.out.println("");
            System.out.println("Test CourseMusicLnameCannotMorethanTwentyFive Pass");
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
        cm.setNickname("อาจารย์ท๊อฟฟี่");
        cm.setTelephone("0986270527");
        cm.setClassroom(classroomRepository.findById(1L).get());
        cm.setCourseTime(courseTimeRepository.findById(1L).get());
        cm.setPaymentType(paymentTypeRepository.findById(1L).get());
        cm.setMember(memberRepository.findById(1L).get());
        cm.setInstrument(instrumentRepository.findById(1L).get());


        try {
            entityManager.persist(cm);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println("");
            System.out.println("");
            System.out.println("Test CourseMusicLnameCannotLessthanThree Pass");
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
        cm.setNickname("อาจารย์ท๊อฟฟี่");
        cm.setTelephone("0986270527");
        cm.setClassroom(classroomRepository.findById(1L).get());
        cm.setCourseTime(courseTimeRepository.findById(1L).get());
        cm.setPaymentType(paymentTypeRepository.findById(1L).get());
        cm.setMember(memberRepository.findById(1L).get());
        cm.setInstrument(instrumentRepository.findById(1L).get());


        try {
            entityManager.persist(cm);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println("");
            System.out.println("");
            System.out.println("Test CourseMusicLnameCannotBeNumber Pass");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testCourseMusicNicknameCannotMorethanSixteen() {
        CourseMusic cm = new CourseMusic();
        cm.setFname("ภัทรพล");
        cm.setLname("จันทวัติกุล");
        cm.setNickname("อาจารย์ท๊อฟฟี่เทพซ่า");
        cm.setTelephone("0986270527");
        cm.setClassroom(classroomRepository.findById(1L).get());
        cm.setCourseTime(courseTimeRepository.findById(1L).get());
        cm.setPaymentType(paymentTypeRepository.findById(1L).get());
        cm.setMember(memberRepository.findById(1L).get());
        cm.setInstrument(instrumentRepository.findById(1L).get());


        try {
            entityManager.persist(cm);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println("");
            System.out.println("");
            System.out.println("Test CourseMusicNicknameCannotMorethanSixteen Pass");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testCourseMusicNicknameCannotLessthanThree() {
        CourseMusic cm = new CourseMusic();
        cm.setFname("ภัทรพล");
        cm.setLname("จันทวัติกุล");
        cm.setNickname("อา");
        cm.setTelephone("0986270527");
        cm.setClassroom(classroomRepository.findById(1L).get());
        cm.setCourseTime(courseTimeRepository.findById(1L).get());
        cm.setPaymentType(paymentTypeRepository.findById(1L).get());
        cm.setMember(memberRepository.findById(1L).get());
        cm.setInstrument(instrumentRepository.findById(1L).get());


        try {
            entityManager.persist(cm);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println("");
            System.out.println("");
            System.out.println("Test CourseMusicNicknameCannotLessthanThree Pass");
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
        cm.setNickname("อาจารย์ท๊อฟฟี่7");
        cm.setTelephone("0986270527");
        cm.setClassroom(classroomRepository.findById(1L).get());
        cm.setCourseTime(courseTimeRepository.findById(1L).get());
        cm.setPaymentType(paymentTypeRepository.findById(1L).get());
        cm.setMember(memberRepository.findById(1L).get());
        cm.setInstrument(instrumentRepository.findById(1L).get());


        try {
            entityManager.persist(cm);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println("");
            System.out.println("");
            System.out.println("Test CourseMusicNicknameCannotBeNumber Pass");
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
        cm.setNickname("อาจารย์ท๊อฟฟี่");
        cm.setTelephone("0986270527123456");
        cm.setClassroom(classroomRepository.findById(1L).get());
        cm.setCourseTime(courseTimeRepository.findById(1L).get());
        cm.setPaymentType(paymentTypeRepository.findById(1L).get());
        cm.setMember(memberRepository.findById(1L).get());
        cm.setInstrument(instrumentRepository.findById(1L).get());


        try {
            entityManager.persist(cm);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println("");
            System.out.println("");
            System.out.println("Test CourseMusicTelephoneEqualTenString Pass");
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
        cm.setNickname("อาจารย์ท๊อฟฟี่");
        cm.setTelephone("3986270527");
        cm.setClassroom(classroomRepository.findById(1L).get());
        cm.setCourseTime(courseTimeRepository.findById(1L).get());
        cm.setPaymentType(paymentTypeRepository.findById(1L).get());
        cm.setMember(memberRepository.findById(1L).get());
        cm.setInstrument(instrumentRepository.findById(1L).get());


        try {
            entityManager.persist(cm);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println("");
            System.out.println("");
            System.out.println("Test CourseMusicTelephoneFirstNumberEqualZero Pass");
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
        cm.setNickname("อาจารย์ท๊อฟฟี่");
        cm.setTelephone("0986270527");
        cm.setClassroom(null);
        cm.setCourseTime(courseTimeRepository.findById(1L).get());
        cm.setPaymentType(paymentTypeRepository.findById(1L).get());
        cm.setMember(memberRepository.findById(1L).get());
        cm.setInstrument(instrumentRepository.findById(1L).get());


        try {
            entityManager.persist(cm);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println("");
            System.out.println("");
            System.out.println("Test CourseMusicClassroomCannotBeNull Pass");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testCourseMusicCourseTimeCannotBeNull() {
        CourseMusic cm = new CourseMusic();
        cm.setFname("ภัทรพล");
        cm.setLname("จันทวัติกุล");
        cm.setNickname("อาจารย์ท๊อฟฟี่");
        cm.setTelephone("0986270527");
        cm.setClassroom(classroomRepository.findById(1L).get());
        cm.setCourseTime(null);
        cm.setPaymentType(paymentTypeRepository.findById(1L).get());
        cm.setMember(memberRepository.findById(1L).get());
        cm.setInstrument(instrumentRepository.findById(1L).get());


        try {
            entityManager.persist(cm);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println("");
            System.out.println("");
            System.out.println("Test CourseMusicCourseTimeCannotBeNull Pass");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testCourseMusicPaymentTypeCannotBeNull() {
        CourseMusic cm = new CourseMusic();
        cm.setFname("ภัทรพล");
        cm.setLname("จันทวัติกุล");
        cm.setNickname("อาจารย์ท๊อฟฟี่");
        cm.setTelephone("0986270527");
        cm.setClassroom(classroomRepository.findById(1L).get());
        cm.setCourseTime(courseTimeRepository.findById(1L).get());
        cm.setPaymentType(null);
        cm.setMember(memberRepository.findById(1L).get());
        cm.setInstrument(instrumentRepository.findById(1L).get());


        try {
            entityManager.persist(cm);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println("");
            System.out.println("");
            System.out.println("Test CourseMusicPaymentTypeCannotBeNull Pass");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testCourseMusicMemberCannotBeNull() {
        CourseMusic cm = new CourseMusic();
        cm.setFname("ภัทรพล");
        cm.setLname("จันทวัติกุล");
        cm.setNickname("อาจารย์ท๊อฟฟี่");
        cm.setTelephone("0986270527");
        cm.setClassroom(classroomRepository.findById(1L).get());
        cm.setCourseTime(courseTimeRepository.findById(1L).get());
        cm.setPaymentType(paymentTypeRepository.findById(1L).get());
        cm.setMember(null);
        cm.setInstrument(instrumentRepository.findById(1L).get());


        try {
            entityManager.persist(cm);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println("");
            System.out.println("");
            System.out.println("Test CourseMusicMemberCannotBeNull Pass");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testCourseMusicInstrumentCannotBeNull() {
        CourseMusic cm = new CourseMusic();
        cm.setFname("ภัทรพล");
        cm.setLname("จันทวัติกุล");
        cm.setNickname("อาจารย์ท๊อฟฟี่");
        cm.setTelephone("0986270527");
        cm.setClassroom(classroomRepository.findById(1L).get());
        cm.setCourseTime(courseTimeRepository.findById(1L).get());
        cm.setPaymentType(paymentTypeRepository.findById(1L).get());
        cm.setMember(memberRepository.findById(1L).get());
        cm.setInstrument(null);


        try {
            entityManager.persist(cm);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println("");
            System.out.println("");
            System.out.println("Test CourseMusicMemberCannotBeNull Pass");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
   


}
