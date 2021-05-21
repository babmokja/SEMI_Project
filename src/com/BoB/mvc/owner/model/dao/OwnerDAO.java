package com.BoB.mvc.owner.model.dao;

import static com.BoB.mvc.common.jdbc.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

import com.BoB.mvc.common.config.ConfigLocation;
import com.BoB.mvc.owner.model.dto.OwnerDTO;
import com.BoB.mvc.owner.model.dto.PictureDTO;
import com.BoB.mvc.owner.model.dto.StoreInfoDTO;

public class OwnerDAO {

	private Properties prop = new Properties();
	
	public OwnerDAO() {
		
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION+"owner-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public int insertOwner(Connection con, OwnerDTO requestOwner, StoreInfoDTO requestStore) {
		
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		
		int result = 0;
		int result2 = 0;
		
		String query = prop.getProperty("insertOwner");
		String query2 = prop.getProperty("insertStore");
		
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString( 1 , requestOwner.getMemberId());
			pstmt.setString( 2 , requestOwner.getMemberPwd());
			pstmt.setString( 3 , requestOwner.getName());
			pstmt.setString( 4 , requestOwner.getPhone());
			pstmt.setString( 5 , requestOwner.getAddress());
			pstmt.setString( 6 , requestOwner.getEmail());
			pstmt.setString( 7 , requestOwner.getResidentNum());
			
			result = pstmt.executeUpdate();
		if(result>0) {
			pstmt = con.prepareStatement(query2);
			
			
			
			
			result2 = pstmt.executeUpdate();
		}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result2;
	}
	

	public int insertOwner(Connection con, OwnerDTO Owner) {
		
		PreparedStatement pstmt = null;
		
		int result3 = 0;
		
		String query = prop.getProperty("insertOwner");
		
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString( 1 , Owner.getMemberId());
			pstmt.setString( 2 , Owner.getMemberPwd());
			pstmt.setString( 3 , Owner.getName());
			pstmt.setString( 4 , Owner.getPhone());
			pstmt.setString( 5 , Owner.getAddress());
			pstmt.setString( 6 , Owner.getEmail());
			pstmt.setString( 7 , Owner.getResidentNum());
			
			result3 = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result3;
	}



	public int insertStore(Connection con, StoreInfoDTO store, Map<String, PictureDTO> picture, OwnerDTO owner, LicenseManagerDTO lm) {
		
		PreparedStatement pstmt = null;
		
		int result4 = 0;
		
		String query = prop.getProperty("insertStore");
		
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString( 1 , store.getStoreName());
			pstmt.setInt( 2 , store.getBusinessNum());
			pstmt.setString( 3 , store.getStoreXY());
			pstmt.setString( 4 , store.getStoreIntro());
			pstmt.setString( 5 , store.getCategory());
			pstmt.setInt(6, store.getTypeCode());
			pstmt.setString( 7 , store.getAddress());
			
			result4 = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result4;
	}



	public String selectEncryptedPwd(Connection con, OwnerDTO requestMember) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String encPwd = null;
		
		String query = prop.getProperty("selectEncryptedPwd");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, requestMember.getMemberId());
			
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



	public OwnerDTO selectLoginMember(Connection con, OwnerDTO requestMember) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		OwnerDTO loginMember = null;
		
		String query = prop.getProperty("selectLoginOwner");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, requestMember.getMemberId());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				loginMember = new OwnerDTO();
				
				loginMember.setUserCode(rset.getInt("USER_CODE"));
				loginMember.setMemberId(rset.getString("USER_ID"));
				loginMember.setName(rset.getString("USER_NAME"));
				loginMember.setPhone(rset.getString("USER_PHONE"));
				loginMember.setAddress(rset.getString("ADDRESS"));
				loginMember.setPoint(rset.getInt("POINT"));
				loginMember.setEmail(rset.getString("USER_EMAIL"));
				loginMember.setWithdrawYN(rset.getString("WITHDRAW_YN"));
				loginMember.setRoleCode(rset.getInt("ROLE_CODE"));
				loginMember.setBlacklistYN(rset.getString("BLACKLIST_YN"));
				loginMember.setBlacklistDate(rset.getDate("BLACKLIST_DATE"));
				loginMember.setResidentNum(rset.getString("USER_NO"));
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return loginMember;
	}



	
	
	
}
