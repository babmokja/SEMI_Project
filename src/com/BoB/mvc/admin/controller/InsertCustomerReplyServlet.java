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


@WebServlet("/admin/customer/insertReply")
public class InsertCustomerReplyServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String content = request.getParameter("content");
		int boardCode = Integer.valueOf(request.getParameter("boardCode"));
		
    	
    	CustomerCommentBoardService customerCommentBoardService = new CustomerCommentBoardService();
    	
    	
    	/*1*/
    	CustomerCommentBoardDTO customerComment = new CustomerCommentBoardDTO();
    	customerComment = customerCommentBoardService.selectOwnerComment(boardCode);
    	
    	/*2*/
    	List<CustomerReplyDTO> replyList = new ArrayList<>();
    	replyList = customerCommentBoardService.selectCustomerReply(boardCode);
    	System.out.println("replyList : " + replyList);
    	
    	/*3*/
    	int result= customerCommentBoardService.insertCustomerReply(content, boardCode);
    	
    	System.out.println("result" + result);
    	
    	String path="";
    	path = "/WEB-INF/views/admin/admin_Customer_SecretWrite_Board.jsp";
		
		  request.setAttribute("customerComment", customerComment);
		  request.setAttribute("replyList", replyList);
		
    	request.getRequestDispatcher(path).forward(request, response);
    	
    	
    	
	}

}
