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
		String StrboardCode = request.getParameter("boardCode");
		
		System.out.println("StrboardCode = "+StrboardCode);
    	int boardCode = 0;
    	boardCode = Integer.parseInt(StrboardCode);
    	
		
    	CustomerCommentBoardService customerCommentBoardService = new CustomerCommentBoardService();
    	
    	int result= customerCommentBoardService.insertCustomerReply(content, boardCode);
    	
    	List<CustomerCommentBoardDTO> customerComment = new ArrayList<>();
    	
    	customerComment = customerCommentBoardService.selectCostomerComment(boardCode);
    	
    	List<CustomerReplyDTO> replyList = new ArrayList<>();
    	replyList = customerCommentBoardService.selectAdminComment(boardCode);
    	System.out.println(replyList);
    	
    	String path="";
    	path = "/WEB-INF/views/admin/admin_Customer_SecretWrite_Board.jsp";
    	request.setAttribute("customerComment", customerComment);
    	request.setAttribute("replyList", replyList);
    	request.getRequestDispatcher(path).forward(request, response);
    	
    	
    	
	}

}
