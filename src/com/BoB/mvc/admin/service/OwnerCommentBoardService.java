package com.BoB.mvc.admin.service;

import java.sql.Connection;
import java.util.List;

import com.BoB.mvc.admin.dao.OwnerCommentBoardDAO;
import com.BoB.mvc.admin.dto.OwnerCommentBoardDTO;
import com.BoB.mvc.admin.dto.OwnerReplyManageDTO;

import static com.BoB.mvc.common.jdbc.JDBCTemplate.*;

public class OwnerCommentBoardService {

	private OwnerCommentBoardDAO ownerCommentBoardDAO;
	
	public OwnerCommentBoardService() {
		
		ownerCommentBoardDAO = new OwnerCommentBoardDAO();
	}
	
	/*1*/
	public OwnerCommentBoardDTO selectOwnerComment(int intBoardCode) {
		
		Connection con = getConnection();
		
		OwnerCommentBoardDTO ownerList = ownerCommentBoardDAO.selectOwnerComment(con, intBoardCode);
		
		close(con);

		return ownerList;
	}
	
	/*2*/
	public List<OwnerReplyManageDTO> selectOwnerReply(int boardCode) {
		Connection con = getConnection();
		
		List<OwnerReplyManageDTO> ownerReply = ownerCommentBoardDAO.selectOwnerReply(con, boardCode);
		
		close(con);

		return ownerReply;
	}

	/*3*/
	public int insertOwnerReply(String content, int boardCode) {
		
		Connection con = getConnection();
		
		int result = 0;
		

		
		if(ownerCommentBoardDAO.insertOwnerReply(con, content) > 0) {
			if(ownerCommentBoardDAO.insertStoreReply(con, boardCode) > 0) {
				result = 1;
				commit(con);
			} else {
				rollback(con);
			}
		} else {
			rollback(con);
		}
		
		close(con);

		return result;
	}

}
