package com.BoB.mvc.admin.service;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.List;

import com.BoB.mvc.admin.dao.OwnerFeeDAO;
import com.BoB.mvc.admin.dto.AdminBillDTO;

import static com.BoB.mvc.common.jdbc.JDBCTemplate.*;

public class OwnerFeeService {
	private OwnerFeeDAO ownerFeeDAO;
	
	public OwnerFeeService(){
		ownerFeeDAO = new OwnerFeeDAO();
	}
	
	 

public List<AdminBillDTO> selectFeeList(String month, int value) {
		
		Connection con = getConnection();
		
		String calender = "";
		
		  calender += month.charAt(2);
	      calender += month.charAt(3);
	      calender += "/";
	      calender += month.charAt(5);
	      calender += month.charAt(6);
		
		System.out.println("calender "+calender);
 
		List<AdminBillDTO> OwnerFeeList = ownerFeeDAO.selectBillList(con, calender,value);
		close(con);
		
		
		return OwnerFeeList;
	}



	public List<AdminBillDTO> selectOneFee(int value) {
		
		Connection con = getConnection();
		
	      
	      List<AdminBillDTO> oneFeeList = ownerFeeDAO.selectOneFee(con,value);
	      close(con);
		
		return oneFeeList;
	}

}
