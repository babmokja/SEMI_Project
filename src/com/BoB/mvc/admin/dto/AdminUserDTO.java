package com.BoB.mvc.admin.dto;

public class AdminUserDTO {
	private int userNum;
	private String blackList;
	private String userName;
	private String userId;
	private String userAddr;
	private String withDrawYN;
	
	public AdminUserDTO() {
		
	}

	public AdminUserDTO(int userNum, String blackList, String userName, String userId, String userAddr,
			String withDrawYN) {
		super();
		this.userNum = userNum;
		this.blackList = blackList;
		this.userName = userName;
		this.userId = userId;
		this.userAddr = userAddr;
		this.withDrawYN = withDrawYN;
	}

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	public String getBlackList() {
		return blackList;
	}

	public void setBlackList(String blackList) {
		this.blackList = blackList;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserAddr() {
		return userAddr;
	}

	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}

	public String getWithDrawYN() {
		return withDrawYN;
	}

	public void setWithDrawYN(String withDrawYN) {
		this.withDrawYN = withDrawYN;
	}

	@Override
	public String toString() {
		return "AdminUserDTO [userNum=" + userNum + ", blackList=" + blackList + ", userName=" + userName + ", userId="
				+ userId + ", userAddr=" + userAddr + ", withDrawYN=" + withDrawYN + "]";
	}

	
	

	
	
	
	
	
	
}
