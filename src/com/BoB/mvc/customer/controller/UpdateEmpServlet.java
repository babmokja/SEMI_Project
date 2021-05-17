package com.BoB.mvc.customer.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BoB.mvc.customer.model.dto.EmployeeDTO;
import com.BoB.mvc.customer.model.service.EmployeeService;

/**
 * Servlet implementation class UpdateEmpServlet
 */
@WebServlet("/employee/update")
public class UpdateEmpServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		
		String empId = request.getParameter("empId");
		java.sql.Date ent_date = java.sql.Date.valueOf(request.getParameter("entDate"));
		
		EmployeeDTO empDTO = new EmployeeDTO();
		
		empDTO.setEmpId(empId);
		empDTO.setEntDate(ent_date);
		
		EmployeeService empService = new EmployeeService();
		
		int result = empService.updateEmp(empDTO);
		
		String path="";
		if(result > 0) {
			path = "/WEB-INF/views/common/successPage.jsp";
			request.setAttribute("result", result);
		} else {
			path = "WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("message", "업데이트 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
