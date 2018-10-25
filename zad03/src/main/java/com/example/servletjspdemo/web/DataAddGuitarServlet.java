package com.example.servletjspdemo.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.servletjspdemo.domain.Guitar;
import com.example.servletjspdemo.service.StorageService;

@WebServlet(urlPatterns = "/data-guitar")
public class DataAddGuitarServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		StorageService ss = (StorageService) getServletContext().getAttribute("storage_service");
		
		DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		long id = Long.parseLong(request.getParameter("id"));
		String producer = request.getParameter("producer");
		Date makeDate = null;
		try {
			makeDate = formatter.parse(request.getParameter("makeDate"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		double price = Double.parseDouble(request.getParameter("price"));
		boolean isReserved = Boolean.parseBoolean(request.getParameter("isReserved"));

		Guitar newGuitar = new Guitar(id, producer, makeDate, price, isReserved);

		ss.add(newGuitar);
		response.sendRedirect("all-guitars");
		out.close();
	}
	
	@Override
	public void init() throws ServletException {

		// application context
		getServletContext().setAttribute("storage_service", new StorageService());
	}
}
