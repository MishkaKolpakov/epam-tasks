package model.service;
import java.util.Optional;

import dao.DaoFactory;
import dao.TicketDao;
import model.entity.Ticket;

public class TicketService {
	private DaoFactory daoFactory;
	private TicketDao ticketDao;
	
	public TicketService(DaoFactory daoFactory){
		this.daoFactory = daoFactory;
		this.ticketDao = daoFactory.createTicketDao();
	}
	
	public TicketService(){
		this.daoFactory = DaoFactory.getInstance();
		this.ticketDao = daoFactory.createTicketDao();
	}
	
	private static class Holder {
		static final TicketService INSTANCE = new TicketService();
	}

	public static TicketService getInstance() {
		return Holder.INSTANCE;
	}

	public Optional<Ticket> getTicketById(Long id) {
		return ticketDao.findElementById(id);
	}
	
	public Integer getBaggagePrice(Long ticketId){
		return ticketDao.getBaggagePriceById(ticketId);
	}
	
	public Integer getFirstQueuePrice(Long ticketId){
		return ticketDao.getFirstQueuePriceById(ticketId);
	}
	
	public Integer getTicketPrice(Long ticketId){
		return ticketDao.getTicketPriceById(ticketId);
	}
	
}
