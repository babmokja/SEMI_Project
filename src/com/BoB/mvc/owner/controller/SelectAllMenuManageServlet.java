package com.BoB.mvc.owner.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BoB.mvc.owner.model.dto.MenuListDTO;
import com.BoB.mvc.owner.model.service.MenuListService;

/**
 * Servlet implementation class MenuManageServlet
 */
@WebServlet("/owner/menu/all")
public class SelectAllMenuManageServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<MenuListDTO> menuList = new MenuListService().selectAllMenuList();
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

}
