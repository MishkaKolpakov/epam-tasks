package dao;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

import model.entity.employee.Employee;
import model.entity.employee.Worker;

public class WorkerDAO extends ArrayList<Worker> implements DAOAddable<Worker>, DAORemovable, DAOSearchable<Worker> {

	private static final long serialVersionUID = 1L;

	public WorkerDAO() {
		this.add(new Worker(new Employee("Mykhailo", "Oleksiyovych", "Kolpakov", LocalDate.of(1995, 11, 14),
				LocalDate.of(2017, 7, 17))));
		this.add(new Worker(
				new Employee("Andrew", "Petrovich", "Ivanov", LocalDate.of(1998, 12, 4), LocalDate.of(2015, 2, 12))));
		this.add(new Worker(new Employee("Illya", "Mykhailovych", "Gerasimov", LocalDate.of(1990, 8, 22),
				LocalDate.of(2017, 5, 11))));
		this.add(new Worker(
				new Employee("Kostya", "Ignatievych", "Hvalko", LocalDate.of(1995, 8, 14), LocalDate.of(2017, 3, 4))));
		this.add(new Worker(new Employee("Nazar", "Volodymyrovych", "Petrov", LocalDate.of(1995, 5, 14),
				LocalDate.of(2017, 5, 6))));
	}

	public List<Worker> getWorkers() {
		return this;
	}

	@Override
	public boolean removeEmployee(String lastName) {
		for (Worker worker : this) {
			if (worker.getEmployee().getLastName().toUpperCase().equals(lastName.toUpperCase())) {
				return this.remove(worker);
			}
		}
		return false;
	}

	@Override
	public boolean addEmployee(Worker employee) {
		return this.add(employee);
	}

	@Override
	public Worker findByLastName(String lastName) {
		for(Worker worker : this) {
			if(worker.getEmployee().getLastName().toUpperCase().equals(lastName)) {
				return worker;
			}
		}
		return null;
	}
	
}
