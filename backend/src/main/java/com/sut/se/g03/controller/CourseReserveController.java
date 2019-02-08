package com.sut.se.g03.controller;

import com.sut.se.g03.entity.*;
import com.sut.se.g03.repository.*;
import com.sut.se.g03.repository.CourseReserveRepository;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class CourseReserveController{

    @Autowired
    private StatusCourseRepository statuscourseRepository;
    @Autowired
    private CourseReserveRepository coursereserveRepository;
    @Autowired
    private CourseMusicRepository coursemusicRepository;
    @Autowired
    private MemberRepository memberRepository;
    
    @GetMapping("/coursereserve/StatusCourse")
    public Collection<StatusCourse> statuscourse() {
       return statuscourseRepository.findAll();
    }

    @GetMapping("/coursereserve/CourseMusic")
    public Collection<CourseMusic> coursemusic() {
       return coursemusicRepository.findAll();
    }

    @GetMapping("/coursereserve/CourseReserve")
    public Collection<CourseReserve> coursreserve() {
       return coursereserveRepository.findAll();
    }
    

    @PostMapping("/coursereserve/reserve/{courseId}/{nickname}/{phone}/{statuscourseId}/{username}")
    public CourseReserve newCouseReserve(@PathVariable Long courseId,@PathVariable String nickname,@PathVariable String phone,@PathVariable Long statuscourseId,@PathVariable String username) {
        CourseReserve newCourseReserve = new CourseReserve();
        Member member = memberRepository.findByUserName(username);
        StatusCourse statuscourse = statuscourseRepository.findById(statuscourseId).get();
        CourseMusic coursemusic = coursemusicRepository.findById(courseId).get();
    
        newCourseReserve.setMember(member);
        newCourseReserve.setCoursemusic(coursemusic);
        newCourseReserve.setNickname(nickname);
        newCourseReserve.setPhone(phone);
        newCourseReserve.setStatusCourse(statuscourse);
        return coursereserveRepository.save(newCourseReserve);
    } 
    
}
