package com.BoB.mvc.owner.model.service;

import static com.BoB.mvc.common.jdbc.JDBCTemplate.close;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.commit;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.getConnection;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.BoB.mvc.owner.model.dao.MenuListDAO;
import com.BoB.mvc.owner.model.dto.MenuListDTO;
import com.BoB.mvc.owner.model.dto.PictureDTO;
import com.BoB.mvc.owner.model.dto.StoreInfoDTO;

public class MenuListService {
	
	private final MenuListDAO menuListDAO;
	
	public MenuListService() {
		menuListDAO = new MenuListDAO();
	}

	public List<MenuListDTO> selectAllMenuList(StoreInfoDTO storeInfoDTO) {
		
		Connection con = getConnection();
		
		List<MenuListDTO> menuList = menuListDAO.selectAllMenuList(con,storeInfoDTO);
		
		close(con);
		
		return menuList;
	}

	public int insertBoard(MenuListDTO newMenu, PictureDTO pictureDTO, StoreInfoDTO storeInfoDTO) {

		Connection con = getConnection();
		int result = 0;
		int pictureResult = menuListDAO.insertPicture(con,pictureDTO);
		
		int pictureNo = menuListDAO.selectPictureSequence(con);
		
		newMenu.setPicCode(pictureNo);
		
		int newMenuResult = menuListDAO.insertNewMenu(con,newMenu,storeInfoDTO);
		
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

	public String getMenuname(MenuListDTO menuList) {
		
		Connection con = getConnection();
		String result = "";
		
		result = menuListDAO.getMenuname(con,menuList);
		
		close(con);

		return result;
	}

	public int updateBoard(MenuListDTO menuList, PictureDTO pictureDTO, StoreInfoDTO storeInfoDTO) {
		
		Connection con = getConnection();
		int result = 0;
		
		result = menuListDAO.updateBoard(con,menuList,storeInfoDTO);
		
		close(con);

		return result;
	}
	
	
public int deleteMenu(String MENUCode, StoreInfoDTO storeInfoDTO) {
		
		Connection con = getConnection();
		
		int result = menuListDAO.deleteMenu(MENUCode,storeInfoDTO,con);
		
		close(con);
		
		return result;
	}


}
