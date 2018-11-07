package com.example.servletjspdemo.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.servletjspdemo.domain.Guitar;
import com.example.servletjspdemo.service.StorageService;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/data-cart")
public class DataAddCartServlet extends HttpServlet {

	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		StorageService ss = (StorageService) getServletContext().getAttribute("storage_service");
		
		List<Guitar> availableGuitars = ss.getAllGuitars();
		Guitar guitarToCart = availableGuitars.get(Integer.parseInt(request.getParameter("add")) - 1);
			
		HttpSession ses = request.getSession();
		if (ses.getAttribute("cart") == null) {
			List<Guitar> cart = new ArrayList<Guitar>();
			ses.setAttribute("cart", cart);
		}
		
		List<Guitar> cart = (List<Guitar>) ses.getAttribute("cart");
		cart.add(guitarToCart);

		response.sendRedirect("cart");
		out.close();
	}
	
	@Override
	public void init() throws ServletException {

		// application context
		getServletContext().setAttribute("storage_service", new StorageService());
	}
}
