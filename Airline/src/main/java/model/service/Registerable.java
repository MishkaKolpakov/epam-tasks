package model.service;

import model.entity.Client;
import model.entity.User;

public interface Registerable {
	void registerClient(User user, Client client);
	boolean checkByEmailAndPassportId(String email, String passportId);
}
