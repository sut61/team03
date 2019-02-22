package com.sut.se.g03.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table( name = "Cash")
public class Cash {
    @SequenceGenerator(name="cash_seq",sequenceName="cash_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="cash_seq")
    @Id
    private  Long id;
    private  String cashreceive;
    private float cashprice;

    @ManyToOne(fetch = FetchType.EAGER,targetEntity = Member.class)
    @JoinColumn(name = "Member",insertable = true)
    private Member mem;

    @OneToOne
    private Bill bill;


    @ManyToOne(fetch = FetchType.EAGER,targetEntity = PaidStatus.class)
    @JoinColumn(name = "PaidStatus",insertable = true)
    private PaidStatus paidStatus;
}
