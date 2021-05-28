package com.BoB.mvc.customer.model.service;

import static com.BoB.mvc.common.jdbc.JDBCTemplate.close;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.BoB.mvc.customer.model.dao.StoreDetailDAO;
import com.BoB.mvc.customer.model.dto.StoreDetailDTO;

public class StoreDetailService {
	
	/* Connection 객체 생성, 결과에 따른 트랜잭션 처리, [Connection 객체 소멸]*/ 
	
	/* StoreDetailDAO와 연결할 필드 변수 */
	private StoreDetailDAO storedetailDAO = new StoreDetailDAO();

	/**
	 * 가게 고유 번호를 이용해서 가게 이미지 정보를 select
	 * @param storeId 가게 고유 번호
	 * @return 이미지 정보
	 */
	public List<StoreDetailDTO> selectPhotoById(int storeId) {
		
		/* Connection 생성 */
		Connection con = getConnection();
		
		/* Connection과 함께 정보를 전달하여 조회를 한다. */
		List<StoreDetailDTO> selectedPhoto = storedetailDAO.selectPhotoById(con, storeId);
		
		/* Connection을 닫는다. */
		close(con);
		
		return selectedPhoto;
	}

	/**
	 * 가게 고유 번호를 이용해서 가게 정보를 select
	 * @param storeId 가게 고유 번호
	 * @return 가게 정보
	 */
	public StoreDetailDTO selectInfoById(int storeId) {
		
		/* Connection 생성 */
		Connection con = getConnection();
		
		/* Connection과 함께 정보를 전달하여 조회를 한다. */
		StoreDetailDTO selectedInfo = storedetailDAO.selectInfoById(con, storeId);
		
		/* Connection을 닫는다. */
		close(con);
		
		return selectedInfo;
	}
	
	/**
	 * 가게 고유 번호를 이용해서 가게 리뷰 상태별 개수 정보를 select
	 * @param storeId
	 * @return
	 */
	public StoreDetailDTO selectReviewCntById(int storeId) {
		
		/* Connection 생성 */
		Connection con = getConnection();
		
		/* Connection과 함께 정보를 전달하여 조회를 한다. */
		StoreDetailDTO selectedReviewCnt = storedetailDAO.selectReviewCntById(con, storeId);
		
		/* Connection을 닫는다. */
		close(con);
		
		return selectedReviewCnt;
	}

	/**
	 * 가게 고유 번호를 이용해서 가게 리뷰 정보를 select
	 * @param storeId 가게 고유 번호
	 * @return 가게 리뷰 정보
	 */
	public List<StoreDetailDTO> selectReviewById(int storeId) {
		
		/* Connection 생성 */
		Connection con = getConnection();
		
		/* Connection과 함께 정보를 전달하여 조회를 한다. */
		List<StoreDetailDTO> selectedReview = storedetailDAO.selectReviewById(con, storeId);
		
		/* Connection을 닫는다. */
		close(con);
		
		return selectedReview;
	}

}
