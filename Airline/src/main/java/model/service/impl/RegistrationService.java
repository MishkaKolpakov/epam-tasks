package model.service.impl;

import java.util.Optional;

import dao.ClientDao;
import dao.DaoFactory;
import dao.UserDao;
import model.entity.Client;
import model.entity.User;
import model.service.Registerable;

public class RegistrationService implements Registerable{

	private DaoFactory daoFactory;
	private UserDao userDao;
	private ClientDao clientDao;
	
	public RegistrationService(DaoFactory daoFactory){
		this.daoFactory = daoFactory;
		this.userDao = daoFactory.createUserDao();
		this.clientDao = daoFactory.createClientDao();
		
	}
	
	public RegistrationService(){
		this.daoFactory = DaoFactory.getInstance();
		this.userDao = daoFactory.createUserDao();
		this.clientDao = daoFactory.createClientDao();
		
	}

	private static class Holder {
		static final RegistrationService INSTANCE = new RegistrationService();
	}

	public static RegistrationService getInstance() {
		return Holder.INSTANCE;
	}

	private Optional<User> checkUser(String email) {
		return userDao.getUserByEmail(email);
	}

	private Optional<Client> checkPassportId(String passportId) {
		Optional<Client> client = Optional.empty();		
		client = clientDao.findClientByPassportId(passportId);
		return client;
	}
	
	public boolean checkByEmailAndPassportId(String email, String passportId){
		return (checkPassportId(passportId).isPresent() || checkUser(email).isPresent());
		
	}
	
	@Override
	public void registerClient(User user, Client client) {
		userDao.insert(user);
		client.setId(user.getId());
		clientDao.insert(client);
	}
}
