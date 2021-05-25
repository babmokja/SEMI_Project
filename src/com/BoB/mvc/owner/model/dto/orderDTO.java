package com.BoB.mvc.owner.model.dto;

import java.util.Date;

public class orderDTO {
	
	
	private int orderNum;
	private String cusName;
	private Date orderDate;
	private String type;
	private int price;
	
	public orderDTO() {
		
	}
	
	
	
	@Override
	public String toString() {
		return "orderDTO [orderNum=" + orderNum + ", cusName=" + cusName + ", orderDate=" + orderDate + ", type=" + type
				+ ", price=" + price + "]";
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

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}



	protected orderDTO(int orderNum, String cusName, Date orderDate, String type, int price) {
		super();
		this.orderNum = orderNum;
		this.cusName = cusName;
		this.orderDate = orderDate;
		this.type = type;
		this.price = price;
	}
	
	
	
	
}
