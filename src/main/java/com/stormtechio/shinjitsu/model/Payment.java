package com.stormtechio.shinjitsu.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Payment {
	
	@Id
	@GeneratedValue
	private int id;
	@OneToOne
	private User user;
	@Column(name = "amount")
	private Double amount;
	@Column(name = "paid")
	private boolean paid;
	@Column(name = "due_date", nullable=false)
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss'Z'")
	private Date dueDate;
	@Column(name = "payment_date", nullable=false)
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss'Z'")
	private Date paymentDate;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public boolean isPaid() {
		return paid;
	}
	public void setPaid(boolean paid) {
		this.paid = paid;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	
	
}
