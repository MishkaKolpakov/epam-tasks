package dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.entity.employee.Employee;
import model.entity.employee.Manager;

public class ManagerDAO extends ArrayList<Manager> implements DAOAddable<Manager>, DAORemovable, DAOSearchable<Manager> {
	
	private static final long serialVersionUID = 1L;

	public ManagerDAO() {
		this.add(new Manager(new Employee("Ekateryna", "Anreevna", "Skichko", LocalDate.of(1990, 8, 13),
				LocalDate.of(2017, 4, 17))));
		this.add(new Manager(new Employee("Valeriy", "Petrovich", "Petrenko", LocalDate.of(1998, 1, 4),
				LocalDate.of(2015, 11, 12))));
		this.add(new Manager(new Employee("Anton", "Mykhailovych", "Fedorov", LocalDate.of(1990, 8, 22),
				LocalDate.of(2017, 12, 11))));
		this.add(new Manager(new Employee("Vasiliy", "Aleksandrovych", "Chinaksi", LocalDate.of(1992, 11, 14),
				LocalDate.of(2017, 12, 14))));
	}

	public List<Manager> getManagers() {
		return this;
	}

	@Override
	public boolean addEmployee(Manager employee) {
		return this.add(employee);
	}

	@Override
	public boolean removeEmployee(String lastName) {
		for (Manager manager : this) {
			if (manager.getEmployee().getLastName().toUpperCase().equals(lastName.toUpperCase())) {
				return this.remove(manager);
			}
		}
		return false;
	}

	@Override
	public Manager findByLastName(String lastName) {
		for(Manager manager : this) {
			if(manager.getEmployee().getLastName().toUpperCase().equals(lastName)) {
				return manager;
			}
		}
		return null;
	}
}
