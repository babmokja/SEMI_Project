package com.BoB.mvc.owner.model.service;

import static com.BoB.mvc.common.jdbc.JDBCTemplate.close;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.commit;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.getConnection;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.BoB.mvc.owner.model.dao.OwnerDAO;
import com.BoB.mvc.owner.model.dao.orderDAO;
import com.BoB.mvc.owner.model.dto.LicenseManagerDTO;
import com.BoB.mvc.owner.model.dto.OwnerDTO;
import com.BoB.mvc.owner.model.dto.PageInfoDTO;
import com.BoB.mvc.owner.model.dto.PictureDTO;
import com.BoB.mvc.owner.model.dto.ReviewBoardListDTO;
import com.BoB.mvc.owner.model.dto.SelectBeforeModifyDTO;
import com.BoB.mvc.owner.model.dto.StoreInfoDTO;
import com.BoB.mvc.owner.model.dto.SuggestionDTO;

public class OwnerService {
	
	private final OwnerDAO ownerDAO;
	private orderDAO orderDAO;
	
	public OwnerService() {
		orderDAO = new orderDAO();
		ownerDAO = new OwnerDAO();
	}



	public int registOwner(Map<String, PictureDTO> picture, LicenseManagerDTO lm, OwnerDTO owner, StoreInfoDTO store) {
		
		Connection con = getConnection();
		int result5 = 0;
		
		int result1 = ownerDAO.insertPicture(con, picture);
		System.out.println("result1 : "+ result1);
		if(result1==2) {commit(con);}
		else {rollback(con);}
		
		int result2 = ownerDAO.insertLicenseManager(con,lm,picture);
		System.out.println("result2 : " + result2);
		if(result1==2 && result2>0) {commit(con);}
		else {rollback(con);}
			
		int result3 = ownerDAO.insertOwner(con, owner);
		System.out.println("result3"+result3);
		if(result1==2 && result2>0&&result3>0) {commit(con);}
		else {rollback(con);}
		
		int result4 = ownerDAO.insertStore(con,store,picture,owner,lm);
		System.out.println("result4"+result4);
		if(result1==2 && result2>0&&result3>0&&result4>0) {commit(con);}
		else {rollback(con);}
		
		result5 = ownerDAO.insertPICtable(con, store, picture, owner, lm);
		System.out.println("result5"+result5);
		if(result1==2 && result2>0&&result3>0&&result4>0&&result5>0) {commit(con);}
		else {rollback(con);}
		
		close(con);
		
		return result5;
	}



	public Map<String, Object> loginCheck(OwnerDTO requestMember) {
		
		Connection con = getConnection();
		Map<String, Object> loginmap = new HashMap<String, Object>();
		
		String encPwd = ownerDAO.selectEncryptedPwd(con,requestMember);
		
		System.out.println("encPwd : " + encPwd);
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		/* ????????? ????????? ?????? ??????????????? ???????????? ?????? ???????????? ??????????????? ??????????????? ?????? */
		if(passwordEncoder.matches(requestMember.getMemberPwd(), encPwd)) {
			/* ??????????????? ???????????? ???????????? ?????? ????????? ???????????????. */
			loginmap =  ownerDAO.selectLoginMember(con, requestMember);
		}
		
		close(con);
		
		return loginmap;
		
	}



	public String IdCheck(String memberId) {
		
		Connection con = getConnection();
		
		String checkId = ownerDAO.IdCheck(con,memberId);
		
		close(con);
		
		return checkId;
	}



	public SelectBeforeModifyDTO OwnerModifyInfo(String id) {
		
		Connection con = getConnection();
		SelectBeforeModifyDTO dto = new SelectBeforeModifyDTO();
		dto = ownerDAO.ModifyInfo(con,id);
		
		close(con);
		
		
		return dto;
	}



	public int updateOwner(Map<String, PictureDTO> picture, LicenseManagerDTO lm, OwnerDTO owner, StoreInfoDTO store, OwnerDTO ownerDTO, LicenseManagerDTO lmDTO, StoreInfoDTO storeInfoDTO) {
		
		Connection con = getConnection();
		int result4 = 0;
		
		int result1 = ownerDAO.modifyPicture(con, picture,lm,storeInfoDTO,ownerDTO,lmDTO);
		System.out.println("result1 : "+ result1);
		if(result1==2) {commit(con);}
		else {rollback(con);}
		
		int result2 = ownerDAO.modifyLicenseManager(con,lm,picture,lmDTO,storeInfoDTO);
		System.out.println("result2 : " + result2);
		if(result1==2 && result2>0) {commit(con);}
		else {rollback(con);}
			
		int result3 = ownerDAO.modifyOwner(con, owner,ownerDTO,lmDTO);
		System.out.println("result3"+result3);
		if(result1==2 && result2>0&&result3>0) {commit(con);}
		else {rollback(con);}
		
		result4 = ownerDAO.modifyStore(con,store,picture,owner,lm,storeInfoDTO);
		System.out.println("result4"+result4);
		if(result1==2 && result2>0&&result3>0&&result4>0) {commit(con);}
		else {rollback(con);}
					
		
		close(con);
		
		
		return result4;
	}



	public int selectReviewReplyTotalCount(StoreInfoDTO storeDTO) {
		
		Connection con = getConnection();
		
		int totalCount = ownerDAO.selectReviewReplyTotalCount(con,storeDTO);
		
		close(con);
		
		return totalCount;
	}



	public List<ReviewBoardListDTO> selectReviewList(PageInfoDTO pageInfo, StoreInfoDTO storeDTO) {
		
		Connection con = getConnection();
		
		List<ReviewBoardListDTO> ReviewList = ownerDAO.selectReviewList(con,pageInfo,storeDTO);
		
		close(con);
		
		return ReviewList;
	}



	public int selectReviewReplyTotalCount(String condition, String value) {
		
		Connection con = getConnection();
		
		int totalsearchcount = ownerDAO.selectReviewList(con,condition,value);
		
		close(con);
		
		return totalsearchcount;
	}



	public List<ReviewBoardListDTO> selectSearchReviewList(String condition, String value, PageInfoDTO pageInfo, OwnerDTO ownerDTO, StoreInfoDTO storeDTO, LicenseManagerDTO lmDTO) {
		
		Connection con = getConnection();
		
		List<ReviewBoardListDTO> ReviewSearchList = ownerDAO.selectSearchReviewList(con,condition, value, pageInfo,storeDTO);
		
		close(con);
		
		return ReviewSearchList;
		
	}



	public ReviewBoardListDTO selectCommentDetail(String boardNo) {
		
		Connection con = getConnection();
		
		ReviewBoardListDTO commentDetail = ownerDAO.selectCommentDetail(con,boardNo);
		
		close(con);
		
		return commentDetail;
	}







	






//	public ReviewBoardListDTO selectNoticeDetail(int no) {
//		
//		Connection con = getConnection();
//		ReviewBoardListDTO reviewDetail = null;
////		
////		int result = ownerDAO.incrementReviewCount
////		
////		ReviewSearchList = ownerDAO.selectReviewList(con,condition, value, pageInfo);
////		
////		close(con);
////		
////		return ReviewSearchList;
//	}
	
	
	
	
}
