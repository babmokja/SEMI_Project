package com.BoB.mvc.owner.model.dto;

public class NoShowDTO {
	
	private int userCode;
	private int orderCode;
	private int storeCode;
	
	public NoShowDTO() {
		super();
	}

	public NoShowDTO(int userCode, int orderCode, int storeCode) {
		super();
		this.userCode = userCode;
		this.orderCode = orderCode;
		this.storeCode = storeCode;
	}

	public int getUserCode() {
		return userCode;
	}

	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}

	public int getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(int orderCode) {
		this.orderCode = orderCode;
	}

	public int getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(int storeCode) {
		this.storeCode = storeCode;
	}

	@Override
	public String toString() {
		return "NoShowDTO [userCode=" + userCode + ", orderCode=" + orderCode + ", storeCode=" + storeCode + "]";
	}
	
	
	

}
