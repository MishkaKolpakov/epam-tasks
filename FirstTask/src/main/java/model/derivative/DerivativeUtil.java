package model.derivative;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import model.comparators.RiskLevelComparator;
import model.entities.responsibilities.Responsibility;

public class DerivativeUtil {
	List<Responsibility> responsibilities;
	Derivative derivative;

	public DerivativeUtil(Derivative derivative) {
		this.responsibilities = derivative.getDerivative();
		this.derivative = derivative;
	}

	public Derivative getDerivative() {
		return derivative;
	}

	private boolean checkDiapason(Responsibility responsibility, long lowerPrice, long upperPrice) {
		return (responsibility.getPrice() >= lowerPrice && responsibility.getPrice() <= upperPrice);
	}

	private boolean checkDiapason(Responsibility responsibility, int lowerRisk, int upperRisk) {
		return (responsibility.getRiskLevel() >= lowerRisk && responsibility.getRiskLevel() <= upperRisk);
	}

	private boolean checkFullDiapason(Responsibility responsibility, int lowerRisk, int upperRisk, long lowerPrice,
			long upperPrice) {
		return checkDiapason(responsibility, lowerRisk, upperRisk)
				&& checkDiapason(responsibility, lowerPrice, upperPrice);
	}

	public List<Responsibility> sortByRiskLevel() {
		List<Responsibility> temp = new LinkedList<>();
		temp.addAll(responsibilities);
		Collections.sort(temp, new RiskLevelComparator());
		return responsibilities = temp;
	}
	
	public long summaryPrice() {
		long sum = 0;
		for (Responsibility responsibility : responsibilities) {
			sum += responsibility.getPrice();
		}
		return sum;
	}

	public List<Responsibility> findByRiskLevel(int lowerRisk, int upperRisk) {
		List<Responsibility> temporary = new LinkedList<>();
		for (Responsibility note : responsibilities) {
			if (checkDiapason(note, lowerRisk, upperRisk)) {
				temporary.add(note);
			}
		}
		return temporary;
	}

	public List<Responsibility> findByPrice(long lowerPrice, long upperPrice) {
		List<Responsibility> temporary = new LinkedList<>();
		for (Responsibility note : responsibilities) {
			if (checkDiapason(note, lowerPrice, upperPrice)) {
				temporary.add(note);
			}
		}
		return temporary;
	}

	public List<Responsibility> findByPriceAndRisk(long lowerPrice, long upperPrice, int lowerRisk, int upperRisk) {
		List<Responsibility> temporary = new LinkedList<>();
		for (Responsibility note : responsibilities) {
			if (checkFullDiapason(note, lowerRisk, upperRisk, lowerPrice, upperPrice)) {
				temporary.add(note);
			}
		}
		return temporary;
	}

}
