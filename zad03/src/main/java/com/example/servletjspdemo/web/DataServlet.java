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

@WebServlet(urlPatterns = "/data")
public class DataServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(request.getParameter("producer"));
		StorageService storageService = new StorageService();
		    
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date makeDate = null;
		try {
			makeDate = formatter.parse(request.getParameter("makeDate"));
		} catch (ParseException e) { }
		    
		Guitar newGuitar = new Guitar(Long.parseLong(request.getParameter("id")), request.getParameter("producer"), makeDate ,
				Double.parseDouble(request.getParameter("price")), true);
		    storageService.add(newGuitar);    
	}

}