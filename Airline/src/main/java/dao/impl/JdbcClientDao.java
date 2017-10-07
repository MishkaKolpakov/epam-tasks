package dao.impl;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;

import dao.ClientDao;
import model.entity.Client;

public class JdbcClientDao implements ClientDao {
	private static final Logger LOGGER = Logger.getLogger(JdbcClientDao.class.getSimpleName());
	private Connection connection;
	private String INSERT_INTO_CLIENT = "INSERT INTO client(id, first_name, middle_name, last_name, passport_id) VALUES(?,?,?,?,?)";
	private String SELECT_FROM_CLIENT_WHERE_PASSPORTID = "SELECT * FROM client WHERE lower(passport_id) = ?";
	private String INSERT_INTO_CLIENT_ORDERS = "INSERT INTO orders(client_id, ticket_id, order_price) VALUES(?,?,?)";
	private String DELETE_FROM = "DELETE FROM orders WHERE client_id = ? and ticket_id = ?";
	
	public JdbcClientDao(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Client> findAll() {
		List<Client> clients = new ArrayList<>();
		String find = "SELECT id, first_name, middle_name, last_name, passport_id FROM client";
		ResultSet resultSet;
		try (PreparedStatement preparedStatement = connection.prepareStatement(find)) {
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Client client = new Client.Builder().addId(resultSet.getLong("id"))
						.addFirstName(resultSet.getString("first_name"))
						.addMiddleName(resultSet.getString("middle_name")).addLastName(resultSet.getString("last_name"))
						.addPassportId(resultSet.getString("passport_id")).build();
				clients.add(client);
				LOGGER.info("List of clients was returned");
			}

		} catch (SQLException e) {
			LOGGER.error("Caught exception in findAll clients method");
			throw new RuntimeException(e);
		}

		return clients;
	}

	@Override
	public boolean update(Client item) {

		return false;
	}

	@Override
	public boolean delete(Long id) {

		return false;
	}

	@Override
	public Optional<Client> findElementById(Long id) {

		return null;
	}

	@Override
	public long insert(Client item) {
		long result = -1L;
		try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_CLIENT)) {
			preparedStatement.setLong(1, item.getId());
			preparedStatement.setString(2, item.getFirstName());
			preparedStatement.setString(3, item.getMiddleName());
			preparedStatement.setString(4, item.getLastName());
			preparedStatement.setString(5, item.getPassportId());
			preparedStatement.executeUpdate();
			result = item.getId();
			LOGGER.info("Client was inserted");
		} catch (SQLException e) {
			LOGGER.error("Caught exception in insert client method");
			throw new RuntimeException(e);
		}

		return result;
	}

	@Override
	public void close() throws Exception {
		connection.close();
	}

	@Override
	public Optional<Client> findClientByPassportId(String passportId) {
		Optional<Client> result = null;

		try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FROM_CLIENT_WHERE_PASSPORTID)) {
			preparedStatement.setString(1, passportId.toLowerCase());
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				Client client = getClientByResultSet(resultSet);
				result = Optional.of(client);
				LOGGER.info("Client was found by passport id");
			} else {
				LOGGER.info("Client was not found by passport id");
				result = Optional.empty();
			}
		} catch (SQLException e) {
			LOGGER.error("Caught exception in findClientByPassportId method int client dao");
			throw new RuntimeException(e);
		}
		return result;
	}

	private Client getClientByResultSet(ResultSet rs) throws SQLException {
		Client client = new Client.Builder()
				.addFirstName(rs.getString("first_name"))
				.addMiddleName(rs.getString("middle_name"))
				.addLastName(rs.getString("middle_name"))
				.addPassportId(rs.getString("passport_id"))
				.build();
		
		return client;
	}

	
	@Override
	public boolean insertClientTicket(Long clientId, Long ticketId, Integer orderPrice) {
		try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_CLIENT_ORDERS)) {
			preparedStatement.setLong(1, clientId);
			preparedStatement.setLong(2, ticketId);
			preparedStatement.setInt(3, orderPrice);
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean deleteClientTicket(Long clientId, Long ticketId) {
		try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FROM)) {
			preparedStatement.setLong(1, clientId);
			preparedStatement.setLong(2, ticketId);
			preparedStatement.executeUpdate();
			LOGGER.info("Client ticket was deleted from orders");
		} catch (SQLException e) {
			LOGGER.error("Caught exception in delete clientTicket method in client dao");
			throw new RuntimeException(e);
		}
		return false;
	}

	

}
