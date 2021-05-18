package com.BoB.mvc.owner.model.service;

import static com.BoB.mvc.common.jdbc.JDBCTemplate.close;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.commit;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.getConnection;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;

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
	
	
	
	
}
