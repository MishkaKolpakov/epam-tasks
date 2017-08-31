package model.service.count;

import java.util.List;

import model.entity.employee.Worker;

public class ProportionalStrategy implements RestStrategy {

	@Override
	public Long distributeRest(Long rest, Worker worker, List<Worker> workers) {
		Double coeficient = defineCoeficient(rest, workers);
		return (long) (coeficient * worker.getSalaryRate());
	}

	private Double defineCoeficient(Long rest, List<Worker> workers) {
		Long salarySum = 0L;
		for (Worker employee : workers) {
			salarySum += employee.getSalaryRate();
		}
		return Double.valueOf(rest / salarySum);
	}
}
