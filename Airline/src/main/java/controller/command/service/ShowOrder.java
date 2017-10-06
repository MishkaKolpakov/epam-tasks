package controller.command.service;

import java.util.ArrayList;

import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import config.ConfigurationManager;
import config.MessageManager;
import controller.command.ActionCommand;
import model.entity.Order;
import model.service.OrderService;

public class ShowOrder implements ActionCommand {
	private static final Logger LOGGER = Logger.getLogger(ShowOrder.class.getSimpleName());
	private OrderService orderService;
	
	public ShowOrder(OrderService service) {
		orderService = service;
	}
	
	public ShowOrder() {
		this.orderService = OrderService.getInstance();
	}
	
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		List<Order> orders = new ArrayList<>();

		Long clientId = (Long) (request.getSession().getAttribute("clientId"));
		 
		for(Order order : orderService.getClientOrder(clientId).get()){
			orders.add(order);
		}
		
		LOGGER.info("User clicked order list menu item");
		request.setAttribute("orders", orders);
		if (orders.isEmpty()) {
			request.setAttribute("emptyOrders", MessageManager.getProperty("orders.empty"));
			LOGGER.info("User opened his order list, which is empty");
		}

		page = ConfigurationManager.getProperty("path.page.orders");

		return page;
	}

}
