package com.BoB.mvc.customer.model.dao;

import static com.BoB.mvc.common.jdbc.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.BoB.mvc.common.config.ConfigLocation;
import com.BoB.mvc.customer.model.dto.MenuListDTO;
import com.BoB.mvc.customer.model.dto.StoreDetailDTO;

public class MenuListDAO {
	
	/* Properties 객체를 이용해서 쿼리문을 조회해서 사용한다. 
	 * 기본생성자를 통해서 쿼리문을 조회해온다.
	 * */
	
	private Properties prop = new Properties();
	
	public MenuListDAO() {
		
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION+"store/MenuList.xml"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * 메뉴 정보 select
	 * @param con
	 * @param storeId
	 * @return
	 */
	public List<MenuListDTO> selectMenuById(Connection con, int storeId) {
		
		/* Statement를 사용할까? 아님 PreparedStatement를 사용할까 */
		PreparedStatement pstmt = null;
		/* 결과값을 뭘로 받을까??를 고민한다. 
		 * 1. select를 요청헀을 떄 -> ResultSet
		 * 2. insert,update,delete를 요청했을 때 -> int
		 * */
		ResultSet rset = null;
		
		// 반환시킬 변수
		List<MenuListDTO> selectedMenu = null;
		
		String query = prop.getProperty("selectMenuById");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, storeId); // <- 위치홀더의 시작인덱스값은 1부터 시작한다.
			
			rset = pstmt.executeQuery(); // 위에서 만든 쿼리문을 이용해서 데이터베이스에 질의하여 데이터 정보를 리턴받음
			
			selectedMenu = new ArrayList<>();
			
			while(rset.next()) {
				MenuListDTO menu = new MenuListDTO();
				
				menu.setStoreId(rset.getInt("CODE"));
				menu.setName(rset.getString("NAME"));
				menu.setPrice(rset.getInt("PRICE"));
				menu.setPhoto(rset.getString("PICTURE"));
				menu.setContent(rset.getString("EXP"));
				menu.setMenuCode(rset.getInt("MENUCODE"));
				
				selectedMenu.add(menu);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return selectedMenu;
	}

}
