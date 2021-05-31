package com.BoB.mvc.customer.model.service;

import java.sql.Connection;
import java.util.List;

import com.BoB.mvc.admin.dto.PageInfoDTO;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.close;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.commit;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.getConnection;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.rollback;

import com.BoB.mvc.customer.model.dao.UserBoardDAO;
import com.BoB.mvc.customer.model.dto.BoardDTO;

public class UserBoardService {
	
	private final UserBoardDAO boardDAO;
	
	public UserBoardService() {
		boardDAO = new UserBoardDAO();
	}

	/**
	 * 페이징 처리를 위한 전체 게시물 수 조회용 메소드
	 * @param boardDto 
	 * @return
	 */
	public int selectTotalCount(BoardDTO boardDto) {
		
		Connection con = getConnection();
		
		int totalCount = boardDAO.selectTotalCount(con,boardDto);
		System.out.println("서비스잘넘어왔나확인"+boardDto.getWriterUserCode());
		
		close(con);
		
		
		return totalCount;
	}

	public List<BoardDTO> selectBoardList(PageInfoDTO pageInfo, int writerMemberNo) {
		Connection con = getConnection();
		
		List<BoardDTO> boardList = boardDAO.selectBoardList(con, pageInfo,writerMemberNo);
		
		
		close(con);
		
		return boardList;
	}

	  public int insertBoard(BoardDTO newBoard) {
			Connection con = getConnection();
			
			int result = boardDAO.insertBoard(con, newBoard);
			
			if(result > 0) {
				commit(con);
			} else {
				rollback(con);
			}
			
			close(con);
			
			return result;
		
	}

	public BoardDTO readUserBoard(String boardNo, int userCode) {
       Connection con = getConnection();
		
		BoardDTO readBoard = boardDAO.readBoard(con,boardNo,userCode);
		
		close(con);
		
		return readBoard;
	}

	public BoardDTO readComment(String boardNo) {
		
       Connection con = getConnection();
		
		BoardDTO readComment = boardDAO.readComment(con,boardNo);
		
		close(con);
		
		return readComment;
		
		
	}

	

	



}

