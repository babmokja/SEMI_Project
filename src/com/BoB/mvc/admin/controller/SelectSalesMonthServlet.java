package com.BoB.mvc.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BoB.mvc.admin.dto.PageInfoDTO;
import com.BoB.mvc.admin.dto.ownerSalesDTO;
import com.BoB.mvc.admin.paging.OrderPaging;
import com.BoB.mvc.admin.service.AdminService;


@WebServlet("/admin/sales/month")
public class SelectSalesMonthServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchValue = request.getParameter("searchValue"); //null
		String ownerNum = request.getParameter("ownerNum");
		int intSearchValue = 1;
		int intOnwerNum = 0;
		String stringValue = searchValue;
		if(searchValue != null && !"".equals(searchValue)) {
			intSearchValue = Integer.parseInt(searchValue);
			if(intSearchValue<10) {
				stringValue = ("0"+intSearchValue); // 쿼리문엔 이거 넣자
			}
			
		}else {
			searchValue="1";
			stringValue="01";
		}
		if(ownerNum != null && !"".equals(ownerNum)) {
			intOnwerNum = Integer.parseInt(ownerNum);
			
		}
		System.out.println("개월수"+intSearchValue);
		System.out.println("유저번호"+intOnwerNum);
		
		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;
		
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}
		
		if(pageNo <= 0) {
			pageNo = 1;
		}
		
		AdminService adminService = new AdminService();
		int totalCount = adminService.searchMonthSalesCount(stringValue,ownerNum);
		
		System.out.println(totalCount);
		
		/* 한 페이지에 보여 줄 게시물 수 */
		int limit = 10;		//얘도 파라미터로 전달받아도 된다.
		/* 한 번에 보여질 페이징 버튼의 갯수 */
		int buttonAmount = 5;
		
		/* 페이징 처리를 위한 로직 호출 후 페이징 처리에 관한 정보를 담고 있는 인스턴스를 반환받는다. */
		PageInfoDTO pageInfo = OrderPaging.getPageInfo(pageNo, totalCount, limit, buttonAmount);
		
		List<ownerSalesDTO> salesList = adminService.searchMonthSales(pageInfo,stringValue,ownerNum);
		
		String path="";
		path = "/WEB-INF/views/admin/admin_Sales_month_Board.jsp";
		request.setAttribute("message", "성공");
		request.setAttribute("searchValue", searchValue);
		request.setAttribute("ownerNum", ownerNum);
		request.setAttribute("salesList", salesList);
		request.setAttribute("pageInfo", pageInfo);
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
