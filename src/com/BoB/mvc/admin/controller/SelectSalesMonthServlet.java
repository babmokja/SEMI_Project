package com.BoB.mvc.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/admin/sales/month")
public class SelectSalesMonthServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchValue = request.getParameter("searchValue");
		String ownerNum = request.getParameter("ownerNum");
		int intSearchValue = 1;
		int intOnwerNum = 0;
		if(searchValue != null && !"".equals(searchValue)) {
			intSearchValue = Integer.parseInt(searchValue);
			
		}
		if(ownerNum != null && !"".equals(ownerNum)) {
			intOnwerNum = Integer.parseInt(ownerNum);
			
		}
		System.out.println("개월수"+intSearchValue);
		System.out.println("유저번호"+intOnwerNum);
		
		
		
		String path="";
		path = "/WEB-INF/views/admin/admin_Sales_month_Board.jsp";
		request.setAttribute("message", "성공");
		request.setAttribute("searchValue", searchValue);
		request.setAttribute("ownerNum", ownerNum);
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
