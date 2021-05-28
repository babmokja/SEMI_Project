package com.BoB.mvc.customer.model.dao;

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

import com.BoB.mvc.admin.dto.PageInfoDTO;
import com.BoB.mvc.common.config.ConfigLocation;
import com.BoB.mvc.customer.model.dto.BoardDTO;
import com.BoB.mvc.customer.model.dto.UserDTO;

public class UserBoardDAO {
	
	private final Properties prop;
	
	public UserBoardDAO() {
		prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "user/user-mapper.xml"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public List<BoardDTO> selectBoardList(Connection con, PageInfoDTO pageInfo, int writerMemberNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<BoardDTO> boardList = null;
		
		
		String query = prop.getProperty("selectBoardList");
		
	    
		
		try {
			
			pstmt = con.prepareStatement(query);
            pstmt.setInt(1, writerMemberNo);
			pstmt.setInt(2, pageInfo.getStartRow());
			pstmt.setInt(3, pageInfo.getEndRow());

		
			rset = pstmt.executeQuery();
			
			boardList = new ArrayList<>();
			
			while(rset.next()) {
				BoardDTO board = new BoardDTO();
				board.setTitle(rset.getString("BOARD_TITLE"));
				board.setBody(rset.getString("BOARD_CONTENT"));
				board.setCreatedDate(rset.getDate("BOARD_DATE"));
				board.setNo(rset.getInt("BOARD_CODE"));
				
				
	
				boardList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return boardList;
	}

	public int selectTotalCount(Connection con, BoardDTO boardDto) {

		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		int totalCount = 0;
		
		String query = prop.getProperty("selectTotalCount");
	    System.out.println("dao 잘넘어왔나확인!!!"+boardDto.getWriterUserCode());
		
		try {
			
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, boardDto.getWriterUserCode());

			rset = pstmt.executeQuery();
			
			if(rset.next()) {
		
				totalCount = rset.getInt("COUNT(*)");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println( "쿼리에서 잘가져왔나??????" +totalCount);
		return totalCount;
		
	
	}

	public int insertBoard(Connection con, BoardDTO newBoard) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("insertBoard");
		System.out.println("제목"+newBoard.getTitle());
	    System.out.println("body"+newBoard.getBody());
	    System.out.println("userNo"+newBoard.getWriterUserCode());
		try {
			pstmt = con.prepareStatement(query);
	
			pstmt.setString(1, newBoard.getTitle());
			pstmt.setString(2, newBoard.getBody());
			pstmt.setInt(3, newBoard.getWriterUserCode());
			

			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public BoardDTO readBoard(Connection con, String boardNo) {
        
		PreparedStatement pstmt = null;
		
        BoardDTO BoardDTO = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("ReadBoard");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(boardNo));
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				BoardDTO = new BoardDTO();
				BoardDTO.setTitle(rset.getString("boardTitle"));
				BoardDTO.setBody(rset.getString("boardContent"));
				BoardDTO.setCreatedDate(rset.getDate("boardDate"));
				BoardDTO.setReply(rset.getString("replyContent"));
				BoardDTO.setReplyDate(rset.getDate("replyDate"));
				

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
	
		
		return BoardDTO;
		
	}



}
