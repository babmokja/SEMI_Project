package com.BoB.mvc.admin.service;

import static com.BoB.mvc.common.jdbc.JDBCTemplate.close;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.BoB.mvc.admin.dao.OrderDAO;
import com.BoB.mvc.admin.dao.OwnerDAO;
import com.BoB.mvc.admin.dto.OwnerDetailDTO;
import com.BoB.mvc.admin.dto.PageInfoDTO;
import com.BoB.mvc.admin.dto.cartDTO;
import com.BoB.mvc.admin.dto.orderDTO;
import com.BoB.mvc.admin.dto.orderDetailDTO;
import com.BoB.mvc.admin.dto.ownerDTO;

public class AdminService {

	
	private  OrderDAO OrderDAO;
	private  OwnerDAO OwnerDAO;
	public AdminService() {
		OrderDAO = new OrderDAO();
		OwnerDAO = new OwnerDAO();
	}
	
	public int selectTotalCount() {
		
		Connection con = getConnection();
		
		int totalCount = OrderDAO.selectTotalCount(con);
		
		close(con);
		
		return totalCount;
	}

	public List<orderDTO> selectOrderList(PageInfoDTO pageInfo) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		
		List<orderDTO> orderList = OrderDAO.selectOrderList(con, pageInfo);
		
		close(con);
		
		
		return orderList;
	}

	public List<cartDTO> selectCartList(int orderNumber) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		List<cartDTO> cartList = OrderDAO.selectCartList(con,orderNumber);
		close(con);

		return cartList;
	}

	public List<orderDetailDTO> selectOrderDetail(int orderNumber) {
		// TODO Auto-generated method stub
		
		Connection con = getConnection();
		List<orderDetailDTO> orderDetailList = OrderDAO.selectOrderDetail(con,orderNumber);
		close(con);

		return orderDetailList;
	}

	public int searchOrderCount(String condition, String value) {
		Connection con = getConnection();
		int totalCount = OrderDAO.searchOrderCount(con,condition,value);
		close(con);

		return totalCount;
	}

	public List<orderDTO> searchOrderList(String condition, String value, PageInfoDTO pageInfo) {
		Connection con = getConnection();		
		
		List<orderDTO> orderList = OrderDAO.searchOrderList(con,pageInfo,condition,value);
		close(con);
		return orderList;
	}

	public int selectOwnerTotalCount() {
		Connection con = getConnection();
		
		int totalCount = OwnerDAO.selectOwnerTotalCount(con);
		
		close(con);
		
		return totalCount;
	}

	public List<ownerDTO> selectOwnerList(PageInfoDTO pageInfo) {
		Connection con = getConnection();
		
		List<ownerDTO> orderList = OwnerDAO.selectOwnerList(con, pageInfo);
		
		close(con);
		
		
		return orderList;
	}

	public int searchOwnerCount(String condition, String value) {
		Connection con = getConnection();
		int totalCount = OwnerDAO.searchOrderCount(con,condition,value);
		close(con);

		return totalCount;
	}

	public List<ownerDTO> searchOwnerList(String condition, String value, PageInfoDTO pageInfo) {
		Connection con = getConnection();		
		
		List<ownerDTO> orderList = OwnerDAO.searchOrderList(con,pageInfo,condition,value);
		close(con);
		return orderList;
	}

	public List<OwnerDetailDTO> selectOwnerDetail(int ownerNumber) {
		Connection con = getConnection();		
		
		List<OwnerDetailDTO> detailList = OwnerDAO.selectOwnerDetail(con,ownerNumber);
		close(con);
		return detailList;
	}
}
