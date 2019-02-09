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
import com.sut.se.g03.entity.CourseMusic;
import com.sut.se.g03.entity.StatusCourse;
import com.sut.se.g03.entity.Member;
import com.sut.se.g03.entity.CourseReserve;
import com.sut.se.g03.repository.CourseReserveRepository;
import com.sut.se.g03.repository.StatusCourseRepository;
import com.sut.se.g03.repository.CourseMusicRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CourseReserveTest {
    @Autowired  
	private CourseMusicRepository courseMusicRepository;
   
    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testTrue() {
        CourseReserve s = new CourseReserve();
        s.setPhone("085-1234567");
        s.setNickname("เฟรมซุ่ม");
        s.setNameFacebook("frame frame");
        s.setCoursemusic(courseMusicRepository.findById(1L).get());
        s.setStatusCourse(entityManager.persist(new StatusCourse("ใช้งาน")));
        try {
            entityManager.persist(s);
            entityManager.flush();

        } catch(javax.validation.ConstraintViolationException e) {
            fail("Should not pass to this line");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testNullPhone() {
        CourseReserve s = new CourseReserve();
        s.setPhone(null);
        s.setNickname("เฟรมซุ่ม");
        s.setNameFacebook("frame frame");
        s.setCoursemusic(courseMusicRepository.findById(1L).get());
        s.setStatusCourse(entityManager.persist(new StatusCourse("ใช้งาน")));

        try {
            entityManager.persist(s);
            entityManager.flush();
            fail("Should not pass to this line");

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testSizeLongPhone() {
        CourseReserve s = new CourseReserve();
        s.setPhone("085-12345678");
        s.setNickname("เฟรมซุ่ม");
        s.setNameFacebook("frame frame");
        s.setCoursemusic(courseMusicRepository.findById(1L).get());
        s.setStatusCourse(entityManager.persist(new StatusCourse("ใช้งาน")));

        try {
            entityManager.persist(s);
            entityManager.flush();
            fail("Should not pass to this line");

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testSizeShortPhone() {
        CourseReserve s = new CourseReserve();
        s.setPhone("085-12345");
        s.setNickname("เฟรมซุ่ม");
        s.setNameFacebook("frame frame");
        s.setCoursemusic(courseMusicRepository.findById(1L).get());
        s.setStatusCourse(entityManager.persist(new StatusCourse("ใช้งาน")));

        try {
            entityManager.persist(s);
            entityManager.flush();
            fail("Should not pass to this line");

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testPatternPhone() {
        CourseReserve s = new CourseReserve();
        s.setPhone("08512345678");
        s.setNickname("เฟรมซุ่ม");
        s.setNameFacebook("frame frame");
        s.setCoursemusic(courseMusicRepository.findById(1L).get());
        s.setStatusCourse(entityManager.persist(new StatusCourse("ใช้งาน")));

        try {
            entityManager.persist(s);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testNullNameFacebook() {
        CourseReserve s = new CourseReserve();
        s.setPhone("085-1234567");
        s.setNickname("เฟรมซุ่ม");
        s.setNameFacebook(null);
        s.setCoursemusic(courseMusicRepository.findById(1L).get());
        s.setStatusCourse(entityManager.persist(new StatusCourse("ใช้งาน")));

        try {
            entityManager.persist(s);
            entityManager.flush();
            fail("Should not pass to this line");

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testNullNickname() {
        CourseReserve s = new CourseReserve();
        s.setPhone("085-1234567");
        s.setNickname(null);
        s.setNameFacebook("frame frame");
        s.setCoursemusic(courseMusicRepository.findById(1L).get());
        s.setStatusCourse(entityManager.persist(new StatusCourse("ใช้งาน")));

        try {
            entityManager.persist(s);
            entityManager.flush();
            fail("Should not pass to this line");

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testSizeShortNickName() {
        CourseReserve s = new CourseReserve();
        s.setPhone("085-1234567");
        s.setNickname("a");
        s.setNameFacebook("frame frame");
        s.setCoursemusic(courseMusicRepository.findById(1L).get());
        s.setStatusCourse(entityManager.persist(new StatusCourse("ใช้งาน")));

        try {
            entityManager.persist(s);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testSizeLongNickName() {
        CourseReserve s = new CourseReserve();
        s.setPhone("085-1234567");
        s.setNickname("เฟรมซุ่มเฟรมซุ่มเฟรมซุ่มเฟรมซุ่ม");
        s.setNameFacebook("frame frame");
        s.setCoursemusic(courseMusicRepository.findById(1L).get());
        s.setStatusCourse(entityManager.persist(new StatusCourse("ใช้งาน")));

        try {
            entityManager.persist(s);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testNullCourseMusic() {
        CourseReserve s = new CourseReserve();
        s.setPhone("085-1234567");
        s.setNickname("เฟรมซุ่ม");
        s.setNameFacebook("frame frame");
        s.setCoursemusic(null);
        s.setStatusCourse(entityManager.persist(new StatusCourse("ใช้งาน")));

        try {
            entityManager.persist(s);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testNullStatusCourse() {
        CourseReserve s = new CourseReserve();
        s.setPhone("085-1234567");
        s.setNickname("เฟรมซุ่ม");
        s.setNameFacebook("frame frame");
        s.setCoursemusic(courseMusicRepository.findById(1L).get());
        s.setStatusCourse(null);

        try {
            entityManager.persist(s);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testNullStatusCourseName() {
        StatusCourse s = new StatusCourse();
        s.setName(null);

        try {
            entityManager.persist(s);
            entityManager.flush();
            fail("Should not pass to this line");

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

}