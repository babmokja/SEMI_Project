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

import com.BoB.mvc.admin.dto.OwnerDetailDTO;
import com.BoB.mvc.admin.dto.PageInfoDTO;
import com.BoB.mvc.admin.dto.ownerDTO;
import com.BoB.mvc.admin.dto.ownerSalesDTO;
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
						order.setEnrollDate(rset.getDate("ENROLL_DATE"));
						order.setAppr(rset.getString("APPROVAL"));
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
				order.setEnrollDate(rset.getDate("ENROLL_DATE"));
				order.setAppr(rset.getString("APPROVAL"));
				
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


	public List<OwnerDetailDTO> selectOwnerDetail(Connection con, int ownerNumber) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<OwnerDetailDTO> orderDetailList = null;
		String query = prop.getProperty("selectOwnerDetail");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, ownerNumber);
			rset = pstmt.executeQuery();
			
			orderDetailList = new ArrayList<>();
			
			if(rset.next()) {

				OwnerDetailDTO owner = new OwnerDetailDTO();		
				owner.setOwnerNum(rset.getInt("OWNER_NO"));
				owner.setStoName(rset.getString("STORE_NAME"));
				owner.setStoNum(rset.getInt("STORE_CODE"));
				owner.setCategory(rset.getString("CATEGORY"));
				owner.setStoAddr(rset.getString("STORE_ADDR"));
				owner.setPhone(rset.getString("USER_PHONE"));
				owner.setType(rset.getString("TYPE_NAME"));
				owner.setAppr(rset.getString("APPROVAL"));
				
				orderDetailList.add(owner);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return orderDetailList;
	}


	public int updateAppr(Connection con, String result, String ownerNum) {
		
		PreparedStatement pstmt = null;
		int updateAppr = 0;
		String query = prop.getProperty("updateAppr");
		
		try {
			
			if(result.equals("OK")) {
				pstmt = con.prepareStatement(query);
				
				pstmt.setString(1, "Y");
				pstmt.setString(2, ownerNum);
				
				updateAppr = pstmt.executeUpdate();
			}else {
				pstmt = con.prepareStatement(query);
				
				pstmt.setString(1, "X");
				pstmt.setString(2, ownerNum);
				
				updateAppr = pstmt.executeUpdate();
			}
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		
		return updateAppr;
	}


	public int selectSalesTodayCount(Connection con, int ownerNum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int totalCount = 0;
		
		String query = prop.getProperty("selectSalesTotalCount");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, ownerNum);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				totalCount = rset.getInt("COUNT(*)");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return totalCount;
	}


	public List<ownerSalesDTO> selectSalesTodayList(Connection con, PageInfoDTO pageInfo, int ownerNum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<ownerSalesDTO> salesList = null;
		
		String query = prop.getProperty("selectSalesTodayList");

		if(query != null) {
			System.out.println(query);
		}
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, ownerNum);
			pstmt.setInt(2, pageInfo.getStartRow());
			pstmt.setInt(3, pageInfo.getEndRow());
			System.out.println(pageInfo.getStartRow());
			System.out.println(pageInfo.getEndRow());
			rset = pstmt.executeQuery();
			
			salesList = new ArrayList<>();
			
			while(rset.next()) {
				ownerSalesDTO sales = new ownerSalesDTO();		
				sales.setOwnerNum(rset.getInt("USER_CODE"));
				sales.setOrderNum(rset.getInt("ORDER_CODE"));
				sales.setOrderDate(rset.getTime("ORDER_TIME"));
				sales.setType(rset.getString("TYPE_YN"));
				sales.setPrice(rset.getInt("TOTAL_AMOUNT"));
				
				
				salesList.add(sales);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return salesList;
	}


	public int searchMonthSalesCount(Connection con, String stringValue, String ownerNum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int totalCount = 0;
		
		String query = prop.getProperty("searchMonthSalesCount");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, stringValue);
			pstmt.setString(2, ownerNum);
			rset = pstmt.executeQuery();
			System.out.println(query);
			if(rset.next()) {
				totalCount = rset.getInt("COUNT(*)");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return totalCount;
	}


	public List<ownerSalesDTO> searchMonthSales(Connection con, PageInfoDTO pageInfo, String ownerNum,
			String stringValue) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<ownerSalesDTO> salesList = null;
		
		String query = prop.getProperty("searchMonthSales");

		if(query != null) {
			System.out.println(query);
		}
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, stringValue);
			pstmt.setString(2, ownerNum);
			pstmt.setInt(3, pageInfo.getStartRow());
			pstmt.setInt(4, pageInfo.getEndRow());
			System.out.println(pageInfo.getStartRow());
			System.out.println(pageInfo.getEndRow());
			rset = pstmt.executeQuery();
			
			salesList = new ArrayList<>();
			
			while(rset.next()) {
				ownerSalesDTO sales = new ownerSalesDTO();		
				sales.setOwnerNum(rset.getInt("USER_CODE"));
				sales.setOrderNum(rset.getInt("ORDER_CODE"));
				sales.setOrderDate(rset.getDate("ORDER_TIME"));
				sales.setType(rset.getString("TYPE_YN"));
				sales.setPrice(rset.getInt("TOTAL_AMOUNT"));
				
				
				salesList.add(sales);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return salesList;
	}


	public int searchMonthSalesPrice(Connection con, String stringValue, String ownerNum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int totalCount = 0;
		
		String query = prop.getProperty("searchMonthSalesPrice");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, stringValue);
			pstmt.setString(2, ownerNum);
			rset = pstmt.executeQuery();
			System.out.println(query);
			while(rset.next()) {
				totalCount += rset.getInt("TOTAL_AMOUNT");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return totalCount;
	}


	public int selectSalesTodayPrice(Connection con, int ownerNum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int totalCount = 0;
		
		String query = prop.getProperty("searchMonthSalesPrice");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, ownerNum);
			rset = pstmt.executeQuery();
			System.out.println(query);
			while(rset.next()) {
				totalCount += rset.getInt("TOTAL_AMOUNT");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return totalCount;
	}
}
