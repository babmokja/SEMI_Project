package com.BoB.mvc.owner.model.service;

import static com.BoB.mvc.common.jdbc.JDBCTemplate.close;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.commit;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.getConnection;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.BoB.mvc.owner.model.dao.PCProcessDAO;
import com.BoB.mvc.owner.model.dto.CartListDTO;
import com.BoB.mvc.owner.model.dto.DeliveryDTO;

public class PCProcessService {
	
	private final PCProcessDAO pcProcessDAO;
	
	public PCProcessService() {
		pcProcessDAO = new PCProcessDAO();
	}

	public List<DeliveryDTO> selectAllOrderProcess(int ownerCode) {

		Connection con = getConnection();
		
		List<DeliveryDTO> deliveryList = pcProcessDAO.selectDeliveryOrder(con,ownerCode);
		
		close(con);
		
		return deliveryList;
	}
	

	public List<CartListDTO> selectMenuList(int ownerCode) {

		Connection con = getConnection();
		
		List<CartListDTO> cartList = pcProcessDAO.selectMenuList(con,ownerCode);
		
		close(con);
		
		return cartList;
	}

	public int updateOnwerComment(int ownerCode, int orderCode, String comment) {
		
		Connection con = getConnection();
		
		int result = pcProcessDAO.updateOwnerComment(con,ownerCode, orderCode, comment);
		
		if(result>0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		
		return result;
		
	}

	public int updateOnwerDenyComment(int ownerCode, int orderCode, String deny) {
		
		Connection con = getConnection();
		
		int result = pcProcessDAO.updateOnwerDenyComment(con,ownerCode, orderCode, deny);
		
		if(result>0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		
		return result;
	}

	public int updateOwnerCompleteComment(int ownerCode, int orderCode, String complete) {

		Connection con = getConnection();
		
		int result = pcProcessDAO.updateOnwerCompleteComment(con,ownerCode, orderCode, complete);
		
		if(result>0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		
		return result;
	}

	public List<DeliveryDTO> selectPickupOrderProcess(int ownerCode) {
		
		Connection con = getConnection();
		
		List<DeliveryDTO> pickupList = pcProcessDAO.selectPickupOrder(con,ownerCode);
		
		close(con);
		
		return pickupList;
	}

	public int updateOnwerpickupComment(int ownerCode, int orderCode, String accept) {
		
Connection con = getConnection();
		
		int result = pcProcessDAO.updateOwnerpickupComment(con,ownerCode, orderCode, accept);
		
		if(result>0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		
		return result;
	}

	public int insertUserBlackList(int ownerCode, int orderCode, String userId, int storeCode) {
		
		Connection con =getConnection();
		
		int result = pcProcessDAO.insertUserBlackList(con,ownerCode, orderCode, userId, storeCode);
		
		if(result>0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		
		return result;
	}

}
