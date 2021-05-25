package com.BoB.mvc.owner.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BoB.mvc.owner.model.dto.MonthSalesDTO;
import com.BoB.mvc.owner.model.service.SalesService;

/**
 * Servlet implementation class SelectMonthSales
 */
@WebServlet("/owner/sales/month")
public class SelectMonthSales extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String path = "";
		
		List<MonthSalesDTO> salesMonthList = new SalesService().selectMontlySales();
		System.out.println(salesMonthList);
		
		if(salesMonthList !=null) {
			path="/WEB-INF/views/owner/Owner_Sales_month_Board.jsp";
			request.setAttribute("salesMonthList", salesMonthList);
		}else {
			path="/WEB-INF/views/common/faild.jsp";
			request.setAttribute("message", "매출을 불러오는데 실패하셨습니다. 다시 페이지를 시작해주세요!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}
		
}
