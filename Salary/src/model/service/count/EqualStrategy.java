package model.service.count;

import dao.EmployeesDB;

public class EqualStrategy implements EqualCountable {

	@Override
	public Long distributeEqual(Long rest, EmployeesDB database) {
		Long restForSingle = rest / (database.getManagerDAO().getManagers().size()
				+ database.getOtherDAO().getOthers().size() 
				+ database.getWorkerDAO().getWorkers().size());

		return restForSingle;
	}

}
