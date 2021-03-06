package controller.command;

import java.util.HashMap;

import java.util.Map;

import controller.command.authentication.Login;
import controller.command.authentication.LoginForm;
import controller.command.authentication.Logout;
import controller.command.authentication.Registration;
import controller.command.authentication.RegistrationForm;
import controller.command.service.ShowContact;
import controller.command.service.AddFlight;
import controller.command.service.BuyTicket;
import controller.command.service.FindFlight;
import controller.command.service.ChangeLanguage;
import controller.command.service.AddToOrder;
import controller.command.service.ShowProfile;
import controller.command.service.ShowFlights;
import controller.command.service.ShowOrder;
import controller.command.service.ShowTicket;

public class UrlMap {
	
	private static final Map<String, ActionCommand> urlMap = new HashMap<>();

	static {
		urlMap.put("POST:/login", new Login());
		urlMap.put("GET:/logout", new Logout());
		urlMap.put("POST:/registration", new Registration());
		urlMap.put("GET:/registration", new RegistrationForm());
		urlMap.put("GET:/login", new LoginForm());
		urlMap.put("GET:/profile", new ShowProfile());
		urlMap.put("GET:/about", new ShowContact());
		urlMap.put("POST:/add", new AddFlight());
		urlMap.put("GET:/book", new ShowFlights());
		urlMap.put("GET:/orders", new ShowOrder());
		urlMap.put("POST:/order", new AddToOrder());
		urlMap.put("POST:/ticket", new ShowTicket());
		urlMap.put("POST:/find", new FindFlight());
		urlMap.put("POST:/ticket", new ShowTicket());
		urlMap.put("POST:/language", new ChangeLanguage());
		urlMap.put("POST:/buy", new BuyTicket());
		urlMap.put("POST:/add", new AddFlight());
	}
	
	public static Map<String, ActionCommand> getUrlMap(){
		return urlMap;
	}
}
