package controller;

import model.service.BuyService;
import model.service.IncreasePriceService;
import model.service.OrderService;
import static org.mockito.Mockito.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Test;

import controller.command.service.BuyTicket;

import static org.junit.Assert.*;

public class BuyCommandTest {
	private BuyService buyService;
	private OrderService orderService;
	private HttpServletRequest request;
	private BuyTicket buyCommand;
	private HttpSession session;
	private IncreasePriceService increasePriceService;
	
	@Test
	public void testExecuteSuccess(){
		buyService = mock(BuyService.class);
		orderService = mock(OrderService.class);
		increasePriceService = mock(IncreasePriceService.class);
		request = mock(HttpServletRequest.class);
		session = mock(HttpSession.class);
		
		buyCommand = new BuyTicket(buyService, orderService, increasePriceService);
		
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
		buyCommand = new BuyTicket(buyService, orderService, increasePriceService);
		
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
