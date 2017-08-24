package controller.command.functionality;

import javax.servlet.http.HttpServletRequest;

import controller.command.ActionCommand;
import controller.manager.ConfigurationManager;

public class MainMenuCommand implements ActionCommand {
	/**
	 * Method returning to main page invalidating current user session
	 * 
	 * @param request
	 * @return page
	 */
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		page = ConfigurationManager.getProperty("path.page.index");
		request.getSession().invalidate();
		return page;
	}

}
