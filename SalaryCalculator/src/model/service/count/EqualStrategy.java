package model.service.count;

import java.util.List;

import model.entity.employee.Worker;

public class EqualStrategy implements RestStrategy {
	@Override
	public Long distributeRest(Long rest, Worker worker, List<Worker> workers) {
		return rest / workers.size();
	}

}
