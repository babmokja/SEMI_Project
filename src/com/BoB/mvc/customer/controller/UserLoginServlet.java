package com.BoB.mvc.customer.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BoB.mvc.customer.model.dto.UserDTO;
import com.BoB.mvc.customer.model.service.UserService;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/user/login")
public class UserLoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("check");
		String path = "/WEB-INF/views/customer/Login.jsp";
		
		request.getRequestDispatcher(path).forward(request, response);
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		System.out.println(userId);
		System.out.println(userPwd);
		
		UserDTO requestUser = new UserDTO();
		requestUser.setId(userId);
		requestUser.setPwd(userPwd);
		
		UserService userService = new UserService();
		
		UserDTO loginUser = userService.loginCheck(requestUser);
		
//	    String blackYn = userService.blackCheck(requestUser);
//	    String y = "Y";
//	    String n = "N";
		
	    String path = "";
		if(loginUser != null ) {
			path = "/WEB-INF/views/customer/CustomerMain.jsp";
			request.setAttribute("successCode", "signin");
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginUser);
			
			
		}else{
			request.setAttribute("message", "");
			request.getRequestDispatcher("/WEB-INF/views/customer/Login.jsp").forward(request, response);
            
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
