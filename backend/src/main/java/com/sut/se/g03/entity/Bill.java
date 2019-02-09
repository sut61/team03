package com.sut.se.g03.entity;

import com.sut.se.g03.repository.PaidStatusRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@ToString
@EqualsAndHashCode
@Data
public class Bill {
	@SequenceGenerator(name="bill_seq",sequenceName="bill_seq")
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="bill_seq")
	@Id
	private Long id;
	private Date date;
	private float totalPrice;

	@NotNull
	@Pattern(regexp = "^(([ก-ู]|[เ-์]){1,25} ([ก-ู]|[เ-์]){1,25})|([A-Z][a-z]{1,25} [A-Z][a-z]{1,25})|([a-z]{1,25} [a-z]{1,25})$")
	private String bookingName;

	@ManyToOne
	private PaidStatus paidStatus;

	@ManyToOne
	private Member member;

	public Bill(){}

	public Bill(Date date, float totalPrice, Member member) {
		this.date = date;
		this.totalPrice += totalPrice;
		this.member = member;
	}

	public Bill(Date date, float totalPrice, Member member, PaidStatus paidStatus) {
		this.date = date;
		this.totalPrice += totalPrice;
		this.paidStatus = paidStatus;
		this.member = member;
	}

	public Bill(Date date, float totalPrice, Member member, PaidStatus paidStatus, String bookingName) {
		this.date = date;
		this.totalPrice += totalPrice;
		this.paidStatus = paidStatus;
		this.member = member;
		this.bookingName = bookingName;
	}

}
