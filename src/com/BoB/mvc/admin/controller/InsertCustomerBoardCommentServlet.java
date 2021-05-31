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
		
		CustomerCommentBoardDTO customercomment = new CustomerCommentBoardDTO();
		
		CustomerCommentBoardService customerCommentBoardService = new CustomerCommentBoardService();
		
		customercomment = customerCommentBoardService.selectOwnerComment(intBoardCode);
		
		
		System.out.println("customercomment : " + customercomment);

		/* 관리자 댓글 조회 */
		
		List<CustomerReplyDTO> replyList = new ArrayList<>();
		replyList = customerCommentBoardService.selectCustomerReply(intBoardCode);
		
		System.out.println("replyList : " + replyList);
		
		String path="";
		path = "/WEB-INF/views/admin/admin_Customer_SecretWrite_Board.jsp";
		
		request.setAttribute("customercomment", customercomment);
		request.setAttribute("replyList", replyList);
		
		request.setAttribute("intBoardCode", intBoardCode);
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
