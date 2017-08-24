package dao.property;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.ConnectorDB;
import model.entity.responsibility.property.PropertyAbstractFactory;
import model.entity.responsibility.property.PropertyResponsibility;
import model.entity.responsibility.property.PropertyResponsibilityFactory;

public class PropertyDAO implements PropertyGettable {
	List<PropertyResponsibility> properties;

	/**
	 * Getting all individual responsibilities from database
	 * 
	 * @return List<IndividualResponsibility>
	 */
	@Override
	public List<PropertyResponsibility> getAllPropertyResponsibilities() {
		properties = new ArrayList<>();
		try (Connection connection = ConnectorDB.getConnection()) {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(GET_ALL_PROPERTY_RESPONSIBILITIES);
			PropertyAbstractFactory propertyAbstractFactory = new PropertyResponsibilityFactory();
			while (resultSet.next()) {
				PropertyResponsibility propertyResponsibility = propertyAbstractFactory
						.createPropertyResponsibility(resultSet);
				properties.add(propertyResponsibility);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return properties;
	}
}
