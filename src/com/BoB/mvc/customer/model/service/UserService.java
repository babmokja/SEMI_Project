package com.BoB.mvc.customer.model.service;

import static com.BoB.mvc.common.jdbc.JDBCTemplate.close;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.commit;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.getConnection;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.BoB.mvc.customer.model.dao.UserDAO;
import com.BoB.mvc.customer.model.dto.UserDTO;
import com.BoB.mvc.customer.model.dto.UserOrderDTO;

public class UserService {
	
	private final UserDAO userDAO;
	
	public UserService() {
		userDAO = new UserDAO();
		
	}
	/**
	 * @param requestUser
	 * @return
	 */
	public UserDTO loginCheck(UserDTO requestUser) {
		
		Connection con = getConnection();
		UserDTO loginUser = null;    //
		
		String encPwd = userDAO.selectEncryptedPwd(con,requestUser);
		
		System.out.println("encPwd : " + encPwd);
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		if(passwordEncoder.matches(requestUser.getPwd(), encPwd)) {
	        
			loginUser = userDAO.selectLoginUser(con, requestUser);
		}
		loginUser = userDAO.selectLoginUser(con, requestUser);
		System.out.println("loginUser : " + loginUser);
		
		return loginUser;

	}
	/**
	 * @param requestUser
	 * @return
	 */
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
	/**
	 * @param userCode
	 * @return
	 */
	public UserDTO selectOneById(int userCode) {
		
		/* Connection 생성 */
		Connection con = getConnection();
		
		/* Connection과 함께 정보를 전달하여 조회를 한다. */
		UserDTO loginUser  = userDAO.selectOneById(con, userCode);
		

		close(con);
		
		return loginUser;
	}
	/**
	 * 정보수정용 
	 * @param requestUser
	 * @return
	 */
	public int modifyUser(UserDTO requestUser) {
        
		Connection con = getConnection();
		
		int result = userDAO.modifyUser(con, requestUser);
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}
	/**회원탈퇴
	 * @param userdto
	 * @return 
	 */
	public int deleteId(UserDTO userdto) {
        Connection con = getConnection();
		
		int result = userDAO.deleteId(con, userdto);
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}
	/**
	 * @param orderUserCode
	 * @return
	 */
	public List<UserOrderDTO> latestOrder(int orderUserCode) {
		   Connection con = getConnection();
			
		   List<UserOrderDTO> result = userDAO.latestOrder(con, orderUserCode);
			
			
			close(con);
			
			return result;
		
	}
	public String idCheck(String id) {
		
		   Connection con = getConnection();
		   String idCheck = userDAO.idCheck(con,id);
	
			close(con);
			
			return idCheck;
		
	}

	public String blackCheck(UserDTO requestUser) {
		 Connection con = getConnection();
		 
		 String blackid = userDAO.blackCheck(con,requestUser);
	
			close(con);
		
		return blackid;
	}



	

}
