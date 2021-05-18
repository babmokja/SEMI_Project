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
				menu.setMenuCode(rset.getString("MENU_CODE"));
				menu.setMenuName(rset.getString("MENU_NAME"));
				menu.setMenuExplain(rset.getString("MENU_EXP"));
				menu.setPrice(rset.getInt("PRICE"));
				menu.setSalesYN(rset.getString("SALES_YN"));
				menu.setStoreCode(rset.getInt("STORE_CODE"));
				menu.setPictureCode(rset.getInt("PICTURE_CODE"));
				
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

}
