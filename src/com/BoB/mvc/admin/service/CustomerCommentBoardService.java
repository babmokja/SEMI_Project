package com.BoB.mvc.admin.service;

import java.sql.Connection;
import java.util.List;

import com.BoB.mvc.admin.dao.CustomerCommentBoardDAO;
import com.BoB.mvc.admin.dto.CustomerCommentBoardDTO;
import com.BoB.mvc.admin.dto.CustomerReplyDTO;

import static com.BoB.mvc.common.jdbc.JDBCTemplate.*;

public class CustomerCommentBoardService {

	private CustomerCommentBoardDAO customerCommentBoardDAO;
	
	public CustomerCommentBoardService() {
		customerCommentBoardDAO = new CustomerCommentBoardDAO();
	}
	
	
	/*1*/
	public CustomerCommentBoardDTO selectOwnerComment(int intBoardCode) {
		
		Connection con = getConnection();
		
		CustomerCommentBoardDTO customercomment = customerCommentBoardDAO.selectCustomerComment(con, intBoardCode);
		
		close(con);
		
		return customercomment;
	}
	
	

	/*2*/
	public List<CustomerReplyDTO> selectCustomerReply(int intBoardCode) {
		
		Connection con = getConnection();
		
		List<CustomerReplyDTO> replyList = customerCommentBoardDAO.selectCustomerReply(con, intBoardCode);
		
		return replyList;
	}
	
	
	/*3*/
	public int insertCustomerReply(String content, int boardCode) {
		
		Connection con = getConnection();
		
		int result = 0;
		
		if(customerCommentBoardDAO.insertCustomerReply(con, content) > 0) {
			if(customerCommentBoardDAO.insertStoreReply(con, boardCode) > 0) {
				result = 1;
				commit(con);
			} else {
				rollback(con);
			}
			
			close(con);
			
		}
		
		return result;
	}







	
	
}
