package com.sut.se.g03.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@ToString
@EqualsAndHashCode
@Data
public class StatusCourse {
    @SequenceGenerator(name="statuscourse_seq",sequenceName="statuscourse_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="statuscourse_seq")
    @Id
    private Long id;
    
    @NotNull
    private String name;

    public StatusCourse(){}

    public StatusCourse(String name){
        this.name = name;
    }

}