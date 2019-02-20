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
public class TimeTable {
    @SequenceGenerator(name="timetable_seq",sequenceName="timetable_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="timetable_seq")
    @Id
    private Long id;
    private boolean reserve = false;

    @ManyToOne
	Member member;

    @NotNull
    @ManyToOne
    Schedule schedule;

    @NotNull
    @ManyToOne
    TimePeriod timePeriod;

    @NotNull
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
