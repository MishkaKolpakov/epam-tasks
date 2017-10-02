package controller.command.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import config.ConfigurationManager;
import config.MessageManager;
import controller.command.ActionCommand;

public class AboutCommand implements ActionCommand {
	private static final Logger LOGGER = Logger.getLogger(AboutCommand.class.getSimpleName());
	
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		request.setAttribute("contact", MessageManager.getProperty("contact.us"));
		page = ConfigurationManager.getProperty("path.page.about");
		LOGGER.info("User clicked contact us menu item");
		return page;
	}

}
