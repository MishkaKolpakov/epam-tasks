package controller.command;

import javax.servlet.http.HttpServletRequest;

import controller.manager.MessageManager;

public class ActionFactory {
	/**
	 * Method get the command from enum
	 * save it to the interface variable
	 * @param request
	 * @return current 
	 **/
	public ActionCommand defineCommand(HttpServletRequest request) {
		ActionCommand current = new EmptyCommand();
		String action = request.getParameter("command");
		if (action == null || action.isEmpty()) {
			return current;
		}

		try {
			CommandEnum currentCommand = CommandEnum.valueOf(action.toUpperCase());
			current = currentCommand.getCurrentCommand();
		} catch (IllegalArgumentException iae) {
			request.setAttribute("wrongAction", action + MessageManager.getProperty("message.wrongaction"));
		}
		return current;
	}
}
