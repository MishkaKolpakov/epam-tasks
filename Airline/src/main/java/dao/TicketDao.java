package dao;

import java.util.List;

import java.util.Optional;
import model.entity.Ticket;

public interface TicketDao extends GenericDao<Ticket>{
	public boolean updateAmount(Long id);
	public Integer findAmountById(Long id);
	public Optional<Ticket> getTicketByOrderId(Long orderId);
	public Integer getBaggagePriceById(Long ticketId);
	public Integer getFirstQueuePriceById(Long ticketId);
	public Integer getTicketPriceById(Long ticketId);
	public Integer getOrderPrice(Long orderId);
	public List<Long> getOrderIdsByClientId(Long clientId);
	public Optional<Long> getOrderByIds(Long clientId, Long ticketId);
}
