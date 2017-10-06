package controller.command.authentication;

import javax.servlet.http.HttpServletRequest;


import config.ConfigurationManager;
import controller.command.ActionCommand;

public class Logout implements ActionCommand {
	
	public String execute(HttpServletRequest request) {
		String page = null;
		page = ConfigurationManager.getProperty("path.page.login"); 
		request.getSession().invalidate();
		request.getSession().setAttribute("locale", "en_US");
		return page;
	}

}
