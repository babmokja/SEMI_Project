package com.BoB.mvc.customer.model.service;

import static com.BoB.mvc.common.jdbc.JDBCTemplate.close;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.BoB.mvc.customer.model.dao.StoreListDAO;
import com.BoB.mvc.customer.model.dto.PageInfoDTO;
import com.BoB.mvc.customer.model.dto.StoreListDTO;

public class StoreListService {
	
	/* Connection 객체 생성, 결과에 따른 트랜잭션 처리, [Connection 객체 소멸]*/ 
	
	/* StoreListDAO와 연결할 필드 변수 */
	private StoreListDAO storelistDAO = new StoreListDAO();

	/**
	 * 카테고리 & 유형별 가게 리스트 조회
	 * @param type 배달 / 픽업 / 배달&픽업
	 * @param cate 카테고리
	 * @param order 
	 * @param pageInfo 
	 * @param storeId 
	 * @return
	 */
	public List<StoreListDTO> selectStore(String cate, String type, String order, PageInfoDTO pageInfo, int storeId) {
		
		/* Connection 생성 */
		Connection con = getConnection();
		
		/* Connection과 함께 정보를 전달하여 조회를 한다. */
		List<StoreListDTO> selectedStore = storelistDAO.selectStore(con, cate, type, order, pageInfo, storeId);
		
		/* Connection을 닫는다. */
		close(con);
		
		return selectedStore;
	}

	/**
	 * 페이징 처리를 위한 전체 게시물 수 조회용 메소드
	 * @return
	 */
	public int selectTotalCount(String cate, String type) {
		
		Connection con = getConnection();
		
		int totalCount = storelistDAO.selectTotalCount(con, cate, type);
		
		close(con);
		
		return totalCount;
	}
	
}
