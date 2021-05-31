package com.BoB.mvc.owner.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BoB.mvc.owner.model.dto.DeliveryDTO;
import com.BoB.mvc.owner.model.dto.OwnerDTO;
import com.BoB.mvc.owner.model.service.PCProcessService;

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
		String deny = request.getParameter("result");
		String complete = request.getParameter("complete");
		
		
		System.out.println("deny: "+deny);
		System.out.println("complete: "+complete);
		
		String comment = "";
		
		if(time != null) {
		if(time.equals("30 분 ~ 40 분")) {
			
			comment = "배달완료까지 30~40분 소요 예정입니다.";
			
		}else if(time.equals("40 분 ~ 50 분")) {
			
			comment = "배달완료까지 40~50분 소요 예정입니다.";
			
		}else {
			
			comment = "배달완료까지 50~60분 소요 예정입니다.";
		}
		}
//		DeliveryDTO deliveryDTO = new DeliveryDTO();
//		deliveryDTO.setOwnerComment(comment);
		

		String path="";
		
		PCProcessService pcService = new PCProcessService();
		
		if(!comment.equals("")) {
			
			int orderCode = Integer.parseInt(request.getParameter("code"));
			System.out.println("code: "+orderCode);
			
			int result = pcService.updateOnwerComment(ownerCode,orderCode,comment);
			
			if(result>0) {
			    path = "/WEB-INF/views/owner/delivery.jsp";
				}
/*			request.getRequestDispatcher(path).forward(request, response);*/
			
		}else if(deny != null) {
			
			int orderCode = Integer.parseInt(request.getParameter("code1"));
			System.out.println("code1:" +orderCode);
			int result1 = pcService.updateOnwerDenyComment(ownerCode,orderCode,deny);
			
			if(result1>0) {
			    path = "/WEB-INF/views/owner/delivery.jsp";
				}
			
/*			request.getRequestDispatcher(path).forward(request, response);*/
		}else{
			
			int orderCode = Integer.parseInt(request.getParameter("code2"));
			System.out.println("code2: "+orderCode);
			int result2 = pcService.updateOwnerCompleteComment(ownerCode,orderCode,complete);
				if(result2>0) {
				    path = "/WEB-INF/views/owner/delivery.jsp";
					}
/*			request.getRequestDispatcher(path).forward(request, response);*/
		}
		response.sendRedirect(request.getContextPath()+"/owner/delivery");
			
		
	
	
		
	}

}
