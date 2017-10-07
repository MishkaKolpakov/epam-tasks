package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;

import dao.TicketDao;
import model.entity.FlightInstance;
import model.entity.Ticket;

public class JdbcTicketDao implements TicketDao {
	private static final Logger LOGGER = Logger.getLogger(JdbcFlightInstanceDao.class.getSimpleName());
	private final static String SELECT_FROM_WHERE_ID = "SELECT ticket.id, departure_date, places_amount, baggage_price, first_queue_price, ticket_price, "
			+ "flight_from, flight_to, duration " + "FROM ticket "
			+ "left join flight_instance f_i on ticket.flight_instance_id = f_i.id " + "WHERE ticket.id = ?";

	private final static String UPDATE_SET_PRICE = "UPDATE ticket set ticket_price = (SELECT (ticket_price + (ticket_price * 0.2)) from "
			+ "(SELECT * from ticket) as tickets where id = ?) WHERE id = ?";

	private final static String SELECT_AMOUNT_FROM = "SELECT places_amount FROM ticket WHERE id = ?";
	private static final String SELECT_BAGGAGE_PRICE = "SELECT baggage_price FROM ticket where id = ?";
	private static final String SELECT_FIRST_QUEUE_PRICE = "SELECT first_queue_price FROM ticket where id = ?";
	private static final String SELECT_TICKET_PRICE = "SELECT ticket_price FROM ticket where id = ?";
	private static final String INSERT_INTO_TICKET = "INSERT INTO ticket(baggage_price, first_queue_price, ticket_price, departure_date, flight_instance_id, places_amount) VALUES(?,?,?,?,?,?)";
	private static final String SELECT_ORDER = "SELECT ticket_id FROM orders where id = ?";

	private static final String SELECT_FROM_TICKET = "SELECT * FROM ticket LEFT JOIN flight_instance on ticket.flight_instance_id = flight_instance.id where places_amount > 0";

	private static final String SELECT_FROM_FLIGHT_WHERE = "SELECT ticket.id, departure_date, flight_from, flight_to, duration, places_amount, flight_instance.id FROM ticket "
			+ "LEFT JOIN flight_instance on ticket.flight_instance_id = flight_instance.id "
			+ "WHERE flight_from=? and flight_to=? and DATE(departure_date) = ?";

	private static final String SELECT_FROM_FLIGHT_WITHOUT_DATE = "SELECT ticket.id, departure_date, flight_from, flight_to, duration, places_amount, flight_instance.id FROM ticket "
			+ "LEFT JOIN flight_instance on ticket.flight_instance_id = flight_instance.id "
			+ "WHERE flight_from=? and flight_to=?";

	private static final String DELETE_TICKET_FLIGHT = "DELETE FROM ticket where ticket.id = ? and ticket.places_amount = 0";

	private static final String UPDATE_SET_AMOUNT = "UPDATE ticket set places_amount = (SELECT places_amount-1 from "
			+ "(SELECT * from ticket) as places where id = ?) WHERE id = ?";

	private Connection connection;

	public JdbcTicketDao(Connection connection) {
		this.connection = connection;
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

	@Override
	public boolean updateAmount(Long id) {
		try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SET_AMOUNT)) {
			preparedStatement.setLong(1, id);
			preparedStatement.setLong(2, id);
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Optional<List<Ticket>> findFlight(String from, String to, LocalDate date) {
		List<Ticket> tickets = new ArrayList<>();
		ResultSet resultSet;

		try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FROM_FLIGHT_WHERE)) {
			preparedStatement.setString(1, from);
			preparedStatement.setString(2, to);
			preparedStatement.setTimestamp(3, Timestamp.valueOf(date.atTime(0, 0)));

			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Ticket ticket = getTicketByResultSet(resultSet).get();
				tickets.add(ticket);
			}
			LOGGER.info("Find flight method including date was called");
		} catch (SQLException e) {
			LOGGER.error("Caught exception in find flight by direction and date method, flight dao");
			throw new RuntimeException(e);
		}
		return Optional.of(tickets);
	}

	@Override
	public Optional<List<Ticket>> findFlightWitoutDate(String from, String to) {
		List<Ticket> tickets = new ArrayList<>();
		ResultSet resultSet;

		try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FROM_FLIGHT_WITHOUT_DATE)) {
			preparedStatement.setString(1, from);
			preparedStatement.setString(2, to);

			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Ticket ticket = getFlightByResultSet(resultSet).get();
				tickets.add(ticket);
			}
			LOGGER.info("Find flight method was called");
		} catch (SQLException e) {
			LOGGER.error("Caught exception in find flight by direction, flight dao");
			throw new RuntimeException(e);
		}
		return Optional.of(tickets);
	}

	private Optional<Ticket> getFlightByResultSet(ResultSet rs) throws SQLException {
		Timestamp departureDate = rs.getTimestamp("departure_date");
		LocalDateTime localDepartureDate = departureDate.toLocalDateTime();
		Time time = rs.getTime("duration");
		LocalTime durationTime = time.toLocalTime();

		FlightInstance flightInstance = new FlightInstance.Builder()
				.setFrom(rs.getString("flight_from"))
				.setTo(rs.getString("flight_to"))
				.setTime(durationTime)
				.build();

		Ticket ticket = new Ticket.Builder().setId(rs.getLong(1))
				.setDepartureDateTime(localDepartureDate)
				.setPlacesAmount(rs.getInt("places_amount"))
				.setFlightInstance(flightInstance)
				.build();

		return Optional.of(ticket);
	}

	@Override
	public List<Ticket> findAll() {
		List<Ticket> tickets = new ArrayList<>();
		ResultSet resultSet;
		try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FROM_TICKET)) {
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Ticket ticket = getTicketByResultSet(resultSet).get();
				tickets.add(ticket);
				LOGGER.info("List of tickets was returned");
			}
			return tickets;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean update(Ticket item) {
		return false;
	}

	@Override
	public boolean delete(Long id) {
		return false;
	}

	@Override
	public Optional<Ticket> findElementById(Long id) {
		Optional<Ticket> result = Optional.empty();
		try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FROM_WHERE_ID)) {

			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				result = getTicketByResultSet(resultSet);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return result;
	}

	@Override
	public long insert(Ticket item) {
		try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_TICKET,
				Statement.RETURN_GENERATED_KEYS)) {
			Timestamp timestamp = Timestamp.valueOf(item.getDepartureDateTime());
			preparedStatement.setInt(1, item.getBaggagePrice());
			preparedStatement.setInt(2, item.getFirstInQueuePrice());
			preparedStatement.setInt(3, item.getTicketPrice());
			preparedStatement.setTimestamp(4, timestamp);
			preparedStatement.setLong(5, item.getFlightInstance().getId());
			preparedStatement.setInt(6, item.getPlacesAmount());

			preparedStatement.executeUpdate();
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next()) {
				item.setId(resultSet.getLong(1));
			}

			return item.getId();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Optional<Ticket> getTicketByOrderId(Long orderId) {
		Ticket result = null;

		try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDER)) {
			preparedStatement.setLong(1, orderId);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				result = findElementById(resultSet.getLong(1)).get();
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return Optional.of(result);
	}

	@Override
	public void close() throws Exception {
		connection.close();
	}

	private Optional<Ticket> getTicketByResultSet(ResultSet rs) throws SQLException {

		Timestamp departureDate = rs.getTimestamp("departure_date");
		LocalDateTime localDepartureDate = departureDate.toLocalDateTime();
		Time time = rs.getTime("duration");
		LocalTime durationTime = time.toLocalTime();

		FlightInstance flightInstance = new FlightInstance.Builder()
				.setFrom(rs.getString("flight_from"))
				.setTo(rs.getString("flight_to"))
				.setTime(durationTime)
				.build();

		Ticket ticket = new Ticket.Builder().setId(rs.getLong(1))
				.setDepartureDateTime(localDepartureDate)
				.setPlacesAmount(rs.getInt("places_amount"))
				.setFlightInstance(flightInstance)
				.setTicketPrice(rs.getInt("ticket_price"))
				.setBaggagePrice(rs.getInt("baggage_price"))
				.setFirstInQueuePrice(rs.getInt("first_queue_price"))
				.build();

		return Optional.of(ticket);
	}

	@Override
	public Integer findAmountById(Long orderId) {

		Integer result = -1;
		try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_AMOUNT_FROM)) {

			preparedStatement.setLong(1, orderId);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				result = resultSet.getInt("places_amount");
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return result;
	}

	@Override
	public Integer getBaggagePriceById(Long ticketId) {
		Integer result = 0;

		try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BAGGAGE_PRICE)) {
			preparedStatement.setLong(1, ticketId);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				result = resultSet.getInt(1);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return result;
	}

	@Override
	public Integer getFirstQueuePriceById(Long ticketId) {
		Integer result = 0;

		try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FIRST_QUEUE_PRICE)) {
			preparedStatement.setLong(1, ticketId);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				result = resultSet.getInt(1);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return result;
	}

	@Override
	public Integer getTicketPriceById(Long ticketId) {
		Integer result = 0;

		try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TICKET_PRICE)) {
			preparedStatement.setLong(1, ticketId);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				result = resultSet.getInt(1);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return result;
	}
	
	@Override
	public boolean updatePrice(Long ticketId) {
		try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SET_PRICE)) {
			preparedStatement.setLong(1, ticketId);
			preparedStatement.setLong(2, ticketId);
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
