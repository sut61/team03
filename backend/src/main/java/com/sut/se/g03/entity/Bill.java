package com.sut.se.g03.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@ToString
@EqualsAndHashCode
@Data
public class Bill {
	@SequenceGenerator(name="bill_seq",sequenceName="bill_seq")
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="bill_seq")
	@Id
	private Long id;
	private Date date;
	private float totalPrice;
	private Timestamp timestamp;
	private Boolean paid = false;

	@ManyToOne
	private Member member;

	public Bill(){}

	public Bill(Date date, float totalPrice, Member member) {
		this.date = date;
		this.totalPrice += totalPrice;
		this.member = member;
	}
}
