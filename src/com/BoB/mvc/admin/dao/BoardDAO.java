package com.BoB.mvc.admin.dao;

import static com.BoB.mvc.common.jdbc.JDBCTemplate.close;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.BoB.mvc.admin.dto.CustomerBoardDTO;
import com.BoB.mvc.admin.dto.PageInfoDTO;
import com.BoB.mvc.common.config.ConfigLocation;

public class BoardDAO {
	private final Properties prop;

	public BoardDAO() {
		prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "admin/admin-mapper.xml"));
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}

	public int selectStoBoardTotalCount(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		
		int totalCount = 0;
		String query = prop.getProperty("selectBoardTotalCount");

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				totalCount = rset.getInt("COUNT(*)");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		
		
		return totalCount;
	}

	public List<CustomerBoardDTO> selectStoBoardList(Connection con, PageInfoDTO pageInfo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<CustomerBoardDTO> boardList = null;
		String query = prop.getProperty("selectBoardList");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, pageInfo.getStartRow());
			pstmt.setInt(2, pageInfo.getEndRow());
			System.out.println(pageInfo.getStartRow());
			System.out.println(pageInfo.getEndRow());
			rset = pstmt.executeQuery();
			boardList = new ArrayList<>();
			
			
			while(rset.next()) {
				CustomerBoardDTO board = new CustomerBoardDTO();
				board.setBoardCode(rset.getInt("BOARD_CODE"));
				board.setBoardTitle(rset.getString("BOARD_TITLE"));
				board.setBoardDate(rset.getDate("BOARD_DATE"));
				board.setUserCode(rset.getInt("OWNER_CODE"));
				board.setUserName(rset.getString("USER_NAME"));
				board.setVisible(rset.getString("VISIBLE_YN"));
				boardList.add(board);
			}
			
		}
			catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
		
		return boardList;
	}

	public int searchBoardCount(Connection con, String condition, String value) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		String query = null;
		int totalCount = 0;
		
		if(condition.equals("boardTitle")) {
			query = prop.getProperty("boardTitleCount");
		}else if(condition.equals("userName")) {
			query = prop.getProperty("userNameCount");
		}
		try {
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, value);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				totalCount = rset.getInt("COUNT(*)");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return totalCount;
	}

	public List<CustomerBoardDTO> searchBoardList(Connection con, PageInfoDTO pageInfo, String condition, String value) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<CustomerBoardDTO> boardList = null;
		
		String query = null;
		
		if(condition.equals("boardTitle")) {
			query = prop.getProperty("searchBoardTitle");
		}else if(condition.equals("userName")) {
			query = prop.getProperty("searchUserName");
		}
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, value);
			pstmt.setInt(2, pageInfo.getStartRow());
			pstmt.setInt(3, pageInfo.getEndRow());
			boardList = new ArrayList<>();
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				CustomerBoardDTO board = new CustomerBoardDTO();
				board.setBoardCode(rset.getInt("BOARD_CODE"));
				board.setBoardTitle(rset.getString("BOARD_TITLE"));
				board.setBoardDate(rset.getDate("BOARD_DATE"));
				board.setUserCode(rset.getInt("OWNER_CODE"));
				board.setUserName(rset.getString("USER_NAME"));
				board.setVisible(rset.getString("VISIBLE_YN"));
				boardList.add(board);
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return boardList;
	}

	public int selectCusBoardTotalCount(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		
		int totalCount = 0;
		String query = prop.getProperty("selectCusBoardTotalCount");

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				totalCount = rset.getInt("COUNT(*)");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		
		
		return totalCount;
	}

	public List<CustomerBoardDTO> selectCusBoardList(Connection con, PageInfoDTO pageInfo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<CustomerBoardDTO> boardList = null;
		String query = prop.getProperty("selectCusBoardList");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, pageInfo.getStartRow());
			pstmt.setInt(2, pageInfo.getEndRow());
			System.out.println(pageInfo.getStartRow());
			System.out.println(pageInfo.getEndRow());
			rset = pstmt.executeQuery();
			boardList = new ArrayList<>();
			
			
			while(rset.next()) {
				CustomerBoardDTO board = new CustomerBoardDTO();
				board.setBoardCode(rset.getInt("BOARD_CODE"));
				board.setBoardTitle(rset.getString("BOARD_TITLE"));
				board.setBoardDate(rset.getDate("BOARD_DATE"));
				board.setUserCode(rset.getInt("USER_CODE"));
				board.setUserName(rset.getString("USER_NAME"));
				board.setVisible(rset.getString("VISIBLE_YN"));
				boardList.add(board);
			}
			
		}
			catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
		
		return boardList;
	}

	public int searchCusBoardCount(Connection con, String condition, String value) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		String query = null;
		int totalCount = 0;
		
		if(condition.equals("boardTitle")) {
			query = prop.getProperty("CusBoardTitleCount");
		}else if(condition.equals("userName")) {
			query = prop.getProperty("CusUserNameCount");
		}
		try {
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, value);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				totalCount = rset.getInt("COUNT(*)");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return totalCount;
	}

	public List<CustomerBoardDTO> searchCusBoardList(Connection con, PageInfoDTO pageInfo, String condition,
			String value) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<CustomerBoardDTO> boardList = null;
		
		String query = null;
		
		if(condition.equals("boardTitle")) {
			query = prop.getProperty("searchCusBoardTitle");
		}else if(condition.equals("userName")) {
			query = prop.getProperty("searchCusUserName");
		}
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, value);
			pstmt.setInt(2, pageInfo.getStartRow());
			pstmt.setInt(3, pageInfo.getEndRow());
			boardList = new ArrayList<>();
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				CustomerBoardDTO board = new CustomerBoardDTO();
				board.setBoardCode(rset.getInt("BOARD_CODE"));
				board.setBoardTitle(rset.getString("BOARD_TITLE"));
				board.setBoardDate(rset.getDate("BOARD_DATE"));
				board.setUserCode(rset.getInt("USER_CODE"));
				board.setUserName(rset.getString("USER_NAME"));
				board.setVisible(rset.getString("VISIBLE_YN"));
				boardList.add(board);
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return boardList;
	}
	
	
	
	
}
