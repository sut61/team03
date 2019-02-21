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
public class RoomType {
    @SequenceGenerator(name="roomtype_seq",sequenceName="roomtype_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="roomtype_seq")
    @Id
    private Long id;

    @NotNull
    private String type;

    public RoomType(){}

    public RoomType(String type){
        this.type = type;
    }

}
