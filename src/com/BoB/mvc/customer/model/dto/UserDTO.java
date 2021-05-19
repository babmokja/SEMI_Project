package com.BoB.mvc.customer.model.dto;

import java.sql.Date;

public class UserDTO implements java.io.Serializable{

	public int userCode;     //사용자코드
	private String id;
	private String pwd;
	private String name;
	private String phone;
	private String email;
	private String address;
	private boolean withdraw;  //탈퇴여부
	private int point; 
	private String userNo;     //주민번호
	private int roleCode;      //역할코드
    private boolean blacklistYn;   //블랙리스트 여부
    private Date blacklistDate; 
	
	public UserDTO() {}

	public UserDTO(int userCode, String id, String pwd, String name, String phone, String email, String address,
			boolean withdraw, int point, String userNo, int roleCode, boolean blacklistYn, Date blacklistDate) {
		super();
		this.userCode = userCode;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.withdraw = withdraw;
		this.point = point;
		this.userNo = userNo;
		this.roleCode = roleCode;
		this.blacklistYn = blacklistYn;
		this.blacklistDate = blacklistDate;
	}

	public int getUserCode() {
		return userCode;
	}

	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isWithdraw() {
		return withdraw;
	}

	public void setWithdraw(boolean withdraw) {
		this.withdraw = withdraw;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public int getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(int roleCode) {
		this.roleCode = roleCode;
	}

	public boolean isBlacklistYn() {
		return blacklistYn;
	}

	public void setBlacklistYn(boolean blacklistYn) {
		this.blacklistYn = blacklistYn;
	}

	public Date getBlacklistDate() {
		return blacklistDate;
	}

	public void setBlacklistDate(Date blacklistDate) {
		this.blacklistDate = blacklistDate;
	}

	@Override
	public String toString() {
		return "UserDTO [userCode=" + userCode + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", phone=" + phone
				+ ", email=" + email + ", address=" + address + ", withdraw=" + withdraw + ", point=" + point
				+ ", userNo=" + userNo + ", roleCode=" + roleCode + ", blacklistYn=" + blacklistYn + ", blacklistDate="
				+ blacklistDate + "]";
	}
	
	

	

}
