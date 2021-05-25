package com.BoB.mvc.admin.dto;

import java.sql.Date;

public class CustomerBoardDTO implements java.io.Serializable{

	private int boardCode;
	private String boardTitle;
	private Date boardDate;
	private String boardContent;
	private int userCode;
	private String userName;
	private String visible;
	
	public CustomerBoardDTO() {}

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

	public int getUserCode() {
		return userCode;
	}

	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getVisible() {
		return visible;
	}

	public void setVisible(String visible) {
		this.visible = visible;
	}

	public CustomerBoardDTO(int boardCode, String boardTitle, Date boardDate, String boardContent, int userCode,
			String userName, String visible) {
		super();
		this.boardCode = boardCode;
		this.boardTitle = boardTitle;
		this.boardDate = boardDate;
		this.boardContent = boardContent;
		this.userCode = userCode;
		this.userName = userName;
		this.visible = visible;
	}

	@Override
	public String toString() {
		return "CustomerBoardDTO [boardCode=" + boardCode + ", boardTitle=" + boardTitle + ", boardDate=" + boardDate
				+ ", boardContent=" + boardContent + ", userCode=" + userCode + ", userName=" + userName + ", visible="
				+ visible + "]";
	}

	

	

	
	
	
}
