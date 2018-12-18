package com.sut.se.g03

import lombok.*;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;

@Entity
@Getter @Setter
public class Room {
    @Id @GeneratedValue
    private Long id;
    public Room(){}
}