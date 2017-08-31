package model.service.type;

import model.dao.EmployeeDB;
import model.entity.employee.Manager;
import model.entity.employee.Other;
import model.entity.employee.Worker;

public interface WorkerTypeChangable {
	Manager workerToManager(Worker worker, EmployeeDB employeeDB);
	Other workerToOther(Worker worker, EmployeeDB employeeDB);
}
