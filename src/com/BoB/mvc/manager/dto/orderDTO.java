package com.BoB.mvc.manager.dto;

import java.util.Date;

public class orderDTO {
	private int orderNum;
	private String cusName;
	private String stoName;
	private Date orDate;
	private String price;
	private String cusPhone;
	private String stoPhone;
	
	
	public orderDTO() {
		
	}


	public orderDTO(int orderNum, String cusName, String stoName, Date orDate, String price, String cusPhone,
			String stoPhone) {
		super();
		this.orderNum = orderNum;
		this.cusName = cusName;
		this.stoName = stoName;
		this.orDate = orDate;
		this.price = price;
		this.cusPhone = cusPhone;
		this.stoPhone = stoPhone;
	}


	public int getOrderNum() {
		return orderNum;
	}


	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}


	public String getCusName() {
		return cusName;
	}


	public void setCusName(String cusName) {
		this.cusName = cusName;
	}


	public String getStoName() {
		return stoName;
	}


	public void setStoName(String stoName) {
		this.stoName = stoName;
	}


	public Date getOrDate() {
		return orDate;
	}


	public void setOrDate(Date orDate) {
		this.orDate = orDate;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public String getCusPhone() {
		return cusPhone;
	}


	public void setCusPhone(String cusPhone) {
		this.cusPhone = cusPhone;
	}


	public String getStoPhone() {
		return stoPhone;
	}


	public void setStoPhone(String stoPhone) {
		this.stoPhone = stoPhone;
	}


	@Override
	public String toString() {
		return "orderDTO [orderNum=" + orderNum + ", cusName=" + cusName + ", stoName=" + stoName + ", orDate=" + orDate
				+ ", price=" + price + ", cusPhone=" + cusPhone + ", stoPhone=" + stoPhone + "]";
	}
	
	
	
}
