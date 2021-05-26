package com.BoB.mvc.owner.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class ReviewBoardListDTO implements Serializable{

	private int rowNum;
	private String satisfied;
	private String reviewContent;
	private String userId;
	private Date replyDate;
	private Date orderTime;
	
	public ReviewBoardListDTO() {}
	
	
	public ReviewBoardListDTO(int rowNum, String satisfied, String reviewContent, String userId, Date replyDate,
			Date orderTime) {
		super();
		this.rowNum = rowNum;
		this.satisfied = satisfied;
		this.reviewContent = reviewContent;
		this.userId = userId;
		this.replyDate = replyDate;
		this.orderTime = orderTime;
	}
	
	
	public int getRowNum() {
		return rowNum;
	}
	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}
	public String getSatisfied() {
		return satisfied;
	}
	public void setSatisfied(int satisfied) {
		switch(satisfied) {
		case 1 : this.satisfied = "보통"; break;
		case 2 : this.satisfied = "좋음"; break;
		case 3 : this.satisfied = "매우좋음"; break;
		};
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	@Override
	public String toString() {
		return "ReviewBoardList [rowNum=" + rowNum + ", satisfied=" + satisfied + ", reviewContent=" + reviewContent
				+ ", userId=" + userId + ", replyDate=" + replyDate + ", orderTime=" + orderTime + "]";
	}
	
	
	
}
