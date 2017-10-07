package model.service.impl;

import java.time.LocalDate;

import java.util.List;
import java.util.Optional;

import dao.DaoFactory;
import dao.TicketDao;
import model.entity.Ticket;

public class FindService {

	private DaoFactory daoFactory;
	private TicketDao ticketDao;
	
	public FindService(){
		this.daoFactory = DaoFactory.getInstance();
		ticketDao = daoFactory.createTicketDao();
	}
	
	public FindService(DaoFactory daoFactory){
		this.daoFactory = daoFactory;
		ticketDao = daoFactory.createTicketDao();
	}
	
	private static class Holder {
		static final FindService INSTANCE = new FindService();
	}

	public static FindService getInstance() {
		return Holder.INSTANCE;
	}

	public Optional<List<Ticket>> findFlight(String from, String to, LocalDate date) {
		return ticketDao.findFlight(from, to, date);
	}
	
	public Optional<List<Ticket>> findFlightWithoutDate(String from, String to) {
		return ticketDao.findFlightWitoutDate(from, to);
	}
}
