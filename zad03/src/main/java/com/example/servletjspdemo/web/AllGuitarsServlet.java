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

import com.example.servletjspdemo.domain.Guitar;
import com.example.servletjspdemo.service.StorageService;

@WebServlet(urlPatterns = "/all-guitars")
public class AllGuitarsServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		StorageService ss = (StorageService) getServletContext().getAttribute("storage_service");
	
		List<Guitar> allGuitars = ss.getAllGuitars();

		out.append("<html><body><h2>All Guitars:</h2>");

		for (Guitar guitar: allGuitars) {
			out.append("<p>Id: " + guitar.getId() + "</p>");
			out.append("<p>Producer: " + guitar.getProducer() + "</p>");
			out.append("<p>Made date: " + guitar.getMakeDate() + "</p>");
			out.append("<p>Price: " + guitar.getPrice() + "</p>");
			out.append("<p>Is Reserved: " + guitar.getIsReserved() + "</p>");
			out.append("<form action='data-cart'><input type='submit' name='add' value='" + guitar.getId() +"' ></form>");
		}

		out.append( "</br><li><a href='index'>Index</a></li>");
		out.append("</body></html>");
		out.close();
	}
	
	@Override
	public void init() throws ServletException {

		// application context
		getServletContext().setAttribute("storage_service", new StorageService());
	}
}
