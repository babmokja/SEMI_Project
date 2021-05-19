package com.BoB.mvc.owner.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BoB.mvc.owner.model.dto.MenuListDTO;
import com.BoB.mvc.owner.model.service.MenuListService;

/**
 * Servlet implementation class InsertNewMenuServlet
 */
@WebServlet("/menu/new")
public class InsertNewMenuServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String path ="/WEB-INF/views/owner/MenuManage.jsp";
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String menuName = request.getParameter("menuName");
		int price = Integer.parseInt(request.getParameter("price"));
		String salesYN = request.getParameter("salesYN");
		String menuExplain = request.getParameter("menuExplain");
		
		MenuListDTO newMenu = new MenuListDTO();
		newMenu.setMenuName(menuName);
		newMenu.setPrice(price);
		newMenu.setSalesYN(salesYN);
		newMenu.setMenuExplain(menuExplain);
		
		
		MenuListService menuService = new MenuListService();
		int result = menuService.insertBoard(newMenu);
		
		String path ="";
		if(result>0) {
			path="/WEB-INF/views/owner/MenuManage.jsp";
//			request.setAttribute(name, o);
		}else{
			path="/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "메뉴등록에 실패하셨습니다! 다시 등록해주세요.");
		}
		
	}

}
