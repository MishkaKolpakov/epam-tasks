package controller;

import javax.servlet.http.HttpServletRequest;
import static org.mockito.Mockito.*;

import java.util.Optional;

import static org.junit.Assert.*;
import org.junit.Test;

import controller.command.service.AddFlight;
import model.entity.FlightInstance;
import model.service.AddFlightService;

public class AddCommandTest {

	private AddFlightService addFlightService;
	private HttpServletRequest request;
	private AddFlight addCommand;
	
	@Test
	public void testExecute(){
		addFlightService = mock(AddFlightService.class);
		request = mock(HttpServletRequest.class);
		addCommand = new AddFlight(addFlightService);
		String expected = "/pages/admin.jsp";
		
		FlightInstance flightInstance = new FlightInstance.Builder()
				.setFrom("Kiev")
				.setTo("Lviv")
				.build();
		
		when(addFlightService.getFlight(anyString(), anyString())).thenReturn(Optional.of(flightInstance));
		when(request.getParameter("date")).thenReturn("2017-11-14T14:00");
		when(request.getParameter("ticketPrice")).thenReturn("1000");
		when(request.getParameter("baggagePrice")).thenReturn("1000");
		when(request.getParameter("queuePrice")).thenReturn("1000");
		when(request.getParameter("amount")).thenReturn("10");
		when(request.getParameter("from")).thenReturn("Kiev");
		when(request.getParameter("to")).thenReturn("Lviv");
		
		String actual = addCommand.execute(request);
		assertEquals(expected, actual);
		
		verify(request).getParameter("date");
		verify(request).getParameter("ticketPrice");
		verify(request).getParameter("baggagePrice");
		verify(request).getParameter("queuePrice");
		verify(request).getParameter("amount");
		verify(request).getParameter("from");
		verify(request).getParameter("to");
		
	}
}
