package model.service.impl;

import dao.DaoFactory;

import dao.TicketDao;
import model.service.Buyable;

public class BuyService implements Buyable{
	private DaoFactory daoFactory;
	private TicketDao ticketDao;
	

	public BuyService() {
		this.daoFactory = DaoFactory.getInstance();
		ticketDao = daoFactory.createTicketDao();
		
	}
	
	public BuyService(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
		ticketDao = daoFactory.createTicketDao();
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

	@Override
	public boolean buyTicket(Long ticketId) {
		if (checkAmount(ticketId)) {
			return ticketDao.updateAmount(ticketId);
		}
			return false;
	}
	
	public Integer getTicketsAmount(Long ticketId){
		return ticketDao.findAmountById(ticketId);
	}
}
