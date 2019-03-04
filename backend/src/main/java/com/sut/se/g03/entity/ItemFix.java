package com.sut.se.g03.entity;
import lombok.*;

import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class ItemFix {
    @Id
    @SequenceGenerator(name="itemFix_seq",sequenceName="itemFix_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="itemFix_seq")
    @Column(name="ItemFix_ID")
    private @NonNull  Long itemFixId;
    @NotNull
    private String itemFixName;

    public ItemFix(String itemFixName) {
        this.itemFixName = itemFixName;
    }
}
