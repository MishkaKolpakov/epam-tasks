package model.service;

import dao.EmployeesDB;

public interface PremiumCountable {
	Long countPremium(EmployeesDB employeesDB, String lastName);
}
