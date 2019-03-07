package com.sut.se.g03.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Time;

import javax.validation.constraints.NotNull;

@Entity
@ToString
@EqualsAndHashCode
@Data
public class CourseTime {
    @SequenceGenerator(name="courseTime_seq",sequenceName="courseTime_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="courseTime_seq")
    @Id
    private Long id;
    @NotNull
    private String day;
    @NotNull
    private Time start;
    @NotNull
    private Time end;

    public CourseTime(){}

    public CourseTime(String day,Time start,Time end) {
        this.day = day;
        this.start = start;
        this.end = end;
    }

}