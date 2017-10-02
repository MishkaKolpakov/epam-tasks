package model.service;

import java.util.Optional;

import dao.ClientDao;
import dao.DaoFactory;
import dao.UserDao;
import model.entity.Client;
import model.entity.User;

public class RegistrationService {

	private DaoFactory daoFactory;
	private UserDao userDao;
	private ClientDao clientDao;
	
	public RegistrationService(DaoFactory daoFactory){
		this.daoFactory = daoFactory;
		this.userDao = this.daoFactory.createUserDao();
		this.clientDao = this.daoFactory.createClientDao();
		
	}

	private static class Holder {
		static final RegistrationService INSTANCE = new RegistrationService(DaoFactory.getInstance());
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

	public void registerClient(User user, Client client) {
		userDao.insert(user);
		client.setId(user.getId());
		clientDao.insert(client);
	}
}
