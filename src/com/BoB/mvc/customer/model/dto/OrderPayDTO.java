package com.BoB.mvc.customer.model.dto;

import java.sql.Date;

public class OrderPayDTO {
	
	private int userCode; 			 	// 사용자(= 주문자,고객) 코드
	private String request; 		 	// 주문 요청사항
	private String payType; 		 	// 결제 수단
	private int point; 				 	// 포인트 사용 여부
	private String storeName; 		 	// 가게 이름
	private int price; 				 	// 메뉴 가격
	private int menuCode; 			 	// 메뉴 코드
	private int amount; 			 	// 수량
	private int storeCode; 			 	// 가게 코드
	private int cartCode; 			 	// 장바구니 코드
	private int orderCode;           	// 주문 코드
	private java.sql.Date orderTime; 	// 주문시간
	private String orderYN;          	// 주문진행상황
	private String reServeTime;         // 예약시간
	private String orderType ;       	// 가게 유형
	private String menuName;         	// 메뉴명
	
	public OrderPayDTO() {
		super();
	}

	public OrderPayDTO(int userCode, String request, String payType, int point, String storeName, int price,
			int menuCode, int amount, int storeCode, int cartCode, int orderCode, Date orderTime, String orderYN,
			String reServeTime, String orderType, String menuName) {
		super();
		this.userCode = userCode;
		this.request = request;
		this.payType = payType;
		this.point = point;
		this.storeName = storeName;
		this.price = price;
		this.menuCode = menuCode;
		this.amount = amount;
		this.storeCode = storeCode;
		this.cartCode = cartCode;
		this.orderCode = orderCode;
		this.orderTime = orderTime;
		this.orderYN = orderYN;
		this.reServeTime = reServeTime;
		this.orderType = orderType;
		this.menuName = menuName;
	}

	public int getUserCode() {
		return userCode;
	}

	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(int menuCode) {
		this.menuCode = menuCode;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(int storeCode) {
		this.storeCode = storeCode;
	}

	public int getCartCode() {
		return cartCode;
	}

	public void setCartCode(int cartCode) {
		this.cartCode = cartCode;
	}

	public int getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(int orderCode) {
		this.orderCode = orderCode;
	}

	public java.sql.Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(java.sql.Date orderTime) {
		this.orderTime = orderTime;
	}

	public String getOrderYN() {
		return orderYN;
	}

	public void setOrderYN(String orderYN) {
		this.orderYN = orderYN;
	}

	public String getReServeTime() {
		return reServeTime;
	}

	public void setReServeTime(String reServeTime) {
		this.reServeTime = reServeTime;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	@Override
	public String toString() {
		return "OrderPayDTO [userCode=" + userCode + ", request=" + request + ", payType=" + payType + ", point="
				+ point + ", storeName=" + storeName + ", price=" + price + ", menuCode=" + menuCode + ", amount="
				+ amount + ", storeCode=" + storeCode + ", cartCode=" + cartCode + ", orderCode=" + orderCode
				+ ", orderTime=" + orderTime + ", orderYN=" + orderYN + ", reServeTime=" + reServeTime + ", orderType="
				+ orderType + ", menuName=" + menuName + "]";
	}
	
}
