package model.entity.responsibility.property;

import model.entity.responsibility.Responsibility;

public class PropertyResponsibility extends Responsibility {
	private String propertyState;
	private boolean compulsory;

	public PropertyResponsibility(PropertyResponsibilityBuilder prb) {
		super(prb.getTitle(), prb.getRiskRate(), prb.getPrice());
		this.propertyState = prb.getPropertyState();
		this.compulsory = prb.isCompulsory();
	}

	public String getPropertyState() {
		return propertyState;
	}

	public void setPropertyState(String propertyState) {
		this.propertyState = propertyState;
	}

	public boolean isCompulsory() {
		return compulsory;
	}

	public void setCompulsory(boolean compulsory) {
		this.compulsory = compulsory;
	}

}
