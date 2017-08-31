package model.entity.employee;

import java.time.LocalDate;

public class Worker implements EmployeeGettable {
	private String firstName;
	private String lastName;
	private String middleName;
	private LocalDate birthdayDate;
	private LocalDate hireJobDate;
	private Long salaryRate;
	private Long actualSalary;
	
	public Worker(WorkerBuilder workerBuilder) {
		this.firstName = workerBuilder.getFirstName();
		this.lastName = workerBuilder.getLastName();
		this.middleName = workerBuilder.getMiddleName();
		this.birthdayDate = workerBuilder.getBirthdayDate();
		this.hireJobDate = workerBuilder.getHireJobDate();
		this.salaryRate = workerBuilder.getSalaryRate();
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public void setBirthdayDate(LocalDate birthdayDate) {
		this.birthdayDate = birthdayDate;
	}

	public void setHireJobDate(LocalDate hireJobDate) {
		this.hireJobDate = hireJobDate;
	}

	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public String getMiddleName() {
		return middleName;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public LocalDate getBirthdayDate() {
		return birthdayDate;
	}

	@Override
	public LocalDate getHireJobDate() {
		return hireJobDate;
	}

	@Override
	public void setSalaryRate(Long salaryRate) {
		this.salaryRate = salaryRate;
	}

	@Override
	public Long getSalaryRate() {
		return salaryRate;
	}

	@Override
	public void setActualSalary(Long actualSalary) {
		this.actualSalary = actualSalary;
	}

	@Override
	public Long getActualSalary() {
		return actualSalary;
	}

}