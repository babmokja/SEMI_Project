package com.BoB.mvc.owner.model.service;

import static com.BoB.mvc.common.jdbc.JDBCTemplate.close;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.BoB.mvc.owner.model.dao.SalesDAO;
import com.BoB.mvc.owner.model.dto.MonthSalesDTO;
import com.BoB.mvc.owner.model.dto.PageInfoDTO;
import com.BoB.mvc.owner.model.dto.SalesDTO;
import com.BoB.mvc.owner.model.dto.StoreInfoDTO;

public class SalesService {
	
	private final SalesDAO salesDAO;
	
	

	public SalesService() {
		salesDAO = new SalesDAO();
	}



	public List<SalesDTO> selectDailySales(String month, PageInfoDTO pageInfo, StoreInfoDTO storeDTO) {

		Connection con = getConnection();
		
		List<SalesDTO> salesDailyList= salesDAO.selectDailySales(con,month,pageInfo, storeDTO);
		
		close(con);
		
		return salesDailyList;
	}



	public List<MonthSalesDTO> selectMontlySales() {
		
		Connection con = getConnection();
		
		List<MonthSalesDTO> salesMonthlyList = salesDAO.selectMonthlySales(con);
		
		close(con);
		
		return salesMonthlyList;
	}



	public int SelectDailySalesTotalCount(StoreInfoDTO storeDTO) {
		
		Connection con = getConnection();
		
		int totalCount = salesDAO.SelectDailySalesTotalCount(con,storeDTO);
		
		close(con);
		
		return totalCount;
	}




}
