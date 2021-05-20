package com.BoB.mvc.owner.model.service;

import static com.BoB.mvc.common.jdbc.JDBCTemplate.close;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.commit;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.getConnection;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.Map;

import com.BoB.mvc.owner.model.dao.OwnerDAO;
import com.BoB.mvc.owner.model.dto.LicenseManagerDTO;
import com.BoB.mvc.owner.model.dto.OwnerDTO;
import com.BoB.mvc.owner.model.dto.PictureDTO;
import com.BoB.mvc.owner.model.dto.StoreInfoDTO;

public class OwnerService {
	
	private final OwnerDAO ownerDAO;
	
	public OwnerService() {
		
		ownerDAO = new OwnerDAO();
	}



	public int registOwner(Map<String, PictureDTO> picture, LicenseManagerDTO lm, OwnerDTO owner, StoreInfoDTO store) {
		
		Connection con = getConnection();
		int result4 = 0;
		
		int result1 = ownerDAO.insertPicture(con, picture);
		System.out.println("result1"+ result1);
		if(result1==2) {commit(con);}
		else {rollback(con);}
		
		int result2 = ownerDAO.insertLicenseManager(con,lm,picture);
		System.out.println("result2" + result2);
		if(result1==2 && result2>0) {commit(con);}
		else {rollback(con);}
			
		int result3 = ownerDAO.insertOwner(con, owner);
		System.out.println("result3"+result3);
		if(result1==2 && result2>0&&result3>0) {commit(con);}
		else {rollback(con);}
		
		result4 = ownerDAO.insertStore(con,store,picture,owner,lm);
		System.out.println("result4"+result4);
		if(result1==2 && result2>0&&result3>0&&result4>0) {commit(con);}
		else {rollback(con);}
					
		
		close(con);
		
		return result4;
	}
	
	
	
	
}
