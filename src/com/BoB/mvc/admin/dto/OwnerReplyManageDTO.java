package com.BoB.mvc.admin.dto;

import java.sql.Date;

public class OwnerReplyManageDTO {

	private String userName;
	private String replyContent;
	private java.sql.Date replyDate;
	private int replyCode;
	
	public OwnerReplyManageDTO() {
	}

	public OwnerReplyManageDTO(String userName, String replyContent, Date replyDate, int replyCode) {
		this.userName = userName;
		this.replyContent = replyContent;
		this.replyDate = replyDate;
		this.replyCode = replyCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public java.sql.Date getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(java.sql.Date replyDate) {
		this.replyDate = replyDate;
	}

	public int getReplyCode() {
		return replyCode;
	}

	public void setReplyCode(int replyCode) {
		this.replyCode = replyCode;
	}

	@Override
	public String toString() {
		return "OwnerReplyManageDTO [userName=" + userName + ", replyContent=" + replyContent + ", replyDate="
				+ replyDate + ", replyCode=" + replyCode + "]";
	}
	
}
