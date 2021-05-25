package com.BoB.mvc.admin.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.BoB.mvc.admin.dto.CustomerBoardDTO;
import com.BoB.mvc.common.config.ConfigLocation;

import static com.BoB.mvc.common.jdbc.JDBCTemplate.*;

public class CustomerBoardDAO {

	private Properties prop = new Properties();
	
	public CustomerBoardDAO() {
		
		
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION+"admin/custom-board.xml"));
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public List<CustomerBoardDTO> selectCustomerBoardList(Connection con) {
		
		Statement stmt = null;
		ResultSet rset = null;
		
		List<CustomerBoardDTO> customerBoardList = null;
		
		String query = prop.getProperty("selectCustomerList");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			customerBoardList = new ArrayList<>();
			
			while(rset.next()) {
				
				CustomerBoardDTO customerBoard = new CustomerBoardDTO();
				
				customerBoard.setBoardCode(rset.getInt("BOARD_CODE"));
				customerBoard.setBoardTitle(rset.getString("BOARD_TITLE"));
				customerBoard.setBoardDate(rset.getDate("BOARD_DATE"));
				customerBoard.setBoardContent(rset.getString("BOARD_CONTENT"));
				customerBoard.setUserCode(rset.getInt("USER_CODE"));
				customerBoard.setUserName(rset.getString("USER_NAME"));			
				
				customerBoardList.add(customerBoard);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			close(rset);
			close(stmt);
		}
		
		
		
		return customerBoardList;
	}

}
