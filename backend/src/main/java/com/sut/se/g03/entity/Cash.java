package com.sut.se.g03.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

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

    @NotNull
    @Size(min = 2 , max = 12)
    @Pattern(regexp = "\\w+|[ก-๙]+")
    private  String cashreceive;

    @PositiveOrZero
    private float cashprice;

    @ManyToOne(fetch = FetchType.EAGER,targetEntity = Member.class)
    @JoinColumn(name = "Member",insertable = true)
    @NotNull
    private Member mem;

    @OneToOne
    @NotNull
    private Bill bill;


    @ManyToOne(fetch = FetchType.EAGER,targetEntity = PaidStatus.class)
    @JoinColumn(name = "PaidStatus",insertable = true)
    @NotNull
    private PaidStatus paidStatus;
}
