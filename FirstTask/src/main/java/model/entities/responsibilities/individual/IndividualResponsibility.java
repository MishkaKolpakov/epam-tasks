package model.entities.responsibilities.individual;

import model.entities.responsibilities.Responsibility;

public class IndividualResponsibility extends Responsibility {

	private boolean isGroup;

	public IndividualResponsibility(String title, int riskLevel, long price, boolean isGroup) {
		super(title, riskLevel, price);
		setIsGroup(isGroup);
	}

	public boolean isGroup() {
		return isGroup;
	}

	public void setIsGroup(boolean isGroup) {
		this.isGroup = isGroup;
	}
}
