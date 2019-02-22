package com.sut.se.g03.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import javax.validation.constraints.NotNull;
import javax.persistence.*;

@Entity
@ToString
@EqualsAndHashCode
@Data
public class PaymentType {
    @SequenceGenerator(name="paymentType_seq",sequenceName="paymentType_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="paymentType_seq")
    @Id
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Float  price;

    public PaymentType(){}

    public PaymentType(String name,Float price) {
        this.name = name;
        this.price = price;
    }

}
