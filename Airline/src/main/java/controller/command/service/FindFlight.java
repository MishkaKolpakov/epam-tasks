package controller.command.service;

import java.time.LocalDate;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import config.ConfigurationManager;
import controller.command.ActionCommand;
import model.entity.Ticket;
import model.service.impl.FindService;

public class FindFlight implements ActionCommand{
	private static final Logger LOGGER = Logger.getLogger(FindFlight.class.getSimpleName());
	private FindService findService;
	
	public FindFlight(FindService service) {
		findService = service;
	}
	
	public FindFlight() {
		this.findService = FindService.getInstance();
	}
	
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		Optional<List<Ticket>> result = null;
	
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		String date = request.getParameter("date");
		
		if(date == null || date.isEmpty()){
			result = findService.findFlightWithoutDate(from, to);
			LOGGER.info("User search flight only by direction.");
		} else {
			LocalDate localDate = LocalDate.parse(date);
			result = findService.findFlight(from, to, localDate);
			LOGGER.info("User search flight by direction and date.");
		}
		
		if(result.isPresent()){
			request.setAttribute("findResult", result.get());
			LOGGER.info("User got filtered information about flights.");
		}

		page = ConfigurationManager.getProperty("path.page.find");
		return page;
	}

}
