package com.BoB.mvc.customer.model.dto;

public class MenuListDTO implements java.io.Serializable {

	private int storeId;    // 가게 코드
	private String name;    // 메뉴 이름
	private int price;      // 메뉴 가격
	private String photo;   // 사진 경로
	private String content; // 메뉴 정보
	private int menuCode;   // 메뉴 코드
	
	public MenuListDTO() {
		super();
	}

	public MenuListDTO(int storeId, String name, int price, String photo, String content, int menuCode) {
		super();
		this.storeId = storeId;
		this.name = name;
		this.price = price;
		this.photo = photo;
		this.content = content;
		this.menuCode = menuCode;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(int menuCode) {
		this.menuCode = menuCode;
	}

	@Override
	public String toString() {
		return "MenuListDTO [storeId=" + storeId + ", name=" + name + ", price=" + price + ", photo=" + photo
				+ ", content=" + content + ", menuCode=" + menuCode + "]";
	}
	
}
