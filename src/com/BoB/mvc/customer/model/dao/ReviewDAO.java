package com.BoB.mvc.customer.model.dao;

import static com.BoB.mvc.common.jdbc.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import com.BoB.mvc.common.config.ConfigLocation;
import com.BoB.mvc.customer.model.dto.ReviewDTO;
import com.BoB.mvc.owner.model.dto.PictureDTO;

public class ReviewDAO {
	private final Properties prop;
	
	public ReviewDAO() {
		prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "user/user-mapper.xml"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public int insertReviewContent(Connection con, ReviewDTO review, PictureDTO picturedto) {
       
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query =prop.getProperty("insertReviewContent");
		System.out.println(review.getSatisfied());
		System.out.println(review.getReviewContent());
		System.out.println("픽처마지막 코드 : "+picturedto.getPictureCode());
	
		try {
		pstmt = con.prepareStatement(query);
		pstmt.setInt(1, review.getSatisfied());
		pstmt.setString(2, review.getReviewContent());
		pstmt.setInt(3, picturedto.getPictureCode());  //픽쳐코드	
	    pstmt.setInt(4, review.getStoreCode());
		pstmt.setInt(5, review.getOrderCode());
		

		result = pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println(result);
		return result;
	}

	public int selectReviewPic(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		
		int lastPicCode = 0;
		
		String query = prop.getProperty("lastPicCode");
		
		try {
			stmt = con.createStatement();
			
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				lastPicCode= rset.getInt("CURRVAL");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return lastPicCode;
		
	}

	/**리뷰에 있는 사진 테이블에 넣는 메소드
	 * @param con
	 * @param picturedto
	 * @return
	 */
	public int insertPic(Connection con, PictureDTO picturedto) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("insertAttachment");

		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, picturedto.getOriginName());
			
			result = pstmt.executeUpdate();
   
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int insertPoint(Connection con, int writerMemberNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("addPoint");

		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, writerMemberNo);
			
			result = pstmt.executeUpdate();
   
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}




	

}
