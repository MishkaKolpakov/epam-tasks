package controller.command.service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import config.ConfigurationManager;
import controller.command.ActionCommand;
import model.entity.Ticket;
import model.service.impl.TicketService;

public class ShowTicket implements ActionCommand{
	private static final Logger LOGGER = Logger.getLogger(ShowTicket.class.getSimpleName());
	private TicketService ticketService;
	
	public ShowTicket(TicketService service) {
		ticketService = service;
	}
	
	public ShowTicket() {
		this.ticketService = TicketService.getInstance();
	}
	
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		Long id = Long.parseLong(request.getParameter("flightId"));
		Optional<Ticket> ticket = Optional.empty();
		
		ticket = ticketService.getTicketById(id);
		request.setAttribute("ticket", ticket.get());
		
		LOGGER.info("User clicked on button that shows detail information about flight");
		page = ConfigurationManager.getProperty("path.page.ticket");
		return page;
	}

}
