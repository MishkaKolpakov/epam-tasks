package model.entities.responsibilities.property;

import java.util.LinkedList;
import java.util.List;

public class PropertyResponsibilitiesList extends LinkedList<PropertyResponsibility> {

	private static final long serialVersionUID = 1L;

	public PropertyResponsibilitiesList() {
		this.add(new PropertyResponsibility("Home", 20, 10_000, false));
		this.add(new PropertyResponsibility("Car", 35, 5_000, false));
		this.add(new PropertyResponsibility("Goods", 15, 7_500, true));
		this.add(new PropertyResponsibility("Business", 40, 20_000, true));
	}

	public List<PropertyResponsibility> getAvailablePropertyResponsibilities() {
		return this;
	}
}
