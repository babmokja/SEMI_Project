package com.BoB.mvc.owner.model.service;

import static com.BoB.mvc.common.jdbc.JDBCTemplate.close;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.commit;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.getConnection;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.BoB.mvc.owner.model.dao.OwnerDAO;
import com.BoB.mvc.owner.model.dto.OwnerDTO;
import com.BoB.mvc.owner.model.dto.StoreInfoDTO;

public class OwnerService {
	
	private OwnerDAO ownerDAO = new OwnerDAO();

	public int registOwner(OwnerDTO requestOwner, StoreInfoDTO requestStore) {
		
		Connection con = getConnection();
		
		int result = ownerDAO.insertOwner(con, requestOwner, requestStore);
		
		if(result>0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}



	public OwnerDTO loginCheck(OwnerDTO requestMember) {
		
		Connection con = getConnection();
		OwnerDTO loginMember = null;
		
		String encPwd = ownerDAO.selectEncryptedPwd(con,requestMember);
		
		System.out.println("encPwd : " + encPwd);
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		/* 로그인 요청한 원문 비밀번호와 저장되어 있는 암호화된 비밀번호가 일치하는지 확인 */
		if(passwordEncoder.matches(requestMember.getMemberPwd(), encPwd)) {
			/* 비밀번호가 일치하는 경우에만 회원 정보를 조회해온다. */
			loginMember = ownerDAO.selectLoginMember(con, requestMember);
		}
		System.out.println("loginMember : " + loginMember);
		
		return loginMember;
		
	}
	
	
	
	
}
