package model.service.count;

import java.time.LocalDate;

import model.dao.ManagerDAO;
import model.dao.ManagerSearchable;
import model.entity.employee.Manager;
import model.entity.employee.Worker;
import model.entity.fund.PremiumConst;

public class PremiumDefiner implements PremiumDefinable{
	@Override
	public Long definePremium(Worker worker) {
		ManagerSearchable managerChecker = new ManagerDAO();
		Manager manager = managerChecker.findManager(worker);
		Long premium = 0L;

		if (worker.getBirthdayDate().getMonthValue() == LocalDate.now().getMonthValue()) {
			premium += PremiumConst.premiumForBirthday;
		}

		if (manager != null) {
			premium += (manager.getWorkersToManage().size() * PremiumConst.premiumForManager);
		}

		return premium;
	}
}
