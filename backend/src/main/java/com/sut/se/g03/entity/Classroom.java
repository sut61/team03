package com.sut.se.g03.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@EqualsAndHashCode
@Data
public class Classroom {
    @SequenceGenerator(name="classroom_seq",sequenceName="classroom_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="classroom_seq")
    @Id
    private Long id;
    private String name;

    public Classroom(){}

    public Classroom(String name) {
        this.name = name;
    }

}
