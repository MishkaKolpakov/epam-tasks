package controller.command;

import javax.servlet.http.HttpServletRequest;

import controller.manager.ConfigurationManager;

public class EmptyCommand implements ActionCommand {
	/**
	 * Method dispatcher to main page by default
	 * 
	 * @param request
	 * @return page
	 */
	public String execute(HttpServletRequest request) {
		String page = ConfigurationManager.getProperty("path.page.main");
		return page;
	}

}
