package dao.impl;

import dao.ClientDao;

import dao.DaoFactory;
import dao.FlightDao;
import dao.FlightInstanceDao;
import dao.OrderDao;
import dao.TicketDao;
import dao.UserDao;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.sql.DataSource;

import config.ContextConfiguration;

public class JdbcDaoFactory extends DaoFactory {

	Connection getConnection() {
		Connection connection = null;
		DataSource dataSource = null;
		try {
			dataSource = ContextConfiguration.getDataSource();
			connection = dataSource.getConnection();
		} catch (SQLException | NamingException e) {
			throw new RuntimeException(e);
		}
		return connection;
	}

	@Override
	public ClientDao createClientDao() {
		return new JdbcClientDao(getConnection());
	}

	@Override
	public UserDao createUserDao() {
		return new JdbcUserDao(getConnection());
	}

	@Override
	public FlightDao createFlightDao() {
		return new JdbcFlightDao(getConnection());
	}

	@Override
	public TicketDao createTicketDao() {
		return new JdbcTicketDao(getConnection());
	}

	@Override
	public FlightInstanceDao createFlightInstanceDao() {
		return new JdbcFlightInstanceDao(getConnection());
	}

	@Override
	public OrderDao createOrderDao() {
		return new JdbcOrderDao(getConnection());
	}
}
