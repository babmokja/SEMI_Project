package com.BoB.mvc.admin.service;

import static com.BoB.mvc.common.jdbc.JDBCTemplate.close;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.BoB.mvc.admin.dao.OrderDAO;
import com.BoB.mvc.admin.dto.PageInfoDTO;
import com.BoB.mvc.admin.dto.orderDTO;

public class AdminService {

	
	private  OrderDAO OrderDAO;
	
	public AdminService() {
		OrderDAO = new OrderDAO();
	}
	
	public int selectTotalCount() {
		
		Connection con = getConnection();
		
		int totalCount = OrderDAO.selectTotalCount(con);
		
		close(con);
		
		return totalCount;
	}

	public List<orderDTO> selectOrderList(PageInfoDTO pageInfo) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		
		List<orderDTO> orderList = OrderDAO.selectOrderList(con, pageInfo);
		
		close(con);
		
		
		return orderList;
	}
}
