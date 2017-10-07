package model.service.impl;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import dao.ClientDao;
import dao.DaoFactory;
import dao.OrderDao;
import dao.TicketDao;
import model.entity.Order;
import model.entity.Ticket;
import model.service.Orderable;

public class OrderService implements Orderable {
	private DaoFactory daoFactory;
	private ClientDao clientDao;
	private TicketDao ticketDao;
	private OrderDao orderDao;

	public OrderService(){
		this.daoFactory = DaoFactory.getInstance();
		this.clientDao = daoFactory.createClientDao();
		this.ticketDao = daoFactory.createTicketDao();
		this.orderDao =  daoFactory.createOrderDao();
	}
	
	public OrderService(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
		this.clientDao = daoFactory.createClientDao();
		this.ticketDao = daoFactory.createTicketDao();
		this.orderDao = daoFactory.createOrderDao();
	}

	private static class Holder {
		static final OrderService INSTANCE = new OrderService();
	}

	public static OrderService getInstance() {
		return Holder.INSTANCE;
	}

	@Override
	public boolean orderTicket(Long clientId, Long ticketId, Integer orderPrice) {
		return clientDao.insertClientTicket(clientId, ticketId, orderPrice);
	}

	public boolean checkOrder(Long clientId, Long ticketId) {
		return !(orderDao.getOrderByIds(clientId, ticketId).isPresent());
	}

	public Optional<List<Order>> getClientOrder(Long clientId) {
		List<Long> ids = orderDao.getOrderIdsByClientId(clientId);
		List<Order> orders = new ArrayList<>();
		Ticket ticket = null;
		Integer orderPrice = null;
		
		for (Long orderId : ids) {
			if (ticketDao.getTicketByOrderId(orderId).isPresent()) {
				ticket = ticketDao.getTicketByOrderId(orderId).get();
				orderPrice = orderDao.getOrderPrice(orderId);
				Order order = createOrder(ticket, orderPrice);
				orders.add(order);
			}
		}
		return Optional.of(orders);
	}

	public boolean deleteFromOrder(Long clientId, Long ticketId) {
		return clientDao.deleteClientTicket(clientId, ticketId);
	}
	
	private Order createOrder(Ticket ticket, Integer orderPrice){
		return new Order.Builder()
				.addTicket(ticket)
				.addOrderPrice(orderPrice)
				.build();
	}

}
