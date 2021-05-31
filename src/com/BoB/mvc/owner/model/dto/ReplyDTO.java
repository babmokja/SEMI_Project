package com.BoB.mvc.owner.model.dto;

import java.sql.Date;

public class ReplyDTO {
	
	private int replyCode;
	private String replyContent;
	private Date replyDate;
	private int boardCode;
	
	public ReplyDTO() {
		super();
	}

	public ReplyDTO(int replyCode, String replyContent, Date replyDate, int boardCode) {
		super();
		this.replyCode = replyCode;
		this.replyContent = replyContent;
		this.replyDate = replyDate;
		this.boardCode = boardCode;
	}

	public int getReplyCode() {
		return replyCode;
	}

	public void setReplyCode(int replyCode) {
		this.replyCode = replyCode;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Date getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}

	public int getBoardCode() {
		return boardCode;
	}

	public void setBoardCode(int boardCode) {
		this.boardCode = boardCode;
	}

	@Override
	public String toString() {
		return "ReplyDTO [replyCode=" + replyCode + ", replyContent=" + replyContent + ", replyDate=" + replyDate
				+ ", boardCode=" + boardCode + "]";
	}
	
	
	
	
	

}
