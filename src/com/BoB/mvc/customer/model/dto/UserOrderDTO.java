package com.BoB.mvc.customer.model.dto;

import java.sql.Date;

public class UserOrderDTO {
	
	private Date orderDate;
	private String orderType;
	private String storeName;
	private String proceed;
	private String ownerComment;
	private int totalAmount;
	private int storeCode;
	private int userCode;
	private int orderCode;
	public UserOrderDTO() {
	}
	public UserOrderDTO(Date orderDate, String orderType, String storeName, String proceed, String ownerComment,
			int totalAmount, int storeCode, int userCode, int orderCode) {
		super();
		this.orderDate = orderDate;
		this.orderType = orderType;
		this.storeName = storeName;
		this.proceed = proceed;
		this.ownerComment = ownerComment;
		this.totalAmount = totalAmount;
		this.storeCode = storeCode;
		this.userCode = userCode;
		this.orderCode = orderCode;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getProceed() {
		return proceed;
	}
	public void setProceed(String proceed) {
		this.proceed = proceed;
	}
	public String getOwnerComment() {
		return ownerComment;
	}
	public void setOwnerComment(String ownerComment) {
		this.ownerComment = ownerComment;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public int getStoreCode() {
		return storeCode;
	}
	public void setStoreCode(int storeCode) {
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
	@Override
	public String toString() {
		return "UserOrderDTO [orderDate=" + orderDate + ", orderType=" + orderType + ", storeName=" + storeName
				+ ", proceed=" + proceed + ", ownerComment=" + ownerComment + ", totalAmount=" + totalAmount
				+ ", storeCode=" + storeCode + ", userCode=" + userCode + ", orderCode=" + orderCode + "]";
	}

	
	
	
	

	

}
