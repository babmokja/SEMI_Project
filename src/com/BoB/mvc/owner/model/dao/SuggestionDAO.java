package com.BoB.mvc.owner.model.dao;

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
import com.BoB.mvc.owner.model.dto.SuggestionDTO;

public class SuggestionDAO {
	
	private final Properties prop;
	
	public SuggestionDAO(){
		prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION+"owner/owner-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<SuggestionDTO> selectAllList(Connection con) { 
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<SuggestionDTO> suggestionList = null;
		
		String query = prop.getProperty("selectAllSuggestion");
		
		try {
			suggestionList = new ArrayList<>();
			pstmt= con.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				SuggestionDTO suggestion = new SuggestionDTO();
				
				suggestion.setBoardCode(rset.getInt("BOARD_CODE"));
				suggestion.setBoardTitle(rset.getString("BOARD_TITLE"));
				suggestion.setBoardDate(rset.getDate("BOARD_DATE"));
				
				suggestionList.add(suggestion);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
	
		
		return suggestionList;
	}

	public int insertSuggestion(Connection con, SuggestionDTO suggestionDTO) {

		PreparedStatement pstmt = null;
		
		int result =0;
		
		String query=prop.getProperty("InsertSuggestion");
		
		try {
			pstmt=con.prepareStatement(query);
			
			pstmt.setString(1, suggestionDTO.getBoardTitle());
			pstmt.setString(2, suggestionDTO.getBoardContent());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}

	public SuggestionDTO selectDetail(Connection con, String boardNo) {

		PreparedStatement pstmt = null;
		
		SuggestionDTO suggestionDTO = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("SuggestionDetail");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(boardNo));
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				suggestionDTO = new SuggestionDTO();
				suggestionDTO.setBoardTitle(rset.getString("boardTitle"));
				suggestionDTO.setBoardContent(rset.getString("boardContent"));
				suggestionDTO.setBoardDate(rset.getDate("boardDate"));
				suggestionDTO.setReplyContent(rset.getString("replyContent"));
				suggestionDTO.setReplyDate(rset.getDate("replyDate"));
				

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
	
		
		return suggestionDTO;
	}

}
