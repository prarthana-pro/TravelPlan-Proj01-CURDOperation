package com.nt.service;

import java.util.List;
import java.util.Map;

import com.nt.entity.TravelPlan;

public interface ITravelPlanMgmtService {
	public String registerTravelPlan(TravelPlan plan); //save operation
	public Map<Integer ,String> getTravelPlanCategories(); //Select Operation
	public List<TravelPlan> showAllTravelPlans();//for Select operation
	public TravelPlan showTravelPlanIdBy(Integer planId);//for edit operation(To show the  record editing)
	public String updateTravelPlan(TravelPlan plan); //for edit operation form submission 
	public String deleteTravelPlan(Integer planId); //for deletion operation (hard deletion)
	public String changeTravelPlanStatus(Integer planId,String status);//soft deletion activity
	

}
