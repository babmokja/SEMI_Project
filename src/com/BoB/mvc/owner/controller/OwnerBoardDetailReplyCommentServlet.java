package com.BoB.mvc.owner.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BoB.mvc.owner.model.dto.ReviewBoardListDTO;
import com.BoB.mvc.owner.model.service.OwnerService;

/**
 * Servlet implementation class OwnerBoardDetailReplyCommentServlet
 */
@WebServlet("/owner/detailreplycomment")
public class OwnerBoardDetailReplyCommentServlet extends HttpServlet {
	
	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		int no = Integer.parseInt(request.getParameter("no"));
//		
//		OwnerService Service = new OwnerService();
//		ReviewBoardListDTO reviewDetail = Service.selectNoticeDetail(no);
//		
//		System.out.println("reviewDetail : " + reviewDetail);
//		
//		String path = "";
//		if(reviewDetail != null) {
//			path = "/WEB-INF/views/owner/Owner_Comment_Write_Board.jsp";
//			request.setAttribute("review", reviewDetail);
//		} else {
//			path = "/WEB-INF/views/common/failed.jsp";
//			request.setAttribute("message", "공지사항 상세 보기 조회에 실패하였습니다.");
//		}
//		
//		request.getRequestDispatcher(path).forward(request, response);
//	}


		

}
