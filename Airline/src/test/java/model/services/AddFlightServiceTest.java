package model.services;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import java.util.Optional;

import org.junit.Test;

import dao.DaoFactory;
import dao.FlightInstanceDao;
import model.entity.FlightInstance;
import model.service.AddFlightService;

public class AddFlightServiceTest {
	private DaoFactory daoFactory;
	private FlightInstanceDao flightInstanceDao;
	private AddFlightService addFlightService;

	@Test
	public void successGetFlightByDirection() {
		daoFactory = mock(DaoFactory.class);
		flightInstanceDao = mock(FlightInstanceDao.class);
		when(daoFactory.createFlightInstanceDao()).thenReturn(flightInstanceDao);
		addFlightService = new AddFlightService(daoFactory);

		FlightInstance expected = new FlightInstance.Builder()
									  .setFrom("Kiev")
									  .setTo("Lviv")
									  .build();

		when(flightInstanceDao.findFlightByDirection(anyString(), anyString())).thenReturn(Optional.of(expected));

		FlightInstance actual = addFlightService.getFlight("Kiev", "Lviv").get();
		assertEquals(expected.getFrom(), actual.getFrom());
		assertEquals(expected.getTo(), actual.getTo());
	}

	@Test
	public void wrongGetFlightByDirection() {
		daoFactory = mock(DaoFactory.class);
		flightInstanceDao = mock(FlightInstanceDao.class);
		when(daoFactory.createFlightInstanceDao()).thenReturn(flightInstanceDao);
		addFlightService = new AddFlightService(daoFactory);

		when(flightInstanceDao.findFlightByDirection(anyString(), anyString())).thenReturn(Optional.empty());

		Optional<FlightInstance> expected = Optional.empty();
		Optional<FlightInstance> actual = addFlightService.getFlight("New York", "Lviv");
		assertEquals(expected, actual);

	}
}
