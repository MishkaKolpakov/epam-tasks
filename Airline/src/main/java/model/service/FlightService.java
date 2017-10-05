package model.service;

import java.util.List;

import dao.DaoFactory;
import dao.FlightDao;
import model.entity.Flight;

public class FlightService {
	private DaoFactory daoFactory;
	private FlightDao flightDao;
	
	public FlightService(){
		this.daoFactory = DaoFactory.getInstance();
		flightDao = daoFactory.createFlightDao();
	}
	
	public FlightService(DaoFactory daoFactory){
		this.daoFactory = daoFactory;
		flightDao = daoFactory.createFlightDao();
	}

	private static class Holder {
		static final FlightService INSTANCE = new FlightService();
	}

	public static FlightService getInstance() {
		return Holder.INSTANCE;
	}

	public List<Flight> getAllFlights() {
		return flightDao.findAll();
	}
	
	public boolean deleteEndedTickets(Long ticketId){
		return flightDao.deleteTicketById(ticketId);
	}
}
