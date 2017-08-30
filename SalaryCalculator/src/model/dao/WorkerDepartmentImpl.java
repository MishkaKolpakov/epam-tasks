package model.dao;

import java.util.ArrayList;
import java.util.List;

import model.entity.employee.Worker;

public class WorkerDepartmentImpl implements WorkerDepartmentAddable {

	private ArrayList<Worker> workers;
	private WorkerSearchable workerFinder = new WorkerDAO();

	@Override
	public List<Worker> getWorkersByDepartment(Department department) {
		switch (department.toString()) {
		case "FINANCE":
			workers = new ArrayList<>();
			workers.add(workerFinder.findWorkerByLastName("Kolpakov"));
			workers.add(workerFinder.findWorkerByLastName("Stepanenko"));
			return workers;
		case "IT":
			workers = new ArrayList<>();
			workers.add(workerFinder.findWorkerByLastName("Hvalko"));
			workers.add(workerFinder.findWorkerByLastName("Ivanov"));
			return workers;
		case "SUPPORT":
			workers = new ArrayList<>();
			workers.add(workerFinder.findWorkerByLastName("Vasilenko"));
			return workers;
		default:
			throw new RuntimeException("No such a department");
		}
	}

}
