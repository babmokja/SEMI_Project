package com.BoB.mvc.owner.model.dto;

import java.sql.Date;

public class SalesDTO {
	
	private int orderCode;
	private int totalAmount;
	private Date orderTime;
	private String typeYN;
	private int userCode;
	private int totalDayAmount;
	private int storeCode;
	private StoreInfoDTO storeInfoCode;
	
	public SalesDTO() {
		super();
	}

	public SalesDTO(int orderCode, int totalAmount, Date orderTime, String typeYN, int userCode, int totalDayAmount,
			int storeCode, StoreInfoDTO storeInfoCode) {
		super();
		this.orderCode = orderCode;
		this.totalAmount = totalAmount;
		this.orderTime = orderTime;
		this.typeYN = typeYN;
		this.userCode = userCode;
		this.totalDayAmount = totalDayAmount;
		this.storeCode = storeCode;
		this.storeInfoCode = storeInfoCode;
	}

	public int getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(int orderCode) {
		this.orderCode = orderCode;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public String getTypeYN() {
		return typeYN;
	}

	public void setTypeYN(String typeYN) {
		this.typeYN = typeYN;
	}

	public int getUserCode() {
		return userCode;
	}

	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}

	public int getTotalDayAmount() {
		return totalDayAmount;
	}

	public void setTotalDayAmount(int totalDayAmount) {
		this.totalDayAmount = totalDayAmount;
	}

	public int getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(int storeCode) {
		this.storeCode = storeCode;
	}

	public StoreInfoDTO getStoreInfoCode() {
		return storeInfoCode;
	}

	public void setStoreInfoCode(StoreInfoDTO storeInfoCode) {
		this.storeInfoCode = storeInfoCode;
	}

	@Override
	public String toString() {
		return "SalesDTO [orderCode=" + orderCode + ", totalAmount=" + totalAmount + ", orderTime=" + orderTime
				+ ", typeYN=" + typeYN + ", userCode=" + userCode + ", totalDayAmount=" + totalDayAmount
				+ ", storeCode=" + storeCode + ", storeInfoCode=" + storeInfoCode + "]";
	}

	
}
