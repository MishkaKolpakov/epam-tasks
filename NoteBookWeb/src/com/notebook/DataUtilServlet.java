package com.notebook;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DataUtilServlet")
public class DataUtilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		String lastName = request.getParameter("lastName");
		String firstName = request.getParameter("firstName");
		String middleName = request.getParameter("middleName");
		String nickName = request.getParameter("nickName");
		String commentaries = request.getParameter("commentary");
		String group = request.getParameter("group");
		String homePhoneNumber = request.getParameter("homePhone");
		String mobilePhoneNumber = request.getParameter("mobilePhone");
		String alternativePhoneNumber = request.getParameter("alternativePhone");
		String email = request.getParameter("email");
		String skype = request.getParameter("skype");

		out.println(lastName);
		out.println(firstName);
		out.println(middleName);
		out.println(nickName);
		out.println(commentaries);
		out.println(group);
		out.println(homePhoneNumber);
		out.println(mobilePhoneNumber);
		out.println(alternativePhoneNumber);
		out.println(email);
		out.println(skype);

	}

}
