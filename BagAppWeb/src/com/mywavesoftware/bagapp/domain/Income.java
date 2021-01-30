package com.mywavesoftware.bagapp.domain;

import java.io.Serializable;
import java.sql.Date;

public class Income implements Serializable{
	
	private int userId;
	private int amount;
	private String name;
	private Date payDate;
	private String frequency;
	



	public Income(){
		
	}
	
	public Income(int amount, String name, Date payDate, String frequency) {
		super();
		this.amount = amount;
		this.name = name;
		this.payDate = payDate;
		this.frequency = frequency;
	}
	
	
	public Income(int amount, String name, Date payDate, String frequency, int userId) {
		super();
		this.amount = amount;
		this.name = name;
		this.payDate = payDate;
		this.frequency = frequency;
		this.userId = userId;
	}

	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	
	
}
