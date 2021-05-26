package com.BoB.mvc.owner.model.dao;

import static com.BoB.mvc.common.jdbc.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.BoB.mvc.common.config.ConfigLocation;
import com.BoB.mvc.customer.model.dto.PageInfoDTO;
import com.BoB.mvc.owner.model.dto.LicenseManagerDTO;
import com.BoB.mvc.owner.model.dto.OwnerDTO;
import com.BoB.mvc.owner.model.dto.PictureDTO;
import com.BoB.mvc.owner.model.dto.ReviewBoardListDTO;
import com.BoB.mvc.owner.model.dto.SelectBeforeModifyDTO;
import com.BoB.mvc.owner.model.dto.StoreInfoDTO;

public class OwnerDAO {

	private Properties prop = new Properties();
	
	public OwnerDAO() {
		
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION+"owner/owner-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	

	public int insertPicture(Connection con, Map<String, PictureDTO> picture) {
		
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		int result1 = 0;
		int result2 = 0;
		
		String query1 = prop.getProperty("registPictures");
		
		
		try {
			pstmt1 =con.prepareStatement(query1);
			
			pstmt1.setString(1, picture.get("pict1").getOriginName());
			pstmt1.setString(2, picture.get("pict1").getRevisedName());
			pstmt1.setString(3, picture.get("pict1").getRoute());
			result1 =pstmt1.executeUpdate();
			
			pstmt2 =con.prepareStatement(query1);
			
			pstmt2.setString(1, picture.get("pict2").getOriginName());
			pstmt2.setString(2, picture.get("pict2").getRevisedName());
			pstmt2.setString(3, picture.get("pict2").getRoute());
			
			result2 = pstmt2.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt1);
			close(pstmt2);
		}
		
		
		return result1+result2;
	}
	
	public int insertLicenseManager(Connection con, LicenseManagerDTO lm, Map<String, PictureDTO> picture) {
		
		PreparedStatement pstmt = null;
		
		int result2 = 0;
		
		String query = prop.getProperty("registLicenseManager");
		
		try {
			pstmt =con.prepareStatement(query);
			pstmt.setString(1, lm.getSbName());
			pstmt.setString(2, lm.getBISI());
			pstmt.setDate(3, lm.getOpenDate());
			pstmt.setString(4, lm.getAddress());
			pstmt.setString(5, lm.getCondition());
			pstmt.setString(6, lm.getMajor());
			pstmt.setString(7, lm.getMainAddress());
			pstmt.setDate(8, lm.getIssueDate());
			
			result2 = pstmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		
		return result2;
	}
	
	
	

	public int insertOwner(Connection con, OwnerDTO Owner) {
		
		PreparedStatement pstmt = null;
		
		int result3 = 0;
		
		String query = prop.getProperty("registOwner");
		
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString( 1 , Owner.getMemberId());
			pstmt.setString( 2 , Owner.getMemberPwd());
			pstmt.setString( 3 , Owner.getName());
			pstmt.setString( 4 , Owner.getPhone());
			pstmt.setString( 5 , Owner.getAddress());
			pstmt.setString( 6 , Owner.getEmail());
			pstmt.setString( 7 , Owner.getResidentNum());
			
			result3 = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result3;
	}



	public int insertStore(Connection con, StoreInfoDTO store, Map<String, PictureDTO> picture, OwnerDTO owner, LicenseManagerDTO lm) {
		
		PreparedStatement pstmt = null;
		
		int result4 = 0;
		
		String query = prop.getProperty("registStore");
		
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString( 1 , store.getStoreName());
			pstmt.setInt( 2 , store.getBusinessNum());
			pstmt.setString( 3 , store.getStoreXY());
			pstmt.setString( 4 , store.getCategory());
			pstmt.setInt(5, store.getTypeCode());
			pstmt.setString( 6 , owner.getAddress());
			pstmt.setString( 7 , store.getStoreIntro());
			
			result4 = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result4;
	}
	
	public int insertPICtable(Connection con, StoreInfoDTO store, Map<String, PictureDTO> picture, OwnerDTO owner,
			LicenseManagerDTO lm) {
		
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		
		int result5 = 0;
		int result50 = 0;
		
		String query = prop.getProperty("registPICtable");
		String query2 = prop.getProperty("registPICtable2");
		
		
			try {
				pstmt = con.prepareStatement(query);
				
				result5 = pstmt.executeUpdate();
				
				
				pstmt2 = con.prepareStatement(query2);
				
				result50 = pstmt2.executeUpdate();
				 
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		
		return result5+result50;
	}



	public String selectEncryptedPwd(Connection con, OwnerDTO requestMember) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String encPwd = null;
		
		String query = prop.getProperty("selectEncryptedPwd");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, requestMember.getMemberId());
			
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



	public Map<String, Object> selectLoginMember(Connection con, OwnerDTO requestMember) {
		
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		ResultSet rset = null;
		ResultSet rset2 = null;
		ResultSet rset3 = null;
		
		Map<String, Object> loginmap = new HashMap<String, Object>();
		OwnerDTO loginMember = null;
		StoreInfoDTO loginStore = null;
		LicenseManagerDTO loginLManager = null;
		
		String query1 = prop.getProperty("selectLoginOwner");
		String query2 = prop.getProperty("selectLoginStore");
		String query3 = prop.getProperty("selectLoginLicenseManage");
		
		try {
			pstmt = con.prepareStatement(query1);
			pstmt.setString(1, requestMember.getMemberId());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				loginMember = new OwnerDTO();
				
				loginMember.setUserCode(rset.getInt("USER_CODE"));
				loginMember.setMemberId(rset.getString("USER_ID"));
				loginMember.setName(rset.getString("USER_NAME"));
				loginMember.setPhone(rset.getString("USER_PHONE"));
				loginMember.setAddress(rset.getString("USER_ADDRESS"));
				loginMember.setPoint(rset.getInt("POINT"));
				loginMember.setEmail(rset.getString("USER_EMAIL"));
				loginMember.setWithdrawYN(rset.getString("WITHDRAW_YN"));
				loginMember.setRoleCode(rset.getInt("ROLE_CODE"));
				loginMember.setBlacklistYN(rset.getString("BLACKLIST_YN"));
				loginMember.setBlacklistDate(rset.getDate("BLACKLIST_DATE"));
				loginMember.setResidentNum(rset.getString("USER_NO"));
				
			
				loginmap.put("loginMember", loginMember);
			}
				
				System.out.println(loginMember);
			
			pstmt2 = con.prepareStatement(query2);
			pstmt2.setString(1, requestMember.getMemberId());
			
			rset2 = pstmt2.executeQuery();
			
			if(rset2.next()) {
				loginStore = new StoreInfoDTO();
				
				loginStore.setStoreName(rset2.getString("STORE_NAME"));
				loginStore.setBusinessNum(rset2.getInt("OWNER_NO"));
				loginStore.setStoreXY(rset2.getString("STORE_XY"));
				loginStore.setCategory(rset2.getString("CATEGORY"));
				loginStore.setUserCode(rset2.getInt("USER_CODE"));
				loginStore.setBusinessRegistCode(rset2.getInt("BUSINESS_REGIST_CODE"));
				loginStore.setStoreCode(rset2.getInt("STORE_CODE"));
				loginStore.setApproval(rset2.getString("APPROVAL"));
				loginStore.setStartDate(rset2.getDate("ENROLL_DATE"));
				loginStore.setTypeCode(rset2.getInt("TYPE_CODE"));
				loginStore.setAddress(rset2.getString("STORE_ADDR"));
				loginStore.setStoreIntro(rset2.getString("STORE_INFO"));
				
				loginmap.put("loginStore", loginStore);
			}
			System.out.println(loginStore);
			
			pstmt3 = con.prepareStatement(query3);
			pstmt3.setString(1, requestMember.getMemberId());
			
			rset3 = pstmt3.executeQuery();
			
			if(rset3.next()) {
				loginLManager = new LicenseManagerDTO();
				
				loginLManager.setSbName(rset3.getString("STORE_NAME"));
				loginLManager.setBISI(rset3.getString("BISI_DIV"));
				loginLManager.setOpenDate(rset3.getDate("OPEN_DATE"));
				loginLManager.setAddress(rset3.getString("STORE_ADDRESS"));
				loginLManager.setCondition(rset3.getString("COMPANY"));
				loginLManager.setMajor(rset3.getString("ITEM"));
				loginLManager.setMainAddress(rset3.getString("MAIN_ADDRESS"));
				loginLManager.setIssueDate(rset3.getDate("LIC_DATE"));
				loginLManager.setBISICODE(rset3.getInt("BISI_CODE"));
				loginLManager.setPictureCode(rset3.getInt("PICTURE_CODE"));
				
				loginmap.put("loginLManager", loginLManager);
			}
			System.out.println(loginLManager);
			
			
			
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(rset2);
			close(rset3);
			close(pstmt);
			close(pstmt2);
			close(pstmt3);
		}
		
		
		return loginmap;
	}



	public String IdCheck(Connection con, String memberId) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String checkId = "";
		
		String query = prop.getProperty("checkId");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, memberId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				checkId = rset.getString("USER_ID");
			}
			System.out.println("dao까지는 성공했습니다 " +checkId);
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return checkId;
	}



	public SelectBeforeModifyDTO ModifyInfo(Connection con, String id) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		SelectBeforeModifyDTO dto = null;
		
			String query = prop.getProperty("BeforeModifyInfo");
		
			try {
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, id);
				
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					dto = new SelectBeforeModifyDTO();
					dto.setMemberId(rset.getString("USER_ID"));
					dto.setName(rset.getString("USER_NAME"));
					dto.setBusinessNum(rset.getInt("OWNER_NO"));
					
				}
				
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
		
		
		return dto;
	}



	public int modifyPicture(Connection con, Map<String, PictureDTO> picture, LicenseManagerDTO lm, StoreInfoDTO storeInfoDTO, OwnerDTO ownerDTO, LicenseManagerDTO lmDTO) {
		
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		int result1 = 0;
		int result2 = 0;
		
		String query1 = prop.getProperty("modifyPictures");
		String query2 = prop.getProperty("modifyPictures2");
		
		
		try {
			pstmt1 =con.prepareStatement(query1);
			
			
			pstmt1.setString(1, picture.get("pict1").getOriginName());
			pstmt1.setString(2, picture.get("pict1").getRevisedName());
			pstmt1.setString(3, picture.get("pict1").getRoute());
			pstmt1.setInt(4, ownerDTO.getUserCode());
			
			result1 =pstmt1.executeUpdate();
			
			pstmt2 =con.prepareStatement(query2);
			
			pstmt2.setString(1, picture.get("pict2").getOriginName());
			pstmt2.setString(2, picture.get("pict2").getRevisedName());
			pstmt2.setString(3, picture.get("pict2").getRoute());
			pstmt2.setInt(4, ownerDTO.getUserCode());
			
			result2 = pstmt2.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt1);
			close(pstmt2);
		}
		
		
		return result1+result2;
	}



	public int modifyLicenseManager(Connection con, LicenseManagerDTO lm, Map<String, PictureDTO> picture, LicenseManagerDTO lmDTO, StoreInfoDTO storeInfoDTO) {
		
		PreparedStatement pstmt = null;
		
		int result2 = 0;
		
		String query = prop.getProperty("modifyLicenseManager");
		
		try {
			pstmt =con.prepareStatement(query);
			pstmt.setString(1, lm.getSbName());
			pstmt.setString(2, lm.getBISI());
			pstmt.setDate(3, lm.getOpenDate());
			pstmt.setString(4, lm.getAddress());
			pstmt.setString(5, lm.getCondition());
			pstmt.setString(6, lm.getMajor());
			pstmt.setString(7, lm.getMainAddress());
			pstmt.setDate(8, lm.getIssueDate());
			pstmt.setInt(9, storeInfoDTO.getStoreCode());
			
			result2 = pstmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		
		return result2;
	}



	public int modifyOwner(Connection con, OwnerDTO owner, OwnerDTO ownerDTO, LicenseManagerDTO lmDTO) {
		
		PreparedStatement pstmt = null;
		
		int result3 = 0;
		
		String query = prop.getProperty("modifyOwner");
		
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString( 1 , owner.getMemberPwd());
			pstmt.setString( 2 , owner.getPhone());
			pstmt.setString( 3 , owner.getAddress());
			pstmt.setString( 4 , owner.getEmail());
			pstmt.setInt( 5 , ownerDTO.getRoleCode());
			pstmt.setString(6, ownerDTO.getResidentNum());
			
			result3 = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result3;
	}



	public int modifyStore(Connection con, StoreInfoDTO store, Map<String, PictureDTO> picture, OwnerDTO owner,
			LicenseManagerDTO lm, StoreInfoDTO storeInfoDTO) {
		
		PreparedStatement pstmt = null;
		
		int result4 = 0;
		
		String query = prop.getProperty("modifyStore");
		
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString( 1 , store.getStoreName());
			pstmt.setString( 2 , store.getCategory());
			pstmt.setInt(3, storeInfoDTO.getTypeCode());
			pstmt.setString(4 , store.getAddress());
			pstmt.setString( 5 , store.getStoreIntro());
			pstmt.setInt(6, storeInfoDTO.getStoreCode() );
			
			result4 = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result4;
		
	}



	public int selectReviewReplyTotalCount(Connection con) {
		
		Statement stmt = null;
		ResultSet rset = null;
		
		int totalCount = 0;
		
		String query = prop.getProperty("selectReviewReplyTotalCount");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				totalCount = rset.getInt("COUNT(*)");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		
		return totalCount;
	}



	public List<ReviewBoardListDTO> selectReviewList(Connection con, PageInfoDTO pageInfo) {
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		List<ReviewBoardListDTO> reviewList = null;
		
		String query = prop.getProperty("selectReviewList");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, pageInfo.getStartRow());
			pstmt.setInt(2, pageInfo.getEndRow());
			
			rset = pstmt.executeQuery();
			
			reviewList = new ArrayList<>();
			
			while(rset.next()) {
				ReviewBoardListDTO review = new ReviewBoardListDTO();
				review.setRowNum(rset.getInt("RNUM"));
				review.setSatisfied(rset.getInt("SATISFIED"));
				review.setReviewContent(rset.getString("REVIEW_CONTENT"));
				review.setUserId(rset.getString("USER_ID"));
				review.setReplyDate(rset.getDate("REPLY_DATE"));
				review.setOrderTime(rset.getDate("ORDER_TIME"));
				
				reviewList.add(review);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return reviewList;
	}



	public int selectReviewList(Connection con, String condition, String value) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		String query = null;
		int reviewCount = 0;
		
		try {
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, value);
			
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				reviewCount = rset.getInt("COUNT(*)");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return reviewCount;
	}



	public List<ReviewBoardListDTO> selectReviewList(Connection con, String condition, String value,
			PageInfoDTO pageInfo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		String query = null;
		List<ReviewBoardListDTO> reviewSearchList = null;
		
		if(condition.equals("satisfied")) {
			
			query = prop.getProperty("searchsatisfiedBoardCount");
		}else if(condition.equals("reviewContent")) {
			
			query = prop.getProperty("searchreviewContentBoardCount");
		}else if(condition.equals("userId")) {
			
			query = prop.getProperty("searchuserIdBoardCount");
		}
		
		if(value.equals("보통")) {
			value = "1" ;
		} else if(value.equals("좋음")) {
			value = "2" ;
		} else if(value.equals("매우좋음")) {
			value = "3" ;
		}
		
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, value);
			pstmt.setInt(2, pageInfo.getStartRow());
			pstmt.setInt(3, pageInfo.getEndRow());
			
			rset = pstmt.executeQuery();
			
			reviewSearchList = new ArrayList<>();
			
			while(rset.next()) {
				ReviewBoardListDTO review = new ReviewBoardListDTO();
				review.setRowNum(rset.getInt("RNUM"));
				review.setSatisfied(rset.getInt("SATISFIED"));
				review.setReviewContent(rset.getString("REVIEW_CONTENT"));
				review.setUserId(rset.getString("USER_ID"));
				review.setReplyDate(rset.getDate("REPLY_DATE"));
				review.setOrderTime(rset.getDate("ORDER_TIME"));
				
				reviewSearchList.add(review);
				
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return reviewSearchList;
	}



	
		
		
		
		
		
		



	





	
	
	
	
}
