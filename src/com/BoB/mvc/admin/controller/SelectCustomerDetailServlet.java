package com.BoB.mvc.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BoB.mvc.admin.dto.UserDetailDTO;
import com.BoB.mvc.admin.service.AdminService;

@WebServlet("/admin/customer/detail")
public class SelectCustomerDetailServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userNum = request.getParameter("userNum");
		int userNumber = 0;
		
		if(userNum != null && !"".equals(userNum)) {
			userNumber = Integer.parseInt(userNum);
			System.out.println(userNumber);
		}
		
		AdminService adminService = new AdminService();
		List<UserDetailDTO> userDetail = adminService.selectUserDetail(userNumber);
		System.out.println(userDetail);
		String path="";
		path = "/WEB-INF/views/admin/index-user2.jsp";
		request.setAttribute("userDetail", userDetail);
		request.setAttribute("message", "성공");
		request.getRequestDispatcher(path).forward(request, response);
	}

}
