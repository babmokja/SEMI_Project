package com.BoB.mvc.owner.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BoB.mvc.admin.dto.AdminBillDTO;
import com.BoB.mvc.admin.service.OwnerFeeService;
import com.BoB.mvc.owner.model.dto.OwnerBillDTO;
import com.BoB.mvc.owner.model.dto.OwnerDTO;
import com.BoB.mvc.owner.model.service.OwnerTaxService;

/**
 * Servlet implementation class SelectOwnerTaxConfirm
 */
@WebServlet("/owner/taxconfirm")
public class SearchOwnerTaxConfirm extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		OwnerDTO ownerDTO = (OwnerDTO) session.getAttribute("ownerDTO");
		int ownerNum = ownerDTO.getUserCode();
		
		System.out.println(ownerDTO.getUserCode());
		

		int value = Integer.parseInt(request.getParameter("searchValue"));
		
	
		/* 하나만 조회 */
		List<OwnerBillDTO> oneFeeList = new OwnerTaxService().selectOneFee(value,ownerNum);
		
		String path="";
		
		path = "/WEB-INF/views/admin/AdminOwnerBill.jsp";
		request.setAttribute("oneFeeList", oneFeeList);

		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
