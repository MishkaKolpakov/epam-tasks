package dao;

import config.ConfigDB;

public abstract class DaoFactory {
	public abstract ClientDao createClientDao();

	public abstract UserDao createUserDao();
	
	public abstract FlightDao createFlightDao();
	
	public abstract TicketDao createTicketDao();

	public abstract FlightInstanceDao createFlightInstanceDao();
	
	public abstract OrderDao createOrderDao();
	
	public static DaoFactory getInstance() {
		String className = ConfigDB.getInstance().getFactoryClassName();
		DaoFactory factory = null;
		try {
			factory = (DaoFactory) Class.forName(className).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return factory;
	}
}
