package com.BoB.mvc.admin.service;

import static com.BoB.mvc.common.jdbc.JDBCTemplate.close;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.getConnection;

import java.sql.Connection;

import com.BoB.mvc.admin.dao.OrderDAO;

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
}
