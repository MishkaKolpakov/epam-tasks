package controller.command.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import config.ConfigurationManager;
import config.MessageManager;
import controller.command.ActionCommand;
import model.entity.Order;
import model.service.OrderService;

public class ShowOrderCommand implements ActionCommand {
	private static final Logger LOGGER = Logger.getLogger(ShowOrderCommand.class.getSimpleName());
	private OrderService orderService;
	
	public ShowOrderCommand(OrderService service) {
		orderService = service;
	}
	
	public ShowOrderCommand() {
		this.orderService = OrderService.getInstance();
	}
	
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		Order order = null;

		Long clientId = (Long) (request.getSession().getAttribute("clientId"));
		
		order = orderService.getClientOrder(clientId).get();
		LOGGER.info("User clicked order list menu item");
		request.setAttribute("order", order);
		if (order.getTickets().isEmpty()) {
			request.setAttribute("emptyOrders", MessageManager.getProperty("orders.empty"));
			LOGGER.info("User opened his order list, which is empty");
		}

		page = ConfigurationManager.getProperty("path.page.orders");

		return page;
	}

}
