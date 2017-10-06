package controller;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import controller.command.authentication.Registration;
import model.service.RegistrationService;

public class RegistrationCommandTest {
	private HttpServletRequest request;
	private RegistrationService regisrationService;
	private Registration registrationCommand;
	
	@Test
	public void testSuccessfulRegistration(){
		request = mock(HttpServletRequest.class);
		regisrationService = mock(RegistrationService.class);
		registrationCommand = new Registration(regisrationService);
		
		when(request.getParameter(anyString())).thenReturn("UserDataInformation");
		
		when(regisrationService.checkByEmailAndPassportId(anyString(), anyString())).thenReturn(false);
		
		String actual = registrationCommand.execute(request);
		String expected = "/login";
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testWrongInputDataRegistration(){
		request = mock(HttpServletRequest.class);
		regisrationService = mock(RegistrationService.class);
		registrationCommand = new Registration(regisrationService);
		
		when(request.getParameter(anyString())).thenReturn("Some user data");
		when(regisrationService.checkByEmailAndPassportId(anyString(), anyString())).thenReturn(true);
		
		String actual = registrationCommand.execute(request);
		String expected = "/registration";
		
		assertEquals(expected, actual);
	}
	
	@Test(expected=NullPointerException.class)
	public void testNullRequestRegistration(){
		registrationCommand = new Registration(regisrationService);
		registrationCommand.execute(null);
	}
}
