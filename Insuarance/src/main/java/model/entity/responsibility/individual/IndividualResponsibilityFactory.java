package model.entity.responsibility.individual;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IndividualResponsibilityFactory implements IndividualAbsractFactory{

	public IndividualResponsibility createIndividualResponsibility(ResultSet resultSet) throws SQLException {
		IndividualResponsibility individualResponsibility = new IndividualResponsibilityBuilder()
				.setTitle(resultSet.getString("title"))
				.setRiskRate(resultSet.getInt("risk_level"))
				.setPrice(resultSet.getBigDecimal("price"))
				.setHealthState(resultSet.getString("health_state"))
				.setPersonalCode(resultSet.getString("personal_code"))
				.buildIndividualResponsibility();
		return individualResponsibility;
	}

}
