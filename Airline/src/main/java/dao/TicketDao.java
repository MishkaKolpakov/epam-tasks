package dao;


import java.util.Optional;

import model.entity.Ticket;

public interface TicketDao extends GenericDao<Ticket>{
	
	public Integer findAmountById(Long id);
	public Integer getBaggagePriceById(Long ticketId);
	public Integer getFirstQueuePriceById(Long ticketId);
	public Integer getTicketPriceById(Long ticketId);
	public Optional<Ticket> getTicketByOrderId(Long orderId);
	public boolean updatePrice(Long ticketId);
	
}
