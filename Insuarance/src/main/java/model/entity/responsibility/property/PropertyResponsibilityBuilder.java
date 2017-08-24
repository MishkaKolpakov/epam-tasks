package model.entity.responsibility.property;

import java.math.BigDecimal;

public class PropertyResponsibilityBuilder {
	private String title;
	private Integer riskRate;
	private BigDecimal price;
	private String propertyState;
	private Boolean compulsory;

	public PropertyResponsibilityBuilder() {
	}

	public PropertyResponsibilityBuilder setTitle(String title) {
		this.title = title;
		return this;
	}

	public PropertyResponsibilityBuilder setRiskRate(Integer riskRate) {
		this.riskRate = riskRate;
		return this;
	}

	public PropertyResponsibilityBuilder setPrice(BigDecimal price) {
		this.price = price;
		return this;
	}

	public PropertyResponsibilityBuilder setPropertyState(String propertyState) {
		this.propertyState = propertyState;
		return this;
	}

	public PropertyResponsibilityBuilder setCompulsory(Boolean compulsory) {
		this.compulsory = compulsory;
		return this;
	}

	public PropertyResponsibility buildPropertyResponsibility() {
		return new PropertyResponsibility(this);
	}

	public Boolean isCompulsory() {
		return compulsory;
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

	public String getPropertyState() {
		return propertyState;
	}

}
