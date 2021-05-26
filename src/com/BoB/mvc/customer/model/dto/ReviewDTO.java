package com.BoB.mvc.customer.model.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.BoB.mvc.owner.model.dto.PictureDTO;
import com.BoB.mvc.owner.model.dto.StoreInfoDTO;

public class ReviewDTO {
	
	private int satisfied;
	private String reviewContent;
	private int orderCode; //오더디티오 생기면 바꿔야
	private int storeCode;
    private List<PictureDTO> picture;
	private int reviewCode;
	private UserDTO userCode;
	public ReviewDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReviewDTO(int satisfied, String reviewContent, int orderCode, int storeCode,
			List<PictureDTO> picture, int reviewCode, UserDTO userCode) {
		super();
		this.satisfied = satisfied;
		this.reviewContent = reviewContent;
		this.orderCode = orderCode;
		this.storeCode = storeCode;
		this.picture = picture;
		this.reviewCode = reviewCode;
		this.userCode = userCode;
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
	public List<PictureDTO> getPicture() {
		return picture;
	}
	public void setPicture(List<PictureDTO> picture) {
		this.picture = picture;
	}
	public int getReviewCode() {
		return reviewCode;
	}
	public void setReviewCode(int reviewCode) {
		this.reviewCode = reviewCode;
	}
	public UserDTO getUserCode() {
		return userCode;
	}
	@Override
	public String toString() {
		return "ReviewDTO [satisfied=" + satisfied + ", reviewContent=" + reviewContent + ", orderCode=" + orderCode
				+ ", storeCode=" + storeCode + ", picture=" + picture + ", reviewCode=" + reviewCode + ", userCode="
				+ userCode + "]";
	}
	public void setUserCode(UserDTO userCode) {
		this.userCode = userCode;
	}


	

	

}
