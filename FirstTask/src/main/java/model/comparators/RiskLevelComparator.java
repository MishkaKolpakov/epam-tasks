package model.comparators;

import java.util.Comparator;

import model.entities.responsibilities.Responsibility;

public class RiskLevelComparator implements Comparator<Responsibility> {

	@Override
	public int compare(Responsibility o1, Responsibility o2) {
		return o2.getRiskLevel() - o1.getRiskLevel();
	}
}
