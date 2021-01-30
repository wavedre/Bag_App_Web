package com.mywavesoftware.bagapp.dataacess;

import com.mywavesoftware.bagapp.domain.Income;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public interface IncomeDao {
	
	public Income getIncome(String IncomeName);
	public List getAllIncome();
	public boolean insertIncome(Income income);
	public boolean updateIncome(Income income, int userId);
	public boolean deleteIncome(String name, int userId);
	Income getIncomeByNameAndUserId();

}
