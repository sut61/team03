package com.sut.se.g03.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@EqualsAndHashCode
@Data
public class BillInfo {
	@SequenceGenerator(name="billinfo_seq",sequenceName="billinfo_seq")
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="billinfo_seq")
	@Id
	private Long id;
	private String content;
	private float price;

	@ManyToOne
	private Bill bill;

	public BillInfo(String content, float price, Bill bill) {
		this.content = content;
		this.price = price;
		this.bill = bill;
	}

	public BillInfo() {
	}
}
