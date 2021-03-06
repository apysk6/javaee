package com.example.servletjspdemo.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.servletjspdemo.domain.Guitar;
import com.example.servletjspdemo.service.StorageService;

@WebServlet(urlPatterns = "/cart")
public class CartServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(true);
		
		List<Guitar> allGuitars = (List<Guitar>) session.getAttribute("cart");

		out.append("<html><body><h2>Your cart:</h2>");

		if (allGuitars != null) {
		for (Guitar guitar: allGuitars) {
			out.append("<p>Id: " + guitar.getId() + "</p>");
			out.append("<p>Producer: " + guitar.getProducer() + "</p>");
			out.append("<p>Made date: " + guitar.getMakeDate() + "</p>");
			out.append("<p>Price: " + guitar.getPrice() + "</p>");
			out.append("<p>Is Reserved: " + guitar.getIsReserved() + "</p></br>");
		}
		}

		out.append("</br><li><a href='index'>Index</a></li>");
		out.append("</body></html>");
		out.close();
	}
}
