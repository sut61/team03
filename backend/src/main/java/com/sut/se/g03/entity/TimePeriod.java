package com.sut.se.g03.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Time;

@Entity
@ToString
@EqualsAndHashCode
@Data
public class TimePeriod {
    @SequenceGenerator(name="timeperiod_seq",sequenceName="timeperiod_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="timeperiod_seq")
    @Id
    private Long id;

    @NotNull
    private Time start;

    @NotNull
    private Time end;

    public TimePeriod(){}
    public TimePeriod(Time start,Time end){
        this.start = start;
        this.end = end;
    }



}
