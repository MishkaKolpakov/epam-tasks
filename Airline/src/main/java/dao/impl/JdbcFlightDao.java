package dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.apache.log4j.Logger;
import dao.FlightDao;
import model.entity.Flight;
import model.entity.FlightInstance;

public class JdbcFlightDao implements FlightDao {
	private static final Logger LOGGER = Logger.getLogger(JdbcFlightDao.class.getSimpleName());
	
	private String SELECT_FROM_FLIGHT = "SELECT flight.id, departure_date, flight_from, flight_to, duration, places_amount, flight_instance.id "
			+ "FROM flight LEFT JOIN flight_instance on flight.flight_instance_id = flight_instance.id";
	
	private String SELECT_FROM_FLIGHT_WHERE = "SELECT flight.id, departure_date, flight_from, flight_to, duration, places_amount, flight_instance.id FROM flight "
			+ "LEFT JOIN flight_instance on flight.flight_instance_id = flight_instance.id "
			+ "WHERE flight_from=? and flight_to=? and DATE(departure_date) = ?";
	
	private String SELECT_FROM_FLIGHT_WITHOUT_DATE = "SELECT flight.id, departure_date, flight_from, flight_to, duration, places_amount, flight_instance.id FROM flight "
			+ "LEFT JOIN flight_instance on flight.flight_instance_id = flight_instance.id "
			+ "WHERE flight_from=? and flight_to=?";
	
	private String DELETE_TICKET_FLIGHT = "DELETE f, t FROM flight f "
			+ "INNER JOIN ticket t ON f.id = t.id WHERE f.id = ?";
	
	private String INSERT_INTO_FLIGHT = "INSERT INTO flight(id, departure_date, flight_instance_id, places_amount) VALUES(?,?,?,?)";
	
	private Connection connection;

	public JdbcFlightDao(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Flight> findAll() {
		List<Flight> flights = new ArrayList<>();
		
		ResultSet resultSet;
		try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FROM_FLIGHT)) {
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Flight flight = getFlightByResultSet(resultSet);
				flights.add(flight);
			}
			LOGGER.info("Returned list of all flights");
		} catch (SQLException e) {
			LOGGER.error("Caught exception in find all flights method, flight dao");
			throw new RuntimeException(e);
		}

		return flights;

	}

	@Override
	public boolean update(Flight item) {
		
		return false;
	}

	@Override
	public boolean delete(Long id) {
		return false;
	}

	@Override
	public Optional<Flight> findElementById(Long id) {
		return null;
	}

	@Override
	public long insert(Flight item) {
	
		try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_FLIGHT)) {
			Timestamp timestamp = Timestamp.valueOf(item.getDepartureDateTime());
			preparedStatement.setLong(1, item.getId());
			preparedStatement.setTimestamp(2, timestamp);
			preparedStatement.setLong(3, item.getFlightInstance().getId());
			preparedStatement.setInt(4, item.getPlacesAmount());
			preparedStatement.executeUpdate();
			LOGGER.info("Inserted new flight");
			return item.getId();
		} catch (SQLException e) {
			LOGGER.error("Caught exception in insert flight method, flight dao");
			throw new RuntimeException(e);
		}	
	}

	@Override
	public void close() throws Exception {
		connection.close();
	}

	private Flight getFlightByResultSet(ResultSet rs) throws SQLException {
		Timestamp departureDate = rs.getTimestamp("departure_date");
		LocalDateTime localDepartureDate = departureDate.toLocalDateTime();
		Time time = rs.getTime("duration");
		LocalTime durationTime = time.toLocalTime();
		
		FlightInstance flightInstance = new FlightInstance.Builder()
											.setFrom(rs.getString("flight_from"))
											.setTo(rs.getString("flight_to"))
											.setTime(durationTime)
											.build();
		
		Flight flight = new Flight.Builder()
							.setId(rs.getLong("flight.id"))
							.setDepartureDateTime(localDepartureDate)
							.setPlacesAmount(rs.getInt("places_amount"))
							.setFlightInstance(flightInstance)
							.build();

		return flight;
	}

	@Override
	public Optional<List<Flight>> findFlight(String from, String to, LocalDate date) {
		List<Flight> flights = new ArrayList<>();
		ResultSet resultSet;
		
		try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FROM_FLIGHT_WHERE)) {
			preparedStatement.setString(1, from);
			preparedStatement.setString(2, to);
			preparedStatement.setTimestamp(3, Timestamp.valueOf(date.atTime(0, 0)));
			
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Flight flight = getFlightByResultSet(resultSet);
				flights.add(flight);
			}
			LOGGER.info("Find flight method including date was called");
		} catch (SQLException e) {
			LOGGER.error("Caught exception in find flight by direction and date method, flight dao");
			throw new RuntimeException(e);
		}
		return Optional.of(flights);
	}

	@Override
	public Optional<List<Flight>> findFlightWitoutDate(String from, String to) {
		List<Flight> flights = new ArrayList<>();
		ResultSet resultSet;
		
		try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FROM_FLIGHT_WITHOUT_DATE)) {
			preparedStatement.setString(1, from);
			preparedStatement.setString(2, to);
			
			
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Flight flight = getFlightByResultSet(resultSet);
				flights.add(flight);
			}
			LOGGER.info("Find flight method was called");
		} catch (SQLException e) {
			LOGGER.error("Caught exception in find flight by direction, flight dao");
			throw new RuntimeException(e);
		}
		return Optional.of(flights);
	}

	@Override
	public boolean deleteTicketById(Long ticketId) {
		try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_TICKET_FLIGHT)) {
			preparedStatement.setLong(1, ticketId);
			preparedStatement.executeUpdate();
			LOGGER.info("Delete ticket method was called");
			return true;
		} catch (SQLException e) {
			LOGGER.error("Caught exception in find delete ticket by id method, flight dao");
			throw new RuntimeException(e);
		}
	}
}

