package model.service.count;

import model.entity.employee.Worker;

public interface PremiumDefinable {
	Long definePremium(Worker worker);
}
