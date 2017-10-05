package dao.impl;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;

import dao.UserDao;
import model.entity.Client;
import model.entity.User;
import model.entity.User.Role;

public class JdbcUserDao implements UserDao {
	private static final Logger LOGGER = Logger.getLogger(JdbcUserDao.class.getSimpleName());
	
	private Connection connection;
	private String SELECT_FROM_USER = "SELECT * FROM user";
	private String DELETE_FROM_USER = "DELETE FROM user WHERE id = ?";
	private String INSERT_INTO_USER = "INSERT INTO user( email, password) VALUES(?, ?)";
	private String SELECT_FROM_USER_WHERE_EMAIL = "SELECT * FROM user WHERE lower(email) = ?";
	private String SELECT_FROM_CLIENT = "SELECT * FROM client INNER JOIN user ON user.id = client.id WHERE client.id = ?";

	public JdbcUserDao(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<User> findAll() {
		List<User> users = new ArrayList<>();

		ResultSet resultSet;
		try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FROM_USER)) {
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				User user = getUserByResultSet(resultSet);
				users.add(user);
			}
			LOGGER.info("Method find all returned list of users");
		} catch (SQLException e) {
			LOGGER.error("Caught exception in find all method");
			throw new RuntimeException(e);
		}

		return users;
	}

	@Override
	public boolean update(User item) {

		return false;
	}

	@Override
	public boolean delete(Long id) {
		try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FROM_USER)) {
			preparedStatement.setLong(1, id);
			preparedStatement.executeUpdate();
			LOGGER.info("Method delete user by id was called");
			return true;
		} catch (SQLException e) {
			LOGGER.error("Caught exception in delete user by id method");
			throw new RuntimeException(e);
		}
	}

	@Override
	public Optional<User> findElementById(Long id) {

		return null;
	}

	@Override
	public long insert(User item) {
		long result = -1L;
		try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_USER, Statement.RETURN_GENERATED_KEYS)) {
			preparedStatement.setString(1, item.getEmail());
			preparedStatement.setString(2, item.getPassword());
			preparedStatement.executeUpdate();
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			if(resultSet.next()){
				result = resultSet.getLong(1);
				item.setId(result);
			}
			LOGGER.info("Insert user method was called");
		} catch (SQLException e) {
			LOGGER.error("Caught exception in insert user method");
			throw new RuntimeException(e);
		}
		return result;
	}

	@Override
	public Optional<User> getUserByEmail(String email) {
		
		Optional<User> result = null;
		try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FROM_USER_WHERE_EMAIL)) {
			preparedStatement.setString(1, email.toLowerCase());

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				User user = getUserByResultSet(resultSet);
				result = Optional.of(user);
			} else {
				result = Optional.empty();
			}
			LOGGER.info("Get user by email method was called");
		} catch (SQLException e) {
			LOGGER.error("Caught exception in get user by email method");
			throw new RuntimeException(e);
		}
		return result;
	}

	private User getUserByResultSet(ResultSet rs) throws SQLException {
		User user = new User.Builder()
				.setId(rs.getLong("id"))
				.setEmail(rs.getString("email"))
				.setPassword(rs.getString("password"))
				.setRole(Role.valueOf(rs.getString("role")))
				.build();
		
		return user;
	}
	
	private Client getClientByResultSet(ResultSet rs) throws SQLException {
		Client client = new Client.Builder()
				.addFirstName(rs.getString("first_name"))
				.addMiddleName(rs.getString("middle_name"))
				.addLastName(rs.getString("last_name"))
				.addPassportId(rs.getString("passport_id"))
				.build();

		return client;
	}

	@Override
	public void close() throws Exception {
		connection.close();
	}

	@Override
	public Optional<Client> getClientByUserId(Long id) {
		Optional<Client> result = null;

		try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FROM_CLIENT)) {
			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Client client = getClientByResultSet(resultSet);
				result = Optional.of(client);
			} else {
				result = Optional.empty();
			}
			LOGGER.info("Get user by client id method was called");
		} catch (SQLException e) {
			LOGGER.error("Caught exception in getUserByClientId method");
			throw new RuntimeException(e);
		}
		return result;
	}
}
