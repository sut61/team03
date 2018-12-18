package com.sut.se.g03.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Getter
@Setter
@ToString

@Table( name = "CreditType")
public class CreditType{
    @Id
    @SequenceGenerator(name="type_seq",sequenceName="type_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="type_seq")
    private  @NonNull Long creditTypeDI;
    private  @NonNull String typeName;

}
