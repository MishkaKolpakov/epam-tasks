package model.services;

import dao.ClientDao;
import dao.DaoFactory;
import dao.OrderDao;
import dao.TicketDao;
import model.entity.Client;
import model.entity.Order;
import model.entity.Ticket;
import model.service.OrderService;
import static org.mockito.Mockito.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import static org.junit.Assert.*;

public class OrderServiceTest {

	private DaoFactory daoFactory;
	private ClientDao clientDao;
	private TicketDao ticketDao;
	private OrderDao orderDao;
	private OrderService orderService;

	@Test
	public void testSuccessOrderTicket() {
		daoFactory = mock(DaoFactory.class);
		clientDao = mock(ClientDao.class);
		ticketDao = mock(TicketDao.class);
		orderDao = mock(OrderDao.class);

		when(daoFactory.createClientDao()).thenReturn(clientDao);
		when(daoFactory.createTicketDao()).thenReturn(ticketDao);
		when(daoFactory.createOrderDao()).thenReturn(orderDao);

		orderService = new OrderService(daoFactory);

		when(clientDao.insertClientTicket(anyLong(), anyLong(), anyInt())).thenReturn(true);

		assertTrue(orderService.orderTicket(1L, 1L, 1));

		verify(daoFactory).createClientDao();
		verify(daoFactory).createTicketDao();
		verify(clientDao).insertClientTicket(anyLong(), anyLong(), anyInt());
	}

	@Test
	public void testIncorrectOrderTicket() {
		daoFactory = mock(DaoFactory.class);
		clientDao = mock(ClientDao.class);
		ticketDao = mock(TicketDao.class);
		orderDao = mock(OrderDao.class);

		when(daoFactory.createClientDao()).thenReturn(clientDao);
		when(daoFactory.createTicketDao()).thenReturn(ticketDao);
		when(daoFactory.createOrderDao()).thenReturn(orderDao);

		orderService = new OrderService(daoFactory);

		when(clientDao.insertClientTicket(anyLong(), anyLong(), anyInt())).thenReturn(false);

		assertFalse(orderService.orderTicket(1L, 1L, 1));

		verify(daoFactory).createClientDao();
		verify(daoFactory).createTicketDao();
		verify(clientDao).insertClientTicket(anyLong(), anyLong(), anyInt());
	}

	@Test
	public void testCheckOrderIsPresent() {
		daoFactory = mock(DaoFactory.class);
		clientDao = mock(ClientDao.class);
		ticketDao = mock(TicketDao.class);
		orderDao = mock(OrderDao.class);

		when(daoFactory.createClientDao()).thenReturn(clientDao);
		when(daoFactory.createTicketDao()).thenReturn(ticketDao);
		when(daoFactory.createOrderDao()).thenReturn(orderDao);
		orderService = new OrderService(daoFactory);

		Long ids = 1L;
		when(orderDao.getOrderByIds(anyLong(), anyLong())).thenReturn(Optional.of(ids));

		assertFalse(orderService.checkOrder(1L, 1L));

		verify(daoFactory).createClientDao();
		verify(daoFactory).createTicketDao();
		verify(orderDao).getOrderByIds(anyLong(), anyLong());
	}

	@Test
	public void testCheckOrderIsEmpty() {
		daoFactory = mock(DaoFactory.class);
		clientDao = mock(ClientDao.class);
		ticketDao = mock(TicketDao.class);
		orderDao = mock(OrderDao.class);

		when(daoFactory.createClientDao()).thenReturn(clientDao);
		when(daoFactory.createTicketDao()).thenReturn(ticketDao);
		when(daoFactory.createOrderDao()).thenReturn(orderDao);
		orderService = new OrderService(daoFactory);

		when(orderDao.getOrderByIds(anyLong(), anyLong())).thenReturn(Optional.empty());

		assertTrue(orderService.checkOrder(1L, 1L));

		verify(daoFactory).createClientDao();
		verify(daoFactory).createTicketDao();
		verify(orderDao).getOrderByIds(anyLong(), anyLong());
	}
	
	public void testDeleteFromOrderSuccess(){
		daoFactory = mock(DaoFactory.class);
		clientDao = mock(ClientDao.class);
		ticketDao = mock(TicketDao.class);
		orderDao = mock(OrderDao.class);

		when(daoFactory.createClientDao()).thenReturn(clientDao);
		when(daoFactory.createTicketDao()).thenReturn(ticketDao);
		when(daoFactory.createOrderDao()).thenReturn(orderDao);
		orderService = new OrderService(daoFactory);

		when(clientDao.deleteClientTicket(anyLong(), anyLong())).thenReturn(true);

		assertTrue(orderService.deleteFromOrder(1L, 1L));

		verify(daoFactory).createClientDao();
		verify(daoFactory).createTicketDao();
		verify(clientDao.deleteClientTicket(anyLong(), anyLong()));
	}
	
	public void testDeleteFromOrderFail(){
		daoFactory = mock(DaoFactory.class);
		clientDao = mock(ClientDao.class);
		ticketDao = mock(TicketDao.class);
		orderDao = mock(OrderDao.class);

		when(daoFactory.createClientDao()).thenReturn(clientDao);
		when(daoFactory.createTicketDao()).thenReturn(ticketDao);
		when(daoFactory.createOrderDao()).thenReturn(orderDao);
		orderService = new OrderService(daoFactory);

		when(clientDao.deleteClientTicket(anyLong(), anyLong())).thenReturn(false);

		assertFalse(orderService.deleteFromOrder(1L, 1L));

		verify(daoFactory).createClientDao();
		verify(daoFactory).createTicketDao();
		verify(clientDao.deleteClientTicket(anyLong(), anyLong()));
	}
	
	public void testGetClientOrder(){
		daoFactory = mock(DaoFactory.class);
		clientDao = mock(ClientDao.class);
		ticketDao = mock(TicketDao.class);
		orderDao = mock(OrderDao.class);

		when(daoFactory.createClientDao()).thenReturn(clientDao);
		when(daoFactory.createTicketDao()).thenReturn(ticketDao);
		when(daoFactory.createOrderDao()).thenReturn(orderDao);
		orderService = new OrderService(daoFactory);

		Ticket ticket = new Ticket.Builder()
							.setId(1L)
							.build();
				
		List<Long> ids = Arrays.asList(new Long[]{
			new Long(1L),
		});
		
		Order expected = new Order();
		expected.setClient(new Client.Builder().addId(1L).build());
		expected.setTickets(Arrays.asList(new Ticket[]{
				ticket
		}));
		
		when(orderDao.getOrderIdsByClientId(anyLong())).thenReturn(ids);
		when(ticketDao.getTicketByOrderId(anyLong())).thenReturn(Optional.of(ticket));		
		
		Optional<Order> actual = orderService.getClientOrder(1L);

		assertEquals(expected, actual);
		
		verify(daoFactory).createClientDao();
		verify(daoFactory).createTicketDao();
		verify(orderDao.getOrderIdsByClientId(anyLong()));
		verify(ticketDao.getTicketByOrderId(anyLong()));
	}
	
	public void testGetClientOrderEmpty(){
		daoFactory = mock(DaoFactory.class);
		clientDao = mock(ClientDao.class);
		ticketDao = mock(TicketDao.class);
		orderDao = mock(OrderDao.class);

		when(daoFactory.createClientDao()).thenReturn(clientDao);
		when(daoFactory.createTicketDao()).thenReturn(ticketDao);
		when(daoFactory.createOrderDao()).thenReturn(orderDao);
		orderService = new OrderService(daoFactory);
				
		List<Long> ids = Arrays.asList(new Long[]{});
		
		Order expected = new Order();
		expected.setClient(new Client.Builder().addId(1L).build());
		expected.setTickets(Arrays.asList(new Ticket[]{}));
		
		when(orderDao.getOrderIdsByClientId(anyLong())).thenReturn(ids);
		when(ticketDao.getTicketByOrderId(anyLong())).thenReturn(Optional.of(null));		
		
		Optional<Order> actual = orderService.getClientOrder(1L);

		assertEquals(expected, actual);
		
		verify(daoFactory).createClientDao();
		verify(daoFactory).createTicketDao();
		verify(orderDao.getOrderIdsByClientId(anyLong()));
		verify(ticketDao.getTicketByOrderId(anyLong()));
	}
}
