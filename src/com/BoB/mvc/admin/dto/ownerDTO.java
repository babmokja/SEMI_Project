package com.BoB.mvc.admin.dto;

import java.util.Date;

public class ownerDTO {
	
	
	private int ownerNum;
	private String ownerName;
	private String stoName;
	private int bisiNum;
	private String stoAddr;
	private Date enrollDate;
	private String appr;
	
	public ownerDTO() {
		
	}

	public int getOwnerNum() {
		return ownerNum;
	}

	public void setOwnerNum(int ownerNum) {
		this.ownerNum = ownerNum;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getStoName() {
		return stoName;
	}

	public void setStoName(String stoName) {
		this.stoName = stoName;
	}

	public int getBisiNum() {
		return bisiNum;
	}

	public void setBisiNum(int bisiNum) {
		this.bisiNum = bisiNum;
	}

	public String getStoAddr() {
		return stoAddr;
	}

	public void setStoAddr(String stoAddr) {
		this.stoAddr = stoAddr;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getAppr() {
		return appr;
	}

	public void setAppr(String appr) {
		this.appr = appr;
	}

	public ownerDTO(int ownerNum, String ownerName, String stoName, int bisiNum, String stoAddr, Date enrollDate,
			String appr) {
		super();
		this.ownerNum = ownerNum;
		this.ownerName = ownerName;
		this.stoName = stoName;
		this.bisiNum = bisiNum;
		this.stoAddr = stoAddr;
		this.enrollDate = enrollDate;
		this.appr = appr;
	}

	@Override
	public String toString() {
		return "ownerDTO [ownerNum=" + ownerNum + ", ownerName=" + ownerName + ", stoName=" + stoName + ", bisiNum="
				+ bisiNum + ", stoAddr=" + stoAddr + ", enrollDate=" + enrollDate + ", appr=" + appr + "]";
	}

	

	
	
	
	
	
	
}
