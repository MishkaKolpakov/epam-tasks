package model.service;

import java.util.Optional;

import model.entity.User;

public interface Loginable {
	Optional<User> login(String email, String password);
}
