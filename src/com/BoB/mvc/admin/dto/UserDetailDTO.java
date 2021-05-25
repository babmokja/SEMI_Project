package com.BoB.mvc.admin.dto;

import java.util.Date;

public class UserDetailDTO {
	
	private int userNum;
	private String userId;
	private String userName;
	private String userPhone;
	private String userAddr;
	private int point;
	private String userEmail;
	private String withdraw_yn;
	private int roleCode;
	private String blackListyn;
	private Date blackListDate;
	private String userJumin;
	
	
	public UserDetailDTO() {
		
	}
	
	@Override
	public String toString() {
		return "UserDetailDTO [userNum=" + userNum + ", userId=" + userId + ", userName=" + userName + ", userPhone="
				+ userPhone + ", userAddr=" + userAddr + ", point=" + point + ", userEmail=" + userEmail
				+ ", withdraw_yn=" + withdraw_yn + ", roleCode=" + roleCode + ", blackListyn=" + blackListyn
				+ ", blackListDate=" + blackListDate + ", userJumin=" + userJumin + "]";
	}


	public int getUserNum() {
		return userNum;
	}


	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserPhone() {
		return userPhone;
	}


	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}


	public String getUserAddr() {
		return userAddr;
	}


	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}


	public int getPoint() {
		return point;
	}


	public void setPoint(int point) {
		this.point = point;
	}


	public String getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	public String getWithdraw_yn() {
		return withdraw_yn;
	}


	public void setWithdraw_yn(String withdraw_yn) {
		this.withdraw_yn = withdraw_yn;
	}


	public int getRoleCode() {
		return roleCode;
	}


	public void setRoleCode(int roleCode) {
		this.roleCode = roleCode;
	}


	public String getBlackListyn() {
		return blackListyn;
	}


	public void setBlackListyn(String blackListyn) {
		this.blackListyn = blackListyn;
	}


	public Date getBlackListDate() {
		return blackListDate;
	}


	public void setBlackListDate(Date blackListDate) {
		this.blackListDate = blackListDate;
	}


	public String getUserJumin() {
		return userJumin;
	}


	public void setUserJumin(String userJumin) {
		this.userJumin = userJumin;
	}


	


	protected UserDetailDTO(int userNum, String userId, String userName, String userPhone, String userAddr, int point,
			String userEmail, String withdraw_yn, int roleCode, String blackListyn, Date blackListDate,
			String userJumin) {
		super();
		this.userNum = userNum;
		this.userId = userId;
		this.userName = userName;
		this.userPhone = userPhone;
		this.userAddr = userAddr;
		this.point = point;
		this.userEmail = userEmail;
		this.withdraw_yn = withdraw_yn;
		this.roleCode = roleCode;
		this.blackListyn = blackListyn;
		this.blackListDate = blackListDate;
		this.userJumin = userJumin;
	}
	
	
	
	
	
	
	
	
	
	
	
}
