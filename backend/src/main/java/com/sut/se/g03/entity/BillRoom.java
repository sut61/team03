package com.sut.se.g03.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@EqualsAndHashCode
@Data
public class BillRoom {
	@SequenceGenerator(name="billroom_seq",sequenceName="billroom_seq")
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="billroom_seq")
	@Id
	private Long id;

	@ManyToOne
	private Room room;

	@ManyToOne
	private Bill bill;

	public BillRoom(Room room, Bill bill) {
		this.room = room;
		this.bill = bill;
	}

	public BillRoom() {
	}
}
