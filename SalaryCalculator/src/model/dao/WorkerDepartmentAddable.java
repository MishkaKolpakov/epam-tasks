package model.dao;

import java.util.List;

import model.entity.employee.Worker;

public interface WorkerDepartmentAddable {
	public List<Worker> getWorkersByDepartment(Department department);
}
