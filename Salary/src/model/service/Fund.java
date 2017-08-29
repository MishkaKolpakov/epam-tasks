package model.service;

import dao.EmployeesDB;
import model.entity.employee.Employee;
import model.service.count.EqualCountable;
import model.service.count.EqualStrategy;

public class Fund {
	private Long budget;

	public Fund(Long budget) {
		this.budget = budget;
	}

	private Long getRest(EmployeesDB employeesDB) {
		Long costs = 0L;
		PremiumCountable premiumCountable = new CountPremium();
		SalaryRateGettable getRate = new SalaryRate();
		for (Employee employee : employeesDB.getEmployees()) {
			costs += getRate.getSalaryRate(employeesDB, employee.getLastName());
			costs += premiumCountable.countPremium(employeesDB, employee.getLastName());
		}
		return budget - costs;
	}

	public void distributeSalary(EmployeesDB employeesDB) {

		PremiumCountable premiumCountable = new CountPremium();
		EqualCountable equalCountable = new EqualStrategy();
		SalaryRateGettable getRate = new SalaryRate();

		for (Employee employee : employeesDB.getEmployees()) {
			Long salary = 0L;
			salary += getRate.getSalaryRate(employeesDB, employee.getLastName());
			salary += premiumCountable.countPremium(employeesDB, employee.getLastName());
			salary += equalCountable.distributeEqual(getRest(employeesDB), employeesDB);
			employee.setSalary(salary);
		}
	}
}
