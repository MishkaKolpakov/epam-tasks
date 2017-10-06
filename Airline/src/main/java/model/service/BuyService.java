package model.service;

import dao.DaoFactory;
import dao.FlightDao;
import dao.TicketDao;

public class BuyService {
	private DaoFactory daoFactory;
	private TicketDao ticketDao;
	private FlightDao flightDao;
	private FlightService flightService;

	public BuyService() {
		this.daoFactory = DaoFactory.getInstance();
		ticketDao = daoFactory.createTicketDao();
		flightDao = daoFactory.createFlightDao();
		flightService = new FlightService(daoFactory);
	}
	
	public BuyService(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
		ticketDao = daoFactory.createTicketDao();
		flightDao = daoFactory.createFlightDao();
		flightService = new FlightService(daoFactory);
	}

	private static class Holder {
		static final BuyService INSTANCE = new BuyService();
	}

	public static BuyService getInstance() {
		return Holder.INSTANCE;
	}

	private boolean checkAmount(Long ticketId) {
		return ticketDao.findAmountById(ticketId) > 0;
	}

	public boolean buyTicket(Long ticketId) {
		if (checkAmount(ticketId)) {
			return flightDao.updateAmount(ticketId);
		} else {
			flightService.deleteEndedTickets(ticketId);
			return false;
		}
	}
	
	public Integer getTicketsAmount(Long ticketId){
		return ticketDao.findAmountById(ticketId);
	}
}
