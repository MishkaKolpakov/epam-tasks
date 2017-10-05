package controller.command.service;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import config.ConfigurationManager;
import controller.command.ActionCommand;
import model.entity.Client;
import model.service.ProfileService;

public class ShowProfile implements ActionCommand {
	private static final Logger LOGGER = Logger.getLogger(ShowProfile.class.getSimpleName());
	private ProfileService profileService;
	public ShowProfile(){
		this.profileService = ProfileService.getInstance();
	}
	
	public ShowProfile(ProfileService profileService){
		this.profileService = profileService;
	}
	
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		
		String email = (String) request.getSession().getAttribute("email");
		Optional<Client> client = profileService.getClientByEmail(email);

		if (client.isPresent()) {
			request.getSession().setAttribute("email", email);
			request.getSession().setAttribute("client", client.get());
			page = ConfigurationManager.getProperty("path.page.profile");
			LOGGER.info("User clicked profile menu item");

		} else {
			page = ConfigurationManager.getProperty("path.page.login");
			LOGGER.warn("User doesn`t exists");
		}

		return page;
	}

}
