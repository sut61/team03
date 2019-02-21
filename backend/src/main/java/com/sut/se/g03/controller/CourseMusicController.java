package com.sut.se.g03.controller;
import java.util.Optional;
import java.util.Map;
import java.util.stream.Collectors;
import com.sut.se.g03.entity.*;
import com.sut.se.g03.repository.*;
import java.util.*;
import com.fasterxml.jackson.core.JsonParseException;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class CourseMusicController{

    @Autowired
    private CourseMusicRepository courseMusicRepository;
    @Autowired
    private PaymentTypeRepository paymentTypeRepository;
    @Autowired
    private CourseTimeRepository courseTimeRepository;
    @Autowired
    private ClassroomRepository classroomRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private InstrumentRepository instrumentRepository;

    @GetMapping("/courseMusic/CourseMusic")
    public Collection<CourseMusic> courseMusic() {
       return courseMusicRepository.findAll();
    }

    @GetMapping("/courseMusic/CourseMusic/{courseMusicId}")
    public Optional<CourseMusic> takeinCourseMusicByid(@PathVariable Long courseMusicId) {
        return courseMusicRepository.findById(courseMusicId);
    }

    @GetMapping("/courseMusic/CourseTime")
    public Collection<CourseTime> courseTime() {
       return courseTimeRepository.findAll();
    }

    @GetMapping("/courseMusic/CourseTime/{courseTimeId}")
    public Optional<CourseTime> takeinCourseTimeByid(@PathVariable Long courseTimeId) {
        return courseTimeRepository.findById(courseTimeId);
    }
    
    @GetMapping("/courseMusic/PaymentType")
    public Collection<PaymentType> paymentType() {
       return paymentTypeRepository.findAll();
    }

    @GetMapping("/courseMusic/PaymentType/{paymentTypeId}")
    public Optional<PaymentType> takeinPaymentTypeByid(@PathVariable Long paymentTypeId) {
        return paymentTypeRepository.findById(paymentTypeId);
    }

    @GetMapping("/courseMusic/Classroom")
    public Collection<Classroom> classroom() {
       return classroomRepository.findAll();
    }

    @GetMapping("/courseMusic/Classroom/{classroomId}")
    public Optional<Classroom> takeinClassroomByid(@PathVariable Long classroomId) {
        return classroomRepository.findById(classroomId);
    }

    @GetMapping("/courseMusic/Instrument")
    public Collection<Instrument> instrument() {
       return instrumentRepository.findAll();
    }
    @GetMapping("/courseMusic/Instrument/{instrumentId}")
    public Optional<Instrument> takeinInstrumentByid(@PathVariable Long instrumentId) {
        return instrumentRepository.findById(instrumentId);
    }


    @GetMapping("/courseMusic/Member")
    public Collection<Member> member() {
       return memberRepository.findAll();
    }

    @GetMapping("/courseMusic/Member/{memberId}")
    public Optional<Member> takeinMemberByid(@PathVariable Long memberId) {
        return memberRepository.findById(memberId);
    }

    @PostMapping("/courseMusic/createCourseMusic/{username}/{Fname}/{Lname}/{nickname}/{telephone}/{instrumentId}/{courseTimeId}/{classroomId}/{paymentTypeId}")
    public CourseMusic newCourseMusic(@PathVariable String username,@PathVariable String Fname,@PathVariable String Lname,@PathVariable String nickname,@PathVariable String telephone,@PathVariable Long instrumentId,@PathVariable Long courseTimeId,@PathVariable Long classroomId,@PathVariable Long paymentTypeId) {
        CourseMusic newCourseMusic = new CourseMusic();
        Member member = memberRepository.findByUserName(username);
        Instrument instrument = instrumentRepository.findById(instrumentId).get();
        CourseTime courseTime = courseTimeRepository.findById(courseTimeId).get();
        Classroom classroom = classroomRepository.findById(classroomId).get();
        PaymentType paymentType = paymentTypeRepository.findById(paymentTypeId).get();
    
        newCourseMusic.setMember(member);
        newCourseMusic.setFname(Fname);
        newCourseMusic.setLname(Lname);
        newCourseMusic.setNickname(nickname);
        newCourseMusic.setTelephone(telephone);
        newCourseMusic.setInstrument(instrument);
        newCourseMusic.setCourseTime(courseTime);
        newCourseMusic.setClassroom(classroom);
        newCourseMusic.setPaymentType(paymentType);
        return courseMusicRepository.save(newCourseMusic);
    } 

    @PutMapping("/courseMusic/editCourseMusic/{username}/{courseMusicId}/{instrumentId}/{courseTimeId}/{classroomId}/{paymentTypeId}")
    public CourseMusic newCourseMusic(@PathVariable String username,@PathVariable Long courseMusicId,@PathVariable Long instrumentId,@PathVariable Long courseTimeId,@PathVariable Long classroomId,@PathVariable Long paymentTypeId) {
        CourseMusic newCourseMusic = courseMusicRepository.findById(courseMusicId).get();
        Member member = memberRepository.findByUserName(username);
        Instrument instrument = instrumentRepository.findById(instrumentId).get();
        CourseTime courseTime = courseTimeRepository.findById(courseTimeId).get();
        Classroom classroom = classroomRepository.findById(classroomId).get();
        PaymentType paymentType = paymentTypeRepository.findById(paymentTypeId).get();
        newCourseMusic.setMember(member);
        newCourseMusic.setInstrument(instrument);
        newCourseMusic.setCourseTime(courseTime);
        newCourseMusic.setClassroom(classroom);
        newCourseMusic.setPaymentType(paymentType);
        return courseMusicRepository.save(newCourseMusic);
    } 


}