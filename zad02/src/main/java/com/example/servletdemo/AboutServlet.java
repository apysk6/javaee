package com.example.servletdemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/about")
public class AboutServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>"
				+ "<h1>Artur Pyœk</h1>"
				+ "<p>UG Student</p>"
				+ "<p>Informatyka</p>"
				+ "<p>Nr. indeksu: 246832</p>"
				+ "<h2>Zainteresowania</h2>"
				+ "<ul>"
				+ "<li>Muzyka</li>"
				+ "<li>Programowanie</li>"
				+ "</ul>"
				+ "</body></html>");
		out.close();
	}
}
