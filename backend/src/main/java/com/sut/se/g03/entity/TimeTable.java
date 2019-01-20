package com.sut.se.g03.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@EqualsAndHashCode
@Data
public class TimeTable {
    @SequenceGenerator(name="timetable_seq",sequenceName="timetable_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="timetable_seq")
    @Id
    private Long id;
    private boolean reserve = false;

    @ManyToOne
	Member member;

    @ManyToOne
    Schedule schedule;

    @ManyToOne
    TimePeriod timePeriod;

    @ManyToOne
    Room room;

    public TimeTable(Schedule schedule, TimePeriod timePeriod, Room room) {
        this.schedule = schedule;
        this.timePeriod = timePeriod;
        this.room = room;
    }

    public TimeTable() {
    }
}
