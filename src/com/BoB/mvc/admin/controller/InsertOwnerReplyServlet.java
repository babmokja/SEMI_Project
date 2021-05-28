package com.BoB.mvc.admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BoB.mvc.admin.dto.OwnerCommentBoardDTO;
import com.BoB.mvc.admin.dto.OwnerReplyManageDTO;
import com.BoB.mvc.admin.service.OwnerCommentBoardService;

@WebServlet("/admin/owner/insertReply")
public class InsertOwnerReplyServlet extends HttpServlet {
       
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	String content = request.getParameter("content");
    	int boardCode = Integer.valueOf(request.getParameter("boardCode"));
    	
    	OwnerCommentBoardService ownerCommentBoardService = new OwnerCommentBoardService();
    	
    	int result = ownerCommentBoardService.insertOwnerReply(content, boardCode);
    	
    	OwnerCommentBoardDTO ownerComment = new OwnerCommentBoardDTO();
		
		ownerComment = ownerCommentBoardService.selectOwnerComment(boardCode);
		
		List<OwnerReplyManageDTO> replyList = new ArrayList<>();
		replyList = ownerCommentBoardService.selectOwnerReply(boardCode);
		System.out.println("replyList : " + replyList);
		
		
		String path="";
		path = "/WEB-INF/views/admin/admin_Owner_SecretWrite_Board.jsp";
		request.setAttribute("ownerComment", ownerComment);
		request.setAttribute("replyList", replyList);
		request.getRequestDispatcher(path).forward(request, response);
    }

}
