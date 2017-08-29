package dao;

import java.util.ArrayList;
import java.util.List;

import model.entity.employee.Employee;
import model.entity.employee.Manager;
import model.entity.employee.Other;
import model.entity.employee.Worker;

public class EmployeesDB {

	private WorkerDAO workerDAO = new WorkerDAO();
	private ManagerDAO managerDAO = new ManagerDAO();
	private OtherDAO otherDAO = new OtherDAO();
	private List<Employee> employees = new ArrayList<>();

	public EmployeesDB() {
		fillEmployee();
	}

	private void fillEmployee() {
		for (Manager manager : getManagerDAO().getManagers()) {
			employees.add(manager.getEmployee());
		}
		for (Worker worker : getWorkerDAO().getWorkers()) {
			employees.add(worker.getEmployee());
		}
		for (Other other : getOtherDAO().getOthers()) {
			employees.add(other.getEmployee());
		}
	}
	
	public List<Employee> getEmployees(){
		return employees;
	}

	public WorkerDAO getWorkerDAO() {
		return workerDAO;
	}

	public ManagerDAO getManagerDAO() {
		return managerDAO;
	}

	public OtherDAO getOtherDAO() {
		return otherDAO;
	}
}
