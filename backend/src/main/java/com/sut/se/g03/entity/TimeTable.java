package th.sut.sa.demo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@EqualsAndHashCode
@Data
public class TimeTable {
    @SequenceGenerator(name="timetable_seq",sequenceName="timetable_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="timetable_seq")
    @Id
    private Long id;
    private boolean reserveStatus = false;

    @ManyToOne
    private TimePeriod timePeriod;

}
