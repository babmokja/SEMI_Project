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
		
		if(loginUser != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginUser);
			
			System.out.println("request.getContextPath() : " + request.getContextPath());
			response.sendRedirect(request.getContextPath());
		} else {
			request.setAttribute("message", "로그인 실패!");
			request.getRequestDispatcher("/WEB-INF/views/common/failed.jsp").forward(request, response);
		}
		
	}

}
