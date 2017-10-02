package controller;

import model.service.BuyService;
import model.service.OrderService;
import static org.mockito.Mockito.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Test;

import controller.command.service.BuyCommand;

import static org.junit.Assert.*;

public class BuyCommandTest {
	private BuyService buyService;
	private OrderService orderService;
	private HttpServletRequest request;
	private BuyCommand buyCommand;
	private HttpSession session;
	
	@Test
	public void testExecuteSuccess(){
		buyService = mock(BuyService.class);
		orderService = mock(OrderService.class);
		request = mock(HttpServletRequest.class);
		session = mock(HttpSession.class);
		buyCommand = new BuyCommand(buyService, orderService);
		
		when(request.getParameter(anyString())).thenReturn("1");
		when(request.getSession()).thenReturn(session);
		when(buyService.buyTicket(anyLong())).thenReturn(true);
		when(orderService.deleteFromOrder(anyLong(), anyLong())).thenReturn(true);

		String expected = "/orders";
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
		session = mock(HttpSession.class);
		buyCommand = new BuyCommand(buyService, orderService);
		
		when(request.getParameter(anyString())).thenReturn("1");
		when(request.getSession()).thenReturn(session);
		when(buyService.buyTicket(anyLong())).thenReturn(false);
		when(orderService.deleteFromOrder(anyLong(), anyLong())).thenReturn(true);

		String expected = "/orders";
		String actual = buyCommand.execute(request);
		
		verify(buyService).buyTicket(anyLong());
		verify(orderService).deleteFromOrder(anyLong(), anyLong());
		
		assertEquals(expected, actual);
	}
}
