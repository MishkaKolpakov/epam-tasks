package controller.command.service;

import java.time.LocalDateTime;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import config.ConfigurationManager;
import config.MessageManager;
import controller.command.ActionCommand;
import model.entity.FlightInstance;
import model.entity.Ticket;
import model.service.impl.AddFlightService;

public class AddFlight implements ActionCommand{
	private static final Logger LOGGER = Logger.getLogger(AddFlight.class.getSimpleName());
	private AddFlightService addFlightService;
	
	public AddFlight(AddFlightService service){
		addFlightService = service;
	}
	
	public AddFlight(){
		this.addFlightService = AddFlightService.getInstance();
	}
	
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;

		if(insertNewFlight(request)){
			request.setAttribute("addSuccess", MessageManager.getProperty("add.success"));
			LOGGER.info("Admin added successfully new flight");
		} else {
			request.setAttribute("addWrong", MessageManager.getProperty("add.wrong"));
			LOGGER.warn("Admin tried to add flight with incorrect data!");
		}		
		
		page = ConfigurationManager.getProperty("path.page.admin");
		return page;
	}
	
	private boolean insertNewFlight(HttpServletRequest request){
		
		
		LocalDateTime localDate = dateTimeParser(request);
		
		FlightInstance flightInstance = defineFlightInstance(request);
		
		if(flightInstance == null){
			return false;
		}

		Ticket ticket = createTicket(request, localDate, flightInstance);		
		addFlightService.addFlight(ticket);
		return true;
	}
	
	private LocalDateTime dateTimeParser(HttpServletRequest request){
		String stringDate = request.getParameter("date");
		String[] dateTime = stringDate.split("T");
		String[] date = dateTime[0].split("-");
		String[] time = dateTime[1].split(":");
		
		Integer year = Integer.parseInt(date[0]);
		Integer month = Integer.parseInt(date[1]);
		Integer day = Integer.parseInt(date[2]);
		Integer hours = Integer.parseInt(time[0]);
		Integer minutes = Integer.parseInt(time[1]);
		
		return LocalDateTime.of(year, month, day, hours, minutes);	
	}
	
	private FlightInstance defineFlightInstance(HttpServletRequest request){
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		Optional<FlightInstance> result = addFlightService.getFlight(from, to);
		return result.get();
	}
	
	private Ticket createTicket(HttpServletRequest request, LocalDateTime localDate, FlightInstance flightInstance){
		Integer ticketPrice = Integer.parseInt(request.getParameter("ticketPrice"));
		Integer baggagePrice = Integer.parseInt(request.getParameter("baggagePrice"));
		Integer queuePrice = Integer.parseInt(request.getParameter("queuePrice"));
		Integer amount = Integer.parseInt(request.getParameter("amount"));
		
		return new Ticket.Builder()
				.setTicketPrice(ticketPrice)
				.setBaggagePrice(baggagePrice)
				.setFirstInQueuePrice(queuePrice)
				.setDepartureDateTime(localDate)
				.setPlacesAmount(amount)
				.setFlightInstance(flightInstance)
				.build();
	}	
}
