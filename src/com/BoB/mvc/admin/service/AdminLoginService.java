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


	public AdminDTO loginCheck(String adminId, String adminPwd) {
		Connection con = getConnection();
		AdminDTO loginAdmin = null;
		String encPwd = adminDAO.selectEncryptedPwd(con,adminId,adminPwd);
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		loginAdmin = adminDAO.selectLoginMember(con, adminId,adminPwd);	
		
		close(con);
		
		return loginAdmin;
		
	}
	


	

	
	
}
