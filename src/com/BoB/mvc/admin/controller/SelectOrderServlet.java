package com.BoB.mvc.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BoB.mvc.admin.service.AdminService;

@WebServlet("/admin/order")
public class SelectOrderServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
	//	String currentPage = request.getParameter("currentPage");
	//	int pageNo = 1;
		
	//	if(currentPage != null && !"".equals(currentPage)) {
	//		pageNo = Integer.parseInt(currentPage);
	//	}
		
	//	if(pageNo <= 0) {
	//		pageNo = 1;
	//	}
		AdminService adminService = new AdminService();
		int totalCount = adminService.selectTotalCount();
		
		System.out.println(totalCount);
		
		String path="";
		path = "/WEB-INF/views/admin/index-order.jsp";
		request.setAttribute("message", "성공");
		request.getRequestDispatcher(path).forward(request, response);
	}

}
