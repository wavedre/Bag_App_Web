package com.mywavesoftware.bagapp.dataacess;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import com.mywavesoftware.bagapp.domain.Expense;
public interface ExpenseDao {
	
	public Expense getExpense(String ExpenseName);
	public List getAllExpenses();
	public boolean insertExpense(Expense expense);
	public boolean updateExpense(Expense expense, int userId);
	public boolean deleteExpense(String name, int userId);
	Expense getExpenseByNameAndUserId();

}
