package com.BoB.mvc.admin.dto;

import java.sql.Date;

public class AdminDTO implements java.io.Serializable{
	
	
	private int userCode;
	private String id;
	private String pwd;
	private String name;
	private String phone;
	private String address;
	private int point;
	private String email;
	private String withdraw;
	private int rollcode;
	private String blacklistYn;
	private Date blacklistDate;
	private String userNo;
	
	public AdminDTO() {}

	public AdminDTO(int userCode, String id, String pwd, String name, String phone, String address, int point,
			String email, String withdraw, int rollcode, String blacklistYn, Date blacklistDate, String userNo) {
		super();
		this.userCode = userCode;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.point = point;
		this.email = email;
		this.withdraw = withdraw;
		this.rollcode = rollcode;
		this.blacklistYn = blacklistYn;
		this.blacklistDate = blacklistDate;
		this.userNo = userNo;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(String withdraw) {
		this.withdraw = withdraw;
	}

	public int getRollcode() {
		return rollcode;
	}

	public void setRollcode(int rollcode) {
		this.rollcode = rollcode;
	}

	public String getBlacklistYn() {
		return blacklistYn;
	}

	public void setBlacklistYn(String blacklistYn) {
		this.blacklistYn = blacklistYn;
	}

	public Date getBlacklistDate() {
		return blacklistDate;
	}

	public void setBlacklistDate(Date blacklistDate) {
		this.blacklistDate = blacklistDate;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	@Override
	public String toString() {
		return "AdminDTO [userCode=" + userCode + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", phone=" + phone
				+ ", address=" + address + ", point=" + point + ", email=" + email + ", withdraw=" + withdraw
				+ ", rollcode=" + rollcode + ", blacklistYn=" + blacklistYn + ", blacklistDate=" + blacklistDate
				+ ", userNo=" + userNo + "]";
	}

}
