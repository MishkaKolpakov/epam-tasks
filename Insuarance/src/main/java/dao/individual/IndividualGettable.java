package dao.individual;

import java.util.List;

import model.entity.responsibility.individual.IndividualResponsibility;

public interface IndividualGettable {
	// Getting individual responsibilities query
	String GET_ALL_INDIVIDUAL_RESPONSIBILITIES = "SELECT title, risk_level, price, health_state, personal_code FROM responsibility INNER JOIN individual ON responsibility.id = individual.responsibility_id; ";

	List<IndividualResponsibility> getAllIndividualResponsibilities();
}
