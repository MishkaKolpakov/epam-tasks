package model.service;

import java.time.LocalDate;

import dao.EmployeesDB;
import model.entity.employee.Manager;
import model.entity.employee.Other;
import model.entity.employee.Worker;

public class CountPremium implements PremiumCountable{

	@Override
	public Long countPremium(EmployeesDB employeesDB, String lastName) {
		Manager manager = employeesDB.getManagerDAO().findByLastName(lastName);
		Worker worker = employeesDB.getWorkerDAO().findByLastName(lastName);
		Other other = employeesDB.getOtherDAO().findByLastName(lastName);
		
		Long singlePremium = 0L;
		
		if(manager != null) {
			singlePremium = manager.getWorkersToManage().size() * PremiumConst.premiumForManagers;
			if(manager.getEmployee().getBirthdayDate().getMonthValue() == LocalDate.now().getMonthValue())
				singlePremium += PremiumConst.premiumForBirthday;
		}
		
		if(worker != null) {
			if(worker.getEmployee().getBirthdayDate().getMonthValue() == LocalDate.now().getMonthValue())
				singlePremium += PremiumConst.premiumForBirthday;
		}
		
		if(other != null) {
			if(worker.getEmployee().getBirthdayDate().getMonthValue() == LocalDate.now().getMonthValue())
				singlePremium += PremiumConst.premiumForBirthday;
		}
		
		return singlePremium;
	}

}
