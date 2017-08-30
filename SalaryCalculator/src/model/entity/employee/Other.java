package model.entity.employee;
import java.time.LocalDate;

public class Other implements EmployeeGettable {

	private Worker worker;
	private String description;

	public Other(Worker worker, String description) {
		this.worker = worker;
		this.description = description;
	}

	public Worker getWorker() {
		return worker;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
