package com.sut.se.g03.entity;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class District {
    @Id
    @SequenceGenerator(name="district_seq",sequenceName="district_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="district_seq")
    @Column(name="District_ID")
    private @NonNull  Long id;

    private @NotNull String district;

    public District(String district) {
        this.district = district;
    }

}
