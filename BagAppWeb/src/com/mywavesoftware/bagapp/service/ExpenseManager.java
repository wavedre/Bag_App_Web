package com.mywavesoftware.bagapp.service;

import java.util.List;

import com.mywavesoftware.bagapp.dataacess.ExpenseDao;
import com.mywavesoftware.bagapp.dataacess.ExpenseDaoImpl;
import com.mywavesoftware.bagapp.domain.Expense;

public class ExpenseManager {
	protected ExpenseDaoImpl expDao = new ExpenseDaoImpl();
	
	public Expense getExpense(String expenseName){
		return expDao.getExpense(expenseName);
	}
	
	public List<Expense> getAllExpenses(){
		return expDao.getAllExpenses();
	}
	
	public void addExpense(Expense exp){
		expDao.insertExpense(exp);
	}
	
	public void deleteExpense(String name, int userId){
		expDao.deleteExpense(name, userId);
		
	}
	
	public void updateExpense(Expense exp, int userId){
		expDao.updateExpense(exp, userId);
	}

}
