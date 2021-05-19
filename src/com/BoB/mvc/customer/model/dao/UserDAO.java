package com.BoB.mvc.customer.model.dao;

import static com.BoB.mvc.common.jdbc.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.BoB.mvc.common.config.ConfigLocation;
import com.BoB.mvc.customer.model.dto.UserDTO;

public class UserDAO {
	
	private final Properties prop;
	
	public UserDAO() {
		prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "user/user-mapper.xml"));
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	/**암호화 처리된 비밀번호 조회용 메소
	 * @param con 연결객
	 * @param requestUser
	 * @return
	 */
	public String selectEncryptedPwd(Connection con, UserDTO requestUser) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String encPwd = null;
		
		String query = prop.getProperty("selectEncryptedPwd");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, requestUser.getId());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				encPwd = rset.getString("USER_PWD");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return encPwd;
	}
	/**
	 * @param con
	 * @param requestUser
	 * @return
	 */
	public UserDTO selectLoginUser(Connection con, UserDTO requestUser) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		UserDTO loginUser = null;
		
		String query = prop.getProperty("selectLoginUser");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, requestUser.getId());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				loginUser = new UserDTO();
				
				loginUser.setUserCode(rset.getInt("USER_CODE"));
				loginUser.setId(rset.getString("USER_ID"));
				loginUser.setName(rset.getString("USER_NAME"));
				loginUser.setPhone(rset.getString("USER_PHONE"));
				loginUser.setAddress(rset.getString("USER_ADDRESS"));
				loginUser.setPoint(rset.getInt("POINT"));
				loginUser.setEmail(rset.getString("USER_EMAIL"));
				loginUser.setWithdraw(rset.getBoolean("WITHDRAW_YN"));
				loginUser.setRoleCode(rset.getInt("ROLE_CODE"));
				loginUser.setBlacklistYn(rset.getBoolean("BLACKLIST_YN"));
				loginUser.setBlacklistDate(rset.getDate("BLACKLIST_DATE"));
				loginUser.setUserNo(rset.getString("USER_NO"));
				
				

			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return loginUser;

	}
	/**
	 * @param con
	 * @param requestUser
	 * @return
	 */
	public int insertUser(Connection con, UserDTO requestUser) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("insertUser");
        
		try {
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, requestUser.getId());
			pstmt.setString(2, requestUser.getPwd());
			pstmt.setString(3, requestUser.getName());
			pstmt.setString(4, requestUser.getPhone());
			pstmt.setString(5, requestUser.getAddress());
			pstmt.setString(6, requestUser.getEmail());
			pstmt.setString(7, requestUser.getUserNo());
			
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
      
		return result;
	}

}
