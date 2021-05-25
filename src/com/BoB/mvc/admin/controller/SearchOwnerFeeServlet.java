package com.BoB.mvc.admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BoB.mvc.admin.dto.AdminBillDTO;
import com.BoB.mvc.admin.service.OwnerFeeService;

/**
 * Servlet implementation class SearchOwnerFeeServlet
 */
@WebServlet("/admin/fee/search")
public class SearchOwnerFeeServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String month = request.getParameter("month-input");
		int value = Integer.parseInt(request.getParameter("searchValue"));
		
		System.out.println(month);
		System.out.println(value);
		
		List<AdminBillDTO> OwnerFeeList = new ArrayList<>();
		
		OwnerFeeService ownerFeeService = new OwnerFeeService();
		
		OwnerFeeList = ownerFeeService.selectFeeList(month,value);
		
		
		System.out.println("OwnerFeeList : " + OwnerFeeList);
		String path="";
		
		path = "/WEB-INF/views/admin/AdminOwnerBill.jsp";
		request.setAttribute("OwnerFeeList", OwnerFeeList);
		

		request.getRequestDispatcher(path).forward(request, response);
	}

}
