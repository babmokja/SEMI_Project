package com.BoB.mvc.owner.model.service;

import static com.BoB.mvc.common.jdbc.JDBCTemplate.close;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.BoB.mvc.owner.model.dao.PCProcessDAO;
import com.BoB.mvc.owner.model.dto.DeliveryDTO;

public class PCProcessService {

	public List<DeliveryDTO> selectAllOrderProcess(int ownerCode) {

		Connection con = getConnection();
		
		List<DeliveryDTO> deliveryList = PCProcessDAO.selectDeliveryOrder(con,ownerCode);
		
		close(con);
		
		return deliveryList;
	}

}
