package com.BoB.mvc.owner.model.service;

import static com.BoB.mvc.common.jdbc.JDBCTemplate.close;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.BoB.mvc.owner.model.dao.MenuListDAO;
import com.BoB.mvc.owner.model.dto.MenuListDTO;

public class MenuListService {
	
	private final MenuListDAO menuListDAO;
	
	public MenuListService() {
		menuListDAO = new MenuListDAO();
	}

	public List<MenuListDTO> selectAllMenuList() {
		
		Connection con = getConnection();
		
		List<MenuListDTO> menuList = menuListDAO.selectAllMenuList(con);
		
		close(con);
		
		return menuList;
	}

	public int insertBoard(MenuListDTO newMenu) {

		return 0;
	}

}
