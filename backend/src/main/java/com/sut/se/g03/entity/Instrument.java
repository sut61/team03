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
public class Instrument {
    @SequenceGenerator(name="inst_seq",sequenceName="inst_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="inst_seq")
    @Id
    private Long id;

    @NotNull
    private String name;

    public Instrument(){}

    public Instrument(String name) {
        this.name = name;
    }

}
