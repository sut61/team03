package com.sut.se.g03.entity;
import lombok.*;

import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class Datainfo {
    @Id
    @SequenceGenerator(name="datainfo_seq",sequenceName="datainfo_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="datainfo_seq")
    @Column(name="Datainfo_ID")
    private @NonNull  Long datainfoId;
    @NotNull
    private String data;

    public Datainfo(String data) {
        this.data = data;
    }

}
