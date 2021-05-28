package com.BoB.mvc.owner.model.dto;

import java.sql.Date;

public class DeliveryDTO {

	private String userId;
	private String userName;
	private int totalPrice;
	private String requestCus;
	private String typeYN;
	private Date orderTime;
	private int storeCode;
	private String orderProceed;
	private String ownerComment;
	private int orderCode;
	
	
	public DeliveryDTO() {
		super();
	}


	public DeliveryDTO(String userId, String userName, int totalPrice, String requestCus, String typeYN, Date orderTime,
			int storeCode, String orderProceed, String ownerComment, int orderCode) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.totalPrice = totalPrice;
		this.requestCus = requestCus;
		this.typeYN = typeYN;
		this.orderTime = orderTime;
		this.storeCode = storeCode;
		this.orderProceed = orderProceed;
		this.ownerComment = ownerComment;
		this.orderCode = orderCode;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public int getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}


	public String getRequestCus() {
		return requestCus;
	}


	public void setRequestCus(String requestCus) {
		this.requestCus = requestCus;
	}


	public String getTypeYN() {
		return typeYN;
	}


	public void setTypeYN(String typeYN) {
		this.typeYN = typeYN;
	}


	public Date getOrderTime() {
		return orderTime;
	}


	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}


	public int getStoreCode() {
		return storeCode;
	}


	public void setStoreCode(int storeCode) {
		this.storeCode = storeCode;
	}


	public String getOrderProceed() {
		return orderProceed;
	}


	public void setOrderProceed(String orderProceed) {
		this.orderProceed = orderProceed;
	}


	public String getOwnerComment() {
		return ownerComment;
	}


	public void setOwnerComment(String ownerComment) {
		this.ownerComment = ownerComment;
	}


	public int getOrderCode() {
		return orderCode;
	}


	public void setOrderCode(int orderCode) {
		this.orderCode = orderCode;
	}


	@Override
	public String toString() {
		return "DeliveryDTO [userId=" + userId + ", userName=" + userName + ", totalPrice=" + totalPrice
				+ ", requestCus=" + requestCus + ", typeYN=" + typeYN + ", orderTime=" + orderTime + ", storeCode="
				+ storeCode + ", orderProceed=" + orderProceed + ", ownerComment=" + ownerComment + ", orderCode="
				+ orderCode + "]";
	}

	
	
}
