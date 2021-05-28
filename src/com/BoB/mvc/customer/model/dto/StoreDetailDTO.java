package com.BoB.mvc.customer.model.dto;

public class StoreDetailDTO implements java.io.Serializable {
	
	private String photo;       // 사진 경로
	private String storeName;   // 가게 이름
	private double star;        // 별점
	private String address;     // 가게 주소
	private String phone;       // 가게 전화번호 = 유저 테이블에 있는 전화번호
	private String detailInto;  // 가게 상세 내용
	private int bestReviewCnt;  // 베스트리뷰 개수
	private int goodReviewCnt;  // 굿리뷰 개수
	private int badReviewCnt;   // 베드리뷰 개수
	private String reviewId;    // 리뷰 단 사람의 아이디
	private String review;      // 리뷰내용
	private String reviewPhoto; // 리뷰이미지
	private String cate;        // 카테고리
	private int satisfied ;     // 상태값
	private int storeId;        // 가게 코드
	
	public StoreDetailDTO() {
		super();
	}

	public StoreDetailDTO(String photo, String storeName, double star, String address, String phone, String detailInto,
			int bestReviewCnt, int goodReviewCnt, int badReviewCnt, String reviewId, String review, String reviewPhoto,
			String cate, int satisfied, int storeId) {
		super();
		this.photo = photo;
		this.storeName = storeName;
		this.star = star;
		this.address = address;
		this.phone = phone;
		this.detailInto = detailInto;
		this.bestReviewCnt = bestReviewCnt;
		this.goodReviewCnt = goodReviewCnt;
		this.badReviewCnt = badReviewCnt;
		this.reviewId = reviewId;
		this.review = review;
		this.reviewPhoto = reviewPhoto;
		this.cate = cate;
		this.satisfied = satisfied;
		this.storeId = storeId;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public double getStar() {
		return star;
	}

	public void setStar(double star) {
		this.star = star;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDetailInto() {
		return detailInto;
	}

	public void setDetailInto(String detailInto) {
		this.detailInto = detailInto;
	}

	public int getBestReviewCnt() {
		return bestReviewCnt;
	}

	public void setBestReviewCnt(int bestReviewCnt) {
		this.bestReviewCnt = bestReviewCnt;
	}

	public int getGoodReviewCnt() {
		return goodReviewCnt;
	}

	public void setGoodReviewCnt(int goodReviewCnt) {
		this.goodReviewCnt = goodReviewCnt;
	}

	public int getBadReviewCnt() {
		return badReviewCnt;
	}

	public void setBadReviewCnt(int badReviewCnt) {
		this.badReviewCnt = badReviewCnt;
	}

	public String getReviewId() {
		return reviewId;
	}

	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getReviewPhoto() {
		return reviewPhoto;
	}

	public void setReviewPhoto(String reviewPhoto) {
		this.reviewPhoto = reviewPhoto;
	}

	public String getCate() {
		return cate;
	}

	public void setCate(String cate) {
		this.cate = cate;
	}

	public int getSatisfied() {
		return satisfied;
	}

	public void setSatisfied(int satisfied) {
		this.satisfied = satisfied;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	@Override
	public String toString() {
		return "StoreDetailDTO [photo=" + photo + ", storeName=" + storeName + ", star=" + star + ", address=" + address
				+ ", phone=" + phone + ", detailInto=" + detailInto + ", bestReviewCnt=" + bestReviewCnt
				+ ", goodReviewCnt=" + goodReviewCnt + ", badReviewCnt=" + badReviewCnt + ", reviewId=" + reviewId
				+ ", review=" + review + ", reviewPhoto=" + reviewPhoto + ", cate=" + cate + ", satisfied=" + satisfied
				+ ", storeId=" + storeId + "]";
	}

}
