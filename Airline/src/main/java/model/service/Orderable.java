package model.service;

public interface Orderable {
	boolean orderTicket(Long clientId, Long ticketId, Integer orderPrice);
	boolean checkOrder(Long clientId, Long ticketId);
}
