package controller.command.service;

import javax.servlet.http.HttpServletRequest;


import org.apache.log4j.Logger;

import config.ConfigurationManager;
import config.MessageManager;
import controller.command.ActionCommand;
import model.service.BuyService;
import model.service.OrderService;

public class BuyCommand implements ActionCommand{
	private static final Logger LOGGER = Logger.getLogger(BuyCommand.class.getSimpleName());
	
	private BuyService buyService;
	private OrderService orderService;
	
	public BuyCommand(BuyService buyService, OrderService orderService){
		this.buyService = buyService;
		this.orderService = orderService;
		
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
		LOGGER.info("The ticket was deleted from client order");
		return page;
	}

}
