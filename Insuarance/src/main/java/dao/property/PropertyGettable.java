package dao.property;

import java.util.List;

import model.entity.responsibility.property.PropertyResponsibility;

public interface PropertyGettable {
	// Getting property responsibilities query
	String GET_ALL_PROPERTY_RESPONSIBILITIES = "SELECT title, risk_level, price, property_state, compulsary FROM responsibility INNER JOIN property ON responsibility.id = property.responsibility_id; ";

	List<PropertyResponsibility> getAllPropertyResponsibilities();
}
