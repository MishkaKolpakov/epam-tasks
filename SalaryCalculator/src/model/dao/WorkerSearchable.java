package model.dao;

import model.entity.employee.Worker;

public interface WorkerSearchable {
	Worker findWorkerByLastName(String lastName);
}
