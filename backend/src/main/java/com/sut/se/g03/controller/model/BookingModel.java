package com.sut.se.g03.controller.model;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BookingModel {
	String bookingName;
	String bookingTel;
	String bookingNameSecond;
	String bookingTelSecond;
	Long[] timeData;
	String username;
}
