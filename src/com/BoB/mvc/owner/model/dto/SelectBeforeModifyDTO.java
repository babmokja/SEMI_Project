package com.BoB.mvc.owner.model.dto;

public class SelectBeforeModifyDTO {

	private int businessNum;
	private String memberId;
	private String name;
	
	
	
	public SelectBeforeModifyDTO() {
	}



	public SelectBeforeModifyDTO(int businessNum, String memberId, String name) {
		super();
		this.businessNum = businessNum;
		this.memberId = memberId;
		this.name = name;
	}



	public int getBusinessNum() {
		return businessNum;
	}



	public void setBusinessNum(int businessNum) {
		this.businessNum = businessNum;
	}



	public String getMemberId() {
		return memberId;
	}



	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	@Override
	public String toString() {
		return "SelectBeforeModify [businessNum=" + businessNum + ", memberId=" + memberId + ", name=" + name + "]";
	}


	
	
	
	
}
