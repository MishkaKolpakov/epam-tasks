package model.services;

import java.util.Optional;

import org.junit.Test;

import dao.DaoFactory;
import dao.UserDao;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import model.entity.User;
import model.service.impl.LoginService;

public class LoginServiceTest {

	private LoginService loginService;
	private UserDao userDao;
	private DaoFactory daoFactory;

	@Test
	public void testCorrectLoginPass() {
		userDao = mock(UserDao.class);
		daoFactory = mock(DaoFactory.class);
		loginService = new LoginService(daoFactory);

		User expected = new User.Builder().setEmail("misha@mail").setPassword("12345").build();

		when(daoFactory.createUserDao()).thenReturn(userDao);
		when(userDao.getUserByEmail(anyObject())).thenReturn(Optional.of(expected));
		User actual = loginService.login("misha@mail", "12345").get();

		assertEquals(expected.getEmail(), actual.getEmail());
		assertEquals(expected.getPassword(), actual.getPassword());
	}

	@Test
	public void testWrongLoginCorrectPass() {
		userDao = mock(UserDao.class);
		daoFactory = mock(DaoFactory.class);
		loginService = new LoginService(daoFactory);

		Optional<User> expected = Optional.empty();
		when(daoFactory.createUserDao()).thenReturn(userDao);
		when(userDao.getUserByEmail(anyObject())).thenReturn(expected);

		Optional<User> actual = loginService.login("asdasd@asd.asd", "12345");
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCorrectLoginWrongPass() {
		userDao = mock(UserDao.class);
		daoFactory = mock(DaoFactory.class);
		loginService = new LoginService(daoFactory);

		Optional<User> expected = Optional.empty();
		when(daoFactory.createUserDao()).thenReturn(userDao);
		when(userDao.getUserByEmail(anyObject())).thenReturn(expected);

		Optional<User> actual = loginService.login("misha@mail", "asdasdas");
		assertEquals(expected, actual);
	}
	
	@Test
	public void testWrongLoginWrongPass() {
		userDao = mock(UserDao.class);
		daoFactory = mock(DaoFactory.class);
		loginService = new LoginService(daoFactory);

		Optional<User> expected = Optional.empty();
		when(daoFactory.createUserDao()).thenReturn(userDao);
		when(userDao.getUserByEmail(anyObject())).thenReturn(expected);

		Optional<User> actual = loginService.login("asdasd@asd.asd", "asdasdas");
		assertEquals(expected, actual);
	}

	@Test(expected = Exception.class)
	public void testNullLogin() {
		userDao = mock(UserDao.class);
		daoFactory = mock(DaoFactory.class);
		loginService = new LoginService(daoFactory);
		loginService.login(null, "12345");

	}
}
