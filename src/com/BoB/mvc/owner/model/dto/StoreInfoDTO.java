package com.BoB.mvc.owner.model.dto;

import java.sql.Date;

public class StoreInfoDTO {

	private String storeName;
	private int storeNum;
	private String address;
	private String category;
	private String license;
	private Date startDate;
	
	
	public StoreInfoDTO() {}


	public StoreInfoDTO(String storeName, int storeNum, String address, String category, String license,
			Date startDate) {
		super();
		this.storeName = storeName;
		this.storeNum = storeNum;
		this.address = address;
		this.category = category;
		this.license = license;
		this.startDate = startDate;
	}


	public String getStoreName() {
		return storeName;
	}


	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}


	public int getStoreNum() {
		return storeNum;
	}


	public void setStoreNum(int storeNum) {
		this.storeNum = storeNum;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getLicense() {
		return license;
	}


	public void setLicense(String license) {
		this.license = license;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	@Override
	public String toString() {
		return "StoreInfoDTO [storeName=" + storeName + ", storeNum=" + storeNum + ", address=" + address
				+ ", category=" + category + ", license=" + license + ", startDate=" + startDate + "]";
	}
	
	
	
	
}
