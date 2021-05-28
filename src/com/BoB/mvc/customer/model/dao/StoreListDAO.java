package com.BoB.mvc.customer.model.dao;

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

import com.BoB.mvc.common.config.ConfigLocation;
import com.BoB.mvc.customer.model.dto.PageInfoDTO;
import com.BoB.mvc.customer.model.dto.StoreListDTO;

public class StoreListDAO {

	/**
	 * 식당 리스트 조회
	 * @param con
	 * @param type 
	 * @param cate 
	 * @param order 
	 * @param pageInfo 
	 * @param storeId 
	 * @return
	 */
	public List<StoreListDTO> selectStore(Connection con, String cate, String type, String order, PageInfoDTO pageInfo, int storeId) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<StoreListDTO> selectedStore = null;
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("SELECT B.*\r\n"
				+ "FROM(\r\n"
				+ "SELECT ROWNUM RNUM, C.*\r\n"
				+ "FROM(\r\n"
				+ "SELECT A.STORE_CODE, A.STORE_NAME AS NAME, A.STORE_ADDR AS ADDRESS\r\n"
				+ ", D.ROUTE AS PHOTO, ROUND(AVG(C.SATISFIED),1) AS STAR\r\n"
				+ ", COUNT(C.SATISFIED) AS CONGESTION, COUNT(B.ORDER_PROCEED) AS REVIEWCNT\r\n"
				+ "FROM STORE_TABLE A\r\n"
				+ "JOIN ORDER_TABLE B\r\n"
				+ "ON A.STORE_CODE = B.STORE_CODE\r\n"
				+ "JOIN REVIEW C\r\n"
				+ "ON A.STORE_CODE = C.STORE_CODE\r\n"
				+ "JOIN PICTURE D\r\n"
				+ "ON C.PICTURE_CODE = D.PICTURE_CODE\r\n");
				
		/* sb.append("WHERE CATEGORY= " + cate + "AND TYPE_CODE = " + type); */
		
		switch(cate) {
		case "kor":
			if(type.equals("1")) {
				sb.append("WHERE CATEGORY='한식' AND TYPE_CODE=1\r\n");
			} else {
				sb.append("WHERE CATEGORY='한식' AND TYPE_CODE=2\r\n");
			}
			break;
		case "fra":
			if(type.equals("1")) {
				sb.append("WHERE CATEGORY='프랜차이즈' AND TYPE_CODE=1\r\n");
			} else {
				sb.append("WHERE CATEGORY='프랜차이즈' AND TYPE_CODE=2\r\n");
			}
			break;
		case "chi":
			if(type.equals("1")) {
				sb.append("WHERE CATEGORY='중식' AND TYPE_CODE=1\r\n");
			} else {
				sb.append("WHERE CATEGORY='중식' AND TYPE_CODE=2\r\n");
			}
			break;
		case "jap":
			if(type.equals("1")) {
				sb.append("WHERE CATEGORY='일식' AND TYPE_CODE=1\r\n");
			} else {
				sb.append("WHERE CATEGORY='일식' AND TYPE_CODE=2\r\n");
			}
			break;
		case "ame":
			if(type.equals("1")) {
				sb.append("WHERE CATEGORY='양식' AND TYPE_CODE=1\r\n");
			} else {
				sb.append("WHERE CATEGORY='양식' AND TYPE_CODE=2\r\n");
			}
			break;
		}
		
		sb.append("GROUP BY A.STORE_CODE, A.STORE_NAME, A.STORE_ADDR, D.ROUTE\r\n");
		
		switch(order) {
		case "congestion":
			sb.append("ORDER BY CONGESTION");
			break;
		case "star":
			sb.append("ORDER BY STAR");
			break;
		case "name":
			sb.append("ORDER BY NAME");
			break;
		default :
			sb.append("ORDER BY CONGESTION");
			break;
		}
		
		sb.append(") C) B \r\n"
				+ "WHERE B.RNUM BETWEEN ");
		
		sb.append(pageInfo.getStartRow() + " AND " + pageInfo.getEndRow());
		
		String query = sb.toString();
		
		try {
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			selectedStore = new ArrayList<>();
			
			while(rset.next()) {
				
				StoreListDTO store = new StoreListDTO();
				
				store.setStoreName(rset.getString("NAME"));
				store.setCongestion(rset.getString("CONGESTION"));
				store.setStar(rset.getDouble("STAR"));
				store.setReviewCnt(rset.getInt("REVIEWCNT"));
				store.setPhoto(rset.getString("PHOTO"));
				store.setAddress(rset.getString("ADDRESS"));
				store.setStoreId(Integer.toString(rset.getInt("STORE_CODE")));
				
				selectedStore.add(store);
				
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return selectedStore;
	}

	/**
	 * 원하는 카테고리, 유형에 해당하는 가게 개수
	 * @param con
	 * @return
	 */
	public int selectTotalCount(Connection con, String cate, String type) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int totalCount = 0;
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("SELECT COUNT(*)\r\n"
				+ "FROM(\r\n"
				+ "SELECT A.STORE_CODE, A.STORE_CODE, A.STORE_NAME AS NAME, A.STORE_ADDR AS ADDRESS\r\n"
				+ ", D.ROUTE AS PHOTO, ROUND(AVG(C.SATISFIED),1) AS STAR\r\n"
				+ ", COUNT(C.SATISFIED) AS CONGESTION, COUNT(B.ORDER_PROCEED) AS REVIEWCNT\r\n"
				+ "FROM STORE_TABLE A\r\n"
				+ "JOIN ORDER_TABLE B\r\n"
				+ "ON A.STORE_CODE = B.STORE_CODE\r\n"
				+ "JOIN REVIEW C\r\n"
				+ "ON A.STORE_CODE = C.STORE_CODE\r\n"
				+ "JOIN PICTURE D\r\n"
				+ "ON C.PICTURE_CODE = D.PICTURE_CODE\r\n");
		
		switch(cate) {
		case "kor":
			if(type.equals("1")) {
				sb.append("WHERE CATEGORY='한식' AND TYPE_CODE=1\r\n");
			} else {
				sb.append("WHERE CATEGORY='한식' AND TYPE_CODE=2\r\n");
			}
			break;
		case "fra":
			if(type.equals("1")) {
				sb.append("WHERE CATEGORY='프랜차이즈' AND TYPE_CODE=1\r\n");
			} else {
				sb.append("WHERE CATEGORY='프랜차이즈' AND TYPE_CODE=2\r\n");
			}
			break;
		case "chi":
			if(type.equals("1")) {
				sb.append("WHERE CATEGORY='중식' AND TYPE_CODE=1\r\n");
			} else {
				sb.append("WHERE CATEGORY='중식' AND TYPE_CODE=2\r\n");
			}
			break;
		case "jap":
			if(type.equals("1")) {
				sb.append("WHERE CATEGORY='일식' AND TYPE_CODE=1\r\n");
			} else {
				sb.append("WHERE CATEGORY='일식' AND TYPE_CODE=2\r\n");
			}
			break;
		case "ame":
			if(type.equals("1")) {
				sb.append("WHERE CATEGORY='양식' AND TYPE_CODE=1\r\n");
			} else {
				sb.append("WHERE CATEGORY='양식' AND TYPE_CODE=2\r\n");
			}
			break;
		}
		
		sb.append("GROUP BY A.STORE_CODE, A.STORE_NAME, A.STORE_ADDR, D.ROUTE)");
		
		String query = sb.toString();
		
		try {
			pstmt = con.prepareStatement(query);
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
		
		System.out.println(totalCount);
		
		return totalCount;
	}
	

}
