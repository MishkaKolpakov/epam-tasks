package controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.command.ActionCommand;
import controller.command.ActionFactory;
import controller.manager.ConfigurationManager;
import controller.manager.MessageManager;
import model.Model;
@WebServlet("/controller")
public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Method define the command using request
	 * save path to the page variable according to the command
	 * dispatcher user to needed jsp page
	 * @param request, response
	 */
	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = null;

		ActionFactory client = new ActionFactory();
		ActionCommand command = client.defineCommand(request);

		page = command.execute(request);

		if (page != null) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
			dispatcher.forward(request, response);
		} else {
			page = ConfigurationManager.getProperty("path.page.index");
			request.getSession().setAttribute("nullPage", MessageManager.getProperty("message.nullpage"));
			response.sendRedirect(request.getContextPath() + page);
		}
	}
	
	
	public static Model getModel(){
		return new Model();
	}
	
}
