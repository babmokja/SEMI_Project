package com.BoB.mvc.owner.model.dto;

import java.sql.Date;

public class OwnerBillDTO {

	private int ownerNo;
	private String storeName;
	private String storeAddress;
	private String company;
	private String item;
	private Date orderTime;
	private int totalAmount;
	private String userName;
	
	public OwnerBillDTO() {
		super();
	}

	public OwnerBillDTO(int ownerNo, String storeName, String storeAddress, String company, String item, Date orderTime,
			int totalAmount, String userName) {
		super();
		this.ownerNo = ownerNo;
		this.storeName = storeName;
		this.storeAddress = storeAddress;
		this.company = company;
		this.item = item;
		this.orderTime = orderTime;
		this.totalAmount = totalAmount;
		this.userName = userName;
	}

	public int getOwnerNo() {
		return ownerNo;
	}

	public void setOwnerNo(int ownerNo) {
		this.ownerNo = ownerNo;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "OwnerBillDTO [ownerNo=" + ownerNo + ", storeName=" + storeName + ", storeAddress=" + storeAddress
				+ ", company=" + company + ", item=" + item + ", orderTime=" + orderTime + ", totalAmount="
				+ totalAmount + ", userName=" + userName + "]";
	}
	
	
	
}
