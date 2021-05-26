package com.BoB.mvc.owner.model.dao;

import static com.BoB.mvc.common.jdbc.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.BoB.mvc.admin.dto.PageInfoDTO;
import com.BoB.mvc.common.config.ConfigLocation;
import com.BoB.mvc.owner.model.dto.orderDTO;

public class orderDAO {
	private Properties prop = new Properties();
	
	public orderDAO() {
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION+"owner/owner-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int selectTotalCount(Connection con, int ownerNum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int totalCount = 0;
		String query = prop.getProperty("selectTotalCount");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, ownerNum);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				totalCount = rset.getInt("COUNT(*)");
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return totalCount;
		
		
	}

	public List<orderDTO> selectOrderList(Connection con, PageInfoDTO pageInfo, int ownerNum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<orderDTO> orderList = null;
		
		String query = prop.getProperty("selectOrderList");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, ownerNum);
			pstmt.setInt(2, pageInfo.getStartRow());
			pstmt.setInt(3, pageInfo.getEndRow());
			System.out.println(pageInfo.getStartRow());
			System.out.println(pageInfo.getEndRow());
			rset = pstmt.executeQuery();
			orderList = new ArrayList<>();
			
			while(rset.next()) {
				orderDTO order = new orderDTO();
				order.setOrderNum(rset.getInt("ORDER_CODE"));
				order.setCusName(rset.getString("USER_ID"));
				order.setOrderDate(rset.getDate("ORDER_TIME"));
				order.setType(rset.getString("ORDER_PROCEED"));
				order.setPrice(rset.getInt("TOTAL_AMOUNT"));
				
				orderList.add(order);
			}
			
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
			

		
		return orderList;
	}
}
