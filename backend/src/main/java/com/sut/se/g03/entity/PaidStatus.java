package com.sut.se.g03.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@EqualsAndHashCode
@Data
public class PaidStatus {
	@SequenceGenerator(name="paid_status_seq",sequenceName="paid_status_seq")
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="paid_status_seq")
	@Id
	private Long id;
	private String name;

	public PaidStatus(String name) {
		this.name = name;
	}

	public PaidStatus() {
	}
}
