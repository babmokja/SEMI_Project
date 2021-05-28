package com.BoB.mvc.customer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BoB.mvc.customer.model.dto.OrderPayDTO;
import com.BoB.mvc.customer.model.service.OrderPayService;

/**
 * Servlet implementation class OrderPaySelectServlet
 */
@WebServlet("/order/select")
public class OrderPaySelectServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// select
		int userCodeSelect = Integer.parseInt(request.getParameter("code")); // 사용자 코드
		// int userCodeInsert = ((UserDTO)request.getSession().getAttribute("loginUser")).getUserCode();
		
		OrderPayService orderpayService = new OrderPayService();
		
		OrderPayDTO selectPoint = orderpayService.selectPoint(userCodeSelect);
		List<OrderPayDTO> selectBasket = orderpayService.selectBasket(userCodeSelect);
		
		System.out.println("selectPoint : " + selectPoint);
		System.out.println("selectBasket : " + selectBasket);
		
		String path = ""; 
		if((selectBasket != null) && (selectPoint != null)) {
			path = "/WEB-INF/views/customer/Pay.jsp";
			request.setAttribute("selectPoint", selectPoint);
			request.setAttribute("selectBasket", selectBasket); 
		} else {
			path = "/WEB-INF/views/common/customer/failed.jsp";
			request.setAttribute("message", "주문 내역 확인 페이지를 담을 수 없습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}
}
