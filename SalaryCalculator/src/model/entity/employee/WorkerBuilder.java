package model.entity.employee;

import java.time.LocalDate;

public class WorkerBuilder {
	private String firstName;
	private String lastName;
	private String middleName;
	private LocalDate birthdayDate;
	private LocalDate hireJobDate;
	private Long salaryRate;

	public WorkerBuilder setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public WorkerBuilder setMiddleName(String middleName) {
		this.middleName = middleName;
		return this;
	}

	public WorkerBuilder setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public WorkerBuilder setBirthdayDate(LocalDate birthdayDate) {
		this.birthdayDate = birthdayDate;
		return this;
	}

	public Worker buildWorker() {
		return new Worker(this);
	}

	public LocalDate getHireJobDate() {
		return hireJobDate;
	}

	public WorkerBuilder setHireJobDate(LocalDate hireJobDate) {
		this.hireJobDate = hireJobDate;
		return this;
	}

	public Long getSalaryRate() {
		return salaryRate;
	}

	public WorkerBuilder setSalaryRate(Long salaryRate) {
		this.salaryRate = salaryRate;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public LocalDate getBirthdayDate() {
		return birthdayDate;
	}

}
