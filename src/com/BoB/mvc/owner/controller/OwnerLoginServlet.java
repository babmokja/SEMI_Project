package com.BoB.mvc.owner.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BoB.mvc.owner.model.dto.OwnerDTO;
import com.BoB.mvc.owner.model.service.OwnerService;

/**
 * Servlet implementation class OwnerLoginServlet
 */
@WebServlet("/member/owner/login")
public class OwnerLoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memberId = request.getParameter("memberId");
		String pw = request.getParameter("pw");
		
		System.out.println("memberId : " + memberId);
		System.out.println("memberPwd : " + pw);
		
		OwnerDTO requestMember = new OwnerDTO();
		requestMember.setMemberId(memberId);
		requestMember.setMemberPwd(pw);
		
		OwnerService ownerService = new OwnerService();
		
		OwnerDTO loginMember = ownerService.loginCheck(requestMember);
		System.out.println(loginMember);
		if(loginMember != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", loginMember);
			
			System.out.println("request.getContextPath() : " + request.getContextPath());
			response.sendRedirect(request.getContextPath());
		} else {
			request.setAttribute("message", "로그인 실패!");
			request.getRequestDispatcher("/WEB-INF/views/common/failed.jsp").forward(request, response);
		}
	}

}
