package com.BoB.mvc.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/admin/sales/month")
public class SelectSalesMonthServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path="";
		path = "/WEB-INF/views/admin/admin_Sales_month_Board.jsp";
		request.setAttribute("message", "성공");
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
