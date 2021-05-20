package com.BoB.mvc.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BoB.mvc.admin.dto.cartDTO;
import com.BoB.mvc.admin.dto.orderDetailDTO;
import com.BoB.mvc.admin.service.AdminService;


@WebServlet("/admin/order/detail")
public class SelectOrderDetailServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String orderNum = request.getParameter("ordernum");
		int orderNumber = 0;
		
		if(orderNum != null && !"".equals(orderNum)) {
			orderNumber = Integer.parseInt(orderNum);
			System.out.println(orderNumber);
		}
		
		AdminService adminService = new AdminService();
		
		List<cartDTO> cartList = adminService.selectCartList(orderNumber);
		List<orderDetailDTO> orderDetailList = adminService.selectOrderDetail(orderNumber);
		System.out.println(cartList);
		System.out.println(orderDetailList);
		
		String path="";
		path = "/WEB-INF/views/admin/index-order2.jsp";
		request.setAttribute("cartList", cartList);
		request.setAttribute("orderDetailList", orderDetailList);
		request.setAttribute("message", "성공");
		request.getRequestDispatcher(path).forward(request, response);
	}

}
