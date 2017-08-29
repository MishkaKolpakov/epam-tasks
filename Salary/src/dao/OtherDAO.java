package dao;

import java.time.LocalDate;


import java.util.ArrayList;
import java.util.List;

import model.entity.employee.Employee;
import model.entity.employee.Other;
import model.entity.employee.Position;

public class OtherDAO extends ArrayList<Other> implements DAOAddable<Other>, DAORemovable, DAOSearchable<Other> {

	private static final long serialVersionUID = 1L;

	public OtherDAO() {
		this.add(new Other(
				new Employee("Lilia", "Vitalivna", "Tyshchyk", LocalDate.of(1990, 8, 13), LocalDate.of(2009, 4, 17)),
				Position.DIRECTOR, "The director of firm ..."));
		this.add(new Other(
				new Employee("Petr", "Ivanovych", "Kostenko", LocalDate.of(1998, 1, 4), LocalDate.of(2011, 5, 12)),
				Position.LAWYER, "Lawyer ..."));
		this.add(new Other(new Employee("Svitlana", "Mykhailivna", "Skulska", LocalDate.of(1990, 7, 22),
				LocalDate.of(2014, 2, 11)), Position.SECRETARY, "Secretary description ..."));
	}

	public List<Other> getOthers() {
		return this;
	}

	@Override
	public boolean addEmployee(Other employee) {
		return this.add(employee);
	}

	@Override
	public boolean removeEmployee(String lastName) {
		for (Other other : this) {
			if (other.getEmployee().getLastName().toUpperCase().equals(lastName.toUpperCase())) {
				return this.remove(other);
			}
		}
		return false;
	}

	@Override
	public Other findByLastName(String lastName) {
		for(Other other : this) {
			if(other.getEmployee().getLastName().toUpperCase().equals(lastName)) {
				return other;
			}
		}
		return null;
	}


}
