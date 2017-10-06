package dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import model.entity.Flight;

public interface FlightDao extends GenericDao<Flight>{
	Optional<List<Flight>> findFlight(String from, String to, LocalDate date);
	Optional<List<Flight>> findFlightWitoutDate(String from, String to);
	boolean deleteTicketById(Long ticketId);
	boolean updateAmount(Long id);
}
