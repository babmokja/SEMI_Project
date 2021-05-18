package com.BoB.mvc.owner.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BoB.mvc.owner.model.dto.OwnerDTO;
import com.BoB.mvc.owner.model.dto.StoreInfoDTO;
import com.BoB.mvc.owner.model.service.OwnerService;

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
		
		request.setCharacterEncoding("UTF-8");
		
		String memberId = request.getParameter("memberId");
		String memberPwd = request.getParameter("pw");
		String nickname = request.getParameter("name");
		String phone = request.getParameter("phone").replace("-","");
		String email = request.getParameter("email");
		String residentNum = request.getParameter("residentNum");
		
		OwnerDTO requestOwner = new OwnerDTO();
		
		
//		-------------------------------
		
		String storeName = request.getParameter("storeName");
		String storeNum = request.getParameter("storeNum");
		String address = request.getParameter("zip") + "$" + request.getParameter("addr1") + "$"
				         + request.getParameter("addr2");
		String category = request.getParameter("category");
		String bussinessNum = request.getParameter("bussinessNum");
		String service = request.getParameter("service");
		java.sql.Date start_date = java.sql.Date.valueOf(request.getParameter("startDate"));
		
		StoreInfoDTO requestStore = new StoreInfoDTO();
//		requestMember
				
		OwnerService ownerService = new OwnerService();
		
		int result = ownerService.registOwner(requestOwner, requestStore);

		
		System.out.println("memberController result : " + result);
		
		String page = "";
		
		page = "/WEB-INF/views/common/success.jsp";
		
//		if(result > 0) {
//			
//			page = "/WEB-INF/views/common/success.jsp";
//			request.setAttribute("successCode", "insertMember");
//			
//		} else {
//			page = "/WEB-INF/views/common/failed.jsp";
//			request.setAttribute("message", "회원 가입 실패!");
//		}
		
		request.getRequestDispatcher(page).forward(request, response);
		
		
	}

}
