package com.BoB.mvc.owner.model.dao;

import static com.BoB.mvc.common.jdbc.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.BoB.mvc.common.config.ConfigLocation;
import com.BoB.mvc.owner.model.dto.OwnerDTO;
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
			/*
			result = pstmt.executeUpdate();
			
		if(result>0) {*/
			pstmt = con.prepareStatement(query2);
			pstmt.setString(1, requestStore.getStoreName());
			pstmt.setString(2, requestStore.getStoreNum());
			pstmt.setString(3, requestStore.getAddress());
			pstmt.setString(4, requestStore.getCategory());
			pstmt.setString(5, requestStore.getLicense());
			pstmt.setString(6, requestStore.getStartDate());
			
			
			
			
			result2 = pstmt.executeUpdate();
		}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			close(pstmt);
		}
		
		return result2;
	}

	
	
	
	
}
