package model.service;

import dao.DaoFactory;
import dao.TicketDao;

public class IncreasePriceService {
	
	private DaoFactory daoFactory;
	private TicketDao ticketDao;
	private static final int AMOUNT_TO_INCREASE = 5;
	
	public IncreasePriceService(){
		daoFactory = DaoFactory.getInstance();
		ticketDao = daoFactory.createTicketDao();
	}
	
	private static class Holder {
		static final IncreasePriceService INSTANCE = new IncreasePriceService();
	}

	public static IncreasePriceService getInstance() {
		return Holder.INSTANCE;
	}
	
	public boolean increasePrice(Long ticketId, Integer amount){
		if(checkAmount(amount)){
			ticketDao.updatePrice(ticketId);
			return true;
		}
		
		return false;
	}
	
	private boolean checkAmount(Integer amount){
		return amount == AMOUNT_TO_INCREASE;
	}
}
