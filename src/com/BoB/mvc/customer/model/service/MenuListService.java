package com.BoB.mvc.customer.model.service;

import static com.BoB.mvc.common.jdbc.JDBCTemplate.close;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.BoB.mvc.customer.model.dao.MenuListDAO;
import com.BoB.mvc.customer.model.dto.MenuListDTO;
import com.BoB.mvc.customer.model.dto.StoreDetailDTO;

public class MenuListService {
	
	/* Connection 객체 생성, 결과에 따른 트랜잭션 처리, [Connection 객체 소멸]*/ 
	
	/* MenuListDAO와 연결할 필드 변수 */
	private MenuListDAO munulistDAO = new MenuListDAO();

	/**
	 * 가게 고유 번호를 이용해서 메뉴 정보를 select
	 * @param storeId 가게 고유 번호
	 * @return
	 */
	public List<MenuListDTO> selectMenuById(int storeId) {
		
		/* Connection 생성 */
		Connection con = getConnection();
		
		/* Connection과 함께 정보를 전달하여 조회를 한다. */
		List<MenuListDTO> selectedMenu = munulistDAO.selectMenuById(con, storeId);
		
		/* Connection을 닫는다. */
		close(con);
		
		return selectedMenu;
	}

}
