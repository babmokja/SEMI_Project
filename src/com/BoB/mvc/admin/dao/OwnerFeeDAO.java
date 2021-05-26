package com.BoB.mvc.admin.dao;

import static com.BoB.mvc.common.jdbc.JDBCTemplate.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.BoB.mvc.admin.dto.AdminBillDTO;
import com.BoB.mvc.common.config.ConfigLocation;

public class OwnerFeeDAO {

	private Properties prop;
	
	public OwnerFeeDAO() {
		prop = new Properties();
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION+"admin/owner-fee.xml"));
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public List<AdminBillDTO> selectBillList(Connection con, String calender, int value) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<AdminBillDTO> OwnerFeeList = null;
		String query = prop.getProperty("selectfee1");
		try {
			
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, value);
			pstmt.setString(2, calender);
			
			rset = pstmt.executeQuery();
			
			OwnerFeeList = new ArrayList<>();  
			
			while(rset.next()) {
				
				AdminBillDTO fee = new AdminBillDTO();
				
				fee.setOwnerNo(rset.getInt("OWNER_NO"));
				fee.setStoreName(rset.getString("STORE_NAME"));
				fee.setStoreAddress(rset.getString("STORE_ADDRESS"));
				fee.setCompany(rset.getString("COMPANY"));
				fee.setItem(rset.getString("ITEM"));
				fee.setOrderTime(rset.getDate("ORDER_TIME"));
				fee.setTotalAmount(rset.getInt("TOTAL_AMOUNT"));
				fee.setUserName(rset.getString("USER_NAME"));
				System.out.println("fee 확인"+fee);
				OwnerFeeList.add(fee);
			}
			
		}catch(SQLException e){
			
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return OwnerFeeList;
	}

	public List<AdminBillDTO> selectOneFee(Connection con, int value) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<AdminBillDTO> oneFeeList = null;
		String query = prop.getProperty("oneselectfee");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, value);
			
			rset = pstmt.executeQuery();
			
			oneFeeList = new ArrayList<>();
			
			if(rset.next()) {
				
				AdminBillDTO oneFee = new AdminBillDTO();
				
				oneFee.setOwnerNo(rset.getInt("OWNER_NO"));
				oneFee.setStoreName(rset.getString("STORE_NAME"));
				oneFee.setStoreAddress(rset.getString("STORE_ADDRESS"));
				oneFee.setCompany(rset.getString("COMPANY"));
				oneFee.setItem(rset.getString("ITEM"));
				oneFee.setUserName(rset.getString("USER_NAME"));
				System.out.println("oneFee : " + oneFee);
				oneFeeList.add(oneFee);
				
			} 
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return oneFeeList;
	}
	
	
}
