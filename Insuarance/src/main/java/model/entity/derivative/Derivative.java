package model.entity.derivative;

import java.math.BigDecimal;
import java.util.List;

import dao.individual.IndividualDAO;
import dao.property.PropertyDAO;
import model.entity.responsibility.individual.IndividualResponsibility;
import model.entity.responsibility.property.PropertyResponsibility;

public class Derivative {
	private List<IndividualResponsibility> individualResponsibilities;
	private List<PropertyResponsibility> propertyResponsibilities;
	private BigDecimal summary;

	public Derivative(IndividualDAO individualDAO, PropertyDAO propertyDAO) {
		this.individualResponsibilities = individualDAO.getAllIndividualResponsibilities();
		this.propertyResponsibilities = propertyDAO.getAllPropertyResponsibilities();
	}

	public List<IndividualResponsibility> getIndividualResponsibilities() {
		return individualResponsibilities;
	}

	public void setIndividualResponsibilities(List<IndividualResponsibility> individualResponsibilities) {
		this.individualResponsibilities = individualResponsibilities;
	}

	public List<PropertyResponsibility> getPropertyResponsibilities() {
		return propertyResponsibilities;
	}

	public void setPropertyResponsibilities(List<PropertyResponsibility> propertyResponsibilities) {
		this.propertyResponsibilities = propertyResponsibilities;
	}

	public BigDecimal getSummary() {
		return summary;
	}

	public void setSummary(BigDecimal summary) {
		this.summary = summary;
	}

}
