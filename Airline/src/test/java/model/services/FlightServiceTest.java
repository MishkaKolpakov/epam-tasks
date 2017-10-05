package model.services;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;
import dao.DaoFactory;
import dao.FlightDao;
import model.entity.Flight;
import model.entity.FlightInstance;
import model.service.FlightService;

public class FlightServiceTest {

	private DaoFactory daoFactory;
	private FlightDao flightDao;
	private FlightService flightService;
	
	@Test
	public void testFindAll(){
		daoFactory = mock(DaoFactory.class);
		flightDao = mock(FlightDao.class);
		
		when(daoFactory.createFlightDao()).thenReturn(flightDao);
		flightService = new FlightService(daoFactory);
		
		FlightInstance kievLviv = new FlightInstance.Builder()
				.setFrom("Kiev")
				.setTo("Lviv")
				.build();
		
		List<Flight> expected = Arrays.asList(new Flight[]{
			new Flight.Builder().setFlightInstance(kievLviv).build(),
			new Flight.Builder().setFlightInstance(kievLviv).build()
		});
	
		when(flightDao.findAll()).thenReturn(expected);
		List<Flight> actual = flightService.getAllFlights();
		
		verify(daoFactory, times(1)).createFlightDao();
		verify(flightDao, times(1)).findAll();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCorrectDeleteEnded(){
		daoFactory = mock(DaoFactory.class);
		flightDao = mock(FlightDao.class);
		
		when(daoFactory.createFlightDao()).thenReturn(flightDao);
		flightService = new FlightService(daoFactory);
	
		when(flightDao.deleteTicketById(anyLong())).thenReturn(true);
				
		assertTrue(flightService.deleteEndedTickets(1L));
		
		verify(daoFactory, times(1)).createFlightDao();
		verify(flightDao).deleteTicketById(1L);
	}
	
	@Test
	public void testFailDeleteEnded(){
		daoFactory = mock(DaoFactory.class);
		flightDao = mock(FlightDao.class);
		
		when(daoFactory.createFlightDao()).thenReturn(flightDao);
		flightService = new FlightService(daoFactory);
	
		when(flightDao.deleteTicketById(anyLong())).thenReturn(false);
				
		assertFalse(flightService.deleteEndedTickets(1L));
		
		verify(daoFactory, times(1)).createFlightDao();
		verify(flightDao).deleteTicketById(1L);
	}
}
