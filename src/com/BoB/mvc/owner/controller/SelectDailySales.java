package com.BoB.mvc.owner.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BoB.mvc.owner.model.dto.MenuListDTO;
import com.BoB.mvc.owner.model.dto.SalesDTO;
import com.BoB.mvc.owner.model.service.MenuListService;
import com.BoB.mvc.owner.model.service.SalesService;

/**
 * Servlet implementation class SelectDailySales
 */
@WebServlet("/owner/sales/day")
public class SelectDailySales extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		String path ="/WEB-INF/views/owner/Owner_Sales_day_Board.jsp";
		
//		request.getRequestDispatcher(path).forward(request, respo
				
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
		List<SalesDTO> salesDayList = new SalesService().selectDailySales(month);
		System.out.println("salesDayList: "+salesDayList);
		
		if(salesDayList !=null) {
			System.out.println("확인");
			path="/WEB-INF/views/owner/Owner_Sales_day_Board.jsp";
			request.setAttribute("salesDayList", salesDayList);
		}else {
			path="/WEB-INF/views/common/faild.jsp";
			request.setAttribute("message", "매출을 불러오는데 실패하셨습니다. 다시 페이지를 시작해주세요!");
		}
		request.setAttribute("month", intMonth);
		System.out.println("intMonth: "+ intMonth);
		request.getRequestDispatcher(path).forward(request, response);
	}
		


}
