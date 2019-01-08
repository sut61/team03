package com.sut.se.g03.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@EqualsAndHashCode
@Data
public class MemberInfo {
    @SequenceGenerator(name="member_info_seq",sequenceName="member_info_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="member_info_seq")
    @Id
    private Long id;
    private String fname;
    private String lname;
    private String email;
    private String phone;
}
