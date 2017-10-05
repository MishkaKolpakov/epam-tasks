package model.service;

import java.util.Optional;

import dao.DaoFactory;
import dao.FlightDao;
import dao.FlightInstanceDao;
import dao.TicketDao;
import model.entity.Flight;
import model.entity.FlightInstance;
import model.entity.Ticket;

public class AddFlightService {

	private DaoFactory daoFactory;
	private TicketDao ticketDao;
	private FlightDao flightDao;
	private FlightInstanceDao flightInstanceDao;

	public AddFlightService() {
		this.daoFactory = DaoFactory.getInstance();
		this.ticketDao = daoFactory.createTicketDao();
		this.flightDao = daoFactory.createFlightDao();
		this.flightInstanceDao = daoFactory.createFlightInstanceDao();
	}
	
	public AddFlightService(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
		this.ticketDao = daoFactory.createTicketDao();
		this.flightDao = daoFactory.createFlightDao();
		this.flightInstanceDao = daoFactory.createFlightInstanceDao();
	}

	private static class Holder {
		static final AddFlightService INSTANCE = new AddFlightService();
	}

	public static AddFlightService getInstance() {
		return Holder.INSTANCE;
	}

	public Optional<FlightInstance> getFlight(String from, String to) {
		return flightInstanceDao.findFlightByDirection(from, to);
	}

	public void addFlight(Ticket ticket, Flight flight) {
		ticketDao.insert(ticket);
		flight.setId(ticket.getId());
		flightDao.insert(flight);
	}
}
