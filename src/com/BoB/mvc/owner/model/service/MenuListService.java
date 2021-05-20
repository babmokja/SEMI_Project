package com.BoB.mvc.owner.model.service;

import static com.BoB.mvc.common.jdbc.JDBCTemplate.close;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.BoB.mvc.owner.model.dao.MenuListDAO;
import com.BoB.mvc.owner.model.dto.MenuListDTO;
import com.BoB.mvc.owner.model.dto.PictureDTO;

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

		Connection con = getConnection();
		int result=0;
//		int pictureResult = PictureDTO.insertPicture(con,)
//		
//		int result = menuListDAO.insertNewMenu(con, newMenu);
//		
//		close(con);
		return result;
	}



}
