package dao.individual;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.ConnectorDB;
import model.entity.responsibility.individual.IndividualAbsractFactory;
import model.entity.responsibility.individual.IndividualResponsibility;
import model.entity.responsibility.individual.IndividualResponsibilityFactory;

public class IndividualDAO implements IndividualGettable {

	private List<IndividualResponsibility> individuals;

	/**
	 * Getting all individual responsibilities from database
	 * 
	 * @return List<IndividualResponsibility>
	 */
	public List<IndividualResponsibility> getAllIndividualResponsibilities() {
		individuals = new ArrayList<>();
		try (Connection connection = ConnectorDB.getConnection()) {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(GET_ALL_INDIVIDUAL_RESPONSIBILITIES);
			IndividualAbsractFactory individualAbsractFactory = new IndividualResponsibilityFactory();
			while (resultSet.next()) {
				IndividualResponsibility individualResponsibility = individualAbsractFactory
						.createIndividualResponsibility(resultSet);
				individuals.add(individualResponsibility);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return individuals;
	}

}
