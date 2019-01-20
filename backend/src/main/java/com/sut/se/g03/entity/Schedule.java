package com.sut.se.g03.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@ToString
@EqualsAndHashCode
@Data
public class Schedule {
    @SequenceGenerator(name="schedule_seq",sequenceName="schedule_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="schedule_seq")
    @Id
    private Long id;
    private Date date;

    public Schedule(){}
    public Schedule(Date date){
        this.date = date;
    }

}
