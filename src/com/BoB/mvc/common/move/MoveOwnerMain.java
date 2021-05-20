package com.BoB.mvc.common.move;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MoveOwnerMain
 */
@WebServlet("/move/omain")
public class MoveOwnerMain extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String path = "/WEB-INF/views/owner/main_store.jsp";
		
		request.getRequestDispatcher(path).forward(request, response);
		
		
		
		
	}
	

}
