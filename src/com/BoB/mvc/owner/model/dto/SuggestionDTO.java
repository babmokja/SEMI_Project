package com.BoB.mvc.owner.model.dto;

import java.sql.Date;

import com.BoB.mvc.customer.model.dto.UserDTO;

public class SuggestionDTO {

	private int boardCode;
	private String boardTitle;
	private Date boardDate;
	private String boardContent;
	private String visibleYN;
	private int ownerCode;
	private UserDTO userCode;
	private String replyContent;
	private Date replyDate;
	
	public SuggestionDTO() {
		super();
	}

	public SuggestionDTO(int boardCode, String boardTitle, Date boardDate, String boardContent, String visibleYN,
			int ownerCode, UserDTO userCode, String replyContent, Date replyDate) {
		super();
		this.boardCode = boardCode;
		this.boardTitle = boardTitle;
		this.boardDate = boardDate;
		this.boardContent = boardContent;
		this.visibleYN = visibleYN;
		this.ownerCode = ownerCode;
		this.userCode = userCode;
		this.replyContent = replyContent;
		this.replyDate = replyDate;
	}

	public int getBoardCode() {
		return boardCode;
	}

	public void setBoardCode(int boardCode) {
		this.boardCode = boardCode;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public Date getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getVisibleYN() {
		return visibleYN;
	}

	public void setVisibleYN(String visibleYN) {
		this.visibleYN = visibleYN;
	}

	public int getOwnerCode() {
		return ownerCode;
	}

	public void setOwnerCode(int ownerCode) {
		this.ownerCode = ownerCode;
	}

	public UserDTO getUserCode() {
		return userCode;
	}

	public void setUserCode(UserDTO userCode) {
		this.userCode = userCode;
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

	@Override
	public String toString() {
		return "SuggestionDTO [boardCode=" + boardCode + ", boardTitle=" + boardTitle + ", boardDate=" + boardDate
				+ ", boardContent=" + boardContent + ", visibleYN=" + visibleYN + ", ownerCode=" + ownerCode
				+ ", userCode=" + userCode + ", replyContent=" + replyContent + ", replyDate=" + replyDate + "]";
	}

	
	
	
}
