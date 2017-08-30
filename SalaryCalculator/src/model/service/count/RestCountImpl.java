package model.service.count;

import java.util.List;

import model.entity.employee.Worker;

public class RestCountImpl implements RestCountable {

	@Override
	public Long countRest(Long budget, List<Worker> workers) {
		Long salaryRatePremiumSum = 0L;
		PremiumDefinable premiumDefiner = new PremiumDefiner();
		for (Worker worker : workers) {
			salaryRatePremiumSum += worker.getSalaryRate() + premiumDefiner.definePremium(worker);
		}

		if (budget < salaryRatePremiumSum) {
			budget = salaryRatePremiumSum;
			return 0L;
		} else {
			return budget - salaryRatePremiumSum;
		}

	}

}
