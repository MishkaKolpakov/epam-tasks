package dao.impl;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dao.TicketDao;
import model.entity.Flight;
import model.entity.FlightInstance;
import model.entity.Ticket;

public class JdbcTicketDao implements TicketDao {

	private final static String SELECT_FROM_WHERE_ID = "SELECT t.id, departure_date, places_amount, baggage_price, first_queue_price, ticket_price, "
			+ "flight_from, flight_to, duration " + "FROM flight f inner join ticket t on f.id = t.id "
			+ "left join flight_instance f_i on f.flight_instance_id = f_i.id " + "WHERE f.id = ?";

	private final static String SELECT_AMOUNT_FROM = "SELECT places_amount FROM flight WHERE id = ?";

	private final static String UPDATE_SET_AMOUNT = "UPDATE flight set places_amount = (SELECT places_amount-1 from "
			+ "(SELECT * from flight) as places where id = ?) WHERE id = ?";

	private static final String SELECT_ORDER = "SELECT ticket_id FROM orders where id = ?";

	private static final String SELECT_BAGGAGE_PRICE = "SELECT baggage_price FROM ticket where id = ?";
	private static final String SELECT_FIRST_QUEUE_PRICE = "SELECT first_queue_price FROM ticket where id = ?";
	private static final String SELECT_TICKET_PRICE = "SELECT ticket_price FROM ticket where id = ?";
	private static final String SELECT_ORDER_PRICE = "SELECT order_price FROM orders where id=?";
	private static final String SELECT_ORDER_ID = "SELECT id FROM orders WHERE client_id = ?";
	private static final String SELECT_WHERE_ORDERID_CLIENTID = "SELECT id FROM orders WHERE client_id = ? and ticket_id = ?";
	
	private static final String INSERT_INTO_TICKET = "INSERT INTO ticket(baggage_price, first_queue_price, ticket_price) VALUES(?,?,?)";
	private Connection connection;

	public JdbcTicketDao(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Ticket> findAll() {

		return null;
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
		try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_TICKET, Statement.RETURN_GENERATED_KEYS)) {
			
			preparedStatement.setInt(1, item.getBaggagePrice());
			preparedStatement.setInt(2, item.getFirstInQueuePrice());
			preparedStatement.setInt(3, item.getTicketPrice());
			
			preparedStatement.executeUpdate();
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			if(resultSet.next()){
				item.setId(resultSet.getLong(1));
			}
			
			return item.getId();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}	
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

		Flight flight = new Flight.Builder()
				.setDepartureDateTime(localDepartureDate)
				.setPlacesAmount(rs.getInt("places_amount"))
				.setFlightInstance(flightInstance)
				.build();

		Ticket ticket = new Ticket.Builder()
				.setId(rs.getLong("t.id"))
				.setTicketPrice(rs.getInt("ticket_price"))
				.setBaggagePrice(rs.getInt("baggage_price"))
				.setFirstInQueuePrice(rs.getInt("first_queue_price"))
				.setFlight(flight)
				.build();

		return Optional.of(ticket);
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
	public Optional<Ticket> getTicketByOrderId(Long orderId) {
		Ticket result = null;
		
		try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDER)) {
			preparedStatement.setLong(1, orderId);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				result = findElementById(resultSet.getLong(1)).get();
				result.setFinalPrice(getOrderPrice(orderId));
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return Optional.of(result);
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
	public Integer getOrderPrice(Long orderId) {
		Integer result = 0;

		try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDER_PRICE)) {
			preparedStatement.setLong(1, orderId);
			
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				result = resultSet.getInt("order_price");
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
	public List<Long> getOrderIdsByClientId(Long clientId) {
		List<Long> result = new ArrayList<>();

		try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDER_ID)) {
			preparedStatement.setLong(1, clientId);

			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
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
			if(resultSet.next()){
				result = resultSet.getLong(1);
				return Optional.of(result);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}
}
