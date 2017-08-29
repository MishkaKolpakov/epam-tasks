package model.service;

import dao.EmployeesDB;
import model.entity.employee.Position;

public interface ProportionalCountable {
	Long distributeProportional(Long rest, EmployeesDB database, Position position);
}
