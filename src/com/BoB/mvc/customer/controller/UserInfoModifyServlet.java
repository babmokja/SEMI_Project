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
@WebServlet("/user/modify")
public class UserInfoModifyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int userCode =((UserDTO) request.getSession().getAttribute("loginUser")).getUserCode();
		
		System.out.println(userCode);
		

		UserService service = new UserService();
		UserDTO loginUser = service.selectOneById(userCode);
	    String address = loginUser.getAddress();
//	    String[] aDress = address.split("[$]");
//	    String zip = aDress[0];
//	    String addr = aDress[1];
//	    String addrr = aDress[2];
	    
//	    System.out.println("번호!"+zip+"처음주"+addr+"두번째주소!"+addrr);
	    

		String path = "/WEB-INF/views/customer/ModifyUserInfo.jsp";
		session.setAttribute("loginUser", loginUser);
//	   
//	    request.setAttribute("zip", zip);
//	    request.setAttribute("add1", addr);
//	    request.setAttribute("add2", addrr);
		request.getRequestDispatcher(path).forward(request, response);
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String phone = request.getParameter("userPhone").replace("-", "");
		String email = request.getParameter("email");
		String address = request.getParameter("zip") + "$" + request.getParameter("addr1") + "$" +request.getParameter("addr2");
		HttpSession session = request.getSession();
		int userCode =((UserDTO) request.getSession().getAttribute("loginUser")).getUserCode();		
		
		UserDTO requestUser = new UserDTO();
		requestUser.setId(id);
		requestUser.setPwd(pw);
		requestUser.setName(name);
		requestUser.setPhone(phone);
		requestUser.setEmail(email);
		requestUser.setAddress(address);
		requestUser.setUserCode(userCode);
		
		
		int result = new UserService().modifyUser(requestUser);
		
		String page = "";
         if(result > 0) {
			
			page = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "insertMember");
			
		} else {
			page = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "정보수정실패!!!!!!");
		}
		
	}

}
