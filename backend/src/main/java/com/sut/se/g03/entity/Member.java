package com.sut.se.g03.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sut.se.g03.controller.EncryptText;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@EqualsAndHashCode
@Data
public class Member {
    @SequenceGenerator(name="member_seq",sequenceName="member_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="member_seq")
    @Id
    private Long id;

    @Column(unique = true)
    private String userName;

    @JsonIgnore
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

}
