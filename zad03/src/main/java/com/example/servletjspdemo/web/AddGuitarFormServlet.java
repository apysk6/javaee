package com.example.servletjspdemo.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/add-guitar")
public class AddGuitarFormServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body><h2>Add guitar form</h2>" +
				"<form action='data-guitar'>" +
				"ID: <input type='text' name='id' /> <br />" +
				"Producer: <input type='text' name='producer' /> <br />" +
				"Making date: <input type='text' name='makeDate' /> <br />" +
				"Price: <input type='text' name='price' /> <br />" +
				"Reservation: <select name='isReserved'>" +
				"<option value='true'>Yes</option>" +
				"<option value='false'>No</option>" +
				"</select><br />" +
				"<input type='submit' name='add' value=' OK ' /></form>" +
				"</body></html>");
		out.close();
	}
}
