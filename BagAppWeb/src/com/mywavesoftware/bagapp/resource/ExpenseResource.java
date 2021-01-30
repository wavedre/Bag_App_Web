package com.mywavesoftware.bagapp.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mywavesoftware.bagapp.domain.Expense;
import com.mywavesoftware.bagapp.service.ExpenseManager;
@Path("/expenses") 

public class ExpenseResource {
	ExpenseManager expenseMgr = new ExpenseManager();
	
    @GET
    //@Path("/expense")
    @Path("{expense_name}")
    //@Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_JSON)
    public Expense getExpenses(@PathParam("expense_name") String expense_name){
    	return expenseMgr.getExpense(expense_name);
    }
    
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Expense> getAllExpenses(){
		return expenseMgr.getAllExpenses();
	}
	
	//add new
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void createExpense(Expense exp){
		expenseMgr.addExpense(exp);
		
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)	
	public void updateExpense(Expense ex){
		expenseMgr.updateExpense(ex, 0);
	}
	
	@DELETE
	@Path("{expenseName}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteExpense(@PathParam("expenseName") String expenseName ){
		expenseMgr.deleteExpense(expenseName, 0);
	}
	

}


