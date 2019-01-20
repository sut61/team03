package com.sut.se.g03.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@EqualsAndHashCode
@Data
public class RoomInstrument {
	@SequenceGenerator(name="room_inst_seq",sequenceName="room_inst_seq")
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="room_inst_seq")
	@Id
	private Long id;

	@ManyToOne
	@JsonIgnore// use JsonIgnore to avoid infinite loop when find by room
	Room room;

	@ManyToOne
	Instrument instrument;

	public RoomInstrument(){}

	public RoomInstrument(Room room, Instrument instrument) {
		this.room = room;
		this.instrument = instrument;
	}
}
