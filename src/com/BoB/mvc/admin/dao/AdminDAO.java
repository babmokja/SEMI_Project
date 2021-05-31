package com.BoB.mvc.admin.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.BoB.mvc.admin.dto.AdminDTO;
import com.BoB.mvc.common.config.ConfigLocation;

import static com.BoB.mvc.common.jdbc.JDBCTemplate.*;

public class AdminDAO {
	
	private final Properties prop;
	
	public AdminDAO() {
		prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "admin/admin-mapper.xml"));
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	
	public int selectRoleCode(Connection con, String adminId) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int roleCode = 0;
		
		String query = prop.getProperty("selectRoleCode");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, adminId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				roleCode = rset.getInt("ROLE_CODE");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return roleCode;
	}
	

	public String selectEncryptedPwd(Connection con, String adminId, String adminPwd) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String encPwd = null;
		String query = prop.getProperty("selectEncryptedPwd");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, adminId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				if(rset.getString("USER_PWD") != null) {
					encPwd = rset.getString("USER_PWD");
				}
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return encPwd;

	}

	public AdminDTO selectLoginMember(Connection con, String adminId, String adminPwd) {
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		AdminDTO admindto = null;
		
		String query = prop.getProperty("selectLoginMember");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, adminId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				admindto = new AdminDTO();
				
				admindto.setId(rset.getString("USER_ID"));
				admindto.setPwd(rset.getString("USER_PWD"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return admindto;
	}





}
