package com.BoB.mvc.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BoB.mvc.admin.dto.AdminDTO;
import com.BoB.mvc.admin.service.AdminLoginService;
@WebServlet("/admin/login")
public class AdminLoginServlet extends HttpServlet {
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String adminId = request.getParameter("adminId");
		String adminPwd = request.getParameter("adminPwd");
		
		
		AdminDTO adminmember = new AdminDTO();
		
		
		AdminLoginService adminservice = new AdminLoginService();
		
		int roleCode = adminservice.selectRoleCode(adminId);
		
		
		if(adminId.equals("admin")  && adminPwd.equals("admin")) {
			
			if(roleCode == 3) {
				AdminDTO loginAdmin = adminservice.loginCheck(adminId,adminPwd);
	
				HttpSession session = request.getSession();
				session.setAttribute("loginAdmin", loginAdmin);
				
				
				System.out.println("request.getContextPath() : " + request.getContextPath());
				response.sendRedirect(request.getContextPath());
				
				
			} else {
				
				System.out.println("관리자가 아님");
				
			  }
		}
		else {
			request.setAttribute("message", "로그인실패");
			request.getRequestDispatcher("/WEB-INF/views/common/failed.jsp").forward(request, response);
		}
		
		
			
	
				
	}

}
