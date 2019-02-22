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

import com.sut.se.g03.entity.Instrument;
import com.sut.se.g03.entity.Room;
import com.sut.se.g03.entity.RoomSize;
import com.sut.se.g03.entity.RoomType;
import com.sut.se.g03.entity.RoomInstrument;
import com.sut.se.g03.entity.StatusRoom;
import com.sut.se.g03.repository.RoomRepository;
import com.sut.se.g03.repository.RoomTypeRepository;
import com.sut.se.g03.repository.RoomSizeRepository;
import com.sut.se.g03.repository.StatusRoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RoomTest {
    @Autowired
    private RoomSizeRepository roomSizeRepository;

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Autowired
    private StatusRoomRepository statusRoomRepository;
   
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
        Room s = new Room();
        s.setName("R202");
        s.setRate(777);
        s.setRoomSize(roomSizeRepository.findById(1L).get());
        s.setRoomType(roomTypeRepository.findById(1L).get());
        s.setStatusRoom(statusRoomRepository.findById(1L).get());
        try {
            entityManager.persist(s);
            entityManager.flush();

        } catch(javax.validation.ConstraintViolationException e) {
            fail("Should not pass to this line");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("-------------------------------"+violations+"--------------------------");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testNameSizeMin() {
        Room s = new Room();
        s.setName("R20");
        s.setRate(777);
        s.setRoomSize(roomSizeRepository.findById(1L).get());
        s.setRoomType(roomTypeRepository.findById(1L).get());
        s.setStatusRoom(statusRoomRepository.findById(1L).get());
        try {
            entityManager.persist(s);
            entityManager.flush();
            fail("Should not pass to this line");

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("-------------------------------"+violations+"--------------------------");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    
    @Test
    public void testNameSizeMax() {
        Room s = new Room();
        s.setName("R2055");
        s.setRate(777);
        s.setRoomSize(roomSizeRepository.findById(1L).get());
        s.setRoomType(roomTypeRepository.findById(1L).get());
        s.setStatusRoom(statusRoomRepository.findById(1L).get());
        try {
            entityManager.persist(s);
            entityManager.flush();
            fail("Should not pass to this line");

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("-------------------------------"+violations+"--------------------------");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    
    @Test
    public void testNamePattern() {
        Room s = new Room();
        s.setName("Z202");
        s.setRate(777);
        s.setRoomSize(roomSizeRepository.findById(1L).get());
        s.setRoomType(roomTypeRepository.findById(1L).get());
        s.setStatusRoom(statusRoomRepository.findById(1L).get());
        try {
            entityManager.persist(s);
            entityManager.flush();
            fail("Should not pass to this line");

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("-------------------------------"+violations+"--------------------------");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testRoomNull() {
        Room s = new Room();
        s.setName(null);
        s.setRate(777);
        s.setRoomSize(roomSizeRepository.findById(1L).get());
        s.setRoomType(roomTypeRepository.findById(1L).get());
        s.setStatusRoom(statusRoomRepository.findById(1L).get());
        try {
            entityManager.persist(s);
            entityManager.flush();
            fail("Should not pass to this line");

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("-------------------------------"+violations+"--------------------------");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testUniqueNameFacebook() {
        Room s = new Room();
        Room s1 = new Room();
        s.setName("R202");
        s.setRate(775);
        s.setRoomSize(roomSizeRepository.findById(1L).get());
        s.setRoomType(roomTypeRepository.findById(1L).get());
        s.setStatusRoom(statusRoomRepository.findById(1L).get());

        s1.setName("R202");
        s1.setRate(777);
        s1.setRoomSize(roomSizeRepository.findById(2L).get());
        s1.setRoomType(roomTypeRepository.findById(2L).get());
        s1.setStatusRoom(statusRoomRepository.findById(2L).get());

        try {
            entityManager.persist(s);
            entityManager.flush();
            entityManager.persist(s1);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.persistence.PersistenceException e) {
         System.out.println(" --------------------- "+e+"Err Unique --------------------------------");
        }
    }

    @Test
    public void testRateMin() {
        Room s = new Room();
        s.setName("R202");
        s.setRate(0);
        s.setRoomSize(roomSizeRepository.findById(1L).get());
        s.setRoomType(roomTypeRepository.findById(1L).get());
        s.setStatusRoom(statusRoomRepository.findById(1L).get());
        try {
            entityManager.persist(s);
            entityManager.flush();
            fail("Should not pass to this line");

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("-------------------------------"+violations+"--------------------------");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testRoomSizeNull() {
        Room s = new Room();
        s.setName("R202");
        s.setRate(777);
        s.setRoomSize(null);
        s.setRoomType(roomTypeRepository.findById(1L).get());
        s.setStatusRoom(statusRoomRepository.findById(1L).get());
        try {
            entityManager.persist(s);
            entityManager.flush();
            fail("Should not pass to this line");

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("-------------------------------"+violations+"--------------------------");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testRoomTypeNull() {
        Room s = new Room();
        s.setName("R202");
        s.setRate(777);
        s.setRoomSize(roomSizeRepository.findById(1L).get());
        s.setRoomType(null);
        s.setStatusRoom(statusRoomRepository.findById(1L).get());
        try {
            entityManager.persist(s);
            entityManager.flush();
            fail("Should not pass to this line");

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("-------------------------------"+violations+"--------------------------");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testStatusRoomNull() {
        Room s = new Room();
        s.setName("R202");
        s.setRate(777);
        s.setRoomSize(roomSizeRepository.findById(1L).get());
        s.setRoomType(roomTypeRepository.findById(1L).get());
        s.setStatusRoom(null);
        try {
            entityManager.persist(s);
            entityManager.flush();
            fail("Should not pass to this line");

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("-------------------------------"+violations+"--------------------------");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testStatusRoomNameNull() {
        StatusRoom s = new StatusRoom();
        s.setName(null);
        try {
            entityManager.persist(s);
            entityManager.flush();
            fail("Should not pass to this line");

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("-------------------------------"+violations+"--------------------------");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testRoomTypeNameNull() {
        RoomType s = new RoomType();
        s.setType(null);
        try {
            entityManager.persist(s);
            entityManager.flush();
            fail("Should not pass to this line");

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("-------------------------------"+violations+"--------------------------");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testRoomSizeNameNull() {
        RoomSize s = new RoomSize();
        s.setSize(0);
        try {
            entityManager.persist(s);
            entityManager.flush();
            fail("Should not pass to this line");

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("-------------------------------"+violations+"--------------------------");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testInstrumentNameNull() {
        Instrument s = new Instrument();
        s.setName(null);
        try {
            entityManager.persist(s);
            entityManager.flush();
            fail("Should not pass to this line");

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("-------------------------------"+violations+"--------------------------");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

}