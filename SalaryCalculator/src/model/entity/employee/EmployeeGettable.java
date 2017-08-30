package model.entity.employee;
import java.time.LocalDate;

public interface EmployeeGettable {

	String getFirstName();

	String getMiddleName();

	String getLastName();

	LocalDate getBirthdayDate();
	
	LocalDate getHireJobDate();
	
	void setSalaryRate(Long salaryRate);
	
	Long getSalaryRate();
	
	void setActualSalary(Long actualSalary);
	
	Long getActualSalary();
}
