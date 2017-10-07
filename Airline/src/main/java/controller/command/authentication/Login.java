package controller.command.authentication;

import java.util.Optional;


import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import config.ConfigurationManager;
import config.MessageManager;
import controller.command.ActionCommand;
import model.entity.User;
import model.service.Loginable;
import model.service.impl.LoginService;

public class Login implements ActionCommand {
	private static final Logger LOGGER = Logger.getLogger(Login.class.getSimpleName());
	private Loginable loginer;
	
	public Login(Loginable loginer){
		this.loginer = loginer;
	}
	
	public Login(){
		this.loginer = LoginService.getInstance();
	}

	private static final String LOGIN_PATH = "path.page.login";
	private static final String ADMIN_PATH = "path.page.admin";
	private static final String WELCOME_PATH = "path.page.welcome";
	private static final String WRONG_LOGIN_PASS = "wrong.login.pass";
	private static final String ADMIN = "admin";
	
	public String execute(HttpServletRequest request) {
		String page = null;
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = null;
		Optional<User> result = loginer.login(email, password);
		
		if (result.isPresent()) {
			user = result.get();
			request.getSession().setAttribute("email", user.getEmail());
			request.getSession().setAttribute("clientId", user.getId());
			request.getSession().setAttribute("role", user.getRole());
			request.setAttribute("welcome", MessageManager.getProperty("welcome"));
			
			page = user.getRole().toString().equalsIgnoreCase(ADMIN) ? 
					ConfigurationManager.getProperty(ADMIN_PATH) : 
					ConfigurationManager.getProperty(WELCOME_PATH);	
			LOGGER.info("Successful log in as: " + request.getSession().getAttribute("role"));
		} else {
			request.setAttribute("wrongLoginPass", MessageManager.getProperty(WRONG_LOGIN_PASS));
			page = ConfigurationManager.getProperty(LOGIN_PATH);
			LOGGER.warn("Wrong login, password input.");
		}
		return page;
	}

}
