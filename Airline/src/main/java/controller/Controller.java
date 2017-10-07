package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import config.ConfigurationManager;
import controller.command.ActionCommand;
import controller.command.UrlMap;

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

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getMethod().toUpperCase();
		String path = request.getRequestURI();
		path = path.replaceAll(".*/rest", "").replaceAll("\\d+", "");
		String key = method+":"+path;
		String page = null;
		String language = (String) request.getSession().getAttribute("locale");
	
		ActionCommand actionCommand = UrlMap.getUrlMap().get(key);
		page = actionCommand.execute(request);

		if (language == null) {
			language = "en_US";
		}

		if (page != null) {
			request.getRequestDispatcher(page).forward(request, response);
		} else {
			page = ConfigurationManager.getProperty("path.page.index");
			response.sendRedirect(request.getContextPath() + page);
		}

	}
}
