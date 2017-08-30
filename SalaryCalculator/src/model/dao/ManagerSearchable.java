package model.dao;

import model.entity.employee.Manager;
import model.entity.employee.Worker;

public interface ManagerSearchable {
	Manager findManager(Worker worker);
}
