package com.sut.se.g03.entity;
import lombok.*;

import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class CustomerFix {
    @Id
    @SequenceGenerator(name="customerFix_seq",sequenceName="customerFix_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="customerFix_seq")
    @Column(name="CustomerFix_ID")
    private @NonNull Long customerFixId;
    @NotNull
    private  String customerFixName;
    @NotNull
    @Email
    private  String email;

    @NotNull
    @Size(min = 10,max = 10)
    @Pattern(regexp = "[0]\\d+")
    @Column(unique = true)
    private  String tel;

    public CustomerFix(String tel,String customerFixName,String email) {

        this.tel = tel;
        this.customerFixName = customerFixName;
        this.email = email;
    }
}
