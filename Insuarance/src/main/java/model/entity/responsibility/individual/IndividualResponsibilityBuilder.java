package model.entity.responsibility.individual;

import java.math.BigDecimal;

public class IndividualResponsibilityBuilder {
	public IndividualResponsibilityBuilder() {
	}

	private String title;
	private Integer riskRate;
	private BigDecimal price;
	private String healthState;
	private String personalCode;

	public IndividualResponsibilityBuilder setTitle(String title) {
		this.title = title;
		return this;
	}

	public IndividualResponsibilityBuilder setRiskRate(Integer riskRate) {
		this.riskRate = riskRate;
		return this;
	}

	public IndividualResponsibilityBuilder setPrice(BigDecimal price) {
		this.price = price;
		return this;
	}

	public IndividualResponsibilityBuilder setHealthState(String healthState) {
		this.healthState = healthState;
		return this;
	}

	public IndividualResponsibilityBuilder setPersonalCode(String personalCode) {
		this.personalCode = personalCode;
		return this;
	}

	public IndividualResponsibility buildIndividualResponsibility() {
		return new IndividualResponsibility(this);
	}

	public String getTitle() {
		return title;
	}

	public Integer getRiskRate() {
		return riskRate;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public String getHealthState() {
		return healthState;
	}

	public String getPersonalCode() {
		return personalCode;
	}

}
