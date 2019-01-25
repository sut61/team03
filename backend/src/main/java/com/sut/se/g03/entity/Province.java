package project.se.demo.entity;
import lombok.*;
import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Province {
    @Id
    @SequenceGenerator(name="province_seq",sequenceName="province_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="province_seq")
    @Column(name="province_ID")
    private @NonNull Long id;

    private @NonNull String province;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Collection<District> districtTran;
}
