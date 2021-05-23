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
import com.BoB.mvc.admin.dto.ownerDTO;
import com.BoB.mvc.common.config.ConfigLocation;

public class OwnerDAO {
	private Properties prop;
	
	public OwnerDAO() {
		prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "admin/admin-mapper.xml"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public int selectOwnerTotalCount(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		
		int totalCount = 0;
		
		String query = prop.getProperty("selectOwnerTotalCount");

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

	public List<ownerDTO> selectOwnerList(Connection con, PageInfoDTO pageInfo) {
		// TODO Auto-generated method stub
				PreparedStatement pstmt = null;
				ResultSet rset = null;
				
				List<ownerDTO> ownerList = null;
				
				String query = prop.getProperty("selectOwnerList");

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
					
					ownerList = new ArrayList<>();
					
					while(rset.next()) {
						ownerDTO order = new ownerDTO();		
						order.setOwnerNum(rset.getInt("USER_CODE"));
						order.setOwnerName(rset.getString("USER_NAME"));
						order.setStoName(rset.getString("STORE_NAME"));
						order.setBisiNum(rset.getInt("OWNER_NO"));
						order.setStoAddr(rset.getString("STORE_ADDR"));
						
						ownerList.add(order);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					close(rset);
					close(pstmt);
				}
				
				return ownerList;
	}


	public int searchOrderCount(Connection con, String condition, String value) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		String query = null;
		int totalCount = 0;
		
		if(condition.equals("ownerNum")) {
			query = prop.getProperty("ownerNumCount");
		}else if(condition.equals("bisiNum")) {
			query = prop.getProperty("bisiNumCount");
		}else if(condition.equals("ownerName")) {
			query = prop.getProperty("ownerNameCount");
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


	public List<ownerDTO> searchOrderList(Connection con, PageInfoDTO pageInfo, String condition, String value) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		String query = null;
		
		List<ownerDTO> ownerList = null;
		
		if(condition.equals("ownerNum")) {
			query = prop.getProperty("ownerNumSearch");
		}else if(condition.equals("bisiNum")) {
			query = prop.getProperty("bisiNumSearch");
		}else if(condition.equals("ownerName")) {
			query = prop.getProperty("ownerNameSearch");
		}
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, value);
			pstmt.setInt(2, pageInfo.getStartRow());
			pstmt.setInt(3, pageInfo.getEndRow());
			
			rset = pstmt.executeQuery();
			
			ownerList = new ArrayList<>();
			
			while(rset.next()) {
				ownerDTO order = new ownerDTO();		
				order.setOwnerNum(rset.getInt("USER_CODE"));
				order.setOwnerName(rset.getString("USER_NAME"));
				order.setStoName(rset.getString("STORE_NAME"));
				order.setBisiNum(rset.getInt("OWNER_NO"));
				order.setStoAddr(rset.getString("STORE_ADDR"));
				
				ownerList.add(order);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return ownerList;
	}
}
