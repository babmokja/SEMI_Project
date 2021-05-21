package com.BoB.mvc.admin.dto;

public class orderDetailDTO {
	
	private String cusName;
	private String cusPhone;
	private String cusAddr;
	private String request;
	private String stoName;
	private String stoPhone;
	private String stoAddr;
	
	public orderDetailDTO() {
		
	}

	public orderDetailDTO(String cusName, String cusPhone, String cusAddr, String request, String stoName,
			String stoPhone, String stoAddr) {
		super();
		this.cusName = cusName;
		this.cusPhone = cusPhone;
		this.cusAddr = cusAddr;
		this.request = request;
		this.stoName = stoName;
		this.stoPhone = stoPhone;
		this.stoAddr = stoAddr;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getCusPhone() {
		return cusPhone;
	}

	public void setCusPhone(String cusPhone) {
		this.cusPhone = cusPhone;
	}

	public String getCusAddr() {
		return cusAddr;
	}

	public void setCusAddr(String cusAddr) {
		this.cusAddr = cusAddr;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String getStoName() {
		return stoName;
	}

	public void setStoName(String stoName) {
		this.stoName = stoName;
	}

	public String getStoPhone() {
		return stoPhone;
	}

	public void setStoPhone(String stoPhone) {
		this.stoPhone = stoPhone;
	}

	public String getStoAddr() {
		return stoAddr;
	}

	public void setStoAddr(String stoAddr) {
		this.stoAddr = stoAddr;
	}

	@Override
	public String toString() {
		return "orderDetailDTO [cusName=" + cusName + ", cusPhone=" + cusPhone + ", cusAddr=" + cusAddr + ", request="
				+ request + ", stoName=" + stoName + ", stoPhone=" + stoPhone + ", stoAddr=" + stoAddr + "]";
	}
	
	
	
	
	
	
	
	
}
