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

@WebServlet("/admin/owner/comment")
public class InsertOwnerBoardCommentServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String boardCode = request.getParameter("boardCode");
		int intBoardCode = Integer.parseInt(boardCode);
		
		
		/* 게시글 조회 */
		
		OwnerCommentBoardDTO ownerComment = new OwnerCommentBoardDTO();
		
		OwnerCommentBoardService ownerCommentBoardService = new OwnerCommentBoardService();
		
		ownerComment = ownerCommentBoardService.selectOwnerComment(intBoardCode);
		
		
		/* 관리자 댓글 조회 */
		
		List<OwnerReplyManageDTO> replyList = new ArrayList<>();
		replyList = ownerCommentBoardService.selectOwnerReply(intBoardCode);
		System.out.println(replyList);
		
		
		String path="";
		path = "/WEB-INF/views/admin/admin_Owner_SecretWrite_Board.jsp";
		request.setAttribute("ownerComment", ownerComment);
		request.setAttribute("replyList", replyList);
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
