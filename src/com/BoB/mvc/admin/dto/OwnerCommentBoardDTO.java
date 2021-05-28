package com.BoB.mvc.admin.dto;

import java.sql.Date;

public class OwnerCommentBoardDTO {

	private String boardTitle;
	private Date boardDate;
	private String boardContent;
	private String userName;
	private int boardCode;
	
	public OwnerCommentBoardDTO() {}

	public OwnerCommentBoardDTO(String boardTitle, Date boardDate, String boardContent, String userName,
			int boardCode) {
		this.boardTitle = boardTitle;
		this.boardDate = boardDate;
		this.boardContent = boardContent;
		this.userName = userName;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getBoardCode() {
		return boardCode;
	}

	public void setBoardCode(int boardCode) {
		this.boardCode = boardCode;
	}

	@Override
	public String toString() {
		return "OwnerCommentBoardDTO [boardTitle=" + boardTitle + ", boardDate=" + boardDate + ", boardContent="
				+ boardContent + ", userName=" + userName + ", boardCode=" + boardCode + "]";
	}

	
	
}
