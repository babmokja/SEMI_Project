package com.BoB.mvc.owner.model.service;

import static com.BoB.mvc.common.jdbc.JDBCTemplate.close;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.commit;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.getConnection;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.rollback;

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

	public int insertBoard(MenuListDTO newMenu, PictureDTO pictureDTO) {

		Connection con = getConnection();
		int result=0;
		int pictureResult = menuListDAO.insertPicture(con,pictureDTO);
//		
		int pictureNo = menuListDAO.selectPictureSequence(con);
		
		newMenu.setPicCode(pictureNo);
		
		int newMenuResult = menuListDAO.insertNewMenu(con,newMenu);
		
		System.out.println("########################picture result : " + pictureResult);
		System.out.println("########################newMenu result : " + newMenuResult);
		
		
		if(pictureResult > 0 && newMenuResult >0) {
			commit(con);
			result = 1;
			System.out.println("JAMES JJANG JJANG");
		}else {
			rollback(con);
		}

		return result;
	}



}
