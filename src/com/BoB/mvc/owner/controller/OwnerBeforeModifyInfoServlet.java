package com.BoB.mvc.owner.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BoB.mvc.owner.model.dto.OwnerDTO;
import com.BoB.mvc.owner.model.dto.SelectBeforeModifyDTO;
import com.BoB.mvc.owner.model.service.OwnerService;

/**
 * Servlet implementation class OwnerModifyInfo
 */
@WebServlet("/owner/modify")
public class OwnerBeforeModifyInfoServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		OwnerDTO dto = (OwnerDTO) session.getAttribute("ownerDTO");
		
		
		if(dto==null) {
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			
			writer.println("<script> alert('로그인 후 사용 바랍니다'); location.href='${ pageContext.servletContext.contextPath }/WEB-INF/views/owner/main_store.jsp'; </script>");
			
			writer.close();

			
		} else {
			
			String id = dto.getMemberId();
			System.out.println("현재 로그인한 id는 " + dto.getMemberId());
			
			/* 사업자번호 ,이름, id */
			OwnerService ownerService = new OwnerService();
			SelectBeforeModifyDTO select = ownerService.OwnerModifyInfo(id);
			System.out.println(select);
			request.setAttribute("select", select);
		
		String path = "/WEB-INF/views/owner/Owner_ModifyInfo.jsp";
		
		request.getRequestDispatcher(path).forward(request, response);
		}
		
	}


}
