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
import com.BoB.mvc.admin.service.AdminService;
@WebServlet("/admin/login")
public class AdminLoginServlet extends HttpServlet {
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String adminId = request.getParameter("adminId");
		String adminPwd = request.getParameter("adminPwd");
		
		System.out.println(adminId);
		System.out.println(adminPwd);
		
		AdminDTO adminmember = new AdminDTO();
		
		adminmember.setId(adminId);
		adminmember.setPwd(adminPwd);
		
		AdminLoginService adminservice = new AdminLoginService();
		
		int roleCode = adminservice.selectRoleCode(adminId);
		
		if(roleCode == 3) {			
			AdminDTO loginAdmin = adminservice.loginCheck(adminmember);
			
			if(loginAdmin != null) {
				HttpSession session = request.getSession();
				session.setAttribute("loginAdmin", loginAdmin);
					
				System.out.println("로그인 성공");
				System.out.println("request.getContextPath() : " + request.getContextPath());
				response.sendRedirect(request.getContextPath());
				
			} else {
				
				request.setAttribute("message", "로그인 실패");
				request.getRequestDispatcher("/WEB-INF/views/common/failed.jsp").forward(request, response);
			}
			
		} else {
			
			request.setAttribute("message", "관리자가 아닙니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/failed.jsp").forward(request, response);
		}
		
	
				
	}

}
