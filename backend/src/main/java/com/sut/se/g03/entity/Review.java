package com.sut.se.g03.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table( name = "Review")
public class Review {

    @Id
    @SequenceGenerator(name = "review_seq", sequenceName = "review_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "review_seq")
    private Long id;

    @NotNull
    @Size(min = 5 , max = 40)
    @Pattern(regexp = "\\w+|[ก-๙]+")
    private String  commentNegative;

    @NotNull
    @Size(min = 5 , max = 40)
    @Pattern(regexp = "\\w+|[ก-๙]+")
    private  String commentPositive;


    @ManyToOne(fetch = FetchType.EAGER,targetEntity = ServiceType.class)
    @JoinColumn(name = "serviceType",insertable = true)
    @NotNull
    private ServiceType serviceType;


    @ManyToOne(fetch = FetchType.EAGER,targetEntity = Member.class)
    @JoinColumn(name = "member",insertable = true)
    @NotNull
    private Member member;


    @ManyToOne(fetch = FetchType.EAGER,targetEntity = Score.class)
    @JoinColumn(name = "score",insertable = true)
    @NotNull
    private Score score;


}
