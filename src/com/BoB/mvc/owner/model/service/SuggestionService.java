package com.BoB.mvc.owner.model.service;

import static com.BoB.mvc.common.jdbc.JDBCTemplate.close;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.commit;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.getConnection;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.BoB.mvc.owner.model.dao.SuggestionDAO;
import com.BoB.mvc.owner.model.dto.SuggestionDTO;

public class SuggestionService {

	private final SuggestionDAO suggestionDAO;
	
	public SuggestionService(){
		suggestionDAO = new SuggestionDAO();
	}
	public List<SuggestionDTO> selectAllSuggestion(int ownerCode) {

		Connection con = getConnection();
		
		List<SuggestionDTO> suggestionList = suggestionDAO.selectAllList(con, ownerCode);
		
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

}
