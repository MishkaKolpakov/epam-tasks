package controller;

import static org.mockito.Mockito.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Test;

import controller.command.service.BuyTicket;
import model.service.impl.BuyService;
import model.service.impl.FlightService;
import model.service.impl.IncreasePriceService;
import model.service.impl.OrderService;

import static org.junit.Assert.*;

public class BuyCommandTest {
	private BuyService buyService;
	private OrderService orderService;
	private HttpServletRequest request;
	private BuyTicket buyCommand;
	private HttpSession session;
	private IncreasePriceService increasePriceService;
	private FlightService flightService;
	
	@Test
	public void testExecuteSuccess(){
		buyService = mock(BuyService.class);
		orderService = mock(OrderService.class);
		increasePriceService = mock(IncreasePriceService.class);
		flightService = mock(FlightService.class);
		request = mock(HttpServletRequest.class);
		session = mock(HttpSession.class);
		
		buyCommand = new BuyTicket(buyService, orderService, increasePriceService, flightService);
		
		when(request.getParameter(anyString())).thenReturn("1");
		when(request.getSession()).thenReturn(session);
		when(buyService.buyTicket(anyLong())).thenReturn(true);
		when(orderService.deleteFromOrder(anyLong(), anyLong())).thenReturn(true);

		String expected = "/pages/user/orders.jsp";
		String actual = buyCommand.execute(request);
		
		verify(buyService).buyTicket(anyLong());
		verify(orderService).deleteFromOrder(anyLong(), anyLong());
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testExecuteFail(){
		buyService = mock(BuyService.class);
		orderService = mock(OrderService.class);
		request = mock(HttpServletRequest.class);
		increasePriceService = mock(IncreasePriceService.class);
		session = mock(HttpSession.class);
		flightService = mock(FlightService.class);
		buyCommand = new BuyTicket(buyService, orderService, increasePriceService, flightService);
		
		when(request.getParameter(anyString())).thenReturn("1");
		when(request.getSession()).thenReturn(session);
		when(buyService.buyTicket(anyLong())).thenReturn(false);
		when(orderService.deleteFromOrder(anyLong(), anyLong())).thenReturn(true);

		String expected = "/pages/user/orders.jsp";
		String actual = buyCommand.execute(request);
		
		verify(buyService).buyTicket(anyLong());
		verify(orderService).deleteFromOrder(anyLong(), anyLong());
		
		assertEquals(expected, actual);
	}
}
