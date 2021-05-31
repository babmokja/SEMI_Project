package com.BoB.mvc.customer.model.dao;

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
import com.BoB.mvc.customer.model.dto.StoreDetailDTO;

import static com.BoB.mvc.common.jdbc.JDBCTemplate.close;

public class StoreDetailDAO {
	
	/* Properties 객체를 이용해서 쿼리문을 조회해서 사용한다. 
	 * 기본생성자를 통해서 쿼리문을 조회해온다.
	 * */
	
	private Properties prop = new Properties();
	
	public StoreDetailDAO() {
		
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION+"store/storedetail.xml"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * 이미지 정보 select
	 * @param con
	 * @param storeId
	 * @return
	 */
	public List<StoreDetailDTO> selectPhotoById(Connection con, int storeId) {
		
		/* Statement를 사용할까? 아님 PreparedStatement를 사용할까 */
		PreparedStatement pstmt = null;
		/* 결과값을 뭘로 받을까??를 고민한다. 
		 * 1. select를 요청헀을 떄 -> ResultSet
		 * 2. insert,update,delete를 요청했을 때 -> int
		 * */
		ResultSet rset = null;
		
		// 반환시킬 변수
		List<StoreDetailDTO> selectedPhoto = null;
		
		String query = prop.getProperty("selectPhotoById");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, storeId); // <- 위치홀더의 시작인덱스값은 1부터 시작한다.
			
			rset = pstmt.executeQuery(); // 위에서 만든 쿼리문을 이용해서 데이터베이스에 질의하여 데이터 정보를 리턴받음
			
			selectedPhoto = new ArrayList<>();
			
			while(rset.next()) {
				StoreDetailDTO store = new StoreDetailDTO();
				
				store.setStoreId(rset.getInt("CODE"));
				store.setPhoto(rset.getString("ROUTE"));
				
				selectedPhoto.add(store);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return selectedPhoto;
	}

	/**
	 * 가게 정보 select
	 * @param con
	 * @param storeId
	 * @return
	 */
	public StoreDetailDTO selectInfoById(Connection con, int storeId) {
		
		/* Statement를 사용할까? 아님 PreparedStatement를 사용할까 */
		PreparedStatement pstmt = null;
		/* 결과값을 뭘로 받을까??를 고민한다. 
		 * 1. select를 요청헀을 떄 -> ResultSet
		 * 2. insert,update,delete를 요청했을 때 -> int
		 * */
		ResultSet rset = null;
		
		// 반환시킬 변수
		StoreDetailDTO selectedInfo = null;
		
		String query = prop.getProperty("selectInfoById");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, storeId); // <- 위치홀더의 시작인덱스값은 1부터 시작한다.
			
			rset = pstmt.executeQuery(); // 위에서 만든 쿼리문을 이용해서 데이터베이스에 질의하여 데이터 정보를 리턴받음

			if(rset.next()) {
				selectedInfo = new StoreDetailDTO();
				
				selectedInfo.setStoreName(rset.getString("STORE_NAME"));
				selectedInfo.setStar(rset.getDouble("STAR"));
				selectedInfo.setAddress(rset.getString("ADDR"));
				selectedInfo.setPhone(rset.getString("PHONE"));
				selectedInfo.setCate(rset.getString("CATE"));
				selectedInfo.setDetailInto(rset.getString("INFO"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return selectedInfo;
	}
	
	/**
	 * 리뷰 상태별 개수 select
	 * @param con
	 * @param storeId
	 * @return
	 */
	public StoreDetailDTO selectReviewCntById(Connection con, int storeId) {
		
		/* Statement를 사용할까? 아님 PreparedStatement를 사용할까 */
		PreparedStatement pstmt = null;
		/* 결과값을 뭘로 받을까??를 고민한다. 
		 * 1. select를 요청헀을 떄 -> ResultSet
		 * 2. insert,update,delete를 요청했을 때 -> int
		 * */
		ResultSet rset = null;
		
		// 반환시킬 변수
		StoreDetailDTO selectedReviewCnt = null;
		
		String query = prop.getProperty("selectReviewCntById");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, storeId); // <- 위치홀더의 시작인덱스값은 1부터 시작한다.
			
			rset = pstmt.executeQuery(); // 위에서 만든 쿼리문을 이용해서 데이터베이스에 질의하여 데이터 정보를 리턴받음

			if(rset.next()) {
				selectedReviewCnt = new StoreDetailDTO();
				
				selectedReviewCnt.setBestReviewCnt(rset.getInt("BEST"));
				selectedReviewCnt.setGoodReviewCnt(rset.getInt("SOSO"));
				selectedReviewCnt.setBadReviewCnt(rset.getInt("BAD"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return selectedReviewCnt;
	}

	/**
	 * 리뷰 정보 select
	 * @param con
	 * @param storeId
	 * @return
	 */
	public List<StoreDetailDTO> selectReviewById(Connection con, int storeId) {
		
		/* Statement를 사용할까? 아님 PreparedStatement를 사용할까 */
		PreparedStatement pstmt = null;
		/* 결과값을 뭘로 받을까??를 고민한다. 
		 * 1. select를 요청헀을 떄 -> ResultSet
		 * 2. insert,update,delete를 요청했을 때 -> int
		 * */
		ResultSet rset = null;
		
		// 반환시킬 변수
		List<StoreDetailDTO> selectedReview = null;
		
		String query = prop.getProperty("selectReviewById");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, storeId); // <- 위치홀더의 시작인덱스값은 1부터 시작한다.
			
			rset = pstmt.executeQuery(); // 위에서 만든 쿼리문을 이용해서 데이터베이스에 질의하여 데이터 정보를 리턴받음

			selectedReview = new ArrayList<>();
			
			while(rset.next()) {
				StoreDetailDTO store = new StoreDetailDTO();
				
				store.setReviewId(rset.getString("ID"));
				store.setReview(rset.getString("CONTENT"));
				store.setPhoto(rset.getString("PHOTO"));
				store.setSatisfied(rset.getInt("SATISFIED"));
								
				selectedReview.add(store);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return selectedReview;
	}

}
