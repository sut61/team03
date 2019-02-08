package com.sut.se.g03.controller;

import com.sut.se.g03.entity.Member;
import com.sut.se.g03.entity.Review;
import com.sut.se.g03.entity.Score;
import com.sut.se.g03.entity.ServiceType;
import com.sut.se.g03.repository.MemberRepository;
import com.sut.se.g03.repository.ReviewRepository;
import com.sut.se.g03.repository.ScoreRepository;
import com.sut.se.g03.repository.ServiceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CommentController {
    @Autowired
    private ServiceTypeRepository serviceTypeRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private ScoreRepository scoreRepository;

    //Member
    @GetMapping("comment/member")
    public Collection<Member> Bill() {
        return memberRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("comment/member/{Mid}")
    public Optional<Member> takeinMemberByid(@PathVariable Long Mid) {
        return memberRepository.findById(Mid);
    }

    //ServiceType
    @GetMapping("comment/service")
    public Collection<ServiceType> ServiceType() {
        return serviceTypeRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("comment/service/{Svid}")
    public Optional<ServiceType> takeinServiceByid(@PathVariable Long Svid) {
        return serviceTypeRepository.findById(Svid);
    }

    //Score

    @GetMapping("comment/score")
    public Collection<Score> Score() {
        return scoreRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("comment/score/{Scid}")
    public Optional<Score> takeinScoreByid(@PathVariable Long Scid) {
        return scoreRepository.findById(Scid);
    }


    //Review
    @GetMapping("comment/review")
    public Collection<Review> Review() {
        return reviewRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("comment/review/{Rid}")
    public Optional<Review> takeinReviewByid(@PathVariable Long Rid) {
        return reviewRepository.findById(Rid);
    }
    @PostMapping("comment/review/{commentNegative}/{commentPositive}/{Mid}/{Rid}/{Scid}")
        public Review CreateComment(@PathVariable Long Scid , @PathVariable String commentNegative, @PathVariable Long Mid , @PathVariable Long Rid , @PathVariable String commentPositive ){
        Member member = memberRepository.findById(Mid).get();
        ServiceType serviceType = serviceTypeRepository.findById(Rid).get();
        Score score = scoreRepository.findById(Scid).get();

           Review review = new Review();
           review.setCommentNegative(commentNegative);
           review.setCommentPositive(commentPositive);
           review.setMember(member);
           review.setServiceType(serviceType);
           review.setScore(score);
           reviewRepository.save(review);
           return review;
        }

}