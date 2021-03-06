package controller.command.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import config.ConfigurationManager;
import controller.command.ActionCommand;
import model.service.impl.FlightService;

public class ShowFlights implements ActionCommand {
	private static final Logger LOGGER = Logger.getLogger(ShowFlights.class.getSimpleName());
	private FlightService flightService;
	
	public ShowFlights(FlightService flightService){
		this.flightService = flightService;
	}
	
	public ShowFlights(){
		this.flightService = FlightService.getInstance();
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
