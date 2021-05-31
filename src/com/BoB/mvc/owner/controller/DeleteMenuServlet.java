package com.BoB.mvc.owner.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BoB.mvc.owner.model.dto.LicenseManagerDTO;
import com.BoB.mvc.owner.model.dto.OwnerDTO;
import com.BoB.mvc.owner.model.dto.ReviewBoardListDTO;
import com.BoB.mvc.owner.model.dto.StoreInfoDTO;
import com.BoB.mvc.owner.model.service.MenuListService;
import com.BoB.mvc.owner.model.service.OwnerService;

/**
 * Servlet implementation class OwnerMenuDeleteServlet
 */
@WebServlet("/menu/delete")
public class DeleteMenuServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		OwnerDTO ownerDTO = (OwnerDTO) session.getAttribute("ownerDTO");
		LicenseManagerDTO lmDTO = (LicenseManagerDTO) session.getAttribute("lmDTO");
		StoreInfoDTO storeInfoDTO = (StoreInfoDTO) session.getAttribute("storeInfoDTO");
		
		String MENUCode = request.getParameter("MENUCode");
		
		String path= "";
		System.out.println("boardCode in servlet: "+MENUCode);
		
		int deletecheck = new MenuListService().deleteMenu(MENUCode,storeInfoDTO);
		
		if(deletecheck >0) {
			path="/WEB-INF/views/owner/MenuManage.jsp";
		}else {
			request.setAttribute("message", "문의 상세글을 불러오는데 실패하셨습니다. 다시 페이지를 시작해주세요!");
			path="/WEB-INF/views/common/faild.jsp";
		}
	
		request.getRequestDispatcher(path).forward(request, response);
		
		
		
		
		
	}

}
