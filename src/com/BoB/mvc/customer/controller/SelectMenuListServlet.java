package com.BoB.mvc.customer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BoB.mvc.customer.model.dto.MenuListDTO;
import com.BoB.mvc.customer.model.service.MenuListService;

/**
 * Servlet implementation class SelectMenuListServlet
 */
@WebServlet("/menu/list")
public class SelectMenuListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		  int storeId = Integer.parseInt(request.getParameter("storeId"));
		  
		  MenuListService menulistService = new MenuListService();
		  
		  List<MenuListDTO> selectMenu = menulistService.selectMenuById(storeId);
		  
		  String path = "";
		  if((selectMenu != null)) { 
			  path = "/WEB-INF/views/customer/MenuDetail.jsp";
			  request.setAttribute("selectMenu", selectMenu);
			  request.setAttribute("storeId", selectMenu.get(0).getStoreId()); 
		  } else { 
			  path = "/WEB-INF/views/common/customer/failed.jsp";
			  request.setAttribute("message", "메뉴 상세 정보를 조회할 수 없습니다."); 
		  }
		  
		  request.getRequestDispatcher(path).forward(request, response);
	}

}
