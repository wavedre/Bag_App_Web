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

import com.mywavesoftware.bagapp.domain.Income;
import com.mywavesoftware.bagapp.service.IncomeManager;
@Path("/incomes")

public class IncomeResource {
	IncomeManager incomeMgr = new IncomeManager();
	
	@GET
	@Path("{incomeName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Income getIncome(@PathParam("incomeName") String incomeName){
		return incomeMgr.getIncome(incomeName);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Income> getAllExpenses(){
		return incomeMgr.getAllIncome();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void createIncome(Income income){
		incomeMgr.addIncome(income);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateIncome(Income income){
		incomeMgr.updateIncome(income, 1234);
	}
	
	@DELETE
	@Path("{incomeName}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteIncome(@PathParam("incomeName") String incomeName){
		incomeMgr.deleteIncome(incomeName, 1234);
	}
}
