package controller.command.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import config.ConfigurationManager;
import config.MessageManager;
import controller.command.ActionCommand;

public class ChangeLanguage implements ActionCommand{
	private static final Logger LOGGER = Logger.getLogger(ChangeLanguage.class.getSimpleName());
		
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		String language = request.getParameter("language");
		
		MessageManager.setLanguage(language);
		request.getSession().setAttribute("locale", language);
		page = ConfigurationManager.getProperty("path.page.login");
		LOGGER.info("Language changed");
		return page;
	}

}
