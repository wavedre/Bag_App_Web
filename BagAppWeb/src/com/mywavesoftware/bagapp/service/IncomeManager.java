package com.mywavesoftware.bagapp.service;

import java.util.List;

import com.mywavesoftware.bagapp.dataacess.IncomeDaoImpl;
import com.mywavesoftware.bagapp.domain.Income;


public class IncomeManager {
	protected IncomeDaoImpl incomeDaoimpl = new IncomeDaoImpl();
	
	public Income getIncome(String incomeName){
		return incomeDaoimpl.getIncome(incomeName);
	}
	
	public List<Income> getAllIncome(){
		return incomeDaoimpl.getAllIncome();
	}
	
	public void addIncome(Income income){
		incomeDaoimpl.insertIncome(income);
	}
	
	public void deleteIncome(String name, int userId){
		incomeDaoimpl.deleteIncome(name, userId);
	}
	
	public void updateIncome(Income income, int userId){
		incomeDaoimpl.updateIncome(income, userId);
	}
	
	
	
	
		

}
