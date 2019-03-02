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
@Table( name = "CreditType")
public class CreditType {
    @Id
    @SequenceGenerator(name="CreditType_seq",sequenceName="CreditType_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="CreditType_seq")
    private  Long   id;

    @NotNull
    @Size( max = 14)
    @Pattern(regexp = "\\w+|[ก-๙]+")
    private  String type;

}
