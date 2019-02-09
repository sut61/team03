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
public class Managerinfo {
    @Id
    @SequenceGenerator(name="managerinfo_seq",sequenceName="managerinfo_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="managerinfo_seq")
    @Column(name="Managerinfo_ID")
    private @NonNull  Long managerinfoId;
    @NotNull
    private String managerName;

    public Managerinfo(String managerName) {
        this.managerName = managerName;
    }

}
