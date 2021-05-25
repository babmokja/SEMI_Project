package com.BoB.mvc.owner.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BoB.mvc.owner.model.dto.LicenseManagerDTO;
import com.BoB.mvc.owner.model.dto.OwnerDTO;
import com.BoB.mvc.owner.model.dto.StoreInfoDTO;
import com.BoB.mvc.owner.model.service.OwnerService;

/**
 * Servlet implementation class OwnerLoginServlet
 */
@WebServlet("/owner/login")
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
		
//		OwnerDTO loginMember = ownerService.loginCheck(requestMember);
		Map<String, Object> loginmap = new HashMap<String, Object>();
		loginmap = ownerService.loginCheck(requestMember);
		
		OwnerDTO ownerDTO = (OwnerDTO) loginmap.get("loginMember");
		LicenseManagerDTO lmDTO = (LicenseManagerDTO) loginmap.get("loginLManager");
		StoreInfoDTO storeInfoDTO = (StoreInfoDTO) loginmap.get("loginStore");
		
		System.out.println(loginmap);
		
		if(loginmap != null) {
			
			HttpSession session = request.getSession();
			session.setAttribute("ownerDTO", ownerDTO);
			session.setAttribute("lmDTO", lmDTO);
			session.setAttribute("storeInfoDTO", storeInfoDTO);
			
			System.out.println("request.getContextPath() : " + request.getContextPath());
			response.sendRedirect(request.getContextPath());
			
		} else {
			request.setAttribute("message", "로그인 실패!");
			request.getRequestDispatcher("/WEB-INF/views/common/failed.jsp").forward(request, response);
		}
	}

}
