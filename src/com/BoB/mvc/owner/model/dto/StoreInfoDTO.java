package com.BoB.mvc.owner.model.dto;

import java.sql.Date;

public class StoreInfoDTO {
	private int storeCode; // 시퀀스 받는 필드
	private String storeName;
	private String address;
	private String category;
	private String license;
	private Date startDate;
	private int businessNum;
	private String storeXY;
	private String storeIntro;
	private int typeCode;
	
	
	public StoreInfoDTO() {}


	public StoreInfoDTO(int storeCode, String storeName, String address, String category, String license,
			Date startDate, int businessNum, String storeXY, String storeIntro, int typeCode) {
		super();
		this.storeCode = storeCode;
		this.storeName = storeName;
		this.address = address;
		this.category = category;
		this.license = license;
		this.startDate = startDate;
		this.businessNum = businessNum;
		this.storeXY = storeXY;
		this.storeIntro = storeIntro;
		this.typeCode = typeCode;
	}


	public int getStoreCode() {
		return storeCode;
	}


	public void setStoreCode(int storeCode) {
		this.storeCode = storeCode;
	}


	public String getStoreName() {
		return storeName;
	}


	public void setStoreName(String storeName) {
		this.storeName = storeName;
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


	public int getBusinessNum() {
		return businessNum;
	}


	public void setBusinessNum(int businessNum) {
		this.businessNum = businessNum;
	}


	public String getStoreXY() {
		return storeXY;
	}


	public void setStoreXY(String storeXY) {
		this.storeXY = storeXY;
	}


	public String getStoreIntro() {
		return storeIntro;
	}


	public void setStoreIntro(String storeIntro) {
		this.storeIntro = storeIntro;
	}


	public int getTypeCode() {
		return typeCode;
	}


	public void setTypeCode(int typeCode) {
		this.typeCode = typeCode;
	}


	@Override
	public String toString() {
		return "StoreInfoDTO [storeCode=" + storeCode + ", storeName=" + storeName + ", address=" + address
				+ ", category=" + category + ", license=" + license + ", startDate=" + startDate + ", businessNum="
				+ businessNum + ", storeXY=" + storeXY + ", storeIntro=" + storeIntro + ", typeCode=" + typeCode + "]";
	}


	
	

	
	
	
	
}
