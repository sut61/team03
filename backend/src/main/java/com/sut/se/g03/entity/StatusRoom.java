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
public class StatusRoom {
    @SequenceGenerator(name="statusroom_seq",sequenceName="statusroom_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="statusroom_seq")
    @Id
    private Long id;

    @NotNull
    private String name;

    public StatusRoom(){}

    public StatusRoom(String name){
        this.name = name;
    }

}