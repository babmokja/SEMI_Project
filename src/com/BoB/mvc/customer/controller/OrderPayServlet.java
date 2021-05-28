package com.BoB.mvc.customer.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BoB.mvc.customer.model.dto.OrderPayDTO;
import com.BoB.mvc.customer.model.service.OrderPayService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class OrderPayServlet
 */
@WebServlet("/order/pay")
public class OrderPayServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html;charset=UTF-8");
		
		String jsonString = request.getParameter("jsonString");
		
		Gson gson = new Gson();
		System.out.println(gson.toJson(jsonString));
		
		List<OrderPayDTO> list = Arrays.asList(new GsonBuilder().create().fromJson(jsonString, OrderPayDTO[].class));
		System.out.println(list);
		
		int result = 0;
		int cnt = 0;
		
		OrderPayService orderpayService = new OrderPayService();
		
		// insert
		for(int i = 0; i < list.size(); i++) {
			
			int menuCodeInsert = list.get(i).getMenuCode();   // 메뉴코드
			int amountInsert = list.get(i).getAmount();       // 수량
			int storeCodeInsert = list.get(i).getStoreCode(); // 가게코드
			int userCodeInsert = 1; 						  // 사용자 코드
			// int userCodeInsert = ((UserDTO)request.getSession().getAttribute("loginUser")).getUserCode();
			String reServeTime = list.get(i).getReServeTime(); // 요청 시간
			
			OrderPayDTO basket = new OrderPayDTO(); 
			basket.setMenuCode(menuCodeInsert);
			basket.setAmount(amountInsert); 
			basket.setStoreCode(storeCodeInsert);
			basket.setUserCode(userCodeInsert);
			 
			result = orderpayService.insertMenu(basket);
			
			cnt++;
			
		  }
		
		int userCodeSelect = 1; // 사용자 코드
		// int userCodeInsert = ((UserDTO)request.getSession().getAttribute("loginUser")).getUserCode();

		String resultStr = ""; 
		if(result > 0) { 
			if(cnt == list.size()) {
				resultStr = "success";
			} else {
				resultStr = "fail"; 
			}
		} else { 
			resultStr = "fail"; 
		}
		
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		out.print(resultStr+","+userCodeSelect);
		
		out.flush();
		out.close();
	}

}
