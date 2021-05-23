package com.BoB.mvc.admin.service;

import java.sql.Connection;
import java.util.List;

import com.BoB.mvc.admin.dao.CustomerBoardDAO;
import com.BoB.mvc.admin.dto.CustomerBoardDTO;

import static com.BoB.mvc.common.jdbc.JDBCTemplate.*;

public class CustomerBoardService {

	private CustomerBoardDAO customerBoardDAO = new CustomerBoardDAO();

	public List<CustomerBoardDTO> selectCustomerBoardList() {
		
		Connection con = getConnection();
		
		List<CustomerBoardDTO> customerBoardList = customerBoardDAO.selectCustomerBoardList(con);
		
		close(con);
		
		return customerBoardList;
	}
	
	
	
	
	
}
