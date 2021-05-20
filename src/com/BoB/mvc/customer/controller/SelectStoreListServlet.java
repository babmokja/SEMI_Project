package com.BoB.mvc.customer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BoB.mvc.customer.model.dto.StoreListDTO;
import com.BoB.mvc.customer.model.service.StoreListService;
import com.BoB.mvc.customer.model.dto.PageInfoDTO;
import com.BoB.mvc.common.paging.PageNation;

/**
 * Servlet implementation class SelectStoreListServlet
 */
@WebServlet("/store/list")
public class SelectStoreListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		/* 전달한 파라미터 꺼내기 */
		String cate = request.getParameter("cate");
		String type = request.getParameter("type");
		String order = request.getParameter("order");
		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;
		
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}
		
		System.out.println("================================================="+pageNo);
		
		if(pageNo <= 0) {
			pageNo = 1;
		}
		
		/* 가게정보를 조회하는 비지니스 로직 호출 */
		StoreListService storelistService = new StoreListService();
		int totalCount = storelistService.selectTotalCount(cate, type);
		
		/* 한 페이지에 보여 줄 게시물 수 */
		int limit = 4;
		/* 한 번에 보여질 페이징 버튼의 수*/
		int buttonAmount = 5;
		
		/* 페이징 처리를 위한 로직 호출 후 페이징 처리에 관한 정보를 담고 있는 인스턴스를 반환받는다. */
		System.out.println("currentPage" + currentPage);
		PageInfoDTO pageInfo = PageNation.getPageInfo(pageNo, totalCount, limit, buttonAmount);
		
		/* 결과값을 반환 받자 */
		/* 반환값은 뭘로 받지???? 객체로받을까 , 리스트을받을까? 정수받을까?.... --> 내가 뭘 조회하고있지?또는 무슨작업중이지?*/
		List<StoreListDTO> selectedStore = storelistService.selectStore(cate, type, order, pageInfo);
		
		for(StoreListDTO stolist : selectedStore) {
			System.out.println(stolist);
		}
		
		/* 조회 결과 성공 여부에 따른 뷰 결정 */		
		String path = "";
		if(selectedStore != null) {
			path = "/WEB-INF/views/customer/StoreList.jsp";
			request.setAttribute("selectedStore", selectedStore);
			request.setAttribute("pageInfo", pageInfo);
			
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "식당 목록 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);

	}

}
