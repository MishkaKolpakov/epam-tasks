package controller.command.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import config.ConfigurationManager;
import controller.command.ActionCommand;
import model.entity.Flight;
import model.service.FindService;

public class FindCommand implements ActionCommand{
	private static final Logger LOGGER = Logger.getLogger(FindCommand.class.getSimpleName());
	private FindService findService;
	
	public FindCommand(FindService service) {
		findService = service;
	}
	
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		Optional<List<Flight>> result = null;
	
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
