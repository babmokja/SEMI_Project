package com.BoB.mvc.owner.model.dao;

import static com.BoB.mvc.common.jdbc.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.input.ClassLoaderObjectInputStream;

import com.BoB.mvc.common.config.ConfigLocation;
import com.BoB.mvc.owner.model.dto.MonthSalesDTO;
import com.BoB.mvc.owner.model.dto.SalesDTO;
import com.BoB.mvc.owner.model.dto.StoreInfoDTO;

public class SalesDAO {

	private final Properties prop;
	
	public SalesDAO() {
		prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION+"owner/owner-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public List<SalesDTO> selectDailySales(Connection con, String month) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<SalesDTO> salesList = null;
		
		String query = prop.getProperty("selectDailySales");
		String query1 = prop.getProperty("selectAllSales");
		
		try {
			if(month.equals("0")) {
				pstmt=con.prepareStatement(query1);
				rset = pstmt.executeQuery();
				salesList = new ArrayList<>();
				while(rset.next()) {
					SalesDTO sales = new SalesDTO();
					sales.setStoreInfoCode(new StoreInfoDTO());
					
					sales.setOrderCode(rset.getInt("ORDER_CODE"));
					sales.setOrderTime(rset.getDate("ORDER_TIME"));
					sales.setTotalAmount(rset.getInt("TOTAL_AMOUNT"));
					sales.setStoreCode(rset.getInt("STORE_CODE"));
//					sales.getStoreCode().setStoreCode(rset.getInt("STORE_CODE"));
					sales.setTypeYN(rset.getString("TYPE_YN"));
					
					salesList.add(sales);
					
				}
				
			} else {
				pstmt = con.prepareStatement(query);
				
				
				salesList = new ArrayList<>();
				pstmt.setInt(1, Integer.parseInt(month));
				
				rset = pstmt.executeQuery();
				while(rset.next()) {
					SalesDTO sales = new SalesDTO();
					sales.setStoreInfoCode(new StoreInfoDTO());
					
					sales.setOrderCode(rset.getInt("ORDER_CODE"));
					sales.setOrderTime(rset.getDate("ORDER_TIME"));
					sales.setTotalAmount(rset.getInt("TOTAL_AMOUNT"));
					sales.setStoreCode(rset.getInt("STORE_CODE"));
//					sales.getStoreCode().setStoreCode(rset.getInt("STORE_CODE"));
					sales.setTypeYN(rset.getString("TYPE_YN"));
					
					salesList.add(sales);
					
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		System.out.println(salesList);
		return salesList;
	}
	
	public List<MonthSalesDTO> selectMonthlySales(Connection con) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<MonthSalesDTO> monthSales= null;
		
		String query = prop.getProperty("selectMonthlySales");
		try {
			pstmt = con.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			
			monthSales = new ArrayList<>();
			
			while(rset.next()) {
				MonthSalesDTO month = new MonthSalesDTO();
				
				month.setMonth(rset.getInt("MONTH"));
				month.setCount(rset.getInt("COUNT"));
				month.setTotalPrice(rset.getInt("TOTAL"));
				
				monthSales.add(month);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		return monthSales;
	}

}
