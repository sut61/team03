package com.sut.se.g03.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table( name = "Payment")
public class Payment {
    @Id
    @SequenceGenerator(name = "payment_seq", sequenceName = "payment_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_seq")
    private Long id;

    @NotNull
    private Date date;

    @PositiveOrZero
    private float price;

    @NotNull
    @Size(min = 2 , max = 12)
    @Pattern(regexp = "\\w+|[ก-๙]+")
    private String receive;

    @ManyToOne (fetch = FetchType.EAGER,targetEntity = CreditType.class)
    @JoinColumn(name = "CreditType",insertable = true)
    @NotNull
    private CreditType credit;

    @ManyToOne (fetch = FetchType.EAGER,targetEntity = Member.class)
    @JoinColumn(name = "Member",insertable = true)
    @NotNull
    private Member member;

    @OneToOne
    @NotNull
    private Bill bill;

    @ManyToOne(fetch = FetchType.EAGER,targetEntity = PaidStatus.class)
    @JoinColumn(name = "PaidStatus",insertable = true)
    @NotNull
    private PaidStatus paidStatus;



}

