package com.BoB.mvc.admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BoB.mvc.admin.dto.CustomerCommentBoardDTO;
import com.BoB.mvc.admin.dto.CustomerReplyDTO;
import com.BoB.mvc.admin.service.CustomerCommentBoardService;



@WebServlet("/admin/customer/comment")
public class InsertCustomerBoardCommentServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String boardCode = request.getParameter("boardCode");
		int intBoardCode = Integer.parseInt(boardCode);
		
		System.out.println("boardCode : "+boardCode);
		
		/* 게시글 조회 */
		
		List<CustomerCommentBoardDTO> customerList = new ArrayList<>();
		
		System.out.println("customerList : " + customerList);
		
		CustomerCommentBoardService customerCommentBoardService = new CustomerCommentBoardService();
		
		customerList = customerCommentBoardService.selectCostomerComment(intBoardCode);
		
		/* 관리자 댓글 조회 */
		

		List<CustomerReplyDTO> adminList = new ArrayList<>();
		
		adminList = customerCommentBoardService.selectAdminComment(intBoardCode);
		System.out.println(adminList);
		
		
		
		
		
		System.out.println(customerList);
		System.out.println(adminList);
		String path="";
		path = "/WEB-INF/views/admin/admin_Customer_SecretWrite_Board.jsp";
		
		request.setAttribute("customerList", customerList);
		request.setAttribute("adminList", adminList);
		request.setAttribute("intBoardCode", intBoardCode);
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
