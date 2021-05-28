package com.BoB.mvc.owner.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import com.BoB.mvc.owner.model.dto.SuggestionDTO;
import com.BoB.mvc.owner.model.service.SuggestionService;

/**
 * Servlet implementation class SelectSuggestionDetail
 */
@WebServlet("/suggestion/detail")
public class SelectSuggestionDetail extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String boardNo = request.getParameter("boardCode");
		
		String path= "";
		System.out.println("boardCode in servlet: "+boardNo);
		
		SuggestionDTO suggestionDetail = new SuggestionService().selectDetailSuggestion(boardNo);
		
		if(suggestionDetail != null) {
			request.setAttribute("suggestionDetail", suggestionDetail);
			path="/WEB-INF/views/owner/Owner_Suggestion_Board_Detail.jsp";
		}else {
			request.setAttribute("message", "문의 상세글을 불러오는데 실패하셨습니다. 다시 페이지를 시작해주세요!");
			path="/WEB-INF/views/common/faild.jsp";
		}
	
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
