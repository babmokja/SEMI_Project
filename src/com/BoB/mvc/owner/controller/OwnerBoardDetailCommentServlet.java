package com.BoB.mvc.owner.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BoB.mvc.owner.model.dto.ReviewBoardListDTO;
import com.BoB.mvc.owner.model.dto.SuggestionDTO;
import com.BoB.mvc.owner.model.service.OwnerService;
import com.BoB.mvc.owner.model.service.SuggestionService;

/**
 * Servlet implementation class OwnerBoardDetailReplyCommentServlet
 */
@WebServlet("/owner/detailcomment")
public class OwnerBoardDetailCommentServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
		String boardNo = request.getParameter("boardCode");
		
		String path= "";
		System.out.println("boardCode in servlet: "+boardNo);
		
		ReviewBoardListDTO commentDetail = new OwnerService().selectCommentDetail(boardNo);
		
		if(commentDetail != null) {
			request.setAttribute("commentDetail", commentDetail);
			path="/WEB-INF/views/owner/Owner_Comment_Write_Board.jsp";
		}else {
			request.setAttribute("message", "문의 상세글을 불러오는데 실패하셨습니다. 다시 페이지를 시작해주세요!");
			path="/WEB-INF/views/common/faild.jsp";
		}
	
		request.getRequestDispatcher(path).forward(request, response);
		
	}


		

}
