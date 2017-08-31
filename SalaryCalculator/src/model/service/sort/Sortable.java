package model.service.sort;

import java.util.List;

import model.entity.employee.Worker;

public interface Sortable {
	List<Worker> sort(List<Worker> workers);
}
