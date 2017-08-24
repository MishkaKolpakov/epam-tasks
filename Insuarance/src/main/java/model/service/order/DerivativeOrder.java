package model.service.order;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import model.entity.responsibility.Responsibility;

public class DerivativeOrder implements RiskRateSortable {
	
	/**
	 * Method returning order list by risk rate
	 * 
	 * @param reponsibilities
	 * @return List<Responsibility> orderedValue
	 **/
	public List<Responsibility> orderByRiskLevel(List<Responsibility> unorderResponsibilityList) {
		List<Responsibility> orderResponsibilityList = new LinkedList<>();
		orderResponsibilityList.addAll(unorderResponsibilityList);
		Collections.sort(orderResponsibilityList, new RiskRateComparator());
		return orderResponsibilityList;
	}

}
