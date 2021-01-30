package com.mywavesoftware.bagapp.dataacess;

import com.mywavesoftware.bagapp.domain.Income;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//import com.wavesoftware.bagapp.dataaccess.ConnectionFactory;
//import com.wavesoftware.bagapp.expense.Expense;

public class IncomeDaoImpl implements IncomeDao{
	
	public Income extractIncomeFromResultSet(ResultSet rs) throws SQLException {
		Income income = new Income();
		
		income.setAmount(rs.getInt("amount"));
		income.setName(rs.getString("name"));
		income.setPayDate(rs.getDate("pay_date"));
		income.setFrequency(rs.getString("frequency"));
		income.setUserId(rs.getInt("user_id"));
		
		return income;
	}


	/*
	 * (non-Javadoc)
	 * @see com.wavesoftware.bagapp.income.IncomeDao#getIncome(java.lang.String)
	 */
	public Income getIncome(String incomeName){
		Connection connection = ConnectionFactory.getConnection();
		try{
			Statement stmt = connection.createStatement();
			//System.out.print("expense name in dao object before execution is: " + incomeName);
			ResultSet rs = stmt.executeQuery("SELECT * FROM temp_income where name = '" + incomeName + "'");
			
			if(rs.next()){
				return extractIncomeFromResultSet(rs);

			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
         
		return null;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.wavesoftware.bagapp.income.IncomeDao#getAllIncome()
	 */
	
	public ArrayList<Income> getAllIncome(){

		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM temp_income");
			ArrayList<Income> incomes = new ArrayList<Income>();
			
			while(rs.next())
			{
				Income income = extractIncomeFromResultSet(rs);
				incomes.add(income);
			}
					
			return incomes;
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return null;
		
	}
	/*
	 * (non-Javadoc)
	 * @see com.wavesoftware.bagapp.income.IncomeDao#insertIncome(com.wavesoftware.bagapp.income.Income)
	 */
	public boolean insertIncome(Income income){
		Connection connection = ConnectionFactory.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO temp_income VALUES (?, ?, ?, ?, ?)");
			ps.setInt(1, income.getUserId());
			ps.setInt(2, income.getAmount());    //ps.setInt(1, expense.getAmount());
			ps.setString(3, income.getName());   //ps.setString(2,  expense.getName());
			ps.setDate(4, income.getPayDate());	//ps.setDate(3, expense.getDueDate());
			ps.setString(5,  income.getFrequency());	//ps.setString(4,  expense.getCategory());
			int i = ps.executeUpdate();
			
			if(i == 1){
				return true;
			} 
		}catch (SQLException ex){
				ex.printStackTrace();
			}

		return false;
	}
	
	/*
	 * 
	 */
	public boolean updateIncome(Income income, int userId){
		Connection connection = ConnectionFactory.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("UPDATE temp_income SET amount=?, pay_date=?, frequency=? WHERE name=? AND user_id=?");
			/*ps.setInt(1,  expense.getAmount());
			ps.setDate(2, expense.getDueDate());
			ps.setString(3, expense.getCategory());
			ps.setString(4, expense.getName()); 
			*/
			ps.setInt(1, income.getAmount());   
			ps.setDate(2, income.getPayDate());	
			ps.setString(3,  income.getFrequency());
			ps.setString(4, income.getName());
			ps.setInt(5, income.getUserId());
			int i = ps.executeUpdate();
			
			if(i == 1){
				return true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			
		}
		return false;
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.wavesoftware.bagapp.income.IncomeDao#deleteIncome(java.lang.String, int)
	 */
	public boolean deleteIncome(String name, int userId){
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			int i = stmt.executeUpdate("DELETE FROM temp_income where name='" + name + "' AND user_id=" + userId);
			
			if(i == 1) {
				return true;
			}
		}catch (SQLException ex){
			ex.printStackTrace();
		}
		return false;
	}
	public Income getIncomeByNameAndUserId(){
		Income theIncome = new Income();
		return theIncome;
	}
	
	/*
	 * get all income for a user based on User id
	 */
	public List<Income> getAllIncomeByUserId(int userId){
		
		List<Income> incomeList = new ArrayList<Income>();
		return incomeList;
	}
	
	public boolean insertIncomeByUserId(Income income, int userId){
		return true;
	}

		
	

}
