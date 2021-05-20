package com.BoB.mvc.owner.model.dto;

import java.sql.Date;

public class LicenseManagerDTO {
	
	private String sbName;
	private String BISI;
	private Date openDate;
	private String condition;
	private Date issueDate;
	private String major;
	private String address;
	private String mainAddress;
	
	public LicenseManagerDTO() {
	}

	public LicenseManagerDTO(String sbName, String bISI, Date openDate, String condition, Date issueDate, String major,
			String address, String mainAddress) {
		super();
		this.sbName = sbName;
		BISI = bISI;
		this.openDate = openDate;
		this.condition = condition;
		this.issueDate = issueDate;
		this.major = major;
		this.address = address;
		this.mainAddress = mainAddress;
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

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMainAddress() {
		return mainAddress;
	}

	public void setMainAddress(String mainAddress) {
		this.mainAddress = mainAddress;
	}

	@Override
	public String toString() {
		return "LicenseManagerDTO [sbName=" + sbName + ", BISI=" + BISI + ", openDate=" + openDate + ", condition="
				+ condition + ", issueDate=" + issueDate + ", major=" + major + ", address=" + address
				+ ", mainAddress=" + mainAddress + "]";
	}
	
	
}
