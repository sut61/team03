package com.sut.se.g03.entity;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@ToString
@EqualsAndHashCode
public class Typepromotion {

    @Id
    @SequenceGenerator(name = "typepromotion_seq",sequenceName = "typepromotion_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "typepromotion_seq")
    private Long id;
    @NotNull
    private String typePromotinos;

    public Typepromotion(){}

    public Typepromotion(String typePromotinos){
        this.typePromotinos = typePromotinos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypePromotinos() {
        return typePromotinos;
    }

    public void setTypePromotinos(String typePromotinos) {
        this.typePromotinos = typePromotinos;
    }
}
