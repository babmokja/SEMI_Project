package com.BoB.mvc.owner.model.dto;

import java.sql.Date;

public class OwnerDTO {
	
	private int userCode;
	private String memberId;
	private String memberPwd;
	private String name;
	private String phone;
	private String address;
	private int point;
	private String email;
	private String withdrawYN;
	private int roleCode;
	private String blacklistYN;
	private Date blacklistDate;
	private String residentNum;
	
	
	public OwnerDTO() {}


	public OwnerDTO(int userCode, String memberId, String memberPwd, String name, String phone, String address,
			int point, String email, String withdrawYN, int roleCode, String blacklistYN, Date blacklistDate,
			String residentNum) {
		super();
		this.userCode = userCode;
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.point = point;
		this.email = email;
		this.withdrawYN = withdrawYN;
		this.roleCode = roleCode;
		this.blacklistYN = blacklistYN;
		this.blacklistDate = blacklistDate;
		this.residentNum = residentNum;
	}


	public int getUserCode() {
		return userCode;
	}


	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}


	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	public String getMemberPwd() {
		return memberPwd;
	}


	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
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


	public String getWithdrawYN() {
		return withdrawYN;
	}


	public void setWithdrawYN(String withdrawYN) {
		this.withdrawYN = withdrawYN;
	}


	public int getRoleCode() {
		return roleCode;
	}


	public void setRoleCode(int roleCode) {
		this.roleCode = roleCode;
	}


	public String getBlacklistYN() {
		return blacklistYN;
	}


	public void setBlacklistYN(String blacklistYN) {
		this.blacklistYN = blacklistYN;
	}


	public Date getBlacklistDate() {
		return blacklistDate;
	}


	public void setBlacklistDate(Date blacklistDate) {
		this.blacklistDate = blacklistDate;
	}


	public String getResidentNum() {
		return residentNum;
	}


	public void setResidentNum(String residentNum) {
		this.residentNum = residentNum;
	}


	@Override
	public String toString() {
		return "OwnerDTO [userCode=" + userCode + ", memberId=" + memberId + ", memberPwd=" + memberPwd + ", name="
				+ name + ", phone=" + phone + ", address=" + address + ", point=" + point + ", email=" + email
				+ ", withdrawYN=" + withdrawYN + ", roleCode=" + roleCode + ", blacklistYN=" + blacklistYN
				+ ", blacklistDate=" + blacklistDate + ", residentNum=" + residentNum + "]";
	}


	

	

	
	
	
	
	
	

}
 