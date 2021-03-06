package com.BoB.mvc.owner.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BoB.mvc.owner.model.dto.LicenseManagerDTO;
import com.BoB.mvc.owner.model.dto.MenuListDTO;
import com.BoB.mvc.owner.model.dto.OwnerDTO;
import com.BoB.mvc.owner.model.dto.PageInfoDTO;
import com.BoB.mvc.owner.model.dto.SalesDTO;
import com.BoB.mvc.owner.model.dto.StoreInfoDTO;
import com.BoB.mvc.owner.model.service.MenuListService;
import com.BoB.mvc.owner.model.service.SalesService;
import com.BoB.mvc.owner.model.service.SuggestionService;
import com.BoB.mvc.owner.paging.OwnerPaging;

/**
 * Servlet implementation class SelectDailySales
 */
@WebServlet("/owner/sales/day")
public class SelectDailySales extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		String path ="/WEB-INF/views/owner/Owner_Sales_day_Board.jsp";
		
//		request.getRequestDispatcher(path).forward(request, respo
		HttpSession session = request.getSession();
		OwnerDTO dto = (OwnerDTO) session.getAttribute("ownerDTO");
		LicenseManagerDTO lmDTO = (LicenseManagerDTO) session.getAttribute("lmDTO");
		StoreInfoDTO storeDTO = (StoreInfoDTO) session.getAttribute("storeInfoDTO");
		
		/* 프론트에서 넘어져오는 값 */
		String currentPage = request.getParameter("currentPage");
		/* 맨처음 페이지 클릭했을 때 보여줄 곳 = 1페이지     설정 안할 시 null로 아무것도 안뜬다.*/
		int pageNo = 1;
		
		/* 숫자 버튼 누를시 1페이지만 이동않도록 분기처리 (빈문자열만 아니면 된다) */
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}
		
		/* 0이하 정수는 1로 처리하도록 분기처리*/
		if(pageNo <= 0) {
			pageNo = 1;
		}
		
		/* 전체 게시물 수가 필요 */
		/* 데이터베이스에서 먼저 전체 게시물 수를 조회 */
		int totalCount = new SalesService().SelectDailySalesTotalCount(storeDTO);
		
		System.out.println("totalCount 체크 : " + totalCount);
		
		/* 한 페이지에 보여 줄 게시물 수 */
		int limit = 7;
		/* 한 번에 보여질 페이징 버튼의 수*/
		int buttonAmount = 5;
		
		/* 페이징 처리를 위한 로직 호출 후 페이징 처리에 관한 정보를 담고 있는 인스턴스를 반환받는다. */
		PageInfoDTO pageInfo = OwnerPaging.getPageInfo(pageNo, totalCount, limit, buttonAmount);
		
		System.out.println(pageInfo);
		
		int intMonth = 0;
				
		String month = request.getParameter("month");
		
		if(month == null) {
			month = "0";
		}
		
		if(month != null && !month.equals("")) {
			intMonth = Integer.parseInt(month);
		}
		
		String path = "";
		System.out.println("month : " + month);
		List<SalesDTO> salesDayList = new SalesService().selectDailySales(month,pageInfo,storeDTO);
		System.out.println("salesDayList: "+salesDayList);
		
		if(salesDayList !=null) {
			System.out.println("확인");
			path="/WEB-INF/views/owner/Owner_Sales_day_Board.jsp";
			request.setAttribute("salesDayList", salesDayList);
			request.setAttribute("pageInfo", pageInfo);

		}else {
			path="/WEB-INF/views/common/faild.jsp";
			request.setAttribute("message", "매출을 불러오는데 실패하셨습니다. 다시 페이지를 시작해주세요!");
		}
		request.setAttribute("month", intMonth);
		System.out.println("intMonth: "+ intMonth);
		request.getRequestDispatcher(path).forward(request, response);
	}
		


}
