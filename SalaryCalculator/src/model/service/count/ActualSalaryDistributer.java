package model.service.count;

import java.util.List;

import model.entity.employee.Worker;

public class ActualSalaryDistributer implements ActualSalaryDistributable {

	@Override
	public void distributeRest(Long budget, List<Worker> workers) {
		PremiumDefinable premiumDefiner = new PremiumDefiner();
		RestCountable restCounter = new RestCountImpl();
		RestStrategy restStrategy = new ProportionalStrategy();

		for (Worker worker : workers) {
			Long actualSalary = 0L;
			actualSalary = worker.getSalaryRate();
			actualSalary += premiumDefiner.definePremium(worker);
			actualSalary += restStrategy.distributeRest(restCounter.countRest(budget, workers), worker, workers);
			worker.setActualSalary(actualSalary);
		}
	}

}
