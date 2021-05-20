package com.BoB.mvc.customer.model.service;

import static com.BoB.mvc.common.jdbc.JDBCTemplate.close;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.commit;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.getConnection;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.BoB.mvc.customer.model.dao.UserDAO;
import com.BoB.mvc.customer.model.dto.UserDTO;

public class UserService {
	
	private final UserDAO userDAO;
	
	public UserService() {
		userDAO = new UserDAO();
		
	}
	public UserDTO loginCheck(UserDTO requestUser) {
		
		Connection con = getConnection();
		UserDTO loginUser = null;    //
		
		String encPwd = userDAO.selectEncryptedPwd(con,requestUser);
		
		System.out.println("encPwd : " + encPwd);
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		if(passwordEncoder.matches(requestUser.getPwd(), encPwd)) {
	        
			loginUser = userDAO.selectLoginUser(con, requestUser);
		}
		System.out.println("loginUser : " + loginUser);
		
		return loginUser;

	}
	public int registUser(UserDTO requestUser) {
		Connection con = getConnection();
		
	    int result = userDAO.insertUser(con,requestUser);
	    
	    if(result >0) {
	    	commit(con);
	    	
	    }else {
	    	rollback(con);
	    }
	     close(con);
	     
		return result;
	}

	
	

}
