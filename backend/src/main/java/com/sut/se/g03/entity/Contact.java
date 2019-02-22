package com.sut.se.g03.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@ToString
@EqualsAndHashCode
@Data
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min = 5, max = 45)
	@Pattern(regexp = "^(([ก-ู]|[เ-์]){1,25} ([ก-ู]|[เ-์]){1,25})|([A-Z][a-z]{1,25} [A-Z][a-z]{1,25})|([a-z]{1,25} [a-z]{1,25})$")
	private String name;

	@NotNull
	@Size(min = 10, max = 10)
	@Pattern(regexp = "^(08|09)\\d+")
	private String tel;

	@NotNull
	@ManyToOne
	Bill bill;

	public Contact() {
	}

	public Contact(String name, String tel, Bill bill) {
		this.name = name;
		this.tel = tel;
		this.bill = bill;
	}
}
