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
public class ItemType {
	@Id
	@SequenceGenerator(name="itemtype_seq",sequenceName="itemtype_seq")
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="itemtype_seq")
	private Long id;

	@NotNull
	@Size(min = 5, max = 25)
	@Pattern(regexp = "([a-z]|([ก-ู]|[เ-์])|\\d)+")
	@Column(unique = true)
	private String typeName;

	public ItemType() {
	}

	public ItemType(String typeName) {
		this.typeName = typeName;
	}
}
