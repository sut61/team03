package com.sut.se.g03.G03;

import com.sut.se.g03.entity.Member;
import com.sut.se.g03.entity.Review;
import com.sut.se.g03.entity.Score;
import com.sut.se.g03.entity.ServiceType;
import com.sut.se.g03.repository.ReviewRepository;
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
public class ReviewTest {
    @Autowired private ReviewRepository reviewRepository;
    @Autowired private TestEntityManager entityManager;
    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    //test
    @Test
    public void test02(){}

    //test CommentNegative = Null
    @Test
    public void TestCommentNegativeCannotNull(){
        Review r = new Review();
        r.setCommentNegative(null);
        r.setCommentPositive("aaaaaaaaaaaaaaaaaaaa");
        r.setServiceType(entityManager.persist(new ServiceType("aaaa")));
        r.setScore(entityManager.persist(new Score(1)));
        r.setMember(entityManager.persist(new Member("aaaa")));
        try {
            entityManager.persist(r);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println(" NegativeComent Null");
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);


        }
    }

    //test CommentPositive = Null
    @Test
    public void TestCommentPositiveCannotNull(){
        Review r = new Review();
        r.setCommentNegative("aaaaaaaaaaaaaaaaaaaa");
        r.setCommentPositive(null);
        r.setServiceType(entityManager.persist(new ServiceType("aaaa")));
        r.setScore(entityManager.persist(new Score(1)));
        r.setMember(entityManager.persist(new Member("aaaa")));
        try {
            entityManager.persist(r);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println(" PositiveComment  Null ");
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);


        }
    }

    //CommentNegative = Blank
    @Test
    public void TestCommentNegativeCannotBlank(){
        Review r = new Review();
        r.setCommentNegative(" ");
        r.setCommentPositive("aaaaaaaaaaaaaaaaaaaa");
        r.setServiceType(entityManager.persist(new ServiceType("aaaa")));
        r.setScore(entityManager.persist(new Score(1)));
        r.setMember(entityManager.persist(new Member("aaaa")));
        try {
            entityManager.persist(r);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println(" NegativeComent Blank");
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);


        }
    }

    //CommentPositive = Blank
    @Test
    public void TestCommentPositiveCannotBlank(){
        Review r = new Review();
        r.setCommentNegative("aaaaaaaaaaaaaaaaaaaa");
        r.setCommentPositive(" ");
        r.setServiceType(entityManager.persist(new ServiceType("aaaa")));
        r.setScore(entityManager.persist(new Score(1)));
        r.setMember(entityManager.persist(new Member("aaaa")));
        try {
            entityManager.persist(r);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println(" PositiveComent Blank");
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);


        }
    }



    //test  ServiceType = Null
    @Test
    public void TestServiceTypeCannotNull(){
        Review r = new Review();
        r.setCommentNegative("aaaaaaaaaaaaaaaaaaaa");
        r.setCommentPositive("aaaaaaaaaaaaaaaaaaaa");
        r.setServiceType(null);
        r.setScore(entityManager.persist(new Score(1)));
        r.setMember(entityManager.persist(new Member("aaaa")));

        try {
            entityManager.persist(r);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println(" ServiceType Null");
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);


        }
    }

    //test Score = Null
    @Test
    public void TestScoreCannotNull(){
        Review r = new Review();
        r.setCommentNegative("aaaaaaaaaaaaaaaaaaaa");
        r.setCommentPositive("aaaaaaaaaaaaaaaaaaaa");
        r.setServiceType(entityManager.persist(new ServiceType("aaaa")));
        r.setScore(null);
        r.setMember(entityManager.persist(new Member("aaaa")));

        try {
            entityManager.persist(r);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println(" Score Null");
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);


        }
    }
    //test Member = Null
    @Test
    public void TestMembetCannotNull(){
        Review r = new Review();
        r.setCommentNegative("aaaaaaaaaaaaaaaaaaaa");
        r.setCommentPositive("aaaaaaaaaaaaaaaaaaaa");
        r.setServiceType(entityManager.persist(new ServiceType("aaaa")));
        r.setScore(entityManager.persist(new Score(1)));
        r.setMember(null);

        try {
            entityManager.persist(r);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println(" Member Null");
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);


        }
    }

    //test CommentNegative SizeMin
    @Test
    public void TestCommentNegativeSizeMin(){
        Review r = new Review();
        r.setCommentNegative("aaaa");
        r.setCommentPositive("aaaaaaaaaaaaaaaaaaaa");
        r.setServiceType(entityManager.persist(new ServiceType("aaaa")));
        r.setScore(entityManager.persist(new Score(1)));
        r.setMember(entityManager.persist(new Member("aaaa")));
        try {
            entityManager.persist(r);
            entityManager.flush();

            fail("Should not pass to this line");
        }catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println("Negative MinSize Error");
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    //test CommentPositive SizeMin
    @Test
    public void TestCommentPositiveSizeMin(){
        Review r = new Review();
        r.setCommentNegative("aaaaaaaaaaaaaaaaaaaa");
        r.setCommentPositive("aaaa");
        r.setServiceType(entityManager.persist(new ServiceType("aaaa")));
        r.setScore(entityManager.persist(new Score(1)));
        r.setMember(entityManager.persist(new Member("aaaa")));
        try {
            entityManager.persist(r);
            entityManager.flush();

            fail("Should not pass to this line");
        }catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println("Positive MinSize Error");
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }




    //test CommentNegative SizeMax
   @Test
    public  void TestCommentNegativeSizeMax(){
        Review r = new Review();
        r.setCommentNegative("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        r.setCommentPositive("aaaaaaaaaa");
        r.setServiceType(entityManager.persist(new ServiceType("aaaa")));
        r.setScore(entityManager.persist(new Score(1)));
        r.setMember(entityManager.persist(new Member("aaaa")));
        try {
            entityManager.persist(r);
            entityManager.flush();

            fail("Should not pass to this line");
        }catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println("Negative MaxSize Error");
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    //test CommentPositive SizeMax
    @Test
    public  void TestCommentPositiveSizeMax(){
        Review r = new Review();
        r.setCommentNegative("aaaaaaaaaa");
        r.setCommentPositive("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        r.setServiceType(entityManager.persist(new ServiceType("aaaa")));
        r.setScore(entityManager.persist(new Score(1)));
        r.setMember(entityManager.persist(new Member("aaaa")));
        try {
            entityManager.persist(r);
            entityManager.flush();

            fail("Should not pass to this line");
        }catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println("Positive MaxSize Error");
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }




    //test CommentNegative PatternFail
    @Test
    public void TestCommentNegativePattern(){
        Review r = new Review();
        r.setCommentNegative("-*/-*/-*/-*/-*/-/");
        r.setCommentPositive("aaaaaaaaaaa");
        r.setServiceType(entityManager.persist(new ServiceType("aaaa")));
        r.setScore(entityManager.persist(new Score(1)));
        r.setMember(entityManager.persist(new Member("aaaa")));
        try {
            entityManager.persist(r);
            entityManager.flush();

            fail("Should not pass to this line");
        }catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println("CommentNegative Pattern Error");
            System.out.println();
            System.out.println();


            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    //test CommentPositive PatternFail
    @Test
    public void TestCommentPositivePattern(){
        Review r = new Review();
        r.setCommentNegative("aaaaaaaaaaa");
        r.setCommentPositive("-*/-*/-*/-*/-*/-/");
        r.setServiceType(entityManager.persist(new ServiceType("aaaa")));
        r.setScore(entityManager.persist(new Score(1)));
        r.setMember(entityManager.persist(new Member("aaaa")));
        try {
            entityManager.persist(r);
            entityManager.flush();

            fail("Should not pass to this line");
        }catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println("CommentPositive Pattern Error");
            System.out.println();
            System.out.println();


            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }


}