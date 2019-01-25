package project.se.demo.entity;
import lombok.*;

import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

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
    private  String email;
    private  String tel;
}