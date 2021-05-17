package com.BoB.mvc.customer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BoB.mvc.customer.model.dto.EmployeeDTO;
import com.BoB.mvc.customer.model.service.EmployeeService;

/**
 * Servlet implementation class SelectAllEmpServlet
 */
@WebServlet("/employee/list")
public class SelectAllEmpServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmployeeService empService = new EmployeeService();
		List<EmployeeDTO> empList = empService.selectAllEmp();
		
		for(EmployeeDTO emp : empList) {
			System.out.println(emp);
		}
	
		/* 조회 결과 성공 여부에 따른 뷰 결정 */
		String path = "";
		if(empList != null) {
			path = "/WEB-INF/views/employee/employeeList.jsp";
			request.setAttribute("empList", empList);
		} else {
			path = "/WEB-INF/common/errorPage.jsp";
			request.setAttribute("message", "직원 목록 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
