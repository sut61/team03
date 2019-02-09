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
public class Classify {
	@Id
	@SequenceGenerator(name="classify_seq",sequenceName="classify_seq")
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="classify_seq")
	private Long id;

	@NotNull
	@Size(min = 5, max = 25)
	@Pattern(regexp = "([a-z]|([ก-ู]|[เ-์])|\\d)+")
	@Column(unique = true)
	private String name;

	@NotNull
	@Size(min = 5, max = 250)
	@Pattern(regexp = "([a-z]|([ก-ู]|[เ-์])|\\d|\\s)+([a-z]|([ก-ู]|[เ-์])|\\d)")
	@Column(unique = true)
	private String detail;

	@PositiveOrZero
	private int amount;

	private boolean decreaseAble = false;

	@NotNull
	@ManyToOne
	ClassifyStatus classifyStatus;

	public Classify() {
	}

	public Classify(String name, String detail, int amount, ClassifyStatus classifyStatus) {
		this.name = name;
		this.detail = detail;
		this.amount = amount;
		this.classifyStatus = classifyStatus;
	}

	public Classify(String name, String detail, int amount, boolean decreaseAble, ClassifyStatus classifyStatus) {
		this.name = name;
		this.detail = detail;
		this.amount = amount;
		this.decreaseAble = decreaseAble;
		this.classifyStatus = classifyStatus;
	}

	public Classify(String name, String detail, ClassifyStatus classifyStatus) {
		this.name = name;
		this.detail = detail;
		this.classifyStatus = classifyStatus;
	}

	public Classify(String name) {
		this.name = name;
	}
}
