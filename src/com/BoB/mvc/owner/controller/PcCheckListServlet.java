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

import com.BoB.mvc.owner.model.dto.CartListDTO;
import com.BoB.mvc.owner.model.dto.DeliveryDTO;
import com.BoB.mvc.owner.model.dto.LicenseManagerDTO;
import com.BoB.mvc.owner.model.dto.OwnerDTO;
import com.BoB.mvc.owner.model.dto.StoreInfoDTO;
import com.BoB.mvc.owner.model.service.PCProcessService;

/**
 * Servlet implementation class PcCheckListServlet
 */
@WebServlet("/owner/delivery")
public class PcCheckListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		OwnerDTO ownerDTO = (OwnerDTO) session.getAttribute("ownerDTO");
		LicenseManagerDTO lmDTO = (LicenseManagerDTO) session.getAttribute("lmDTO");
		StoreInfoDTO storeDTO = (StoreInfoDTO) session.getAttribute("storeInfoDTO");
		
		if(ownerDTO==null) {
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script> alert('로그인 후 사용 바랍니다'); location.href ='"+ request.getContextPath() +"/main';</script>");
			writer.close();


		} else {
		

		int ownerCode = ownerDTO.getUserCode();

		System.out.println("현재 로그인한 id는 " + ownerDTO.getMemberId());
		
		
		if(ownerCode==0) {
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('로그인 후 이용가능합니다'); location.href='/WEB-INF/views/owner/main_store.jsp\';</script>");
			writer.close();

			
		} else {
			String path ="";
			
			List<DeliveryDTO> deliveryList = new PCProcessService().selectAllOrderProcess(ownerCode);
			List<CartListDTO> cartList = new PCProcessService().selectMenuList(ownerCode);
			System.out.println("deliveryList: "+ deliveryList);
			System.out.println("cartList: "+ cartList);
			
			
			if(deliveryList !=null) {
				
				path="/WEB-INF/views/owner/delivery.jsp";
				request.setAttribute("deliveryList", deliveryList);
				
				
				request.setAttribute("cartList", cartList);

			}else {
				path="/WEB-INF/views/common/faild.jsp";
				request.setAttribute("message", "주문진행 목록을 불러오는데 실패하셨습니다. 다시 페이지를 시작해주세요!");
			}
			
			request.getRequestDispatcher(path).forward(request, response);
			}
		}
	}}


