package controller;

import javax.servlet.http.HttpServletRequest;


import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.util.Optional;
import org.junit.Test;

import javax.servlet.http.HttpSession;
import controller.command.authentication.Login;
import model.entity.User;
import model.entity.User.Role;
import model.service.Loginable;

public class LoginCommandTest {

	private Loginable loginer;
	private HttpServletRequest request;
	private HttpSession session;
	private Login loginCommand;

	@Test
	public void testSuccesUserLogin() {
		loginer = mock(Loginable.class);
		request = mock(HttpServletRequest.class);
		session = mock(HttpSession.class);
		loginCommand = new Login(loginer);

		User user = new User.Builder().setEmail("misha@mail").setPassword("12345").setRole(Role.valueOf("USER"))
				.build();

		when(request.getParameter("email")).thenReturn("misha@mail");
		when(request.getParameter("password")).thenReturn("12345");
		when(request.getSession()).thenReturn(session);
		when(loginer.login(anyString(), anyString())).thenReturn(Optional.of(user));

		String expected = "/pages/user/welcome.jsp";
		String actual = loginCommand.execute(request);

		assertEquals(expected, actual);
	}

	@Test(expected = NullPointerException.class)
	public void testNullLogin() {
		loginer = mock(Loginable.class);
		request = mock(HttpServletRequest.class);
		session = mock(HttpSession.class);
		loginCommand = new Login(loginer);

		loginCommand.execute(null);
	}

	@Test
	public void testWrongLogin() {
		loginer = mock(Loginable.class);
		request = mock(HttpServletRequest.class);
		session = mock(HttpSession.class);
		loginCommand = new Login(loginer);

		when(request.getParameter("email")).thenReturn("misha@mail");
		when(request.getParameter("password")).thenReturn("asdasd");
		when(request.getSession()).thenReturn(session);
		when(loginer.login(anyString(), anyString())).thenReturn(Optional.empty());

		String expected = "/pages/guest/login.jsp";
		String actual = loginCommand.execute(request);

		assertEquals(expected, actual);
	}
	
	@Test
	public void testSuccessAdminLogin() {
		loginer = mock(Loginable.class);
		request = mock(HttpServletRequest.class);
		session = mock(HttpSession.class);
		loginCommand = new Login(loginer);

		User user = new User.Builder()
				.setEmail("misha@gmail.com")
				.setPassword("12345")
				.setRole(Role.valueOf("ADMIN"))
				.build();

		when(request.getParameter("email")).thenReturn("misha@gmail.com");
		when(request.getParameter("password")).thenReturn("12345");
		when(request.getSession()).thenReturn(session);
		when(loginer.login(anyString(), anyString())).thenReturn(Optional.of(user));
	
		String expected = "/pages/admin.jsp";
		String actual = loginCommand.execute(request);

		assertEquals(expected, actual);
	}

}
