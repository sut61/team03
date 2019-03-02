package com.sut.se.g03.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sut.se.g03.controller.EncryptText;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@ToString
@EqualsAndHashCode
@Data
public class Member {
    @SequenceGenerator(name="member_seq",sequenceName="member_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="member_seq")
    @Id
    private Long id;


    @NotNull
    @Column(unique = true)
    private String userName;

    @JsonIgnore
    @NotNull
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    private MemberInfo memberInfo;

    public Member(){}

    public Member(String userName, MemberInfo memberInfo){
        this.userName = userName;
        this.memberInfo = memberInfo;
    }

    public Member(String userName, String password) throws Exception {
        this.userName = userName;
        this.password = EncryptText.generatePasswordHash(password);
    }

    public Member( String userName) {
        this.userName = userName;
    }
}
