package com.BoB.mvc.customer.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BoB.mvc.customer.model.dto.EmployeeDTO;
import com.BoB.mvc.customer.model.dto.UserDTO;
import com.BoB.mvc.customer.model.service.UserService;

/**
 * Servlet implementation class UserInfoModifyServlet
 */
@WebServlet("/member/user/modify")
public class UserInfoModifyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int userCode =((UserDTO) request.getSession().getAttribute("loginUser")).getUserCode();
		
		System.out.println(userCode);
		

		UserService service = new UserService();
		UserDTO loginUser = service.selectOneById(userCode);
		
		System.out.println("dsdfsf"+loginUser);
	    String address = loginUser.getAddress();
	    
	    System.out.println(address);
	    String[] aDress = address.split("[$]");
	    String zip = aDress[0];
	    System.out.println(zip);
	    String addr = aDress[1];
	    String addrr = aDress[2];
	    

	    request.setAttribute("loginUser", loginUser);

		String path = "/WEB-INF/views/customer/ModifyUserInfo.jsp";
		session.setAttribute("loginUser", loginUser);
	   
	    request.setAttribute("zip", zip);
	    request.setAttribute("add1", addr);
	    request.setAttribute("add2", addrr);
		request.getRequestDispatcher(path).forward(request, response);
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String phone = request.getParameter("userPhone").replace("-", "");
		String email = request.getParameter("email");
		String address = request.getParameter("zip") + "$" + request.getParameter("addr1") + "$" +request.getParameter("addr2");
		

		
		UserDTO requestUser = new UserDTO();
		requestUser.setId(id);
		requestUser.setPwd(pw);
		requestUser.setName(name);
		requestUser.setPhone(phone);
		requestUser.setEmail(email);
		requestUser.setAddress(address);

		
	    System.out.println(requestUser);
		int result = new UserService().modifyUser(requestUser);
		

        String path="";
         
 		if(result > 0) {
			path = "/WEB-INF/views/customer/Mypage.jsp";
			request.setAttribute("successCode", "signin");
			
		} else {
			request.setAttribute("message", "로그인 실패!");
			path= "/WEB-INF/views/customer/ModifyUserInfo.jsp";
            
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}

