package com.BoB.mvc.customer.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserReviewServlet
 */
@WebServlet("/review")
public class UserReviewServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("check");
		String path = "/WEB-INF/views/customer/Review.jsp";
		
		request.getRequestDispatcher(path).forward(request, response);
				
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int satisfied = Integer.parseInt(request.getParameter("emoji"));
		String reviewContent = request.getParameter("reviewContent");
		
	    
		
		
	}

}
