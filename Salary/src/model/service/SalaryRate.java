package model.service;

import dao.EmployeesDB;
import model.entity.employee.Manager;
import model.entity.employee.Other;
import model.entity.employee.Worker;

public class SalaryRate implements SalaryRateGettable{

	@Override
	public Long getSalaryRate(EmployeesDB employeesDB, String lastName) {
		Manager manager = employeesDB.getManagerDAO().findByLastName(lastName);
		Worker worker = employeesDB.getWorkerDAO().findByLastName(lastName);
		Other other = employeesDB.getOtherDAO().findByLastName(lastName);
		
		Long singlePremium = 0L;
		
		if(manager != null) {
			singlePremium = manager.getSalaryRate();
		}
		
		if(worker != null) {
			singlePremium = worker.getSalaryRate();
		}
		
		if(other != null) {
			singlePremium = other.getSalaryRate();
		}
		
		return singlePremium;
	}
	
	
	
}
