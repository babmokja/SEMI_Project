package com.BoB.mvc.owner.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BoB.mvc.owner.model.dto.OwnerDTO;

/**
 * Servlet implementation class UpdateDeliveryTime
 */
@WebServlet("/update/time")
public class UpdateDeliveryTime extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		OwnerDTO ownerDTO = (OwnerDTO) session.getAttribute("ownerDTO");
		int ownerCode = ownerDTO.getUserCode();
		
		
		System.out.println(request.getParameter("selection"));
		
		String time = request.getParameter("selection");
		
	
		
	}

}
