package model.services;

import static org.mockito.Mockito.*;
import org.junit.Test;
import static org.junit.Assert.*;
import dao.DaoFactory;
import dao.TicketDao;
import model.service.impl.BuyService;
import model.service.impl.FlightService;

public class BuyServiceTest {
	private DaoFactory daoFactory;
	private TicketDao ticketDao;
	private BuyService buyService;
	private FlightService flightService;
	

	@Test
	public void testSuccessBuyTicket() {
		daoFactory = mock(DaoFactory.class);
		ticketDao = mock(TicketDao.class);
		when(daoFactory.createTicketDao()).thenReturn(ticketDao);
		
		when(ticketDao.findAmountById(anyLong())).thenReturn(1);
		when(ticketDao.updateAmount(anyLong())).thenReturn(true);

		buyService = new BuyService(daoFactory);

		assertTrue(buyService.buyTicket(1L));
	}

	@Test
	public void testBuyEndedTicket() {
		daoFactory = mock(DaoFactory.class);
		flightService = mock(FlightService.class);
		
		ticketDao = mock(TicketDao.class);

		
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

		when(daoFactory.createTicketDao()).thenReturn(ticketDao);
		buyService = new BuyService(daoFactory);

		buyService.buyTicket(null);
	}
}
