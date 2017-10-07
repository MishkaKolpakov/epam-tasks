package controller.command;

import javax.servlet.http.HttpServletRequest;

import config.ConfigurationManager;

public class EmptyCommand implements ActionCommand {

	private final String INDEX_PATH = "path.page.index";
	
	public String execute(HttpServletRequest request) {
		String page = null;
		page = ConfigurationManager.getProperty(INDEX_PATH);
		return page;
	}

}
