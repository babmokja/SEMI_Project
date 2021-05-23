package com.BoB.mvc.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BoB.mvc.admin.dto.CustomerBoardDTO;
import com.BoB.mvc.admin.service.CustomerBoardService;


@WebServlet("/admin/customer/board")
public class SelectCustomerBoardServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CustomerBoardService customerBoardService = new CustomerBoardService();
		
		List<CustomerBoardDTO> customerBoardList = customerBoardService.selectCustomerBoardList();
		
		System.out.println(customerBoardList);
		
		
		
		
		
		String path="";
		path = "/WEB-INF/views/admin/admin_Customer_Secret_Board.jsp";
		request.setAttribute("customerBoardList", customerBoardList);
		request.getRequestDispatcher(path).forward(request, response);
	}

}
