package com.BoB.mvc.customer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BoB.mvc.customer.model.dto.UserDTO;
import com.BoB.mvc.customer.model.dto.UserOrderDTO;
import com.BoB.mvc.customer.model.service.UserService;

/**
 * Servlet implementation class UserMypage
 */
@WebServlet("/user/mypage")
public class UserMypage extends HttpServlet {


	private static final long serialVersionUID = -3812458580773390097L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
		int orderUserCode = ((UserDTO) request.getSession().getAttribute("loginUser")).getUserCode();
		UserService service = new UserService();
		UserOrderDTO orderdto = new UserOrderDTO();
		
		List<UserOrderDTO> result= service.latestOrder(orderUserCode);
		
		System.out.println(result);
		
		String path = "/WEB-INF/views/customer/Mypage.jsp";
		request.setAttribute("orderdto", result);
		
		request.getRequestDispatcher(path).forward(request, response);
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     
		
		
	}

}
