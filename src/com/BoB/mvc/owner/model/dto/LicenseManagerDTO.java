package com.BoB.mvc.owner.model.dto;

import java.sql.Date;

public class LicenseManagerDTO {
	
	private String sbName;
	private String BISI;
	private String address;
	private Date openDate;
	private String condition;
	private String major;
	private String mainAddress;
	private Date issueDate;
	private int BISICODE;
	private int pictureCode;
	
	public LicenseManagerDTO() {
	}

	public LicenseManagerDTO(String sbName, String bISI, String address, Date openDate, String condition, String major,
			String mainAddress, Date issueDate, int bISICODE, int pictureCode) {
		super();
		this.sbName = sbName;
		BISI = bISI;
		this.address = address;
		this.openDate = openDate;
		this.condition = condition;
		this.major = major;
		this.mainAddress = mainAddress;
		this.issueDate = issueDate;
		BISICODE = bISICODE;
		this.pictureCode = pictureCode;
	}

	public String getSbName() {
		return sbName;
	}

	public void setSbName(String sbName) {
		this.sbName = sbName;
	}

	public String getBISI() {
		return BISI;
	}

	public void setBISI(String bISI) {
		BISI = bISI;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getMainAddress() {
		return mainAddress;
	}

	public void setMainAddress(String mainAddress) {
		this.mainAddress = mainAddress;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public int getBISICODE() {
		return BISICODE;
	}

	public void setBISICODE(int bISICODE) {
		BISICODE = bISICODE;
	}

	public int getPictureCode() {
		return pictureCode;
	}

	public void setPictureCode(int pictureCode) {
		this.pictureCode = pictureCode;
	}

	@Override
	public String toString() {
		return "LicenseManagerDTO [sbName=" + sbName + ", BISI=" + BISI + ", address=" + address + ", openDate="
				+ openDate + ", condition=" + condition + ", major=" + major + ", mainAddress=" + mainAddress
				+ ", issueDate=" + issueDate + ", BISICODE=" + BISICODE + ", pictureCode=" + pictureCode + "]";
	}

	
	
	
}
