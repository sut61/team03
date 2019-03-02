package com.sut.se.g03.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table( name = "Score")
public class Score {
    @Id
    @SequenceGenerator(name = "score_seq", sequenceName = "score_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "score_seq")
    private Long id;


    @NotNull
    @PositiveOrZero
    private Integer score;

    public Score(Integer score) {
        this.score = score;
    }
}
