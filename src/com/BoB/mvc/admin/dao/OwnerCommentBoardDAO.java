package com.BoB.mvc.admin.dao;

import static com.BoB.mvc.common.jdbc.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.BoB.mvc.admin.dto.OwnerCommentBoardDTO;
import com.BoB.mvc.admin.dto.OwnerReplyManageDTO;
import com.BoB.mvc.common.config.ConfigLocation;

public class OwnerCommentBoardDAO {

	private final Properties prop;
	
	public OwnerCommentBoardDAO() {
		
		prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "admin/custom-comment.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/*1*/
	public OwnerCommentBoardDTO selectOwnerComment(Connection con, int intBoardCode) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("ownerComment");
		
		OwnerCommentBoardDTO ownerComment = new OwnerCommentBoardDTO();
		
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, intBoardCode);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				
				ownerComment.setBoardCode(rset.getInt("BOARD_CODE"));
				ownerComment.setBoardTitle(rset.getString("BOARD_TITLE"));
				ownerComment.setBoardDate(rset.getDate("BOARD_DATE"));
				ownerComment.setBoardContent(rset.getString("BOARD_CONTENT"));
				ownerComment.setUserName(rset.getString("USER_NAME"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return ownerComment;
	}
	
	/*2*/
	public List<OwnerReplyManageDTO> selectOwnerReply(Connection con, int boardCode) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectOwnerReply");
		
		List<OwnerReplyManageDTO> ownerReplyList = new ArrayList<>();
		
		OwnerReplyManageDTO ownerReplyManage = new OwnerReplyManageDTO();
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, boardCode);
			
			rset = pstmt.executeQuery();
			
		while(rset.next()) {
			
			ownerReplyManage.setUserName(rset.getString("USER_NAME"));
			ownerReplyManage.setReplyContent(rset.getString("REPLY_CONTENT"));
			ownerReplyManage.setReplyDate(rset.getDate("REPLY_DATE"));
			ownerReplyManage.setReplyCode(rset.getInt("REPLY_CODE"));
			ownerReplyList.add(ownerReplyManage);
		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return ownerReplyList;
	}
	
	/*3*/
	public int insertStoreReply(Connection con, int boardCode) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("insertStoreReply");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, boardCode);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/*4*/
	public int insertOwnerReply(Connection con, String content) {

		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("insertOwnerReply");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, content);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	

}
