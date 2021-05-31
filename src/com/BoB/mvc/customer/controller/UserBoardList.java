package com.BoB.mvc.customer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BoB.mvc.admin.dto.PageInfoDTO;
import com.BoB.mvc.customer.model.dto.BoardDTO;
import com.BoB.mvc.customer.model.dto.UserDTO;
import com.BoB.mvc.customer.model.service.UserBoardService;
import com.BoB.mvc.admin.paging.OrderPaging;

/**
 * Servlet implementation class UserBoardList
 */
@WebServlet("/board/list")
public class UserBoardList extends HttpServlet {

	private static final long serialVersionUID = 8727985936554362829L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;
		
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}
		
		if(pageNo <= 0) {
			pageNo = 1;
		}

		int writerMemberNo = ((UserDTO) request.getSession().getAttribute("loginUser")).getUserCode();
		BoardDTO boardDto = new BoardDTO();
		boardDto.setWriterUserCode(writerMemberNo);
		System.out.println("찾는사람!!!!!!!!"+writerMemberNo);
		
		UserBoardService boardService = new UserBoardService();
		int totalCount =boardService.selectTotalCount(boardDto);
		
		System.out.println("totalCount 체크 : " + totalCount);
		
		/* 한 페이지에 보여 줄 게시물 수 */
		int limit = 10;
		/* 한 번에 보여질 페이징 버튼의 수*/
		int buttonAmount = 5;
		
		/* 페이징 처리를 위한 로직 호출 후 페이징 처리에 관한 정보를 담고 있는 인스턴스를 반환받는다. */
		PageInfoDTO pageInfo = OrderPaging.getPageInfo(pageNo, totalCount, limit, buttonAmount);
		
		System.out.println(pageInfo);
		
		/* 조회 해온다. */
		
        
		List<BoardDTO> boardList = boardService.selectBoardList(pageInfo,writerMemberNo);
		
		
		
		System.out.println("boardList : " + boardList);
		
		String path = "";
		if(boardList != null) {
			path = "/WEB-INF/views/customer/User_Board.jsp";
			request.setAttribute("boardList", boardList);
			request.setAttribute("pageInfo", pageInfo);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "게시물 목록 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
		
	}



}





