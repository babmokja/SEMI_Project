package com.BoB.mvc.owner.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertNewMenuServlet
 */
@WebServlet("/menu/insert")
public class InsertNewMenuServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String path ="/WEB-INF/views/owner/MenuManage.jsp";
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String menuName = request.getParameter("menuName");
		int price = Integer.parseInt(request.getParameter("price"));
		String salesYN = request.getParameter("salesYN");
		String menuExplain = request.getParameter("menuExplain");
		
		
	}

}
