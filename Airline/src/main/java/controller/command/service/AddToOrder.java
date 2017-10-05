package controller.command.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import config.ConfigurationManager;
import config.MessageManager;
import controller.command.ActionCommand;
import model.service.OrderService;
import model.service.TicketService;

public class AddToOrder implements ActionCommand {
	private static final Logger LOGGER = Logger.getLogger(AddToOrder.class.getSimpleName());
	private OrderService orderService;
	private TicketService ticketService = TicketService.getInstance();
	
	public AddToOrder(OrderService service){
		orderService = service;
	}
	
	public AddToOrder(){
		this.orderService = OrderService.getInstance();
	}
	
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		Long ticketId = Long.parseLong(request.getParameter("ticketId"));
		Long clientId = (Long) (request.getSession().getAttribute("clientId"));
		Integer orderPrice = countPrice(request, ticketId);
		
		if(orderService.checkOrder(clientId, ticketId)){
			orderService.orderTicket(clientId, ticketId, orderPrice);
			request.setAttribute("successOrder", MessageManager.getProperty("order.success"));
			LOGGER.info("User successfully ordered the ticket!");
		} else {
			request.setAttribute("alreadyOrdered", MessageManager.getProperty("order.already"));
			LOGGER.info("User tried to order two tickets and got warn message!");
		}

		page = ConfigurationManager.getProperty("path.page.service");
		return page;
	}

	private Integer countPrice(HttpServletRequest request, Long ticketId){
		String baggage = request.getParameter("baggage");
		String firstQueue = request.getParameter("firstQueue");
		
		Integer orderPrice = ticketService.getTicketPrice(ticketId);
		
		if (baggage != null) {
			orderPrice += ticketService.getBaggagePrice(ticketId);
		}

		if (firstQueue != null) {
			orderPrice += ticketService.getFirstQueuePrice(ticketId);
		}
		
		return orderPrice;
	}
}
