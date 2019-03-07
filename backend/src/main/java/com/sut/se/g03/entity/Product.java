package com.sut.se.g03.entity;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@ToString
@EqualsAndHashCode
public class Product {
    @Id
    @SequenceGenerator(name = "product_seq",sequenceName = "product_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "product_seq")
    private Long id;

    @NotNull
    @Size(min=3, max=30)
    @Pattern(regexp = "[a-zA-Z]*")
    private String addproduct;

    @ManyToOne(fetch = FetchType.EAGER)
    private Typeproduct typeproducts;

    @OneToOne
    private Addproduct product;

    public Product(){}

    public Product(String addproduct){
        this.addproduct = addproduct;
    }

    public Product(String addproduct, Typeproduct typeproducts, Addproduct product){
        this.addproduct = addproduct;
        this.typeproducts = typeproducts;
        this.product = product;
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

    public Typeproduct getTypeproducts() {
        return typeproducts;
    }

    public void setTypeproducts(Typeproduct typeproducts) {
        this.typeproducts = typeproducts;
    }


    public Addproduct getProduct() {
        return product;
    }

    public void setProduct(Addproduct product) {
        this.product = product;
    }
}
