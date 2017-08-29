package model.entity.employee;

import java.time.LocalDate;

public class Employee {
	private String firstName;
	private String middleName;
	private String lastName;
	private LocalDate birthdayDate;
	private LocalDate hireJobDate;
	private Long salary;

	public Employee(String firstName, String middleName, String lastName, LocalDate birthdayDate,
			LocalDate hireJobDate) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.birthdayDate = birthdayDate;
		this.hireJobDate = hireJobDate;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthdayDate() {
		return birthdayDate;
	}

	public void setBirthdayDate(LocalDate birthdayDate) {
		this.birthdayDate = birthdayDate;
	}

	public LocalDate getHireJobDate() {
		return hireJobDate;
	}

	public void setHireJobDate(LocalDate hireJobDate) {
		this.hireJobDate = hireJobDate;
	}

}
