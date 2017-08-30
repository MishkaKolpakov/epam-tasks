package model.entity.employee;

import java.time.LocalDate;
import java.util.List;

public class Manager implements EmployeeGettable {
	private Worker worker;
	private List<Worker> workersToManage;

	public Manager(Worker worker, List<Worker> workersToManage) {
		this.worker = worker;
		this.workersToManage = workersToManage;
	}

	public Worker getWorker() {
		return worker;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}

	public List<Worker> getWorkersToManage() {
		return workersToManage;
	}

	public void setWorkersToManage(List<Worker> workersToManage) {
		this.workersToManage = workersToManage;
	}

	@Override
	public String getFirstName() {
		return worker.getFirstName();
	}

	@Override
	public String getMiddleName() {
		return worker.getMiddleName();
	}

	@Override
	public String getLastName() {
		return worker.getLastName();
	}

	@Override
	public LocalDate getBirthdayDate() {
		return worker.getBirthdayDate();
	}

	@Override
	public LocalDate getHireJobDate() {
		return worker.getHireJobDate();
	}

	@Override
	public void setSalaryRate(Long salaryRate) {
		worker.setSalaryRate(salaryRate);
	}

	@Override
	public Long getSalaryRate() {
		return worker.getSalaryRate();
	}

	@Override
	public void setActualSalary(Long actualSalary) {
		worker.setActualSalary(actualSalary);
	}

	@Override
	public Long getActualSalary() {
		return worker.getActualSalary();
	}
}
