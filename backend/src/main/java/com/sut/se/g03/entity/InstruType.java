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
public class InstruType {
    @Id
    @SequenceGenerator(name="instruType_seq",sequenceName="instruType_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="instruType_seq")
    @Column(name="InstruType_ID")
    private @NonNull  Long instruTypeId;
    @NotNull
    private String instumentType;

    public InstruType(String instumentType) {
        this.instumentType = instumentType;
    }
}
