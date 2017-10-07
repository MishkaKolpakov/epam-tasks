package model.services;

import dao.DaoFactory;
import dao.TicketDao;
import model.entity.FlightInstance;
import model.entity.Ticket;
import model.service.impl.FindService;

import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindServiceTest {
	private DaoFactory daoFactory;
	private TicketDao ticketDao;
	private FindService findService;

	@Test
	public void testSuccesstfindFlight() {
		daoFactory = mock(DaoFactory.class);
		ticketDao = mock(TicketDao.class);

		when(daoFactory.createTicketDao()).thenReturn(ticketDao);
		findService = new FindService(daoFactory);

		FlightInstance kievLviv = new FlightInstance.Builder().setFrom("Kiev").setTo("Lviv").build();
		LocalDate localDate = LocalDate.of(2017, 11, 14);
		LocalTime firstLocalTime = LocalTime.of(14, 00);
		LocalTime secondLocalTime = LocalTime.of(21, 00);
		
		List<Ticket> expected = Arrays.asList(new Ticket[] {
				new Ticket.Builder()
						.setDepartureDateTime(LocalDateTime.of(localDate, firstLocalTime))
						.setFlightInstance(kievLviv)
						.build(),
				
				new Ticket.Builder()
						.setDepartureDateTime(LocalDateTime.of(localDate, secondLocalTime))
						.setFlightInstance(kievLviv)
						.build() });

		when(ticketDao.findFlight(anyString(), anyString(), anyObject())).thenReturn(Optional.of(expected));

		List<Ticket> actual = findService.findFlight("Kiev", "Lviv", localDate).get();

		verify(daoFactory).createTicketDao();
		verify(ticketDao).findFlight(anyString(), anyString(), anyObject());

		assertEquals(expected, actual);
	}
	
	@Test
	public void testEmptyfindFlight() {
		daoFactory = mock(DaoFactory.class);
		ticketDao = mock(TicketDao.class);

		when(daoFactory.createTicketDao()).thenReturn(ticketDao);
		findService = new FindService(daoFactory);
		
		Optional<List<Ticket>> expected = Optional.empty(); 
		when(ticketDao.findFlight(anyString(), anyString(), anyObject())).thenReturn(Optional.empty());
		Optional<List<Ticket>> actual = findService.findFlight("Kiev", "Lviv", LocalDate.of(2017,11,22));
		
		verify(daoFactory).createTicketDao();
		verify(ticketDao).findFlight(anyString(), anyString(), anyObject());

		assertEquals(expected, actual);
	}
	
	@Test
	public void testSuccesstfindFlightWithoutDate() {
		daoFactory = mock(DaoFactory.class);
		ticketDao = mock(TicketDao.class);

		when(daoFactory.createTicketDao()).thenReturn(ticketDao);
		findService = new FindService(daoFactory);

		FlightInstance kievLviv = new FlightInstance.Builder()
				.setFrom("Kiev")
				.setTo("Lviv")
				.build();
		
		List<Ticket> expected = Arrays.asList(new Ticket[] {
				new Ticket.Builder()
						.setFlightInstance(kievLviv)
						.build(),
				
				new Ticket.Builder()
						.setFlightInstance(kievLviv)
						.build() });

		when(ticketDao.findFlightWitoutDate(anyString(), anyString())).thenReturn(Optional.of(expected));

		List<Ticket> actual = findService.findFlightWithoutDate("Kiev", "Lviv").get();

		verify(daoFactory).createTicketDao();
		verify(ticketDao).findFlightWitoutDate(anyString(), anyString());

		assertEquals(expected, actual);
	}
	
	@Test
	public void testEmptyfindFlightWithoutDate() {
		daoFactory = mock(DaoFactory.class);
		ticketDao = mock(TicketDao.class);
		
		when(daoFactory.createTicketDao()).thenReturn(ticketDao);
		findService = new FindService(daoFactory);		
		
		Optional<List<Ticket>> expected = Optional.empty(); 
		when(ticketDao.findFlightWitoutDate(anyString(), anyString())).thenReturn(Optional.empty());
		Optional<List<Ticket>> actual = findService.findFlightWithoutDate("Kiev", "Lviv");
		
		verify(daoFactory).createTicketDao();
		verify(ticketDao).findFlightWitoutDate(anyString(), anyString());

		assertEquals(expected, actual);
	}
}
