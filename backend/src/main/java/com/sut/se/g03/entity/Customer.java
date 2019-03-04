package com.sut.se.g03.entity;
import lombok.*;

import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Customer {
    @Id
    @SequenceGenerator(name="customer_seq",sequenceName="customer_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="customer_seq")
    @Column(name="Customer_ID")
    private @NonNull  Long customerId;

    private @NonNull String username;
    private @NonNull String password;
    private @NonNull String customerName;
    @Email
    private @NonNull String email;
    @Size(min = 10,max = 10)
    private @NonNull String tel;

    public Customer(String customerName,String email,String tel) {
        this.customerName = customerName;
        this.email = email;
        this.tel = tel;

    }
}