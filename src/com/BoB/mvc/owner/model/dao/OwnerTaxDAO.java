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


import com.BoB.mvc.common.config.ConfigLocation;
import com.BoB.mvc.owner.model.dto.OwnerBillDTO;

public class OwnerTaxDAO {
	private Properties prop;
	
	public OwnerTaxDAO() {
		prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION+"owner/owner-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public List<OwnerBillDTO> selectOneFee(Connection con, int value, int ownerNum) {
		
		PreparedStatement pstmt = null;
		
	ResultSet rset = null;
		
		List<OwnerBillDTO> oneFeeList = null;
		String query = prop.getProperty("oneselectfee");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, value);
			
			rset = pstmt.executeQuery();
			
			oneFeeList = new ArrayList<>();
			
			if(rset.next()) {
				
				OwnerBillDTO oneFee = new OwnerBillDTO();
				
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
