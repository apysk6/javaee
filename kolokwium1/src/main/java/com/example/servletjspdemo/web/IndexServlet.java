package com.example.servletjspdemo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/index")
public class IndexServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        HttpSession session = request.getSession(true);
        
        if (request.getParameterMap().containsKey("rodo") && request.getParameterMap().containsKey("rodo2")) {
        	session.setAttribute("rodo", true);
        }
        
        if (session.getAttribute("rodo") == null)
        	response.sendRedirect("Start.jsp");

        PrintWriter out = response.getWriter();
        out.println("<html><body><h1>Welcome</h1> <br>" +
                "Menu: <br>" +
                "<ul>" +
                "<li><a href='add-guitar'>Add Guitar</a></li>" +
                "<li><a href='all-guitars'>Buy guitar</a></li>" +
                "<li><a href='cart'>Your cart</a></li>" +
                "<li><a href='survey.jsp'>Survey</a></li>" +
                "</ul>" +
                "</body></html>");
        out.close();
    }

}