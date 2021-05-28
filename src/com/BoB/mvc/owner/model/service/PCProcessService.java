package com.BoB.mvc.owner.model.service;

import static com.BoB.mvc.common.jdbc.JDBCTemplate.close;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.getConnection;

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

}
