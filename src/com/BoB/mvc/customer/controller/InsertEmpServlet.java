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
 * Servlet implementation class InsertEmpServlet
 */
@WebServlet("/employee/insert")
public class InsertEmpServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		
		String empName = request.getParameter("empName");
		String empNo = request.getParameter("personNumber");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String dept_code = request.getParameter("deptCode");
		String job_code = request.getParameter("jobCode");
		String sal_level = request.getParameter("salLevel");
		int salary = (Integer.parseInt(request.getParameter("salary"))) ;
		double bonus =  (Double.parseDouble(request.getParameter("bonus")));
		String manager_id = request.getParameter("managerId");
		java.sql.Date hire_date = java.sql.Date.valueOf(request.getParameter("hireDate"));
		
		EmployeeDTO empDTO = new EmployeeDTO();
		
		empDTO.setEmpName(empName);
		empDTO.setEmpNo(empNo);
		empDTO.setEmail(email);
		empDTO.setPhone(phone);
		empDTO.setDeptCode(dept_code);
		empDTO.setJobCode(job_code);
		empDTO.setSalLevel(sal_level);
		empDTO.setSalary(salary);
		empDTO.setBonus(bonus);
		empDTO.setManagerId(manager_id);
		empDTO.setHireDate(hire_date);
		
		EmployeeService empService = new EmployeeService();
		
		int pageload = empService.insertEmp(empDTO);
		
		String path="";
		if(pageload > 0) {
			path = "/WEB-INF/views/common/successPage.jsp";
			request.setAttribute("pageload", pageload);
		} else {
			path = "/WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("message", "회원 추가 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
