package com.BoB.mvc.owner.model.service;

import static com.BoB.mvc.common.jdbc.JDBCTemplate.close;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.BoB.mvc.owner.model.dao.OwnerTaxDAO;
import com.BoB.mvc.owner.model.dto.OwnerBillDTO;

public class OwnerTaxService {

	private final OwnerTaxDAO ownerTaxDAO;

	public OwnerTaxService() {
		
		ownerTaxDAO = new OwnerTaxDAO();
	}

	public List<OwnerBillDTO> selectOneFee(int value, int ownerNum) {

		Connection con = getConnection();
		
		List<OwnerBillDTO> onefeeList = ownerTaxDAO.selectOneFee(con,value,ownerNum);
		close(con);
		
		return onefeeList;
	}

}
