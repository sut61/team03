package com.sut.se.g03.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table( name = "CreditType")
public class CreditType {
    @Id
    @SequenceGenerator(name="CreditType_seq",sequenceName="CreditType_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="CreditType_seq")
    private  Long   id;
    private  String type;

}
