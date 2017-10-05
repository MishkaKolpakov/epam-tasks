package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.AddressDAO;
import dao.ConnectorDB;
import entity.Address;

public class AddressService implements AddressDAO {

	Connection connection = ConnectorDB.getConnection();
	private static final String INSERT = "INSERT INTO Address VALUES(?, ?, ?, ?, ?)";

	@Override
	public void add(Address address) {
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(INSERT);
			preparedStatement.setLong(1, address.getId());
			preparedStatement.setString(2, address.getCountry());
			preparedStatement.setString(3, address.getCity());
			preparedStatement.setString(4, address.getStreet());
			preparedStatement.setString(5, address.getPostCode());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Address> getAll() throws SQLException {
		List<Address> addressList = new ArrayList<>();

		String sql = "select * from from address";

		Statement statement = null;

		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Address address = new Address();
				address.setId(resultSet.getLong("id"));
				address.setCountry(resultSet.getString("country"));
				address.setCity(resultSet.getString("city"));
				address.setStreet(resultSet.getString("street"));
				address.setPostCode(resultSet.getString("post_code"));

				addressList.add(address);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
		return null;
	}

	@Override
	public Address getById(Long id) {
		PreparedStatement preparedStatement = null;
		Address address = new Address();

		String sql = "select * from from address where id=?";

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				address.setId(resultSet.getLong("id"));
				address.setCountry(resultSet.getString("country"));
				address.setCity(resultSet.getString("city"));
				address.setStreet(resultSet.getString("street"));
				address.setPostCode(resultSet.getString("post_code"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void update(Address address) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(Address address) {
		// TODO Auto-generated method stub

	}

}
