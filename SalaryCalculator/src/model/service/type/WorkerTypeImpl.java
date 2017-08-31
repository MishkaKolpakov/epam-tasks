package model.service.type;

import java.util.ArrayList;

import model.dao.EmployeeDB;
import model.entity.employee.Manager;
import model.entity.employee.Other;
import model.entity.employee.Worker;

public class WorkerTypeImpl implements WorkerTypeChangable{

	@Override
	public Manager workerToManager(Worker worker, EmployeeDB employeeDB) {
		Manager manager = new Manager(worker, new ArrayList<>());
		employeeDB.getManagers().add(manager);
		employeeDB.getWorkers().remove(worker);
		return manager;
	}

	@Override
	public Other workerToOther(Worker worker, EmployeeDB employeeDB) {
		Other other = new Other(worker, "");
		employeeDB.getOthers().add(other);
		employeeDB.getWorkers().remove(worker);
		return other;
	}

}
