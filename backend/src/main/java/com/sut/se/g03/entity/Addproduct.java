package com.sut.se.g03.entity;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import javax.validation.constraints.*;

import lombok.*;
import java.util.Date;
@Entity // บอกว่าเป็น class entity class ที่เก็บขอมูล
@Data // lombox จะสร้าง method getter setter ให้เอง
@EqualsAndHashCode
public class Addproduct {
    @Id
    @SequenceGenerator(name = "addproduct_seq",sequenceName = "addproduct_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "addproduct_seq")
    private Long id;

    @NotNull
    @Positive
    @Min(value = 1)
    @Max(value = 100000)
    private int number;

    @Positive
    @Min(value = 1)
    @Max(value = 100000)
    private int price;

    @NotNull
    @Positive
    @Min(value = 1)
    @Max(value = 100000)
    private int saleprice;

    @NotNull
    Date date;

    public Addproduct() {}
    public Addproduct(int number ,int price,int saleprice,Date date) { // constructor
        this.number = number;
        this.price = price ;
        this.saleprice = saleprice;
        this.date = date;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public void setPrice(int price){
        this.price=price;
    }
    public int getPrice(){
        return price;
    }
    public void setSaleprice(int saleprice){
        this.saleprice=saleprice;
    }
    public int getSaleprice(){
        return saleprice;
    }
    public void setNumber (int number){
        this.number=number;
    }
    public int getNumber(){
        return number;
    }
}