package com.sut.se.g03.entity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class FixMain {
    @Id
    @SequenceGenerator(name="fixMain_seq",sequenceName="fixMain_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="fixMain_seq")
    @Column(name="FixMain_ID")
    private @NonNull Long fixMainId;
    @NotNull
    @PositiveOrZero
    private  Integer cost;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = ItemFix.class)
    @JoinColumn(name = "ITF_ID", insertable = true)
    private ItemFix itemFix;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = CustomerFix.class)
    @JoinColumn(name = "CTF_ID", insertable = true)
    private CustomerFix customerFix;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Datainfo.class)
    @JoinColumn(name = "DT_ID", insertable = true)
    private Datainfo datainfo;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = InstruType.class)
    @JoinColumn(name = "IS_ID", insertable = true)
    private InstruType instruType;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Managerinfo.class)
    @JoinColumn(name = "MN_ID", insertable = true)
    private Managerinfo managerinfo;

}
