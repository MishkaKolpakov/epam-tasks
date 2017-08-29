package model.entity.employee;

import java.util.List;

public class Manager {
	private Employee employee;
	private List<Worker> workersToManage;
	private Position position = Position.MANAGER;
	private Long salaryRate = position.getSalaryRate();

	public Long getSalaryRate() {
		return salaryRate;
	}

	public Manager(Employee employee) {
		this.employee = employee;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Worker> getWorkersToManage() {
		return workersToManage;
	}

	public void setWorkersToManage(List<Worker> workersToManage) {
		this.workersToManage = workersToManage;
	}

}
