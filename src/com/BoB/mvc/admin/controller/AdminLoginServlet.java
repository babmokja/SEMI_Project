package com.BoB.mvc.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.BoB.mvc.admin.dto.AdminDTO;
import com.BoB.mvc.admin.service.AdminLoginService;
@WebServlet("/admin/login")
public class AdminLoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String adminId = request.getParameter("adminId");
		String adminPwd = request.getParameter("adminPwd");
		
		AdminLoginService adminservice = new AdminLoginService();

		AdminDTO loginAdmin = adminservice.loginCheck(adminId, adminPwd);
		
		String path = "";
		
		if(loginAdmin != null) {
			
			if(adminservice.selectRoleCode(adminId) == 3) {
				
				HttpSession session = request.getSession();
				session.setAttribute("loginAdmin", loginAdmin);
				request.setAttribute("message", "로그인 성공");
				path = "/WEB-INF/views/admin/main_manager.jsp";
			} else {
				
				request.setAttribute("message", "관리자가 아닙니다.");
				path = "/WEB-INF/views/common/failed.jsp";
			  }
		}
		else {
			
			request.setAttribute("message", "로그인실패");
			path = "/WEB-INF/views/common/failed.jsp";
		}
		
		request.getRequestDispatcher(path).forward(request, response);
				
	}

}
