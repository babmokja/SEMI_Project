package com.BoB.mvc.admin.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.Properties;

import com.BoB.mvc.admin.dto.CustomerCommentBoardDTO;
import com.BoB.mvc.admin.dto.CustomerReplyDTO;
import com.BoB.mvc.common.config.ConfigLocation;

import static com.BoB.mvc.common.jdbc.JDBCTemplate.*;

public class CustomerCommentBoardDAO {

	private final Properties prop;
	
	public CustomerCommentBoardDAO() {
		prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "admin/custom-comment.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*1*/
	public CustomerCommentBoardDTO selectCustomerComment(Connection con, int intBoardCode) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("customerComment");
		
		CustomerCommentBoardDTO customerComment = new CustomerCommentBoardDTO();
		
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, intBoardCode);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				customerComment.setBoardTitle(rset.getString("BOARD_TITLE"));
				customerComment.setBoardDate(rset.getDate("BOARD_DATE"));
				customerComment.setUserName(rset.getString("USER_NAME"));
				customerComment.setBoardContent(rset.getString("BOARD_CONTENT"));
				customerComment.setBoardCode(rset.getInt("BOARD_CODE"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return customerComment;
	}

	
	/*2*/
	public List<CustomerReplyDTO> selectCustomerReply(Connection con, int intBoardCode) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("adminComment");
		
		List<CustomerReplyDTO> replyList = new ArrayList<>();
		
		CustomerReplyDTO customerReply = new CustomerReplyDTO();
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, intBoardCode);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				customerReply.setUserName(rset.getString("USER_NAME"));
				customerReply.setReplyContent(rset.getString("REPLY_CONTENT"));
				customerReply.setReplyDate(rset.getDate("REPLY_DATE"));
				customerReply.setReplyCode(rset.getInt("REPLY_CODE"));
				
				replyList.add(customerReply);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return replyList;
	}
	
	
	/*2*/
//	public List<CustomerReplyDTO> selectCustomerReply(Connection con, int boardCode) {
//		
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		
//		String query = prop.getProperty("adminComment");
//		List<CustomerReplyDTO> adminList = new ArrayList<>();
//		
//		CustomerReplyDTO customerReplyManage = new CustomerReplyDTO();
//		
//		try {
//			pstmt = con.prepareStatement(query);
//			pstmt.setInt(1, boardCode);
//			
//			rset = pstmt.executeQuery();
//			
//			while(rset.next()) {
//				
//				CustomerReplyDTO admincomment = new CustomerReplyDTO();
//				
//				admincomment.setUserName(rset.getString("USER_NAME"));
//				admincomment.setReplyContent(rset.getString("REPLY_CONTENT"));
//				admincomment.setReplyDate(rset.getDate("REPLY_DATE"));
//				admincomment.setReplyCode(rset.getInt("REPLY_CODE"));
//				
//				adminList.add(admincomment);
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			close(rset);
//			close(pstmt);
//		}
//
//		return adminList;
//	
//	}

	public int insertStoreReply(Connection con, int boardCode) {
		
		PreparedStatement pstmt = null;
		
		
		
		int result = 0;
		
		String query = prop.getProperty("insertTotalUserReply");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, boardCode);
			
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} 
		
		return result;
	}

	public int insertCustomerReply(Connection con, String content) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("insertUserReply");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, content);
			
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}


	
	
		
	

	

}
