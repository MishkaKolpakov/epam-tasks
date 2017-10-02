package model.service;

import java.util.Optional;

import dao.DaoFactory;
import dao.UserDao;
import model.entity.User;

public class LoginService implements Loginable {

	private DaoFactory daoFactory;

	public LoginService(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	private static class Holder {
		static final LoginService INSTANCE = new LoginService(DaoFactory.getInstance());
	}

	public static LoginService getInstance() {
		return Holder.INSTANCE;
	}

	@Override
	public Optional<User> login(String email, String password) {
		try (UserDao userDao = daoFactory.createUserDao()) {
			return userDao.getUserByEmail(email).filter(user -> password.equals(user.getPassword()));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
