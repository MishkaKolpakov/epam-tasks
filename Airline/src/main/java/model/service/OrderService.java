package model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dao.ClientDao;
import dao.DaoFactory;
import dao.TicketDao;
import model.entity.Order;
import model.entity.Ticket;

public class OrderService {
	private DaoFactory daoFactory;
	private ClientDao clientDao;
	private TicketDao ticketDao;

	public OrderService(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
		this.clientDao = this.daoFactory.createClientDao();
		this.ticketDao = this.daoFactory.createTicketDao();
	}

	private static class Holder {
		static final OrderService INSTANCE = new OrderService(DaoFactory.getInstance());
	}

	public static OrderService getInstance() {
		return Holder.INSTANCE;
	}

	public boolean orderTicket(Long clientId, Long ticketId, Integer orderPrice) {
		return clientDao.insertClientTicket(clientId, ticketId, orderPrice);
	}

	public boolean checkOrder(Long clientId, Long ticketId) {
		return !(ticketDao.getOrderByIds(clientId, ticketId).isPresent());
	}

	public Optional<Order> getClientOrder(Long clientId) {
		Order order = new Order();
		List<Long> ids = ticketDao.getOrderIdsByClientId(clientId);
		List<Ticket> tickets = new ArrayList<>();
		Ticket ticket = null;

		for (Long orderId : ids) {
			if (ticketDao.getTicketByOrderId(orderId).isPresent()) {
				ticket = ticketDao.getTicketByOrderId(orderId).get();
				tickets.add(ticket);
			}
		}
		order.setTickets(tickets);
		return Optional.of(order);
	}

	public boolean deleteFromOrder(Long clientId, Long ticketId) {
		return clientDao.deleteClientTicket(clientId, ticketId);
	}

}
