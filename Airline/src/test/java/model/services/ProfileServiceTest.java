package model.services;

import dao.DaoFactory;
import dao.UserDao;
import model.entity.Client;
import model.entity.User;
import model.service.ProfileService;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProfileServiceTest {

	private DaoFactory daoFactory;
	private UserDao userDao;
	private ProfileService profileService;
	
	@Test
	public void testGetClientByEmailExists(){
		daoFactory = mock(DaoFactory.class);
		userDao = mock(UserDao.class);
		
		when(daoFactory.createUserDao()).thenReturn(userDao);
		profileService = new ProfileService(daoFactory);
		
		User expectedUser = new User.Builder()
					.setEmail("misha@mail")
					.build();
		
		Client expectedClient = new Client.Builder()
				.addUser(expectedUser)
				.addLastName("Kolpakov")
				.build();
		
		when(userDao.getClientByUserId(anyLong())).thenReturn(Optional.of(expectedClient));
		when(userDao.getUserByEmail(anyString())).thenReturn(Optional.of(expectedUser));
				
		Client actualClient = profileService.getClientByEmail("misha@mail").get();
		User actualUser = actualClient.getUser();
		
		assertEquals(expectedClient.getLastName(), actualClient.getLastName());
		assertEquals(expectedUser.getEmail(), actualUser.getEmail());
		
	}
	
	@Test
	public void testGetClientByEmailEmpty(){
		daoFactory = mock(DaoFactory.class);
		userDao = mock(UserDao.class);
		
		when(daoFactory.createUserDao()).thenReturn(userDao);
		profileService = new ProfileService(daoFactory);
		
		Optional<Client> expectedClient = Optional.empty();
		when(userDao.getUserByEmail(anyString())).thenReturn(Optional.empty());
		Optional<Client> actualClient = profileService.getClientByEmail("asdasd@asd");
		
		verify(userDao).getUserByEmail(anyString());
		assertEquals(expectedClient, actualClient);		
	}
	
}
