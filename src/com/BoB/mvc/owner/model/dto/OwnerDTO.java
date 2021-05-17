package com.BoB.mvc.owner.model.dto;

public class OwnerDTO {
	
	private String memberId;
	private String memberPwd;
	private String name;
	private String phone;
	private String address;
	/* 추가할 부분 */
	private String email;
	private String residentNum;
	
	
	public OwnerDTO() {}


	public OwnerDTO(String memberId, String memberPwd, String name, String phone, String address, String email,
			String residentNum) {
		super();
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.residentNum = residentNum;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getResidentNum() {
		return residentNum;
	}


	public void setResidentNum(String residentNum) {
		this.residentNum = residentNum;
	}


	@Override
	public String toString() {
		return "OwnerDTO [memberId=" + memberId + ", memberPwd=" + memberPwd + ", name=" + name + ", phone=" + phone
				+ ", address=" + address + ", email=" + email + ", residentNum=" + residentNum + "]";
	}


	
	
	
	
	
	

}
 