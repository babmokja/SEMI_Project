package com.BoB.mvc.owner.model.dto;

import java.sql.Date;

public class StoreInfoDTO {

	private String storeName;
	private int businessNum;
	private String storeXY;
	private String category;
	private int userCode;
	private int businessRegistCode;
	private int storeCode; // 시퀀스 받는 필드
	private String approval;
	private Date startDate;
	private int typeCode;
	private String address;
	private String storeIntro;
	
	
	public StoreInfoDTO() {}


	public StoreInfoDTO(String storeName, int businessNum, String storeXY, String category, int userCode,
			int businessRegistCode, int storeCode, String approval, Date startDate, int typeCode, String address,
			String storeIntro) {
		super();
		this.storeName = storeName;
		this.businessNum = businessNum;
		this.storeXY = storeXY;
		this.category = category;
		this.userCode = userCode;
		this.businessRegistCode = businessRegistCode;
		this.storeCode = storeCode;
		this.approval = approval;
		this.startDate = startDate;
		this.typeCode = typeCode;
		this.address = address;
		this.storeIntro = storeIntro;
	}


	public String getStoreName() {
		return storeName;
	}


	public void setStoreName(String storeName) {
		this.storeName = storeName;
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


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public int getUserCode() {
		return userCode;
	}


	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}


	public int getBusinessRegistCode() {
		return businessRegistCode;
	}


	public void setBusinessRegistCode(int businessRegistCode) {
		this.businessRegistCode = businessRegistCode;
	}


	public int getStoreCode() {
		return storeCode;
	}


	public void setStoreCode(int storeCode) {
		this.storeCode = storeCode;
	}


	public String getApproval() {
		return approval;
	}


	public void setApproval(String approval) {
		this.approval = approval;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public int getTypeCode() {
		return typeCode;
	}


	public void setTypeCode(int typeCode) {
		this.typeCode = typeCode;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getStoreIntro() {
		return storeIntro;
	}


	public void setStoreIntro(String storeIntro) {
		this.storeIntro = storeIntro;
	}


	@Override
	public String toString() {
		return "StoreInfoDTO [storeName=" + storeName + ", businessNum=" + businessNum + ", storeXY=" + storeXY
				+ ", category=" + category + ", userCode=" + userCode + ", businessRegistCode=" + businessRegistCode
				+ ", storeCode=" + storeCode + ", approval=" + approval + ", startDate=" + startDate + ", typeCode="
				+ typeCode + ", address=" + address + ", storeIntro=" + storeIntro + "]";
	}


	

	


	
	

	
	
	
	
}
