package com.BoB.mvc.customer.model.dao;

import static com.BoB.mvc.common.jdbc.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.BoB.mvc.common.config.ConfigLocation;
import com.BoB.mvc.customer.model.dto.UserDTO;
import com.BoB.mvc.customer.model.dto.UserOrderDTO;


/**
 * @author haelim
 *
 */
public class UserDAO {
	
	private final Properties prop;
	private static UserDAO instance;

	
	
	public UserDAO() {
		prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "user/user-mapper.xml"));
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
   public static UserDAO getInstance(){
        if(instance==null)
            instance=new UserDAO();
        return instance;
    }



	/**암호화 처리된 비밀번호 조회용 메소
	 * @param con 연결객
	 * @param requestUser
	 * @return
	 */
	public String selectEncryptedPwd(Connection con, UserDTO requestUser) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String encPwd = null;
		
		String query = prop.getProperty("selectEncryptedPwd");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, requestUser.getId());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				encPwd = rset.getString("USER_PWD");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return encPwd;
	}
	/**
	 * @param con
	 * @param requestUser
	 * @return
	 */
	public UserDTO selectLoginUser(Connection con, UserDTO requestUser) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		UserDTO loginUser = null;
		
		String query = prop.getProperty("selectLoginUser");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, requestUser.getId());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				loginUser = new UserDTO();
				
				loginUser.setUserCode(rset.getInt("USER_CODE"));
				loginUser.setId(rset.getString("USER_ID"));
				loginUser.setName(rset.getString("USER_NAME"));
				loginUser.setPhone(rset.getString("USER_PHONE"));
				loginUser.setAddress(rset.getString("USER_ADDRESS"));
				loginUser.setPoint(rset.getInt("POINT"));
				loginUser.setEmail(rset.getString("USER_EMAIL"));
				loginUser.setRoleCode(rset.getInt("ROLE_CODE"));
				loginUser.setUserNo(rset.getString("USER_NO"));
				loginUser.setBlacklistYn(rset.getString("BLACKLIST_YN"));


			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return loginUser;

	}
	/**
	 * @param con
	 * @param requestUser
	 * @return
	 */
	public int insertUser(Connection con, UserDTO requestUser) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("insertUser");
        
		try {
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, requestUser.getId());
			pstmt.setString(2, requestUser.getPwd());
			pstmt.setString(3, requestUser.getName());
			pstmt.setString(4, requestUser.getPhone());
			pstmt.setString(5, requestUser.getAddress());
			pstmt.setString(6, requestUser.getEmail());
			pstmt.setString(7, requestUser.getUserNo());
			
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
      
		return result;
	}
	/**
	 * 정보수정시 회원정보 불러오는 메소
	 * @param con
	 * @param userCode
	 * @return
	 */
	public UserDTO selectOneById(Connection con, int userCode) {
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		
		UserDTO loginUser = null;
		
		String query = prop.getProperty("selectUserById");
		
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userCode);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				loginUser = new UserDTO();
				
				loginUser.setId(rset.getString("USER_ID"));
				loginUser.setPwd(rset.getString("USER_PWD"));
				loginUser.setName(rset.getString("USER_NAME"));
				loginUser.setPhone(rset.getString("USER_PHONE"));
				loginUser.setAddress(rset.getString("USER_ADDRESS"));
				loginUser.setEmail(rset.getString("USER_EMAIL"));
				loginUser.setPoint(rset.getInt("POINT"));				
				
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		
		
		return loginUser;
	}
	
	
	/**아이디 중복확인용 
	 * @param userId
	 * @return
	 */

	public int confirmID(Connection con, String userId) {
        PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		int result= -1;
		String query = prop.getProperty("selectUserById");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = 1;
				
			}else {
				result= -1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return result ;
	}
	/**정보수정용
	 * @param con
	 * @param requestUser
	 * @return
	 */
	public int modifyUser(Connection con, UserDTO requestUser) {
        
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("modifyUser");
	   System.out.println("값 넘어왔는지 확" +requestUser);
		
		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, requestUser.getPwd());
			pstmt.setString(2, requestUser.getPhone());
			pstmt.setString(3, requestUser.getAddress());
			pstmt.setString(4, requestUser.getEmail());
			pstmt.setString(5, requestUser.getId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
	
		return result;
	}
	/**
	 * @param con
	 * @param userdto
	 * @return
	 */
	public int deleteId(Connection con, UserDTO userdto) {
        PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("deleteId");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, userdto.getUserCode());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return result;
	}
	public List<UserOrderDTO> latestOrder(Connection con, int orderUserCode) {
		   PreparedStatement pstmt = null;
		   ResultSet rset = null;

		   List<UserOrderDTO> result = null;
		   
		  
		
		   String query = prop.getProperty("latestOrder");
		  
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, orderUserCode);
			
			rset = pstmt.executeQuery();
			
			result = new ArrayList<>();
			while(rset.next()) {
				
				UserOrderDTO order = new UserOrderDTO();
				order.setOrderDate(rset.getDate("ORDER_TIME"));
				order.setOrderType(rset.getString("TYPE_YN"));
				order.setStoreName(rset.getString("STORE_NAME"));
				order.setProceed(rset.getString("ORDER_PROCEED"));
				order.setOwnerComment(rset.getString("OWNER_COMMENT"));
				order.setOrderCode(rset.getInt("ORDER_CODE"));
				order.setStoreCode(rset.getInt("STORE_CODE"));
				
						
				result.add(order);
			}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		
		System.out.println(result);
		return result;
	}
	public String idCheck(Connection con, String id) {
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String checkId = "";
		
		String query = prop.getProperty("idCheck");
	   
		
		try {
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);

			rset = pstmt.executeQuery();
			
			if(rset.next()) {
		
				checkId = rset.getString("USER_ID");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println( "중복 아이디????" +checkId);
		return checkId;
	}
	public String blackCheck(Connection con, UserDTO requestUser) {
		
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		
		String requestId = requestUser.getId();
		String query = prop.getProperty("blackCheck");
		String result = "";
	   
		
		try {
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, requestId);

			rset = pstmt.executeQuery();
			
			if(rset.next()) {
		
				 result= rset.getString("BLACKLIST_YN");
			}
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println( " 블랙리스	트 yn?????" + result);
		return result;
	}
	
	

}

