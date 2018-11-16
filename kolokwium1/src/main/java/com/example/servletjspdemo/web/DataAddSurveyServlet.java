package com.example.servletjspdemo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.servletjspdemo.domain.Survey;
import com.example.servletjspdemo.service.StorageService;

@WebServlet(urlPatterns = "/data-survey")
public class DataAddSurveyServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(true);
		StorageService ss = (StorageService) getServletContext().getAttribute("storage_service");

		String dateFrom = request.getParameter("dateFrom");
		String dateTo = request.getParameter("dateTo");
		String frequency = request.getParameter("frequency");
		String selectedComments = "";
		if (request.getParameter("comment") != null) {
		 for (String comment : request.getParameterValues("comment")) {
			 selectedComments += comment + " ";
		 }
		}
		 Survey newSurvey = new Survey(dateFrom, dateTo, frequency, selectedComments);
			
        if (session.getAttribute("session_survey") == null) {
            ss.addSurvey(newSurvey);
        } else {
            Survey oldSurvey = (Survey)session.getAttribute("session_survey");
            ss.removeSurvey(oldSurvey);
            ss.addSurvey(newSurvey);
        }

        session.setAttribute("session_survey", newSurvey);
		response.sendRedirect("allSurveys");
		out.close();
	}
	
	@Override
	public void init() throws ServletException {

		// application context
		getServletContext().setAttribute("storage_service", new StorageService());
	}
}
