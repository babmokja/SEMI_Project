package com.BoB.mvc.admin.dto;

import java.util.Date;

public class ownerSalesDTO {
	
	
	private int ownerNum;
	private int orderNum;
	private Date orderDate;
	private String type;
	private int price;
	
	public ownerSalesDTO() {
		
		
	}
	
	
	@Override
	public String toString() {
		return "ownerSalesDTO [ownerNum=" + ownerNum + ", orderNum=" + orderNum + ", orderDate=" + orderDate + ", type="
				+ type + ", price=" + price + "]";
	}

	public int getOwnerNum() {
		return ownerNum;
	}

	public void setOwnerNum(int ownerNum) {
		this.ownerNum = ownerNum;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
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

	

	protected ownerSalesDTO(int ownerNum, int orderNum, Date orderDate, String type, int price) {
		super();
		this.ownerNum = ownerNum;
		this.orderNum = orderNum;
		this.orderDate = orderDate;
		this.type = type;
		this.price = price;
	}
	
	
	
}
