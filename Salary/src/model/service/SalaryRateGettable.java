package model.service;

import dao.EmployeesDB;

public interface SalaryRateGettable {
	Long getSalaryRate(EmployeesDB employeesDB, String lastName);
}
