package com.mywavesoftware.bagapp.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.sql.Date;

import javax.xml.bind.annotation.XmlElement; 
import javax.xml.bind.annotation.XmlRootElement; 
//@XmlRootElement(name = "expense")

public class Expense implements Serializable{
	//private static final long serialVersionUID = 1L;
	private int amount;
	private String name;
	private String frequency;
	private Date dueDate;
	private String category;
	private int userId;
	

	public Expense(int amt, String name, Date dd, String cat){
		this.amount = amt;
		this.name = name;
		this.dueDate = dd;
		this.category = cat;
	}
	
	public Expense(){
		
	}
	public int getAmount() {
		return amount;
	}
	//@XmlElement
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getName() {
		return name;
	}
	//@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	public String getFrequency() {
		return frequency;
	}
	//@XmlElement
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public Date getDueDate() {
		return dueDate;
	}
	//@XmlElement
	public void setDueDate(Date date) {
		this.dueDate = date;
	}
	public String getCategory() {
		return category;
	}
	//@XmlElement
	public void setCategory(String category) {
		this.category = category;
	}

	public int getUserId() {
		return userId;
	}

	//@XmlElement
	public void setUserId(int userId) {
		this.userId = userId;
	}
	

	
}
