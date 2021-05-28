package com.BoB.mvc.owner.model.dto;

public class CartListDTO {

	private int orderCode;
	private String menuName;
	private int amount;
	private int price;
	
	public CartListDTO() {
		super();
	}

	public CartListDTO(int orderCode, String menuName, int amount, int price) {
		super();
		this.orderCode = orderCode;
		this.menuName = menuName;
		this.amount = amount;
		this.price = price;
	}

	public int getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(int orderCode) {
		this.orderCode = orderCode;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "CartList [orderCode=" + orderCode + ", menuName=" + menuName + ", amount=" + amount + ", price=" + price
				+ "]";
	}
	
	
}
