package com.sut.se.g03.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Entity
@ToString
@EqualsAndHashCode
@Data
public class BillInfo {
	@SequenceGenerator(name="billinfo_seq",sequenceName="billinfo_seq")
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="billinfo_seq")
	@Id
	private Long id;

	@NotNull
	@Size(min = 10, max = 250)
	@Pattern(regexp = "^(([ก-ู]|[เ-์])|\\w)(([ก-ู]|[เ-์])|\\w|\\s|\\d)+(([ก-ู]|[เ-์])|\\w|\\d)$")
	private String content;

	@PositiveOrZero
	private float price;

	@ManyToOne
	@NotNull
	private Bill bill;

	public BillInfo(String content, float price, Bill bill) {
		this.content = content;
		this.price = price;
		this.bill = bill;
	}

	public BillInfo() {
	}
}
