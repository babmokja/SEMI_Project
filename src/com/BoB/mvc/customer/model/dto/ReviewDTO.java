package com.BoB.mvc.customer.model.dto;

public class ReviewDTO {
	
	private int satisfied;
	private String reviewContent;
	private int orderCode;
	private int storeCode;
	private String pictureCode;
	private int reviewCode;
	public ReviewDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReviewDTO(int satisfied, String reviewContent, int orderCode, int storeCode, String pictureCode,
			int reviewCode) {
		super();
		this.satisfied = satisfied;
		this.reviewContent = reviewContent;
		this.orderCode = orderCode;
		this.storeCode = storeCode;
		this.pictureCode = pictureCode;
		this.reviewCode = reviewCode;
	}
	public int getSatisfied() {
		return satisfied;
	}
	public void setSatisfied(int satisfied) {
		this.satisfied = satisfied;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public int getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(int orderCode) {
		this.orderCode = orderCode;
	}
	public int getStoreCode() {
		return storeCode;
	}
	public void setStoreCode(int storeCode) {
		this.storeCode = storeCode;
	}
	public String getPictureCode() {
		return pictureCode;
	}
	public void setPictureCode(String pictureCode) {
		this.pictureCode = pictureCode;
	}
	public int getReviewCode() {
		return reviewCode;
	}
	public void setReviewCode(int reviewCode) {
		this.reviewCode = reviewCode;
	}
	@Override
	public String toString() {
		return "ReviewDTO [satisfied=" + satisfied + ", reviewContent=" + reviewContent + ", orderCode=" + orderCode
				+ ", storeCode=" + storeCode + ", pictureCode=" + pictureCode + ", reviewCode=" + reviewCode + "]";
	}
	

}
