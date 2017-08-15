package model.entities.responsibilities.property;

import model.entities.responsibilities.Responsibility;

public class PropertyResponsibility extends Responsibility {
	private boolean propertyValueated;

	public PropertyResponsibility(String title, int riskLevel, long price, boolean propertyValuated) {
		super(title, riskLevel, price);
		setPropertyValueated(propertyValuated);
	}

	public boolean isPropertyValueated() {
		return propertyValueated;
	}

	public void setPropertyValueated(boolean propertyValueated) {
		this.propertyValueated = propertyValueated;
	}
}
