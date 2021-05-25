package com.BoB.mvc.owner.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BoB.mvc.owner.model.dto.MonthSalesDTO;
import com.BoB.mvc.owner.model.service.SalesService;

/**
 * Servlet implementation class GoToMain
 */
@WebServlet("/main")
public class GoToMain extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/WEB-INF/views/owner/main_store.jsp";
		
		request.getRequestDispatcher(path).forward(request, response);
/*		response.sendRedirect(request.getContextPath()+"/owner/main_store.jsp");*/

	}

}
