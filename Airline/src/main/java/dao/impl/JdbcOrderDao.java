package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dao.OrderDao;
import model.entity.Order;

public class JdbcOrderDao implements OrderDao {
	
	private static final String SELECT_ORDER_ID = "SELECT id FROM orders WHERE client_id = ?";
	private static final String SELECT_WHERE_ORDERID_CLIENTID = "SELECT id FROM orders WHERE client_id = ? and ticket_id = ?";

	private Connection connection;

	public JdbcOrderDao(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Long> getOrderIdsByClientId(Long clientId) {
		List<Long> result = new ArrayList<>();

		try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDER_ID)) {
			preparedStatement.setLong(1, clientId);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				result.add(resultSet.getLong(1));
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return result;
	}

	@Override
	public Optional<Long> getOrderByIds(Long clientId, Long ticketId) {
		Long result = null;
		try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_WHERE_ORDERID_CLIENTID)) {
			preparedStatement.setLong(1, clientId);
			preparedStatement.setLong(2, ticketId);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				result = resultSet.getLong(1);
				return Optional.of(result);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}

	@Override
	public List<Order> findAll() {
		return null;
	}

	@Override
	public boolean update(Order item) {
		return false;
	}

	@Override
	public boolean delete(Long id) {
		return false;
	}

	@Override
	public Optional<Order> findElementById(Long id) {
		return null;
	}

	@Override
	public long insert(Order item) {
		return 0;
	}

	@Override
	public void close() throws Exception {
		connection.close();
	}
}
