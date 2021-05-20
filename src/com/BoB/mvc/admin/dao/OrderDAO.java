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
import com.BoB.mvc.admin.dto.cartDTO;
import com.BoB.mvc.admin.dto.orderDTO;
import com.BoB.mvc.admin.dto.orderDetailDTO;
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
			pstmt.setInt(1, pageInfo.getStartRow());
			pstmt.setInt(2, pageInfo.getEndRow());
			System.out.println(pageInfo.getStartRow());
			System.out.println(pageInfo.getEndRow());
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

	public List<cartDTO> selectCartList(Connection con, int orderNumber) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<cartDTO> cartList = null;
		String query = prop.getProperty("selectCartList");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, orderNumber);
			rset = pstmt.executeQuery();
			
			cartList = new ArrayList<>();
			
			while(rset.next()) {
				cartDTO cart = new cartDTO();		
				cart.setMenuName(rset.getString("MENU_NAME"));
				cart.setPrice(rset.getInt("PRICE"));
				
				cartList.add(cart);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return cartList;
	}

	public List<orderDetailDTO> selectOrderDetail(Connection con, int orderNumber) {
		// TODO Auto-generated method stub
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<orderDetailDTO> orderDetailList = null;
		String query = prop.getProperty("selectOrderDetail");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, orderNumber);
			rset = pstmt.executeQuery();
			
			orderDetailList = new ArrayList<>();
			
			if(rset.next()) {
				orderDetailDTO order = new orderDetailDTO();		
				order.setCusName(rset.getString("USER_NAME"));
				order.setCusPhone(rset.getString("USER_PHONE"));
				order.setCusAddr(rset.getString("USER_ADDRESS"));
				order.setRequest(rset.getString("REQUEST"));
				order.setStoName(rset.getString("STORE_NAME"));
				order.setStoPhone(rset.getString("StoPhone"));
				order.setStoAddr(rset.getString("STORE_ADDR"));
				
				orderDetailList.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return orderDetailList;
	}

	public int searchOrderCount(Connection con, String condition, String value) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		String query = null;
		int totalCount = 0;
		
		if(condition.equals("orderNo")) {
			query = prop.getProperty("orderNoCount");
		}else if(condition.equals("cusName")) {
			query = prop.getProperty("cusNameCount");
		}else if(condition.equals("stoName")) {
			query = prop.getProperty("stoNameCount");
		}
		try {
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, value);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				totalCount = rset.getInt("COUNT(*)");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return totalCount;
	}

	public List<orderDTO> searchOrderList(Connection con, PageInfoDTO pageInfo, String condition, String value) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		String query = null;
		
		List<orderDTO> orderList = null;
		
		if(condition.equals("orderNo")) {
			query = prop.getProperty("orderNoOrder");
		}else if(condition.equals("cusName")) {
			query = prop.getProperty("cusNameOrder");
		}else if(condition.equals("stoName")) {
			query = prop.getProperty("stoNameOrder");
		}
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, value);
			pstmt.setInt(2, pageInfo.getStartRow());
			pstmt.setInt(3, pageInfo.getEndRow());
			
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
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return orderList;
	}
}
