package com.nt.service;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.TravelPlan;
import com.nt.entity.PlanCategory;
import com.nt.repository.IPlanCategoryRepsoitory;
import com.nt.repository.ITravelPlanRepository;
@Service
public class TravelPlanMgmtServiceImpl implements ITravelPlanMgmtService {
	@Autowired
	
	private ITravelPlanRepository travelPlanRepo;
	@ Autowired
	private IPlanCategoryRepsoitory planCategoryRepo;

	@Override
	public String registerTravelPlan(TravelPlan plan) {
		//save the object
		TravelPlan saved=travelPlanRepo.save(plan);
		return saved.getPlanId()!=null?"Travel Plan is saved with id value::"+saved.getPlanId():"Problem is saving TourPlan";
	}

	@Override
	public Map<Integer, String> getTravelPlanCategories() {
		//getTravelPlanCategories
		List<PlanCategory>list=planCategoryRepo.findAll();
		Map<Integer,String> categoriesMap=new HashMap<Integer,String>();
		list.forEach(category->{
			categoriesMap.put(category.getCategoryId(),category.getCategoryName());
			
		});
		
		return categoriesMap;
	}

	@Override
	public List<TravelPlan> showAllTravelPlans() {
		
		return travelPlanRepo.findAll();
	}

	@Override
	public TravelPlan showTravelPlanIdBy(Integer planId) {
		return travelPlanRepo.findById(planId).orElseThrow(() ->new IllegalArgumentException("TravelPlan is not found"));
		/*Optional<TravelPlan> opt=travelPlanRepo.findByld(planId);
		if(opt.isPrepent)) f
		return opt.get);
		｝
		else {
		throw new IllegalArgumentException("plain id not found");
		return null;
		｝*/
		
	}

	@Override
	public String updateTravelPlan(TravelPlan plan) {
		//update the object
		TravelPlan updated=travelPlanRepo.save(plan);
		return updated.getPlanId()+" Travel Plan is updated";
		
	}

	@Override
	public String deleteTravelPlan(Integer planId) {
		Optional<TravelPlan> opt=travelPlanRepo.findById(planId);
		if(opt.isPresent()) {
		//update the object
		travelPlanRepo.deleteById(planId);
		return planId+" Travel Plan is deleted";
		}
		else {
		return planId+" Travel Plan is not found";
		
		}
		
	}

	@Override
	public String changeTravelPlanStatus(Integer planId,String status) {
		Optional<TravelPlan> opt=travelPlanRepo.findById(planId);
		if(opt.isPresent()){
		TravelPlan plan=opt.get();
		plan.setActiveSW(status);
		travelPlanRepo.save(plan);
		return planId+" TRavel Plan Status is changed";
		
		}
		else {
			return planId+" Travel Plan is not found for updation";
		}
	}
}
