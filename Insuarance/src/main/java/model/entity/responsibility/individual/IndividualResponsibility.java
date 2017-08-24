package model.entity.responsibility.individual;

import model.entity.responsibility.Responsibility;

public class IndividualResponsibility extends Responsibility {

	private String healthState;
	private String personalCode;

	public IndividualResponsibility(IndividualResponsibilityBuilder irb) {
		super(irb.getTitle(), irb.getRiskRate(), irb.getPrice());
		this.healthState = irb.getHealthState();
		this.personalCode = irb.getPersonalCode();
	}

	public String getHealthState() {
		return healthState;
	}

	public void setHealthState(String healthState) {
		this.healthState = healthState;
	}

	public String getPersonalCode() {
		return personalCode;
	}

	public void setPersonalCode(String personalCode) {
		this.personalCode = personalCode;
	}

}
