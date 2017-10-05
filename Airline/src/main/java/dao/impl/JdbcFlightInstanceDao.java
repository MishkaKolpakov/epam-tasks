package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;

import dao.FlightInstanceDao;
import model.entity.FlightInstance;

public class JdbcFlightInstanceDao implements FlightInstanceDao {
	private static final Logger LOGGER = Logger.getLogger(JdbcFlightInstanceDao.class.getSimpleName());
	private Connection connection;

	public JdbcFlightInstanceDao(Connection connection) {
		this.connection = connection;
	}
	
	private static final String SELECT_WHERE_FROM_TO = "SELECT id, flight_from, flight_to, duration FROM flight_instance WHERE flight_from = ? AND flight_to = ?";
	
	@Override
	public Optional<FlightInstance> findFlightByDirection(String from, String to) {		
		Optional<FlightInstance> result = Optional.empty();
		FlightInstance flightInstance = null;
		ResultSet resultSet;
		try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_WHERE_FROM_TO)) {
			preparedStatement.setString(1, from);
			preparedStatement.setString(2, to);
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()){
				flightInstance = getFlightInstanceByResultSet(resultSet);				
			}
			
			if(flightInstance != null) {
				result = Optional.of(flightInstance);
			}
			LOGGER.info("Find flight instance by direction was called");
		} catch (SQLException e) {
			LOGGER.error("Caught exception in find by direction method");
			throw new RuntimeException(e);
		}
		return result;
	}

	@Override
	public List<FlightInstance> findAll() {
		return null;
	}

	@Override
	public boolean update(FlightInstance item) {
		return false;
	}

	@Override
	public boolean delete(Long id) {
		return false;
	}

	@Override
	public Optional<FlightInstance> findElementById(Long id) {
		return null;
	}

	@Override
	public long insert(FlightInstance item) {
		return 0;
	}

	@Override
	public void close() throws Exception {
		connection.close();
	}
	
	private FlightInstance getFlightInstanceByResultSet(ResultSet resultSet){
		LocalTime time;
		try {
			time = LocalTime.parse(resultSet.getString("duration"));
			FlightInstance flightInstance = new FlightInstance.Builder()
					.setId(resultSet.getLong("id"))
					.setFrom(resultSet.getString("flight_from"))
					.setTo(resultSet.getString("flight_to"))
					.setTime(time)
					.build();
			return flightInstance;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
