package model.service.order;

import java.util.Comparator;

import model.entity.responsibility.Responsibility;

public class RiskRateComparator implements Comparator<Responsibility> {
	// Risk rate comparator
	@Override
	public int compare(Responsibility firstResponsibility, Responsibility secondResponsibility) {
		return secondResponsibility.getRiskRate() - firstResponsibility.getRiskRate();
	}
}
