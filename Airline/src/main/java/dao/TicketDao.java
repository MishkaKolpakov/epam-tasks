package dao;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import model.entity.Ticket;

public interface TicketDao extends GenericDao<Ticket>{
	
	Integer findAmountById(Long id);
	Integer getBaggagePriceById(Long ticketId);
	Integer getFirstQueuePriceById(Long ticketId);
	Integer getTicketPriceById(Long ticketId);
	Optional<Ticket> getTicketByOrderId(Long orderId);
	boolean updatePrice(Long ticketId);
	Optional<List<Ticket>> findFlight(String from, String to, LocalDate date);
	Optional<List<Ticket>> findFlightWitoutDate(String from, String to);
	boolean deleteTicketById(Long ticketId);
	boolean updateAmount(Long id);

	
}
