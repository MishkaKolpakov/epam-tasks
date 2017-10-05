package model.services;

import dao.ClientDao;
import dao.DaoFactory;
import dao.UserDao;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.Test;


import static org.junit.Assert.*;

import model.entity.Client;
import model.entity.User;
import model.service.RegistrationService;

public class RegistrationServiceTest {

	private RegistrationService registrationService;
	private DaoFactory daoFactory;
	private UserDao userDao;
	private ClientDao clientDao;
	
	@Test
	public void testSuccessfullRegistration(){
		daoFactory = mock(DaoFactory.class);
		userDao = mock(UserDao.class);
		clientDao = mock(ClientDao.class);
		
		when(daoFactory.createUserDao()).thenReturn(userDao);
		when(daoFactory.createClientDao()).thenReturn(clientDao);
		when(userDao.getUserByEmail(anyString())).thenReturn(Optional.empty());
		when(clientDao.findClientByPassportId(anyString())).thenReturn(Optional.empty());
		
		registrationService = new RegistrationService(daoFactory);
		assertFalse(registrationService.checkByEmailAndPassportId("asdasd@masd", "sakkdsk"));
	}
	
	@Test
	public void testEmailExistsRegistration(){
		daoFactory = mock(DaoFactory.class);
		userDao = mock(UserDao.class);
		clientDao = mock(ClientDao.class);
		User user = new User.Builder()
				.setEmail("misha@mail")
				.setPassword("12345")
				.build();
			
		when(daoFactory.createUserDao()).thenReturn(userDao);
		when(daoFactory.createClientDao()).thenReturn(clientDao);
		when(userDao.getUserByEmail(anyString())).thenReturn(Optional.of(user));
		when(clientDao.findClientByPassportId(anyString())).thenReturn(Optional.empty());
		
		registrationService = new RegistrationService(daoFactory);
		assertTrue(registrationService.checkByEmailAndPassportId("misha@mail", "MU122222"));
	}
	
	@Test
	public void testPassportIdRegistration(){
		daoFactory = mock(DaoFactory.class);
		userDao = mock(UserDao.class);
		clientDao = mock(ClientDao.class);
		Client client = new Client.Builder()
				.addPassportId("MU123123")
				.build();
			
		when(daoFactory.createUserDao()).thenReturn(userDao);
		when(daoFactory.createClientDao()).thenReturn(clientDao);
		when(userDao.getUserByEmail(anyString())).thenReturn(Optional.empty());
		when(clientDao.findClientByPassportId(anyString())).thenReturn(Optional.of(client));
		
		registrationService = new RegistrationService(daoFactory);
		assertTrue(registrationService.checkByEmailAndPassportId("asd@asdasd", "MU123123"));
	}
	
	
	
}
