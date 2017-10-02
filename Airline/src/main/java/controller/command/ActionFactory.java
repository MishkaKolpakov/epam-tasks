package controller.command;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {
	private final static String COMMAND = "command";
	
	public ActionCommand defineCommand(HttpServletRequest request) {
		ActionCommand current = new EmptyCommand();

		String action = request.getParameter(COMMAND);

		if (action == null || action.isEmpty()) {
			return current;
		}
		
		CommandEnum commandEnum = CommandEnum.valueOf(action.toUpperCase());
		current = commandEnum.getCurrentCommand();
		
		return current;
	}
}
