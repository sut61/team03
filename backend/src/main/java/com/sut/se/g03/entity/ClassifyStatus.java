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
public class ClassifyStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min = 5, max = 25)
	@Pattern(regexp = "([a-z]|([ก-ู]|[เ-์])|\\d)+")
	@Column(unique = true)
	private String status;

	public ClassifyStatus(String status) {
		this.status = status;
	}

	public ClassifyStatus() {
	}
}
