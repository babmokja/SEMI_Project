package com.BoB.mvc.owner.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BoB.mvc.owner.model.service.OwnerService;

/**
 * Servlet implementation class IdCheckServlet
 */
@WebServlet("/owner/idCheck")
public class IdCheckServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memberId = request.getParameter("memberId");
		
		System.out.println("memberId : " + memberId);
		
		OwnerService Service = new OwnerService();
		
		String checkId = Service.IdCheck(memberId);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		System.out.println("memberId :" + memberId);
		System.out.println("checkId : " + checkId);
		
		if(memberId.equals(checkId)) { 
			
			System.out.println("request.getContextPath() : " + request.getServletPath());
			String a = "1";
			out.print(a);
			
		} else {
			out.print("2");
		}
		
		out.flush();
		out.close();
	}

}
