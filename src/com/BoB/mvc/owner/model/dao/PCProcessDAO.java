package com.BoB.mvc.owner.model.dao;

import static com.BoB.mvc.common.jdbc.JDBCTemplate.close;

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
import com.BoB.mvc.owner.model.dto.CartListDTO;
import com.BoB.mvc.owner.model.dto.DeliveryDTO;
import com.BoB.mvc.owner.model.dto.NoShowDTO;

public class PCProcessDAO {
	private final Properties prop;
	
	public PCProcessDAO(){
		prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION+"owner/owner-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<DeliveryDTO> selectDeliveryOrder(Connection con, int ownerCode) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("DeliveryBasicInfo");
		
		List<DeliveryDTO> deliveryList = null;

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, ownerCode);
			rset = pstmt.executeQuery();
			
			deliveryList = new ArrayList<>();
			
			while(rset.next()) {
				DeliveryDTO delivery= new DeliveryDTO();
				
				delivery.setUserId(rset.getString("USER_CODE"));
				delivery.setUserName(rset.getString("USER_NAME"));
				delivery.setTypeYN(rset.getString("TYPE_YN"));
				delivery.setOrderCode(rset.getInt("ORDER_CODE"));
				delivery.setOrderProceed(rset.getString("ORDER_PROCEED"));
				delivery.setOrderTime(rset.getDate("ORDER_TIME"));
				delivery.setOwnerComment(rset.getString("OWNER_COMMENT"));
				
				deliveryList.add(delivery);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		

		
		return deliveryList;
	}

	
	
	public List<CartListDTO> selectMenuList(Connection con, int ownerCode) {
		
		PreparedStatement pstmt = null;
		ResultSet rset= null;
		
		List<CartListDTO> cartList = null;
		
		String query = prop.getProperty("DeliveryOrderList");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, ownerCode);
			rset = pstmt.executeQuery();
			cartList = new ArrayList<>();
			
			while(rset.next()) {
				CartListDTO cart = new CartListDTO();
				
				cart.setOrderCode(rset.getInt("ORDER_CODE"));
				cart.setMenuName(rset.getString("MENU_NAME"));
				cart.setAmount(rset.getInt("AMOUNT"));
				cart.setPrice(rset.getInt("PRICE"));
				
				cartList.add(cart);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		

		return cartList;
	}

	public int updateOwnerComment(Connection con, int ownerCode, int orderCode, String comment) {

		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("UpdateOwnerComment");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, comment);
			pstmt.setInt(2, orderCode);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	public int updateOnwerDenyComment(Connection con, int ownerCode, int orderCode, String deny) {

		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("DenyOwnerComment");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, deny);
			pstmt.setInt(2, orderCode);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	public int updateOnwerCompleteComment(Connection con, int ownerCode, int orderCode, String complete) {

		PreparedStatement pstmt = null;
		
		int result =0;
		
		String query = prop.getProperty("CompleteOrder");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, complete);
			pstmt.setInt(2, orderCode);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public List<DeliveryDTO> selectPickupOrder(Connection con, int ownerCode) {
		
	
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("PickupBasicInfo");
		
		List<DeliveryDTO> pickupList = null;

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, ownerCode);
			rset = pstmt.executeQuery();
			
			pickupList = new ArrayList<>();
			
			while(rset.next()) {
				DeliveryDTO delivery= new DeliveryDTO();
				
				delivery.setUserId(rset.getString("USER_CODE"));
				delivery.setUserName(rset.getString("USER_NAME"));
				delivery.setTypeYN(rset.getString("TYPE_YN"));
				delivery.setOrderCode(rset.getInt("ORDER_CODE"));
				delivery.setOrderProceed(rset.getString("ORDER_PROCEED"));
				delivery.setOrderTime(rset.getDate("ORDER_TIME"));
				delivery.setReserveTime(rset.getDate("RESERVE_TIME"));
				delivery.setOwnerComment(rset.getString("OWNER_COMMENT"));
				
				pickupList.add(delivery);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return pickupList;
	}

	public int updateOwnerpickupComment(Connection con, int ownerCode, int orderCode, String accept) {

		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("UpdateOwnerPickAccept");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, accept);
			pstmt.setInt(2, orderCode);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

public int insertUserBlackList(Connection con, int ownerCode, int orderCode1,int userId1, int storeCode1) {
		
		PreparedStatement pstmt = null;
				
		int result = 0;
		
		String query= prop.getProperty("InsertNoShowUser");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, userId1 );
			pstmt.setInt(2, orderCode1);
			pstmt.setInt(3, storeCode1);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("insertResult: "+ result);
		return result;
	}

	public NoShowDTO selectnoshowUser(Connection con, int ownerCode) {
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String query= prop.getProperty("selectNoshowinfo");
		NoShowDTO noshowDTO = new NoShowDTO();
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, ownerCode);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
			 
				noshowDTO.setOrderCode(rset.getInt("ORDER_CODE"));
			    noshowDTO.setStoreCode(rset.getInt("STORE_CODE"));
			    noshowDTO.setUserCode(rset.getInt("USER_CODE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println("noshowDTO:"+noshowDTO);
		return noshowDTO;
	}

	public int selectnoshowCount(Connection con, int userId1) {

		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		int result = 0;
		
		String query = prop.getProperty("CountNoshowUser");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userId1);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				result = rset.getInt("COUNT(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		System.out.println("countUser" +result);
		
		return result;
	}

	public int updateRealBlackList(Connection con, int userId1) {

		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateBlockUser");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userId1);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}



}
