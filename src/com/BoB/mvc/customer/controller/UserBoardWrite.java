package com.BoB.mvc.customer.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BoB.mvc.customer.model.dto.BoardDTO;
import com.BoB.mvc.customer.model.dto.UserDTO;
import com.BoB.mvc.customer.model.service.UserBoardService;

/**
 * Servlet implementation class UserBoardWrite
 */
@WebServlet("/user/board/write")
public class UserBoardWrite extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/WEB-INF/views/customer/User_Board_Write.jsp.jsp";

		request.getRequestDispatcher(path).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String body = request.getParameter("body");
		int writerMemberNo = ((UserDTO) request.getSession().getAttribute("loginUser")).getUserCode();

		BoardDTO newBoard = new BoardDTO();
		newBoard.setTitle(title);
		newBoard.setBody(body);
		newBoard.setWriterUserCode(writerMemberNo);
		
		UserBoardService boardService = new UserBoardService();
		int result = boardService.insertBoard(newBoard);
		
		String path = "";
		if(result > 0) {
			path = "/WEB-INF/views/customer/User_Board.jsp";
			request.setAttribute("successCode", "insertBoard");
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "게시판 작성에 실패하셨습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
		
	}

}
