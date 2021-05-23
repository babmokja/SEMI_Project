package com.BoB.mvc.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BoB.mvc.admin.service.AdminService;

@WebServlet("/admin/owner/detail")
public class SelectOwnerDetailServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ownerNum = request.getParameter("ordernum");
		int ownerNumber = 0;
		
		if(ownerNum != null && !"".equals(ownerNum)) {
			ownerNumber = Integer.parseInt(ownerNum);
			System.out.println(ownerNumber);
		}
		
		AdminService adminService = new AdminService();
		

		
		
		
		
		String path="";
		path = "/WEB-INF/views/admin/index-owner2.jsp";
		request.setAttribute("message", "성공");
		request.getRequestDispatcher(path).forward(request, response);
	}

}
