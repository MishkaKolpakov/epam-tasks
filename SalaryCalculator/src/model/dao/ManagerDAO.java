package model.dao;

import java.time.LocalDate;
import java.util.ArrayList;

import model.entity.employee.Manager;
import model.entity.employee.Worker;
import model.entity.employee.WorkerBuilder;

public class ManagerDAO extends ArrayList<Manager> implements ManagerSearchable {

	private static final long serialVersionUID = 1L;

	public ManagerDAO() {
		WorkerDepartmentImpl deparment = new WorkerDepartmentImpl();

		this.add(new Manager(
				new WorkerBuilder().setFirstName("Ekateryna").setLastName("Kochubey").setMiddleName("Petrivna")
						.setSalaryRate(5000L).setBirthdayDate(LocalDate.of(1987, 8, 24))
						.setHireJobDate(LocalDate.of(2009, 2, 15)).buildWorker(),
				deparment.getWorkersByDepartment(Department.FINANCE)));

		this.add(new Manager(
				new WorkerBuilder().setFirstName("Vasyl").setLastName("Kondrashov").setMiddleName("Oleksadrovych")
						.setSalaryRate(5000L).setBirthdayDate(LocalDate.of(1987, 2, 24))
						.setHireJobDate(LocalDate.of(2010, 7, 12)).buildWorker(),
				deparment.getWorkersByDepartment(Department.IT)));

		this.add(new Manager(
				new WorkerBuilder().setFirstName("Danyl").setLastName("Teslenko").setMiddleName("Mykhailovych")
						.setSalaryRate(5000L).setBirthdayDate(LocalDate.of(1984, 5, 24))
						.setHireJobDate(LocalDate.of(2011, 9, 22)).buildWorker(),
				deparment.getWorkersByDepartment(Department.SUPPORT)));

	}

	@Override
	public Manager findManager(Worker worker) {
		for (Manager manager : this) {
			if (manager.getLastName().equalsIgnoreCase(worker.getLastName()))
				return manager;
		}
		return null;
	}
	
	
}
