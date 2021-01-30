package com.mywavesoftware.bagapp.dataacess;

import com.mywavesoftware.bagapp.domain.Expense;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//import com.mywavesoftware.bagapp.dataaccess.ConnectionFactory;

public class ExpenseDaoImpl implements ExpenseDao {
	
	public Expense extractExpenseFromResultSet(ResultSet rs) throws SQLException {
		Expense expense = new Expense();
		
    	expense.setAmount(rs.getInt("expense_amount"));
		expense.setName(rs.getString("expense_name"));
		expense.setDueDate(rs.getDate("date_due"));
		
		expense.setCategory(rs.getString("category"));
		
		return expense;
		
	}
	
	public Expense getExpense(String expenseName){
		Connection connection = ConnectionFactory.getConnection();
		try{
			Statement stmt = connection.createStatement();
			//System.out.print("expense name in dao object before execution is: " + expenseName);
			ResultSet rs = stmt.executeQuery("SELECT * FROM temp_expense where expense_name = '" + expenseName + "'");
			
			if(rs.next()){
				return extractExpenseFromResultSet(rs);

			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
         
		return null;
	}
	public ArrayList<Expense> getAllExpenses(){

		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM temp_expense");
			ArrayList<Expense> expenses = new ArrayList<Expense>();
			
			while(rs.next())
			{
				Expense expense = extractExpenseFromResultSet(rs);
				expenses.add(expense);
			}
					
			return expenses;
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return null;
		
	}
	
	public boolean insertExpense(Expense expense){
		Connection connection = ConnectionFactory.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO temp_expense VALUES (?, ?, ?, ?, ?)");
			ps.setInt(1, expense.getAmount());
			ps.setString(2,  expense.getName());
			ps.setDate(3, expense.getDueDate());
			ps.setString(4,  expense.getCategory());
			ps.setInt(5, expense.getUserId());
			int i = ps.executeUpdate();
			
			if(i == 1){
				return true;
			} 
		}catch (SQLException ex){
				ex.printStackTrace();
			}

		return false;
	}
		
		
	public boolean updateExpense(Expense expense, int userId){
		Connection connection = ConnectionFactory.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("UPDATE temp_expense SET expense_amount=?, date_due=?, category=? WHERE expense_name=? AND user_id=?");
			ps.setInt(1,  expense.getAmount());
			ps.setDate(2, expense.getDueDate());
			ps.setString(3, expense.getCategory());
			ps.setString(4, expense.getName());
			ps.setInt(5, expense.getUserId());
			int i = ps.executeUpdate();
			
			if(i == 1){
				return true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			
		}
		return false;
		
	}
	public boolean deleteExpense(String name, int userId){
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			int i = stmt.executeUpdate("DELETE FROM temp_expense where expense_name= '" + name + "' AND user_id= '"  + userId + "'");
			
			
			if(i == 1) {
				return true;
			}
		}catch (SQLException ex){
			ex.printStackTrace();
		}
		return false;
	}
	public Expense getExpenseByNameAndUserId(){
		Expense theExpense = new Expense();
		return theExpense;
	}

}
