package com.sut.se.g03.entity;
import lombok.*;

import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class Item {
    @Id
    @SequenceGenerator(name="item_seq",sequenceName="item_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="item_seq")
    @Column(name="Item_ID")
    private @NonNull  Long itemId;
    @NotNull
    private  String itemName;
    @NotNull
    private  Integer price;
    @NotNull
    @PositiveOrZero
    @Min(1)
    private  Integer itemNum;
    @NotNull
    private  String pic;

    public Item(String itemName,Integer price,Integer itemNum,String pic) {
        this.itemName = itemName;
        this.price = price;
        this.itemNum = itemNum;
        this.pic = pic;
    }

}
