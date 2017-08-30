package model.service.count;

import java.util.List;

import model.entity.employee.Worker;

public interface RestStrategy {
	Long distributeRest(Long rest, Worker worker, List<Worker> workers);
}
