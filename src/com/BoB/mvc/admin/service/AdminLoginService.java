package com.BoB.mvc.admin.service;

import java.sql.Connection;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.BoB.mvc.admin.dao.AdminDAO;
import com.BoB.mvc.admin.dto.AdminDTO;

import static com.BoB.mvc.common.jdbc.JDBCTemplate.*;

public class AdminLoginService {

	private final AdminDAO adminDAO;
	
	public AdminLoginService() {
		adminDAO = new AdminDAO();
	}
	
	
	public int selectRoleCode(String adminId) {
		
		Connection con = getConnection();
		
		int roleCode = adminDAO.selectRoleCode(con, adminId);
		
		close(con);
		
		return roleCode;
	}
	
	public AdminDTO loginCheck(AdminDTO adminmember) {
		
		Connection con = getConnection();
		AdminDTO loginAdmin = null;
		
		String encPwd = adminDAO.selectEncryptedPwd(con,adminmember);
		
		System.out.println("encPwd : " + encPwd);
		
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		/* 로그인 요청한 원문 비밀번호와 저장되어 있는 암호화된 비밀번호가 일치하는지 확인 */
		if(passwordEncoder.matches(adminmember.getPwd(), encPwd)) {
			
			/* 비밀번호가 일치하는 경우에만 회원 정보를 조회해온다. */
			loginAdmin = adminDAO.selectLoginMember(con, adminmember);
		}
		
		System.out.println("adminmember : " + adminmember);
		
		close(con);
		
		return loginAdmin;
	}

	
	
}
