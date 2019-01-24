package com.sut.se.g03.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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
    private Date date;
    private float price;
    private String receive;

    @ManyToOne (fetch = FetchType.EAGER,targetEntity = CreditType.class)
    @JoinColumn(name = "CreditType",insertable = true)
    private CreditType credit;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Member")
    private Member mem;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TotalPrice")
    private Bill bill;

    @ManyToOne(fetch = FetchType.EAGER,targetEntity = Payment.class)
    @JoinColumn(name = "Status",insertable = true)
    private Payment pay;



}

