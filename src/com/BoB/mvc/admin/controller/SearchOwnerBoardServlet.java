package com.BoB.mvc.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BoB.mvc.admin.dto.CustomerBoardDTO;
import com.BoB.mvc.admin.dto.PageInfoDTO;
import com.BoB.mvc.admin.paging.OrderPaging;
import com.BoB.mvc.admin.service.AdminService;

/**
 * Servlet implementation class SearchOwnerBoardServlet
 */
@WebServlet("/admin/owner/board/search")
public class SearchOwnerBoardServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String condition = request.getParameter("searchCondition");
		String value = request.getParameter("searchValue");
		
		System.out.println(condition);
		System.out.println(value);
		
		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;
		
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}
		
		if(pageNo <= 0) {
			pageNo = 1;
		}
		
		AdminService adminService = new AdminService();
		int totalCount = adminService.searchBoardCount(condition, value);
	
		/* 한 페이지에 보여 줄 게시물 수 */
		int limit = 10;		//얘도 파라미터로 전달받아도 된다.
		/* 한 번에 보여질 페이징 버튼의 갯수 */
		int buttonAmount = 5;
		
		/* 페이징 처리를 위한 로직 호출 후 페이징 처리에 관한 정보를 담고 있는 인스턴스를 반환받는다. */
		PageInfoDTO pageInfo = OrderPaging.getPageInfo(pageNo, totalCount, limit, buttonAmount);
		
		System.out.println(pageInfo);
		
		List<CustomerBoardDTO> boardList = adminService.searchBoardList(condition, value, pageInfo);
		System.out.println(boardList);
		
		String path="";
		path = "/WEB-INF/views/admin/admin_Owner_Secret_Board.jsp";
		request.setAttribute("boardList", boardList);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("searchCondition", condition);
		request.setAttribute("searchValue", value);
		request.setAttribute("message", "성공");
		request.getRequestDispatcher(path).forward(request, response);
	
	}

}
