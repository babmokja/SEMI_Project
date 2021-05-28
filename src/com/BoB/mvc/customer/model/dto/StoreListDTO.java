package com.BoB.mvc.customer.model.dto;

public class StoreListDTO implements java.io.Serializable {

	private String category;   // 카테고리
	private String type;       // 유형(픽업, 배달)
	private String storeName;  // 가게이름
	private String congestion; // 혼잡도 => div갯수 => 주문진행중인것의 갯수
	private double star;       // 별점
	private int reviewCnt;     // 리뷰 개수
	private String photo;      // 대표 이미지
	private String address;    // 지도정보 -> 가게 주소
	private String storeId;       // 가게 코드
	
	public StoreListDTO() {
		super();
	}

	public StoreListDTO(String category, String type, String storeName, String congestion, double star, int reviewCnt,
			String photo, String address, String storeId) {
		super();
		this.category = category;
		this.type = type;
		this.storeName = storeName;
		this.congestion = congestion;
		this.star = star;
		this.reviewCnt = reviewCnt;
		this.photo = photo;
		this.address = address;
		this.storeId = storeId;
	}
	
	public String getStoreId() {
		return storeId;
	}
	
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getCongestion() {
		return congestion;
	}

	public void setCongestion(String congestion) {
		this.congestion = congestion;
	}

	public double getStar() {
		return star;
	}

	public void setStar(double star) {
		this.star = star;
	}

	public int getReviewCnt() {
		return reviewCnt;
	}

	public void setReviewCnt(int reviewCnt) {
		this.reviewCnt = reviewCnt;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "StoreListDTO [category=" + category + ", type=" + type + ", storeName=" + storeName + ", congestion="
				+ congestion + ", star=" + star + ", reviewCnt=" + reviewCnt + ", photo=" + photo + ", address="
				+ address + storeId + "]";
	}
	
}
