package controller.command.authentication;

import javax.servlet.http.HttpServletRequest;

import config.ConfigurationManager;
import controller.command.ActionCommand;

public class LoginForm implements ActionCommand{
	

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		page = ConfigurationManager.getProperty("path.page.login");
		return page;
	}
	
}
