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
	public List<CustomerCommentBoardDTO> selectCostomerComment(int intBoardCode) {
		
		Connection con = getConnection();
		
		List<CustomerCommentBoardDTO> customerList = customerCommentBoardDAO.selectCostomerComment(con, intBoardCode);
		
		close(con);
		
		return customerList;
	}
	
	/*2*/
	public List<CustomerReplyDTO> selectAdminComment(int boardCode) {
		
		Connection con = getConnection();
		
		List<CustomerReplyDTO> customerReply = customerCommentBoardDAO.selectCustomerReply(con, boardCode);
		
		return customerReply;
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
