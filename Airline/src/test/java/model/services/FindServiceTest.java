package model.services;

import dao.DaoFactory;
import dao.FlightDao;
import model.entity.Flight;
import model.entity.FlightInstance;
import model.service.FindService;
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
	private FlightDao flightDao;
	private FindService findService;

	@Test
	public void testSuccesstFindFlight() {
		daoFactory = mock(DaoFactory.class);
		flightDao = mock(FlightDao.class);

		when(daoFactory.createFlightDao()).thenReturn(flightDao);
		findService = new FindService(daoFactory);

		FlightInstance kievLviv = new FlightInstance.Builder().setFrom("Kiev").setTo("Lviv").build();
		LocalDate localDate = LocalDate.of(2017, 11, 14);
		LocalTime firstLocalTime = LocalTime.of(14, 00);
		LocalTime secondLocalTime = LocalTime.of(21, 00);
		
		List<Flight> expected = Arrays.asList(new Flight[] {
				new Flight.Builder()
						.setDepartureDateTime(LocalDateTime.of(localDate, firstLocalTime))
						.setFlightInstance(kievLviv)
						.build(),
				
				new Flight.Builder()
						.setDepartureDateTime(LocalDateTime.of(localDate, secondLocalTime))
						.setFlightInstance(kievLviv)
						.build() });

		when(flightDao.findFlight(anyString(), anyString(), anyObject())).thenReturn(Optional.of(expected));

		List<Flight> actual = findService.findFlight("Kiev", "Lviv", localDate).get();

		verify(daoFactory).createFlightDao();
		verify(flightDao).findFlight(anyString(), anyString(), anyObject());

		assertEquals(expected, actual);
	}
	
	@Test
	public void testEmptyFindFlight() {
		daoFactory = mock(DaoFactory.class);
		flightDao = mock(FlightDao.class);
		
		when(daoFactory.createFlightDao()).thenReturn(flightDao);
		findService = new FindService(daoFactory);		
		
		Optional<List<Flight>> expected = Optional.empty(); 
		when(flightDao.findFlight(anyString(), anyString(), anyObject())).thenReturn(Optional.empty());
		Optional<List<Flight>> actual = findService.findFlight("Kiev", "Lviv", LocalDate.of(2017,11,22));
		
		verify(daoFactory).createFlightDao();
		verify(flightDao).findFlight(anyString(), anyString(), anyObject());

		assertEquals(expected, actual);
	}
	
	@Test
	public void testSuccesstFindFlightWithoutDate() {
		daoFactory = mock(DaoFactory.class);
		flightDao = mock(FlightDao.class);

		when(daoFactory.createFlightDao()).thenReturn(flightDao);
		findService = new FindService(daoFactory);

		FlightInstance kievLviv = new FlightInstance.Builder()
				.setFrom("Kiev")
				.setTo("Lviv")
				.build();
		
		List<Flight> expected = Arrays.asList(new Flight[] {
				new Flight.Builder()
						.setFlightInstance(kievLviv)
						.build(),
				
				new Flight.Builder()
						.setFlightInstance(kievLviv)
						.build() });

		when(flightDao.findFlightWitoutDate(anyString(), anyString())).thenReturn(Optional.of(expected));

		List<Flight> actual = findService.findFlightWithoutDate("Kiev", "Lviv").get();

		verify(daoFactory).createFlightDao();
		verify(flightDao).findFlightWitoutDate(anyString(), anyString());

		assertEquals(expected, actual);
	}
	
	@Test
	public void testEmptyFindFlightWithoutDate() {
		daoFactory = mock(DaoFactory.class);
		flightDao = mock(FlightDao.class);
		
		when(daoFactory.createFlightDao()).thenReturn(flightDao);
		findService = new FindService(daoFactory);		
		
		Optional<List<Flight>> expected = Optional.empty(); 
		when(flightDao.findFlightWitoutDate(anyString(), anyString())).thenReturn(Optional.empty());
		Optional<List<Flight>> actual = findService.findFlightWithoutDate("Kiev", "Lviv");
		
		verify(daoFactory).createFlightDao();
		verify(flightDao).findFlightWitoutDate(anyString(), anyString());

		assertEquals(expected, actual);
	}
}
