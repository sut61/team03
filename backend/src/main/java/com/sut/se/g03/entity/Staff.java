
package com.sut.se.g03.entity;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
@Entity
@ToString
@EqualsAndHashCode
public class Staff {
    @Id
    @SequenceGenerator(name = "staff_seq",sequenceName = "staff_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "staff_seq")
    private Long id;

    @NotNull
    private String staffName;
    public Staff(){}

    public Staff(String staffName){
        this.staffName = staffName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }
}
