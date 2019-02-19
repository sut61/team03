package com.sut.se.g03.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;

@Entity
@ToString
@EqualsAndHashCode
@Data
public class Room {
    @SequenceGenerator(name="room_seq",sequenceName="room_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="room_seq")
    @Id
    private Long id;

    
    @NotNull
    @Size(min = 4,max = 4)
    @Pattern(regexp = "[PR]\\d+")
    @Column(unique = true)
    private String name;

    @NotNull
    @Min(100)
    private int rate;

    @NotNull
    @ManyToOne
    RoomSize roomSize;

    @NotNull
    @ManyToOne
    RoomType roomType;

    @NotNull
    @ManyToOne
    StatusRoom statusRoom;

    @OneToMany(mappedBy = "room")
    List<RoomInstrument> roomInstruments = new ArrayList<>();

    public Room(){}

    public Room(String name,int rate,RoomSize roomSize,RoomType roomType,StatusRoom statusRoom){
        this.name = name;
        this.rate = rate;
        this.roomSize = roomSize;
        this.roomType = roomType;
        this.statusRoom = statusRoom;
    }

}
