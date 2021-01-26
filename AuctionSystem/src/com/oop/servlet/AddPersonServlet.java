package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.Person;
import com.oop.service.PersonServiceImpl;
import com.oop.service.IPersonService;

/**
 * Servlet implementation class LoginServlet
 */
public class AddPersonServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddPersonServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		Person person = new Person();
		
		person.setFirstName(request.getParameter("firstName"));
		person.setLastName(request.getParameter("lastName"));
		person.setEmail(request.getParameter("email"));
		person.setPassword(request.getParameter("password"));

		IPersonService iPersonService = new PersonServiceImpl();
		iPersonService.addPerson(person);

		request.setAttribute("person", person);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListPersons.jsp");
		dispatcher.forward(request, response);
	}

}
