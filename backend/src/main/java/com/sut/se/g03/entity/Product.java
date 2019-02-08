package com.sut.se.g03.entity;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@EqualsAndHashCode
public class Product {
    @Id
    @SequenceGenerator(name = "product_seq",sequenceName = "product_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "product_seq")
    private Long id;
    private String addproduct;

    public Product(){}

    public Product(String addproduct){
        this.addproduct = addproduct;
    }

    public Long getId() {
        return id;
    }

    public String getAddproduct() {
        return addproduct;
    }

    public void setAddproduct(String addproduct) {
        this.addproduct = addproduct;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
