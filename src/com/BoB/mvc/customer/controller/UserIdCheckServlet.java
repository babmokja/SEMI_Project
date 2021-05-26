package com.BoB.mvc.customer.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BoB.mvc.customer.model.dao.UserDAO;
import com.BoB.mvc.customer.model.service.UserService;

/**
 * Servlet implementation class UserIdCheckServlet
 */
@WebServlet("/user/check")
public class UserIdCheckServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   response.setCharacterEncoding("UTF-8");
		   String id = request.getParameter("userId");
	     
		   System.out.println("id가져왔는지 확"+id);
	       UserService service = new UserService();
	        
	        
	       String idCheck = service.idCheck(id);
	        

	        
	        PrintWriter out = response.getWriter();
	        if(id.equals(idCheck)) { 
				
				System.out.println("request.getContextPath() : " + request.getServletPath());
				String a = "1";
				out.print(a);
				
			} else {
				out.print("2");
			}
			
			out.flush();
			out.close();

	       
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
