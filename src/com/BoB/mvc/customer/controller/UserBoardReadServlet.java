package com.BoB.mvc.customer.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BoB.mvc.customer.model.dto.BoardDTO;
import com.BoB.mvc.customer.model.dto.UserDTO;
import com.BoB.mvc.customer.model.service.UserBoardService;

/**
 * Servlet implementation class UserBoardReadServlet
 */
@WebServlet("/board/read")
public class UserBoardReadServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String boardNo = request.getParameter("no");
		HttpSession session = request.getSession();
		int userCode =((UserDTO) request.getSession().getAttribute("loginUser")).getUserCode();
		String userName=((UserDTO) request.getSession().getAttribute("loginUser")).getName();
		BoardDTO boardRead = new UserBoardService().readUserBoard(boardNo,userCode);
		BoardDTO commentRead = new UserBoardService().readComment(boardNo);
		System.out.println("보드넘버 받아 오는 "+boardNo);
		
		System.out.println(boardRead +"boardReadboardReadboardReadboardReadboardRead");
		System.out.println(commentRead+"dsfsdfsdfasdfdsfsadf");
		
		
		String path= "";
		
		if(boardRead != null) {
			path="/WEB-INF/views/customer/User_Board_Read.jsp";
			request.setAttribute("username", userName);
			request.setAttribute("boardRead", boardRead);
			request.setAttribute("commentRead", commentRead);
		}else {
			path="/WEB-INF/views/common/faild.jsp";
			request.setAttribute("message", "문의 상세글을 불러오는데 실패하셨습니다. 다시 페이지를 시작해주세요!");
		}
	
		request.getRequestDispatcher(path).forward(request, response);
	}

	
}
