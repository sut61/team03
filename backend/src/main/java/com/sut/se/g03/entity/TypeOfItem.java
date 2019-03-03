package com.sut.se.g03.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@EqualsAndHashCode
@Data
public class TypeOfItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	ItemType itemType;

	@ManyToOne
	Item item;

	public TypeOfItem(){}

	public TypeOfItem(ItemType itemType, Item item) {
		this.itemType = itemType;
		this.item = item;
	}
}
