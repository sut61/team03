package com.sut.se.g03.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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

    @NotNull
    @Size(max = 30)
    @Pattern(regexp = "\\w+|[ก-๙]+")
    private String typeService;

    public ServiceType(String typeService) {
        this.typeService = typeService;
    }
}
