package com.sut.se.g03.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import javax.persistence.*;


@Entity
@ToString
@EqualsAndHashCode
public class Typeproduct {

    @Id
    @SequenceGenerator(name = "typeproduct_seq",sequenceName = "typeproduct_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "typeproduct_seq")

    private  Long id;
    
    private  String typeproducts;
   
    public Typeproduct() {
    }
    public Typeproduct(String typeproducts){
        this.typeproducts = typeproducts;
    }

    public void setTypeproduct(String typeproducts) {
        this.typeproducts = typeproducts;
        
    }
    public String getTypeproduct(){
        return typeproducts;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

   
    



}