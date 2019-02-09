package com.sut.se.g03.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@EqualsAndHashCode
@Data
public class ClassifyItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	Classify classify;

	@ManyToOne
	Item item;

	public ClassifyItem(Classify classify, Item item) {
		this.classify = classify;
		this.item = item;
	}

	public ClassifyItem() {
	}
}
