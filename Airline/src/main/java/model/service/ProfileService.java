package model.service;

import java.util.Optional;

import dao.DaoFactory;

import dao.UserDao;
import model.entity.Client;
import model.entity.User;

public class ProfileService {
	private DaoFactory daoFactory;
	private UserDao userDao;
	
	public ProfileService(){
		this.daoFactory = DaoFactory.getInstance();
		this.userDao = daoFactory.createUserDao();
	}
	
	public ProfileService(DaoFactory daoFactory){
		this.daoFactory = daoFactory;
		this.userDao = daoFactory.createUserDao();
	}

	private static class Holder {
		static final ProfileService INSTANCE = new ProfileService(DaoFactory.getInstance());
	}

	public static ProfileService getInstance() {
		return Holder.INSTANCE;
	}
	
	private Optional<Client> getClientByUserId(Long userId) {
		Optional<Client> client = userDao.getClientByUserId(userId);
		return client;
	}

	public Optional<Client> getClientByEmail(String email) {
		Optional<User> user = userDao.getUserByEmail(email);
		Optional<Client> client = Optional.empty();
		
		if (user.isPresent()) {
			client = getClientByUserId(user.get().getId());
		}
		
		return client;
	}
	
}
