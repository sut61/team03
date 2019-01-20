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
public class Room {
    @SequenceGenerator(name="room_seq",sequenceName="room_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="room_seq")
    @Id
    private Long id;
    private String name;
    private int rate;

    @ManyToOne
    RoomSize roomSize;

    @ManyToOne
    RoomType roomType;

    @OneToMany(mappedBy = "room")
    List<RoomInstrument> roomInstruments = new ArrayList<>();

    public Room(){}

    public Room(String name,int rate,RoomSize roomSize,RoomType roomType){
        this.name = name;
        this.rate = rate;
        this.roomSize = roomSize;
        this.roomType = roomType;
    }

}
