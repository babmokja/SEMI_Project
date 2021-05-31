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

@WebServlet("/admin/sales/today")
public class SelectSalesTodyServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String currentPage = request.getParameter("currentPage");
		String value = request.getParameter("ownerNum");
		int ownerNum = 0;
		if(value != null && !"".equals(value)) {
			ownerNum = Integer.parseInt(value);
		}
		
		int pageNo = 1;
		
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}
		
		if(pageNo <= 0) {
			pageNo = 1;
		}
		AdminService adminService = new AdminService();
		int totalCount = adminService.selectSalesTodayCount(ownerNum);
		System.out.println(totalCount);
		
		/* 한 페이지에 보여 줄 게시물 수 */
		int limit = 5;
		/* 한 번에 보여질 페이징 버튼의 수*/
		int buttonAmount = 5;
		
		PageInfoDTO pageInfo = OrderPaging.getPageInfo(pageNo, totalCount, limit, buttonAmount);
		List<ownerSalesDTO> salesList = adminService.selectSalesTodayList(pageInfo,ownerNum);
		int totalPrice = adminService.selectSalesTodayPrice(ownerNum);
		
		String path="";
		path = "/WEB-INF/views/admin/admin_Sales_day_Board.jsp";
		request.setAttribute("salesList", salesList);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("ownerNum", ownerNum);
		request.setAttribute("totalPrice", totalPrice);
		request.setAttribute("message", "성공");
		request.getRequestDispatcher(path).forward(request, response);
	}

}
