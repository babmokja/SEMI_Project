package com.BoB.mvc.admin.dto;

public class cartDTO {
	private String menuName;
	private int price;
	
	
	public cartDTO() {
		
	}


	public cartDTO(String menuName, int price) {
		super();
		this.menuName = menuName;
		this.price = price;
	}

	
	
	
	public String getMenuName() {
		return menuName;
	}


	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "cartDTO [menuName=" + menuName + ", price=" + price + "]";
	}
}
