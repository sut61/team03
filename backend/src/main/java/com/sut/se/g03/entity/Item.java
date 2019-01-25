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

public class Item {
    @Id
    @SequenceGenerator(name="item_seq",sequenceName="item_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="item_seq")
    @Column(name="Item_ID")
    private @NonNull  Long itemId;

    private @NonNull String itemName;
    private  Integer price;
    private  Integer itemNum;
    private  String pic;

}
