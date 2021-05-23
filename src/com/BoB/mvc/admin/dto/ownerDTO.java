package com.BoB.mvc.admin.dto;

public class ownerDTO {
	
	
	private int ownerNum;
	private String ownerName;
	private String stoName;
	private int bisiNum;
	private String stoAddr;
	
	public ownerDTO() {
		
	}
	

	
	protected ownerDTO(int ownerNum, String ownerName, String stoName, int bisiNum, String stoAddr) {
		super();
		this.ownerNum = ownerNum;
		this.ownerName = ownerName;
		this.stoName = stoName;
		this.bisiNum = bisiNum;
		this.stoAddr = stoAddr;
	}
	
	public int getOwnerNum() {
		return ownerNum;
	}

	public void setOwnerNum(int ownerNum) {
		this.ownerNum = ownerNum;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getStoName() {
		return stoName;
	}

	public void setStoName(String stoName) {
		this.stoName = stoName;
	}

	public int getBisiNum() {
		return bisiNum;
	}

	public void setBisiNum(int bisiNum) {
		this.bisiNum = bisiNum;
	}

	public String getStoAddr() {
		return stoAddr;
	}

	public void setStoAddr(String stoAddr) {
		this.stoAddr = stoAddr;
	}

	

	
	
	

	@Override
	public String toString() {
		return "ownerDTO [ownerNum=" + ownerNum + ", ownerName=" + ownerName + ", stoName=" + stoName + ", bisiNum="
				+ bisiNum + ", stoAddr=" + stoAddr + "]";
	}
	
	
	
	
}
