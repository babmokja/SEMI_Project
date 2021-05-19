package com.BoB.mvc.admin.dao;

import static com.BoB.mvc.common.jdbc.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.BoB.mvc.admin.dto.PageInfoDTO;
import com.BoB.mvc.admin.dto.orderDTO;
import com.BoB.mvc.common.config.ConfigLocation;

public class OrderDAO {
	private Properties prop;
	
	public OrderDAO() {
		prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "admin/admin-mapper.xml"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public int selectTotalCount(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		
		int totalCount = 0;
		
		String query = prop.getProperty("selectTotalCount");

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				totalCount = rset.getInt("COUNT(*)");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return totalCount;
	}

	public List<orderDTO> selectOrderList(Connection con, PageInfoDTO pageInfo) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<orderDTO> orderList = null;
		
		String query = prop.getProperty("selectOrderList1");

		if(query != null) {
			System.out.println(query);
		}
		try {
			pstmt = con.prepareStatement(query);

		
			rset = pstmt.executeQuery();
			
			orderList = new ArrayList<>();
			
			while(rset.next()) {
				orderDTO order = new orderDTO();
				
				
				order.setOrderNum(rset.getInt("ORDER_CODE"));
				order.setCusName(rset.getString("USER_NAME"));
				order.setStoName(rset.getString("STORE_NAME"));
				order.setOrDate(rset.getDate("ORDER_TIME"));
				order.setPrice(rset.getInt("TOTAL_AMOUNT"));
				order.setCusPhone(rset.getString("USER_PHONE"));	
				order.setStoPhone(rset.getString("StoPhone"));


				

				
				orderList.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return orderList;
	}
}
