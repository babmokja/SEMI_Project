package com.BoB.mvc.customer.model.service;

import static com.BoB.mvc.common.jdbc.JDBCTemplate.close;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.commit;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.getConnection;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.BoB.mvc.customer.model.dao.OrderPayDAO;
import com.BoB.mvc.customer.model.dto.OrderPayDTO;
import com.BoB.mvc.customer.model.dto.StoreListDTO;

public class OrderPayService {
	
	/* Connection 객체 생성, 결과에 따른 트랜잭션 처리, [Connection 객체 소멸]*/ 
	
	/* MenuListDAO와 연결할 필드 변수 */
	private OrderPayDAO orderpayDAO = new OrderPayDAO();

	/**
	 * 장바구니 테이블에 메뉴 저장하는 메소드
	 * @param basket
	 * @return
	 */
	public int insertMenu(OrderPayDTO basket) {
		
		/* Connection 생성 */
		Connection con = getConnection();
		
		int result = orderpayDAO.insert(con,basket);
		
		int cnt = 1;

		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
	
		return result;
		
	}
	
	/**
	 * 사용자 코드를 이용해 사용자의 포인트 조회
	 * @param userCodeSelect
	 * @return
	 */
	public OrderPayDTO selectPoint(int userCodeSelect) {
		
		/* Connection 생성 */
		Connection con = getConnection();
		
		/* Connection과 함께 정보를 전달하여 조회를 한다. */
		OrderPayDTO selectedPoint = orderpayDAO.selectPoint(con, userCodeSelect);
		
		/* Connection을 닫는다. */
		close(con);
		
		return selectedPoint;
	}
	
	/**
	 * 사용자 코드를 이용해 사용자가 장바구니에 담은 메뉴 리스트를 조회
	 * @param userCodeSelect
	 * @return
	 */
	public List<OrderPayDTO> selectBasket(int userCodeSelect) {
		
		/* Connection 생성 */
		Connection con = getConnection();
		
		/* Connection과 함께 정보를 전달하여 조회를 한다. */
		List<OrderPayDTO> selectedBasket = orderpayDAO.selectBasket(con, userCodeSelect);
		
		/* Connection을 닫는다. */
		close(con);
		
		return selectedBasket;
	}

}
