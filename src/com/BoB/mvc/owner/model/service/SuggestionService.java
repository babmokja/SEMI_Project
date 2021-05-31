package com.BoB.mvc.owner.model.service;

import static com.BoB.mvc.common.jdbc.JDBCTemplate.close;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.commit;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.getConnection;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.BoB.mvc.owner.model.dao.SuggestionDAO;
import com.BoB.mvc.owner.model.dto.PageInfoDTO;
import com.BoB.mvc.owner.model.dto.ReplyDTO;
import com.BoB.mvc.owner.model.dto.SuggestionDTO;

public class SuggestionService {

	private final SuggestionDAO suggestionDAO;
	
	public SuggestionService(){
		suggestionDAO = new SuggestionDAO();
	}
	
	public List<SuggestionDTO> selectAllSuggestion(PageInfoDTO pageInfo, int ownerCode) {

		Connection con = getConnection();
		
		List<SuggestionDTO> suggestionList = suggestionDAO.selectAllList(con, pageInfo,ownerCode);
		
		close(con);
		
		
		return suggestionList;
	}
	public int insertSuggestion(SuggestionDTO suggestionDTO) {
		
		Connection con =getConnection();
		
		int result = suggestionDAO.insertSuggestion(con,suggestionDTO);
		
		if(result>0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		
		return result;
	}
	public SuggestionDTO selectDetailSuggestion(String boardNo) {

		Connection con = getConnection();
		
		SuggestionDTO suggestionDetail = suggestionDAO.selectDetail(con,boardNo);
		
		close(con);
		return suggestionDetail;
	}

	public int selectSuggestionTotalCount(int ownerCode) {
		
		Connection con = getConnection();
		
		int totalCount = suggestionDAO.selectSuggestionTotalCount(con,ownerCode);
		
		close(con);
		
		return totalCount;
	}

	public ReplyDTO selectDetailReply(String boardNo) {

		Connection con = getConnection();
		
		ReplyDTO replyDetail = suggestionDAO.selectReplyDetail(con, boardNo);
		
		close(con);
		
		return replyDetail;
	}


}
