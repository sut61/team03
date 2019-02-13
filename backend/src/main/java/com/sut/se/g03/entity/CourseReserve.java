package com.sut.se.g03.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;

@Entity
@ToString
@EqualsAndHashCode
@Data
public class CourseReserve {
    @SequenceGenerator(name="coursereserve_seq",sequenceName="coursereserve_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="coursereserve_seq")
    @Id
    private Long id;

    @NotNull
    @Size(min = 11,max = 11)
    @Pattern(regexp = "\\d{3}-\\d+")
    private String phone;

    @NotNull
    @Size(min = 2,max = 15)
    private String nickname;

    @NotNull
    @Column(unique = true)
    private String nameFacebook;
    
    @ManyToOne
	private Member member;
    
    @NotNull
    @ManyToOne
    StatusCourse statusCourse;
    
    @NotNull
    @ManyToOne
    CourseMusic coursemusic;
    

    public CourseReserve(){}

    public CourseReserve(String phone,String nickname,String nameFacebook,Member member,StatusCourse statusCourse,CourseMusic coursemusic){
        this.phone = phone;
        this.nickname = nickname;
        this.nameFacebook = nameFacebook;
        this.member = member;
        this.statusCourse = statusCourse;
        this.coursemusic = coursemusic;
    }

}
