package com.BoB.mvc.owner.move;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MoveSuggest
 */
@WebServlet("/owner/move/suggest")
public class MoveSuggest extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/owner/Owner_Seggestion_Board.jsp";
		
		request.getRequestDispatcher(path).forward(request, response);
		
		
		
	}

}
