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
		StorageService ss = (StorageService) getServletContext().getAttribute("storage_service");
		HttpSession session = request.getSession();
		
		boolean isRodo = false;
		if (session.getAttribute("rodo") != null) {
			isRodo = (Boolean)session.getAttribute("rodo");
		}
		List<Guitar> allGuitars = ss.getAllCart();

		out.append("<html><body><h2>Your cart:</h2>");

		for (Guitar guitar: allGuitars) {
			out.append("<form><p>Id: " + guitar.getId() + "</p>");
			out.append("<p>Producer: " + guitar.getProducer() + "</p>");
			out.append("<p>Made date: " + guitar.getMakeDate() + "</p>");
			out.append("<p>Price: " + guitar.getPrice() + "</p>");
			out.append("<p>Is Reserved: " + guitar.getIsReserved() + "</p></br>");
		}
		
		if (isRodo == false) {
			out.append("<form action='/buy'>"
					+ "<h3>Compulsory fields</h3>"
					+ "<label for=\"rodo\">I accept RODO-1.</label>"
					+ "<input type=\"checkbox\" name=\"rodo\" id=\"rodo\" required=\"required\"><br> "
					+ "<label for=\"rodo2\">I accept RODO-2.</label>"
					+ "<input type=\"checkbox\" name=\"rodo2\" id=\"rodo2\" required=\"required\"><br>"
					+ "<h3>Optional fields</h3>"
					+ "<label for=\"rodo3\">I accept RODO-3.</label>"
					+ "<input type=\"checkbox\" name=\"rodo3\" id=\"rodo3\"><br><br>");
		}

		out.append("<input type='submit' name='add' value=' BUY ' /></form>");
		out.append("</br><li><a href='index'>Index</a></li>");
		out.append("</body></html>");
		out.close();
	}
	
	@Override
	public void init() throws ServletException {

		// application context
		getServletContext().setAttribute("storage_service", new StorageService());
	}
}
