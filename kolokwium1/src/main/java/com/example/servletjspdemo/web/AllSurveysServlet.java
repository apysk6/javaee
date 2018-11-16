package com.example.servletjspdemo.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.servletjspdemo.domain.Guitar;
import com.example.servletjspdemo.domain.Survey;
import com.example.servletjspdemo.service.StorageService;

@WebServlet(urlPatterns = "/allSurveys")
public class AllSurveysServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		StorageService ss = (StorageService) getServletContext().getAttribute("storage_service");
	
		List<Survey> allSurveys = ss.getAllSurveys();

		out.append("<html><body><h2>All surveys:</h2>");

		for (Survey survey: allSurveys) {
			out.append("<p>Using product from: " + survey.getDateFrom() + "</p>");
			out.append("<p>Using product to: " + survey.getDateTo() + "</p>");
			out.append("<p>Frequency: " + survey.getFrequency() + "</p>");
			out.append("<p>Comments: " + survey.getComment() + "</p></br>");
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
