package com.BoB.mvc.owner.model.dto;

import java.sql.Date;

public class PictureDTO {
	
	private int pictureCode;
	private Date uploadDate;
	private String deleteYN;
	private String originName;
	private String revisedName;
	private String route;

	public PictureDTO() {
		super();
	}

	public PictureDTO(int pictureCode, Date uploadDate, String deleteYN, String originName, String revisedName,
			String route) {
		super();
		this.pictureCode = pictureCode;
		this.uploadDate = uploadDate;
		this.deleteYN = deleteYN;
		this.originName = originName;
		this.revisedName = revisedName;
		this.route = route;
	}

	public int getPictureCode() {
		return pictureCode;
	}

	public void setPictureCode(int pictureCode) {
		this.pictureCode = pictureCode;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getDeleteYN() {
		return deleteYN;
	}

	public void setDeleteYN(String deleteYN) {
		this.deleteYN = deleteYN;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getRevisedName() {
		return revisedName;
	}

	public void setRevisedName(String revisedName) {
		this.revisedName = revisedName;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	@Override
	public String toString() {
		return "PictureDTO [pictureCode=" + pictureCode + ", uploadDate=" + uploadDate + ", deleteYN=" + deleteYN
				+ ", originName=" + originName + ", revisedName=" + revisedName + ", route=" + route + "]";
	}
	
	
	

}
