package dao;

import java.util.Optional;

import model.entity.Client;
import model.entity.User;

public interface UserDao extends GenericDao<User> {
	Optional<User> getUserByEmail(String email);
	Optional<Client> getClientByUserId(Long id);
}
