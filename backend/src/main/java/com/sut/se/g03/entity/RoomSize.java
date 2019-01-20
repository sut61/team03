package com.sut.se.g03.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@EqualsAndHashCode
@Data
public class RoomSize {
    @SequenceGenerator(name="roomsize_seq",sequenceName="roomsize_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="roomsize_seq")
    @Id
    private Long id;
    private int size;

    public RoomSize(){}

    public RoomSize(int size){
        this.size = size;
    }

}
