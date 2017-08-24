package model.entity.responsibility.property;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PropertyResponsibilityFactory implements PropertyAbstractFactory{

	public PropertyResponsibility createPropertyResponsibility(ResultSet resultSet) throws SQLException {
		PropertyResponsibility propertyResponsibility = new PropertyResponsibilityBuilder()
				.setTitle(resultSet.getString("title"))
				.setRiskRate(resultSet.getInt("risk_level"))
				.setPrice(resultSet.getBigDecimal("price"))
				.setPropertyState(resultSet.getString("property_state"))
				.setCompulsory(resultSet.getBoolean("compulsary"))
				.buildPropertyResponsibility();
				
		return propertyResponsibility;
	}

}
