package model.dao;

import java.util.ArrayList;
import java.util.List;

import model.entity.employee.Manager;
import model.entity.employee.Other;
import model.entity.employee.Worker;

public class EmployeeDB {

	private WorkerDAO workers = new WorkerDAO();
	private ManagerDAO managers = new ManagerDAO();
	private OtherDAO others = new OtherDAO();
	private List<Worker> employees = new ArrayList<>();

	public EmployeeDB() {
		employees.addAll(workers);

		for (Manager manager : managers) {
			employees.add(manager.getWorker());
		}

		for (Other other : others) {
			employees.add(other.getWorker());
		}
	}

	public List<Worker> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Worker> employees) {
		this.employees = employees;
	}

	public WorkerDAO getWorkers() {
		return workers;
	}

	public void setWorkers(WorkerDAO workers) {
		this.workers = workers;
	}

	public ManagerDAO getManagers() {
		return managers;
	}

	public void setManagers(ManagerDAO managers) {
		this.managers = managers;
	}

	public OtherDAO getOthers() {
		return others;
	}

	public void setOthers(OtherDAO others) {
		this.others = others;
	}

}
