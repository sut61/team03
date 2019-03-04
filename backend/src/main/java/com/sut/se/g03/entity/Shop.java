package com.sut.se.g03.entity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Collection;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Shop {
    @Id
    @SequenceGenerator(name="shop_seq",sequenceName="shop_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="shop_seq")
    @Column(name="Shop_ID")
    private @NonNull Long shopId;
    @NotNull
    @Size(min = 3,max = 50)
    private String subdist;
    @NotNull
    @PositiveOrZero
    private int itemNum;
    @NotNull
    @Size(min = 3,max = 50)
    private String customerName;
    @NotNull
    @Email
    @Column(unique = true)
    @Size(min = 3,max = 50)
    private String email;
    @NotNull
    @Size(min = 10,max = 10)
    @Pattern(regexp = "[0]\\d+")
    private String tel;


    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Customer.class)
    @JoinColumn(name = "CS_ID", insertable = true)
    private Customer customerShop;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Item.class)
    @JoinColumn(name = "IT_ID", insertable = true)
    private Item item;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = District.class)
    @JoinColumn(name = "DT_ID", insertable = true)
    private District districtShop;


}
