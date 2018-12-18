package com.sut.se.g03.BillaccidentSystem.Entity;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;
import java.util.*;


@Entity
@Getter @Setter  
public class Billaccident {
    @Id  
    @SequenceGenerator(name="billaccident_seq",sequenceName="billaccident_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="billaccident_seq")
    private @NonNull Long billaccidentId;
    private  Date   date;
    private @NonNull Double   totalprice;
  
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "statuspayId")
        private Statuspay statuspay;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "useraccidentId")
        private Useraccident useraccident;

       /*@ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "userId")
        private User user;*/


    public Billaccident(){

    }
}