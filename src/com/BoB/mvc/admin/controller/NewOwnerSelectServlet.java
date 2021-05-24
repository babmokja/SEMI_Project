package com.BoB.mvc.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BoB.mvc.admin.dto.OwnerDetailDTO;
import com.BoB.mvc.admin.service.AdminService;

/**
 * Servlet implementation class NewOwnerSelectServlet
 */
@WebServlet("/admin/new/detail/select")
public class NewOwnerSelectServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result = request.getParameter("result");
		String ownerNum = request.getParameter("ownerNum");
		int ownerInt = Integer.parseInt(ownerNum);
		System.out.println(result);
		System.out.println(ownerNum);
		
		AdminService adminservice = new AdminService();
		
		adminservice.updateAppr(result,ownerNum);
		List<OwnerDetailDTO> ownerDetail = adminservice.selectOwnerDetail(ownerInt);
		
		
		String path="";
		path = "/WEB-INF/views/admin/index-owner-new-detail.jsp";
		request.setAttribute("ownerDetail", ownerDetail);
		request.getRequestDispatcher(path).forward(request, response);
	}

}
