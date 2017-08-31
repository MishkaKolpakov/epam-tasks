package model.service.type;

import java.util.List;

import model.dao.EmployeeDB;
import model.entity.employee.Manager;
import model.entity.employee.Other;
import model.entity.employee.Worker;
import model.entity.employee.WorkerBuilder;

public class ManagerTypeImpl implements ManagerTypeChangable {

	@Override
	public Worker managerToWorker(Manager manager, EmployeeDB employeeDB) {
		Worker worker = new WorkerBuilder().setFirstName(manager.getFirstName()).setLastName(manager.getLastName())
				.setMiddleName(manager.getMiddleName()).setBirthdayDate(manager.getBirthdayDate())
				.setHireJobDate(manager.getHireJobDate()).buildWorker();

		List<Worker> workersLeft = manager.getWorkersToManage();

		employeeDB.getManagers().remove(manager);

		employeeDB.getManagers().get(employeeDB.getManagers().size() - 1).getWorkersToManage().addAll(workersLeft);

		employeeDB.getWorkers().add(worker);
		return worker;
	}

	@Override
	public Other managerToOther(Manager manager, EmployeeDB employeeDB) {
		Other other = new Other(manager.getWorker(), "");
		List<Worker> workersLeft = manager.getWorkersToManage();

		employeeDB.getManagers().remove(manager);

		employeeDB.getManagers().get(employeeDB.getManagers().size() - 1).getWorkersToManage().addAll(workersLeft);

		employeeDB.getOthers().add(other);
		return other;
	}

}
