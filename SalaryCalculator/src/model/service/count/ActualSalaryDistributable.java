package model.service.count;

import java.util.List;

import model.entity.employee.Worker;

public interface ActualSalaryDistributable {
	void distributeRest(Long rest, List<Worker> workers);
}
