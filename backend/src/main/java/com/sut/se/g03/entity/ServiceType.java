package com.sut.se.g03.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table( name = "ServiceType")
public class ServiceType {
    @Id
    @SequenceGenerator(name = "serviceType_seq", sequenceName = "serviceType_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "serviceType_seq")
    private Long id;

    //@NotNull
    private String typeService;
}
