package controller.command.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import config.ConfigurationManager;
import controller.command.ActionCommand;
import model.service.FlightService;

public class ServiceCommand implements ActionCommand {
	private static final Logger LOGGER = Logger.getLogger(ServiceCommand.class.getSimpleName());
	private FlightService flightService;
	
	public ServiceCommand(FlightService service){
		flightService = service;
	}
	
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		
		request.setAttribute("flights", flightService.getAllFlights());
		page = ConfigurationManager.getProperty("path.page.service");
		LOGGER.info("User got all available flights");
		
		return page;
	}

}
