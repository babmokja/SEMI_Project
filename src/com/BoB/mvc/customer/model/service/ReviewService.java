package com.BoB.mvc.customer.model.service;

import java.sql.Connection;
import java.util.List;

import com.BoB.mvc.customer.model.dao.ReviewDAO;
import com.BoB.mvc.customer.model.dto.ReviewDTO;
import com.BoB.mvc.owner.model.dto.PictureDTO;

import static com.BoB.mvc.common.jdbc.JDBCTemplate.close;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.commit;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.getConnection;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.rollback;

public class ReviewService {

	private final ReviewDAO reviewDao;

	
	public ReviewService() {
		reviewDao = new ReviewDAO();
	}




	public int insertReview(ReviewDTO review) {
		Connection con = getConnection();
		
		int result = 0;
		

		
		List<PictureDTO> fileList = review.getPicture();
		PictureDTO picturedto = new PictureDTO();
		for(int i = 0; i < fileList.size(); i++) {
			String name = fileList.get(i).getOriginName();
			
			picturedto.setOriginName(name);

		}

		
		int picResult = reviewDao.insertPic(con,picturedto);
	    System.out.println("픽처 잘 넣었나확인!"+picResult);
		
		int pictureCode = reviewDao.selectReviewPic(con);
		System.out.println("픽쳐마지막코드!!!"+pictureCode);
		
		for(int i = 0; i < fileList.size(); i++) {
			
		    picturedto.setPictureCode(pictureCode);
		};
		 
		System.out.println("마지막코드 잘 넣었나 확인!"+picturedto.getPictureCode());

		
		int boardResult = reviewDao.insertReviewContent(con, review,picturedto);
		
		
		
        
		if(boardResult > 0 ) {
			commit(con);
			result = 1;
		} else {
			rollback(con);
		}
		close(con);
		
		return result;
	}




	public int insertPoint(int writerMemberNo) {
		Connection con = getConnection();
		
		int result = reviewDao.insertPoint(con, writerMemberNo);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

}