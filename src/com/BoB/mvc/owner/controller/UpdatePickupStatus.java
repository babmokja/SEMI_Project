package com.BoB.mvc.owner.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BoB.mvc.owner.model.dto.OwnerDTO;
import com.BoB.mvc.owner.model.dto.StoreInfoDTO;
import com.BoB.mvc.owner.model.service.PCProcessService;

/**
 * Servlet implementation class UpdatePickupStatus
 */
@WebServlet("/update/pickup")
public class UpdatePickupStatus extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		OwnerDTO ownerDTO = (OwnerDTO) session.getAttribute("ownerDTO");
		StoreInfoDTO storeInfoDTO = (StoreInfoDTO) session.getAttribute("storeInfoDTO");
		int ownerCode = ownerDTO.getUserCode();
		int storeCode = storeInfoDTO.getStoreCode();
		
		
		String respon = request.getParameter("selection");
		String deny = request.getParameter("result");
		String complete = request.getParameter("complete");
		
		String path ="";
		String accept = "";
		
		if(respon != null) {
			if(respon.equals("네")) {
				
				accept = "30분 정도 후 픽업 가능하십니다.";
				
			}
		}
			
		PCProcessService pcService = new PCProcessService();
		if(!accept.equals("")) {
			
			int orderCode = Integer.parseInt(request.getParameter("code"));
			System.out.println("code: "+orderCode);
			
			int result = pcService.updateOnwerpickupComment(ownerCode,orderCode,accept);
			
			if(result>0) {
			    path = "/WEB-INF/views/owner/delivery.jsp";
				}
		}else if(deny != null) {
			
			int orderCode = Integer.parseInt(request.getParameter("code1"));
			System.out.println("code1:" +orderCode);
			int result1 = pcService.updateOnwerDenyComment(ownerCode,orderCode,deny);
			
			if(result1>0) {
			    path = "/WEB-INF/views/owner/delivery.jsp";
				}
			
/*			request.getRequestDispatcher(path).forward(request, response);*/
		}else if(complete !=null){
			int orderCode = Integer.parseInt(request.getParameter("code2"));
			
			System.out.println("code2: "+orderCode);
			int result2 = pcService.updateOwnerCompleteComment(ownerCode,orderCode,complete);
		
		}else {
					int orderCode = Integer.parseInt(request.getParameter("code3"));
					String userId = request.getParameter("userId");
					System.out.println("blackList" +orderCode);
					System.out.println("userId: "+orderCode);
			int result3 = pcService.insertUserBlackList(ownerCode,orderCode,userId,storeCode);
		}
	
		response.sendRedirect(request.getContextPath()+"/owner/pick_up");
	}

}
