package model.services;

import static org.mockito.Mockito.*;

import org.junit.Test;

import static org.junit.Assert.*;
import dao.DaoFactory;
import dao.FlightDao;
import dao.TicketDao;
import model.service.BuyService;
import model.service.FlightService;

public class BuyServiceTest {
	private DaoFactory daoFactory;
	private TicketDao ticketDao;
	private BuyService buyService;
	private FlightService flightService;
	private FlightDao flightDao;

	@Test
	public void testSuccessBuyTicket() {
		daoFactory = mock(DaoFactory.class);
		ticketDao = mock(TicketDao.class);
		flightDao = mock(FlightDao.class);
		when(daoFactory.createTicketDao()).thenReturn(ticketDao);
		when(daoFactory.createFlightDao()).thenReturn(flightDao);
		when(ticketDao.findAmountById(anyLong())).thenReturn(1);
		when(flightDao.updateAmount(anyLong())).thenReturn(true);

		buyService = new BuyService(daoFactory);

		assertTrue(buyService.buyTicket(1L));
	}

	@Test
	public void testBuyEndedTicket() {
		daoFactory = mock(DaoFactory.class);
		flightService = mock(FlightService.class);
		flightDao = mock(FlightDao.class);
		ticketDao = mock(TicketDao.class);

		when(daoFactory.createFlightDao()).thenReturn(flightDao);
		when(daoFactory.createTicketDao()).thenReturn(ticketDao);
		when(ticketDao.findAmountById(anyLong())).thenReturn(0);
		when(flightService.deleteEndedTickets(anyLong())).thenReturn(true);

		buyService = new BuyService(daoFactory);
		assertFalse(buyService.buyTicket(1L));
	}
	
	@Test(expected = NullPointerException.class)
	public void testNullBuyTicket() {
		daoFactory = mock(DaoFactory.class);
		flightService = mock(FlightService.class);
		ticketDao = mock(TicketDao.class);

		when(daoFactory.createFlightDao()).thenReturn(flightDao);
		when(daoFactory.createTicketDao()).thenReturn(ticketDao);
		buyService = new BuyService(daoFactory);

		buyService.buyTicket(null);
	}
}
