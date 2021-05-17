package com.BoB.mvc.owner.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BoB.mvc.owner.model.dto.MemberDTO;
import com.BoB.mvc.owner.model.dto.StoreInfoDTO;

/**
 * Servlet implementation class OwnerRegistServlet
 */
@WebServlet("/owner/regist")
public class OwnerRegistServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/owner/signin_owner.jsp";
		
		request.getRequestDispatcher(path).forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memberId = request.getParameter("memberId");
		String memberPwd = request.getParameter("pw");
		String nickname = request.getParameter("name");
		String phone = request.getParameter("phone").replace("-","");
		
		
		MemberDTO requestMember = new MemberDTO();
		
		String storeName = request.getParameter("storeName");
		String storeNum = request.getParameter("storeNum");
		String address = request.getParameter("zip") + "$" + request.getParameter("addr1") + "$"
				         + request.getParameter("addr2");
		String kind = request.getParameter("kind");
		String bussinessNum = request.getParameter("bussinessNum");
		String service = request.getParameter("service");
		
		StoreInfoDTO requestStore = new StoreInfoDTO();
//		requestMember
				
		
		
//		int result = new MemberService().registMember(requestMember);

		
	}

}
