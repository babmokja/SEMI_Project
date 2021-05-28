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
import com.BoB.mvc.owner.model.dto.CartListDTO;
import com.BoB.mvc.owner.model.dto.DeliveryDTO;

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

}
