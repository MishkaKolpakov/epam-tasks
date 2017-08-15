package model.entities.responsibilities.individual;

import java.util.LinkedList;
import java.util.List;

public class IndividualResponsibilitiesList extends LinkedList<IndividualResponsibility> {

	private static final long serialVersionUID = 1L;

	public IndividualResponsibilitiesList() {
		this.add(new IndividualResponsibility("Life", 35, 5_500, false));
		this.add(new IndividualResponsibility("Medical", 25, 2_300, true));
		this.add(new IndividualResponsibility("Pension", 45, 3_000, true));
		this.add(new IndividualResponsibility("Accident", 20, 4_000, false));
	}

	public List<IndividualResponsibility> getAvailableIndividualResponsibilities() {
		return this;
	}
}
