package model.service;

import dao.EmployeesDB;
import model.entity.employee.Position;

public class ProportionalStrategy implements ProportionalCountable{

	@Override
	public Long distributeProportional(Long rest, EmployeesDB database, Position position) {
		Long restForSingleEmployee = rest;
		return restForSingleEmployee;
	}



}
