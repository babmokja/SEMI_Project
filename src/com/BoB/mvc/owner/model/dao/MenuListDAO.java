package com.BoB.mvc.owner.model.dao;

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
import com.BoB.mvc.owner.model.dto.MenuListDTO;
import com.BoB.mvc.owner.model.dto.PictureDTO;

public class MenuListDAO {
	
	private final Properties prop;
	
	public MenuListDAO() {
		prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION+"owner-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<MenuListDTO> selectAllMenuList(Connection con) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<MenuListDTO> menuList = null;
		
		String query = prop.getProperty("selectAllMenuList");
		
		try {
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			menuList = new ArrayList<>();
			
			while(rset.next()) {
				
				MenuListDTO menu = new MenuListDTO();
				menu.setPictureCode(new PictureDTO());
//				menu.setStoreCode(new Stor);
				

				menu.setMenuCode(rset.getString("MENU_CODE"));
				menu.setMenuName(rset.getString("MENU_NAME"));
				menu.setMenuExplain(rset.getString("MENU_EXP"));
				menu.setPrice(rset.getInt("PRICE"));
				menu.setSalesYN(rset.getString("SALES_YN"));
				menu.setStoCode(rset.getInt("STORE_CODE"));
//				menu.getStoreCode().setStoreNum(rset.getInt("STORE_CODE"));

				menu.getPictureCode().setRevisedName(rset.getString("REVISED_NAME"));
				menu.getPictureCode().setRoute(rset.getString("ROUTE"));
				menu.getPictureCode().setPictureCode(rset.getInt("PICTURE_CODE"));
//				menu.setStoreCode(rset.getInt("STORE_CODE"));
//				menu.setPictureCode(rset.getInt("PICTURE_CODE"));

				
				menuList.add(menu);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return menuList;
	}


	public int insertPicture(Connection con, PictureDTO pictureDTO) {
		
		PreparedStatement pstmt = null;
		int result =0;
		
		String query = prop.getProperty("insertPicture");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, pictureDTO.getOriginName());
			pstmt.setString(2, pictureDTO.getRevisedName());
			pstmt.setString(3, pictureDTO.getRoute());
			
			result= pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}

		
		return result;
	}

	public int selectPictureSequence(Connection con) {
		
		Statement stmt = null;
		ResultSet rset = null;
		
		int pictureNo = 0;
		
		String query = prop.getProperty("selectPictureSequence");
		
		try {
			stmt = con.createStatement();
			
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				pictureNo = rset.getInt("CURRVAL");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		return pictureNo;
	}

	public int insertNewMenu(Connection con, MenuListDTO newMenu) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("insertNewMenu");
		
		try {
			pstmt =con.prepareStatement(query);
			pstmt.setString(1, newMenu.getMenuName());
			pstmt.setInt(2, newMenu.getPrice());
			pstmt.setString(3, newMenu.getMenuExplain());
			pstmt.setString(4, newMenu.getSalesYN());
			pstmt.setInt(5,newMenu.getPicCode());
			pstmt.setInt(6, newMenu.getStoCode());
		
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

}
