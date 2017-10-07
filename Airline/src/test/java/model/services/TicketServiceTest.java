package model.services;

import dao.DaoFactory;
import dao.TicketDao;
import model.entity.Ticket;
import model.service.impl.TicketService;

import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.Test;

import static org.junit.Assert.*;

public class TicketServiceTest {

	private DaoFactory daoFactory;
	private TicketDao ticketDao;
	private TicketService ticketService;

	@Test
	public void testGetTicketById() {
		daoFactory = mock(DaoFactory.class);
		ticketDao = mock(TicketDao.class);

		when(daoFactory.createTicketDao()).thenReturn(ticketDao);
		ticketService = new TicketService(daoFactory);

		Ticket expected = new Ticket.Builder().setId(1L).build();

		when(ticketDao.findElementById(anyLong())).thenReturn(Optional.of(expected));
		Ticket actual = ticketService.getTicketById(1L).get();
		verify(ticketDao).findElementById(anyLong());

		assertEquals(expected, actual);
	}

	@Test(expected = NullPointerException.class)
	public void testGetTicketByIdNull() {
		daoFactory = mock(DaoFactory.class);
		ticketDao = mock(TicketDao.class);

		when(daoFactory.createTicketDao()).thenReturn(ticketDao);
		ticketService = new TicketService(daoFactory);

		when(ticketDao.findElementById(anyLong())).thenReturn(null);
		ticketService.getTicketById(null).get();
		verify(ticketDao).findElementById(anyLong());
	}
	
	@Test
	public void testGetTicketPrice(){
		daoFactory = mock(DaoFactory.class);
		ticketDao = mock(TicketDao.class);

		when(daoFactory.createTicketDao()).thenReturn(ticketDao);
		ticketService = new TicketService(daoFactory);

		Integer expected = new Integer(100);
		when(ticketDao.getTicketPriceById(anyLong())).thenReturn(expected);		
		Integer actual = ticketService.getTicketPrice(1L);
		verify(ticketDao).getTicketPriceById(anyLong());

		assertEquals(expected, actual);
	}
}
