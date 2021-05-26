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
 * Servlet implementation class UserRegistServlet
 */
@WebServlet("/member/user/signin")
public class UserRegistServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String path = "/WEB-INF/views/customer/SigninUser.jsp";
		
		request.getRequestDispatcher(path).forward(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		String userNo = request.getParameter("userNo").replace("-", "");
		String Phone = request.getParameter("userPhone").replace("-", "");
		String Email = request.getParameter("userEmail");
		String address = request.getParameter("zip") + "$" + request.getParameter("addr1") + "$" +request.getParameter("addr2");
		
		UserDTO requestUser = new UserDTO();
		
		requestUser.setId(userId);
		requestUser.setPwd(userPwd);
		requestUser.setName(userName);
		requestUser.setUserNo(userNo);
		requestUser.setPhone(Phone);
		requestUser.setEmail(Email);
		requestUser.setAddress(address);
		
		System.out.println(requestUser);

		int result = new UserService().registUser(requestUser);
		String path="";
		if(result > 0) {
			path = "/WEB-INF/views/customer/CustomerMain.jsp";
			request.setAttribute("successCode", "insertBoard");
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "회원가입 실패하셨습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);

		
	}

}
