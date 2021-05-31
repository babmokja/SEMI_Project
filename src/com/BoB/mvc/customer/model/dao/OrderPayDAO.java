package com.BoB.mvc.customer.model.dao;

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
import com.BoB.mvc.customer.model.dto.MenuListDTO;
import com.BoB.mvc.customer.model.dto.OrderPayDTO;
import com.BoB.mvc.customer.model.dto.StoreDetailDTO;
import com.BoB.mvc.customer.model.dto.StoreListDTO;

public class OrderPayDAO {
	
	/* Properties 객체를 이용해서 쿼리문을 조회해서 사용한다. 
	 * 기본생성자를 통해서 쿼리문을 조회해온다.
	 * */
	
	private Properties prop = new Properties();
	
	public OrderPayDAO() {
		
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION+"store/OrderPay.xml"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * 장바구니 테이블에 insert 하는 메소드
	 * @param con
	 * @param basket
	 * @return
	 */
	public int insert(Connection con, OrderPayDTO basket) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertMenu");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, basket.getMenuCode());
			pstmt.setInt(2, basket.getAmount());
			pstmt.setInt(3, basket.getStoreCode());
			pstmt.setInt(4, basket.getUserCode());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		
		return result;
	}
	
	/**
	 * 포인트 정보 select
	 * @param con
	 * @param userCodeSelect
	 * @return
	 */
	public OrderPayDTO selectPoint(Connection con, int userCodeSelect) {
		
		/* Statement를 사용할까? 아님 PreparedStatement를 사용할까 */
		PreparedStatement pstmt = null;
		/* 결과값을 뭘로 받을까??를 고민한다. 
		 * 1. select를 요청헀을 떄 -> ResultSet
		 * 2. insert,update,delete를 요청했을 때 -> int
		 * */
		ResultSet rset = null;
		
		OrderPayDTO selectPoint = null;
		
		String query = prop.getProperty("selectPointById");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userCodeSelect); // <- 위치홀더의 시작인덱스값은 1부터 시작한다.
			
			rset = pstmt.executeQuery(); // 위에서 만든 쿼리문을 이용해서 데이터베이스에 질의하여 데이터 정보를 리턴받음
			
			if(rset.next()) {
				selectPoint = new OrderPayDTO();
				
				selectPoint.setPoint(rset.getInt("POINT"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return selectPoint;
	}
	

	/**
	 * 장바구니에 담긴 주문 내역 정보 select
	 * @param con
	 * @param userCodeSelect
	 * @return
	 */
	public List<OrderPayDTO> selectBasket(Connection con, int userCodeSelect) {
		
		/* Statement를 사용할까? 아님 PreparedStatement를 사용할까 */
		PreparedStatement pstmt = null;
		/* 결과값을 뭘로 받을까??를 고민한다. 
		 * 1. select를 요청헀을 떄 -> ResultSet
		 * 2. insert,update,delete를 요청했을 때 -> int
		 * */
		ResultSet rset = null;
		
		// 반환시킬 변수
		List<OrderPayDTO> selectBasket = null;
				
		String query = prop.getProperty("selectBasketById");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userCodeSelect); // <- 위치홀더의 시작인덱스값은 1부터 시작한다.
			
			rset = pstmt.executeQuery(); // 위에서 만든 쿼리문을 이용해서 데이터베이스에 질의하여 데이터 정보를 리턴받음
			
			selectBasket = new ArrayList<>();
			
			int totalPrice = 0;
			int amount = 0;
			int price = 0;
			
			while(rset.next()) {
				OrderPayDTO basket = new OrderPayDTO();
				
				basket.setStoreName(rset.getString("STORENAME"));
				basket.setMenuName(rset.getString("MENUNAME"));
				basket.setAmount(rset.getInt("AMOUNT"));
				basket.setPrice(rset.getInt("PRICE"));
				basket.setStoreCode(rset.getInt("STOREID"));
				
				amount = rset.getInt("AMOUNT");
				price = rset.getInt("PRICE");
				totalPrice = amount * price;
				
				basket.setTotalPrice(totalPrice);
				
				selectBasket.add(basket);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return selectBasket;
	}

	/**
	 * 이용자 정보 select
	 * @param con
	 * @param userCodeSelect
	 * @return
	 */
	public OrderPayDTO selectOrderPerson(Connection con, int userCodeSelect) {
		
		/* Statement를 사용할까? 아님 PreparedStatement를 사용할까 */
		PreparedStatement pstmt = null;
		/* 결과값을 뭘로 받을까??를 고민한다. 
		 * 1. select를 요청헀을 떄 -> ResultSet
		 * 2. insert,update,delete를 요청했을 때 -> int
		 * */
		ResultSet rset = null;
		
		OrderPayDTO selectOrderPerson = null;
		
		String query = prop.getProperty("selectOrderPersonById");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userCodeSelect); // <- 위치홀더의 시작인덱스값은 1부터 시작한다.
			
			rset = pstmt.executeQuery(); // 위에서 만든 쿼리문을 이용해서 데이터베이스에 질의하여 데이터 정보를 리턴받음
			
			if(rset.next()) {
				selectOrderPerson = new OrderPayDTO();
				
				selectOrderPerson.setEmail(rset.getString("EMAIL"));
				selectOrderPerson.setName(rset.getString("NAME"));
				selectOrderPerson.setPhone(rset.getString("PHONE"));
				selectOrderPerson.setUserCode(rset.getInt("USERID"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return selectOrderPerson;
	}

}
