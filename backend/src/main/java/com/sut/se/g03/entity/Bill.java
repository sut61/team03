package com.sut.se.g03.entity;

import com.sut.se.g03.repository.PaidStatusRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@ToString
@EqualsAndHashCode
@Data
public class Bill {
	@SequenceGenerator(name="bill_seq",sequenceName="bill_seq")
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="bill_seq")
	@Id
	private Long id;

	@NotNull
	private Date date;

	@PositiveOrZero
	private float totalPrice;

	@ManyToOne
	@NotNull
	private PaidStatus paidStatus;

	@ManyToOne
	@NotNull
	private Member member;

	@OneToMany
	List<Contact> contacts;

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

}
