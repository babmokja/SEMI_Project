package com.BoB.mvc.owner.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BoB.mvc.admin.dto.PageInfoDTO;
import com.BoB.mvc.admin.dto.orderDTO2;
import com.BoB.mvc.admin.paging.OrderPaging;
import com.BoB.mvc.admin.service.AdminService;
import com.BoB.mvc.owner.model.dto.OwnerDTO;

/**
 * Servlet implementation class SelectOrderConfirmInfo
 */
@WebServlet("/order/confirm")
public class SelectOrderConfirmInfo extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		OwnerDTO ownerDTO = (OwnerDTO) session.getAttribute("ownerDTO");
		int ownerNum = ownerDTO.getUserCode();
		
		System.out.println(ownerDTO.getUserCode());
		
		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;
		
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}
		
		if(pageNo <= 0) {
			pageNo = 1;
		}
		
		AdminService ownerService = new AdminService();
		
		int totalCount = ownerService.selectOrderCount2(ownerNum);
		
		System.out.println(totalCount);
		/* 한 페이지에 보여 줄 게시물 수 */
		int limit = 10;
		/* 한 번에 보여질 페이징 버튼의 수*/
		int buttonAmount = 5;
		PageInfoDTO pageInfo = OrderPaging.getPageInfo(pageNo, totalCount, limit, buttonAmount);
		
		List<orderDTO2> orderList = ownerService.selectOrderList2(pageInfo,ownerNum);
		
		System.out.println(orderList);
		String path="";
		path = "/WEB-INF/views/owner/OrderConfirm.jsp";
		request.setAttribute("orderList", orderList);
		request.setAttribute("pageInfo", pageInfo);
		//request.setAttribute("message", "성공");
		
		//session.setAttribute("orderList", orderList);
		//request.setAttribute("pageInfo", pageInfo);
		request.getRequestDispatcher(path).forward(request, response);
		
		
		
	}

}
