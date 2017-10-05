package controller.command.service;

import javax.servlet.http.HttpServletRequest;


import org.apache.log4j.Logger;

import config.ConfigurationManager;
import config.MessageManager;
import controller.command.ActionCommand;
import model.service.BuyService;
import model.service.IncreasePriceService;
import model.service.OrderService;

public class BuyTicket implements ActionCommand{
	private static final Logger LOGGER = Logger.getLogger(BuyTicket.class.getSimpleName());
	
	private BuyService buyService;
	private OrderService orderService;
	private IncreasePriceService increasePriceService;
	
	public BuyTicket(BuyService buyService, OrderService orderService, IncreasePriceService increasePriceService){
		this.buyService = buyService;
		this.orderService = orderService;
		this.increasePriceService = increasePriceService;
	}
	
	public BuyTicket(){
		this.buyService = BuyService.getInstance();
		this.orderService = OrderService.getInstance();
		this.increasePriceService = IncreasePriceService.getInstance();
	}
	
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		
		Long ticketId = Long.parseLong(request.getParameter("ticketId"));
		Long clientId = (Long) (request.getSession().getAttribute("clientId"));
		
		page = ConfigurationManager.getProperty("path.page.orders");
		
		if(buyService.buyTicket(ticketId)){
			request.setAttribute("bought", MessageManager.getProperty("bought.success"));
			LOGGER.info("User successfully bought ticket.");
		} else {
			request.setAttribute("bought", MessageManager.getProperty("bought.fail"));
			LOGGER.info("User tried to buy tickets that were ended and got fail message");
		}
		
		orderService.deleteFromOrder(clientId, ticketId);
		increasePriceService.increasePrice(ticketId, buyService.getTicketsAmount(ticketId));
		
		LOGGER.info("The ticket was deleted from client order");
		return page;
	}

}
