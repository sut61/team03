package com.okta.developer.demo.entity;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;
@Entity  //บอกว่าเป็น class entity class ที่เก็บขอมูล
@Data  // lombox จะสร้าง method getter setter ให้เอง
@Table(name="Car") //ชื่อตาราง
public class Car {
@Id  //  Annotations  @Id  บอกว่าเป็น  Primary  key
@GeneratedValue   // Annotations Generate id เอง ตอน insert 
private Long id;
private String color;
private String type;
protected Car() {}
public Car(String type, String color) {  //constructor 
    this.type = type;
     this.color = color;
}
}