package model.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import dao.DaoFactory;
import dao.FlightDao;
import model.entity.Flight;

public class FindService {

	private DaoFactory daoFactory;
	private FlightDao flightDao;
	
	public FindService(){
		this.daoFactory = DaoFactory.getInstance();
		flightDao = daoFactory.createFlightDao();
	}
	
	public FindService(DaoFactory daoFactory){
		this.daoFactory = daoFactory;
		flightDao = daoFactory.createFlightDao();
	}
	
	private static class Holder {
		static final FindService INSTANCE = new FindService();
	}

	public static FindService getInstance() {
		return Holder.INSTANCE;
	}

	public Optional<List<Flight>> findFlight(String from, String to, LocalDate date) {
		return flightDao.findFlight(from, to, date);
	}
	
	public Optional<List<Flight>> findFlightWithoutDate(String from, String to) {
		return flightDao.findFlightWitoutDate(from, to);
	}
}
