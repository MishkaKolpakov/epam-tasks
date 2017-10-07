package model.services;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;
import dao.DaoFactory;
import dao.TicketDao;
import model.entity.FlightInstance;
import model.entity.Ticket;
import model.service.impl.FlightService;

public class FlightServiceTest {

	private DaoFactory daoFactory;
	private TicketDao ticketDao;
	private FlightService flightService;
	
	@Test
	public void testFindAll(){
		daoFactory = mock(DaoFactory.class);
		ticketDao = mock(TicketDao.class);
		
		when(daoFactory.createTicketDao()).thenReturn(ticketDao);
		flightService = new FlightService(daoFactory);
		
		FlightInstance kievLviv = new FlightInstance.Builder()
				.setFrom("Kiev")
				.setTo("Lviv")
				.build();
		
		List<Ticket> expected = Arrays.asList(new Ticket[]{
			new Ticket.Builder().setFlightInstance(kievLviv).build(),
			new Ticket.Builder().setFlightInstance(kievLviv).build()
		});
	
		when(ticketDao.findAll()).thenReturn(expected);
		List<Ticket> actual = flightService.getAllFlights();
		
		verify(daoFactory, times(1)).createTicketDao();
		verify(ticketDao, times(1)).findAll();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCorrectDeleteEnded(){
		daoFactory = mock(DaoFactory.class);
		ticketDao = mock(TicketDao.class);
		
		when(daoFactory.createTicketDao()).thenReturn(ticketDao);
		flightService = new FlightService(daoFactory);
	
		when(ticketDao.deleteTicketById(anyLong())).thenReturn(true);
				
		assertTrue(flightService.deleteEndedTickets(1L));
		
		verify(daoFactory, times(1)).createTicketDao();
		verify(ticketDao).deleteTicketById(1L);
	}
	
	@Test
	public void testFailDeleteEnded(){
		daoFactory = mock(DaoFactory.class);
		ticketDao = mock(TicketDao.class);
		
		when(daoFactory.createTicketDao()).thenReturn(ticketDao);
		flightService = new FlightService(daoFactory);
	
		when(ticketDao.deleteTicketById(anyLong())).thenReturn(false);
				
		assertFalse(flightService.deleteEndedTickets(1L));
		
		verify(daoFactory, times(1)).createTicketDao();
		verify(ticketDao).deleteTicketById(1L);
	}
}
