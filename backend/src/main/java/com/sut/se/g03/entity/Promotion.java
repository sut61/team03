package com.sut.se.g03.entity;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import javax.persistence.*;
import java.util.Date;



import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@ToString
@EqualsAndHashCode
public class Promotion {
    @Id
    @SequenceGenerator(name = "promotion_seq",sequenceName = "promotion_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "promotion_seq")
    private Long id;

    
    @NotNull
    @Size(min=3, max=30)
    @Pattern(regexp = "[a-zA-Z]*")
    private String promotinoName;

    @NotNull
    @Pattern(regexp = "[a-zA-Z]*")
    private String code;
   
    // @Temporal(TemporalType.DATE)
    // private @io.micrometer.core.lang.NonNull
    // Date startDate;
    // Date stopDate;

    
    @FutureOrPresent
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private @io.micrometer.core.lang.NonNull
    Date startDate;

    @FutureOrPresent
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date stopDate;


//    @Temporal(TemporalType.DATE)
//    private @io.micrometer.core.lang.NonNull
//    Date stopDate;

    @ManyToOne(fetch = FetchType.EAGER)
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    private Staff staff;

    @ManyToOne(fetch = FetchType.EAGER)
    private Typepromotion typepromotion;


    public Promotion (){}

    public Promotion (String promotinoName,String code,Date startDate,Date stopDate,Product product,Staff staff,Typepromotion typepromotion){
        this.promotinoName = promotinoName;
        this.code = code;
        this.startDate = startDate;
        this.stopDate = stopDate;
        this.staff = staff;
        this.typepromotion = typepromotion;
        this.product = product;
       
    }
 
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Date getStartDate() {
        return startDate;
    }
    public Date getStopDate() {
        return stopDate;
    }


    public Staff getStaff() {
        return staff;
    }

    public String getCode() {
        return code;
    }

    public String getPromotinoName() {
        return promotinoName;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setPromotinoName(String promotinoName) {
        this.promotinoName = promotinoName;
    }


    public Typepromotion getTypepromotion() {
        return typepromotion;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public void setStopDate(Date stopDate) {
        this.stopDate = stopDate;
    }

    public void setTypepromotion(Typepromotion typepromotion) {
        this.typepromotion = typepromotion;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getProduct()
    {
        return product;
    }

    

    
}
