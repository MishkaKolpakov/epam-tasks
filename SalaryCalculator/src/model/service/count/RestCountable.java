package model.service.count;

import java.util.List;

import model.entity.employee.Worker;

public interface RestCountable {
	Long countRest(Long budget, List<Worker> workers);
}
