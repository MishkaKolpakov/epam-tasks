package controller.filter;

import java.io.IOException;



import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import config.MessageManager;
import model.entity.User.Role;

public class SecurityFilter implements Filter {
	private String loginPath;
	private static final Logger LOGGER = Logger.getLogger(SecurityFilter.class.getSimpleName());
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		loginPath = filterConfig.getInitParameter("LOGIN");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();

		Role role = (Role) session.getAttribute("role");

		if (role == null) {
			RequestDispatcher dispatcher = httpRequest.getRequestDispatcher(loginPath);
			httpRequest.setAttribute("guestPage", MessageManager.getProperty("wrong.guest.rights"));
			dispatcher.forward(httpRequest, httpResponse);
			LOGGER.warn("Guest tried to get user resources");
			return;
		}
		
		chain.doFilter(httpRequest, httpResponse);
	}

	@Override
	public void destroy() {

	}

}
