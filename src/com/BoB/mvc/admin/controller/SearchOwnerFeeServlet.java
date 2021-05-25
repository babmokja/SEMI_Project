package com.BoB.mvc.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchOwnerFeeServlet
 */
@WebServlet("/admin/fee/search")
public class SearchOwnerFeeServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String month = request.getParameter("month-input");
		String value = request.getParameter("searchValue");
		
		System.out.println(month+"/"+value);
		
	}

}
