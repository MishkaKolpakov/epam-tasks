package model.service.count;

import dao.EmployeesDB;


public interface EqualCountable {
	Long distributeEqual(Long rest, EmployeesDB database);
}
