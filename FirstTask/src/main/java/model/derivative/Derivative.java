package model.derivative;

import java.util.LinkedList;
import java.util.List;

import model.entities.responsibilities.Responsibility;
import model.entities.responsibilities.individual.IndividualResponsibilitiesList;
import model.entities.responsibilities.property.PropertyResponsibilitiesList;

public class Derivative {

	private String title;

	private List<Responsibility> responsibilities;
	private IndividualResponsibilitiesList individualResponsibilitiesList;
	private PropertyResponsibilitiesList availablePropertyResponsibilities;

	public Derivative(String title) {
		this.title = title;
		individualResponsibilitiesList = new IndividualResponsibilitiesList();
		availablePropertyResponsibilities = new PropertyResponsibilitiesList();
		createDerivative();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	private void createDerivative() {
		responsibilities = new LinkedList<>();
		fillDerivative();
	}

	public void fillDerivative() {
		responsibilities.addAll((individualResponsibilitiesList.getAvailableIndividualResponsibilities()));
		responsibilities.addAll((availablePropertyResponsibilities.getAvailablePropertyResponsibilities()));
	}

	public List<Responsibility> getDerivative() {
		return responsibilities;
	}

	public IndividualResponsibilitiesList getIndividualResponsibilitiesList() {
		return individualResponsibilitiesList;
	}

	public PropertyResponsibilitiesList getAvailablePropertyResponsibilities() {
		return availablePropertyResponsibilities;
	}

}
