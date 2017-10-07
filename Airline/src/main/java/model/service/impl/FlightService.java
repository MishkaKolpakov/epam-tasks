package model.service.impl;

import java.util.List;
import dao.DaoFactory;
import dao.TicketDao;
import model.entity.Ticket;

public class FlightService {
	private DaoFactory daoFactory;
	private TicketDao ticketDao;
	
	public FlightService(){
		this.daoFactory = DaoFactory.getInstance();
		ticketDao = daoFactory.createTicketDao();
	}
	
	public FlightService(DaoFactory daoFactory){
		this.daoFactory = daoFactory;
		ticketDao = daoFactory.createTicketDao();
	}

	private static class Holder {
		static final FlightService INSTANCE = new FlightService();
	}

	public static FlightService getInstance() {
		return Holder.INSTANCE;
	}

	public List<Ticket> getAllFlights() {
		return ticketDao.findAll();
	}
	
	public boolean deleteEndedTickets(Long ticketId){
		return ticketDao.deleteTicketById(ticketId);
	}
}
