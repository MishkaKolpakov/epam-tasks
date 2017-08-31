package model.service.type;

import model.dao.EmployeeDB;
import model.entity.employee.Manager;
import model.entity.employee.Other;
import model.entity.employee.Worker;

public interface ManagerTypeChangable {
	Worker managerToWorker(Manager manager, EmployeeDB employeeDB);

	Other managerToOther(Manager manager, EmployeeDB employeeDB);
}
