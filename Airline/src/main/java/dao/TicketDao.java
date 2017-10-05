package dao;


import java.util.Optional;

import model.entity.Ticket;

public interface TicketDao extends GenericDao<Ticket>{
	
	public boolean updateAmount(Long id);
	public Integer findAmountById(Long id);
	public Integer getBaggagePriceById(Long ticketId);
	public Integer getFirstQueuePriceById(Long ticketId);
	public Integer getTicketPriceById(Long ticketId);
	public Optional<Ticket> getTicketByOrderId(Long orderId);
	public Integer getOrderPrice(Long orderId);
	public boolean updatePrice(Long ticketId);
	
}
