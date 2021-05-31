package com.BoB.mvc.owner.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BoB.mvc.owner.model.dto.LicenseManagerDTO;
import com.BoB.mvc.owner.model.dto.MenuListDTO;
import com.BoB.mvc.owner.model.dto.OwnerDTO;
import com.BoB.mvc.owner.model.dto.StoreInfoDTO;
import com.BoB.mvc.owner.model.service.MenuListService;

/**
 * Servlet implementation class MenuManageServlet
 */
@WebServlet("/menu/all")
public class SelectAllMenuManageServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		String path ="/WEB-INF/views/owner/MenuManage.jsp";
//		
//		request.getRequestDispatcher(path).forward(request, response);
		
		
		HttpSession session = request.getSession();
		OwnerDTO dto = (OwnerDTO) session.getAttribute("ownerDTO");
		LicenseManagerDTO lmDTO = (LicenseManagerDTO) session.getAttribute("lmDTO");
		StoreInfoDTO storeInfoDTO = (StoreInfoDTO) session.getAttribute("storeInfoDTO");
		
		if(dto==null) {
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script> alert('로그인 후 사용 바랍니다'); location.href ='"+ request.getContextPath() +"/main';</script>");
			writer.close();


		} else {
		List<MenuListDTO> menuList = new MenuListService().selectAllMenuList(storeInfoDTO);
		System.out.println(menuList);
		
		String path = "";
		if(menuList !=null) {
			path="/WEB-INF/views/owner/MenuManage.jsp";
			request.setAttribute("menuList", menuList);
		}else {
			path="/WEB-INF/views/common/faild.jsp";
			request.setAttribute("message", "메뉴를 불러오는데 실패하셨습니다. 다시 페이지를 시작해주세요!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}}
