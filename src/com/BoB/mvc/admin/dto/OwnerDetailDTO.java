package com.BoB.mvc.admin.dto;

public class OwnerDetailDTO {
	public int ownerNum;
	public String stoName;
	public int stoNum;
	public String category;
	public String stoAddr;
	public String phone;
	public String type;
	
	
	public OwnerDetailDTO() {
		
	}


	public int getOwnerNum() {
		return ownerNum;
	}


	public void setOwnerNum(int ownerNum) {
		this.ownerNum = ownerNum;
	}


	public String getStoName() {
		return stoName;
	}


	public void setStoName(String stoName) {
		this.stoName = stoName;
	}


	public int getStoNum() {
		return stoNum;
	}


	public void setStoNum(int stoNum) {
		this.stoNum = stoNum;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getStoAddr() {
		return stoAddr;
	}


	public void setStoAddr(String stoAddr) {
		this.stoAddr = stoAddr;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public OwnerDetailDTO(int ownerNum, String stoName, int stoNum, String category, String stoAddr, String phone,
			String type) {
		super();
		this.ownerNum = ownerNum;
		this.stoName = stoName;
		this.stoNum = stoNum;
		this.category = category;
		this.stoAddr = stoAddr;
		this.phone = phone;
		this.type = type;
	}


	@Override
	public String toString() {
		return "OwnerDetailDTO [ownerNum=" + ownerNum + ", stoName=" + stoName + ", stoNum=" + stoNum + ", category="
				+ category + ", stoAddr=" + stoAddr + ", phone=" + phone + ", type=" + type + "]";
	}
	
	
	
	
	
}
