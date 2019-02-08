package com.sut.se.g03.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@ToString
@EqualsAndHashCode
@Data
public class CourseMusic{
    @SequenceGenerator(name="coursemusic_seq",sequenceName="coursemusic_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="coursemusic_seq")
    @Id
    private Long id;

    private String Fname;

    public CourseMusic(){}

    public CourseMusic(String Fname){
        this.Fname = Fname;
    }


}
