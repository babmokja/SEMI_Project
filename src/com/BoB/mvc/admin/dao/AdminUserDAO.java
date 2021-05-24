package com.BoB.mvc.admin.dao;

import static com.BoB.mvc.common.jdbc.JDBCTemplate.close;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.BoB.mvc.admin.dto.AdminUserDTO;
import com.BoB.mvc.admin.dto.CustomerBoardDTO;
import com.BoB.mvc.admin.dto.PageInfoDTO;
import com.BoB.mvc.common.config.ConfigLocation;

public class AdminUserDAO {
	private Properties prop;

	public AdminUserDAO() {
		prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "admin/admin-mapper.xml"));
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}

	public int selectUserCount(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		
		int totalCount = 0;
		String query = prop.getProperty("selectUserCount");

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

	public List<AdminUserDTO> selectUserList(Connection con, PageInfoDTO pageInfo) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<AdminUserDTO> userList = null;
		String query = prop.getProperty("selectUserList");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, pageInfo.getStartRow());
			pstmt.setInt(2, pageInfo.getEndRow());
			System.out.println(pageInfo.getStartRow());
			System.out.println(pageInfo.getEndRow());
			rset = pstmt.executeQuery();
			userList = new ArrayList<>();
			
			while(rset.next()) {
				AdminUserDTO user = new AdminUserDTO();
				user.setUserNum(rset.getInt("USER_CODE"));
				user.setUserId(rset.getString("USER_ID"));
				user.setUserName(rset.getString("USER_NAME"));
				user.setBlackList(rset.getString("BLACKLIST_YN"));
				user.setUserAddr(rset.getString("USER_ADDRESS"));
				user.setWithDrawYN(rset.getString("WITHDRAW_YN"));
				
				userList.add(user);
				
				
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return userList;
	}

	public int searchUserCount(Connection con, String condition, String value) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		String query = null;
		int totalCount = 0;
		
		if(condition.equals("userNum")) {
			query = prop.getProperty("userNumCount");
		}else if(condition.equals("userId")) {
			query = prop.getProperty("userIdCount");
		}else if(condition.equals("userName")) {
			query = prop.getProperty("userNameCount2");
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

	public List<AdminUserDTO> searchUserList(Connection con, PageInfoDTO pageInfo, String condition, String value) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		String query = null;
		List<AdminUserDTO> userList = null;
		
		
		if(condition.equals("userNum")) {
			query = prop.getProperty("userNumSearch");
		}else if(condition.equals("userId")) {
			query = prop.getProperty("userIdSearch");
		}else if(condition.equals("userName")) {
			query = prop.getProperty("userNameSearch2");
		}
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, value);
			pstmt.setInt(2, pageInfo.getStartRow());
			pstmt.setInt(3, pageInfo.getEndRow());
			userList = new ArrayList<>();
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				AdminUserDTO user = new AdminUserDTO();
				user.setUserNum(rset.getInt("USER_CODE"));
				user.setUserId(rset.getString("USER_ID"));
				user.setUserName(rset.getString("USER_NAME"));
				user.setBlackList(rset.getString("BLACKLIST_YN"));
				user.setUserAddr(rset.getString("USER_ADDRESS"));
				user.setWithDrawYN(rset.getString("WITHDRAW_YN"));
				
				userList.add(user);
				
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
			
		
		return userList;
	}
}
