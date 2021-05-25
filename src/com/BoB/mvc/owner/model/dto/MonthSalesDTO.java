package com.BoB.mvc.owner.model.dto;

public class MonthSalesDTO {

	private int Month;
	private int Count;
	private int TotalPrice;
	
	public MonthSalesDTO() {
		super();
	}

	public MonthSalesDTO(int month, int count, int totalPrice) {
		super();
		Month = month;
		Count = count;
		TotalPrice = totalPrice;
	}

	public int getMonth() {
		return Month;
	}

	public void setMonth(int month) {
		Month = month;
	}

	public int getCount() {
		return Count;
	}

	public void setCount(int count) {
		Count = count;
	}

	public int getTotalPrice() {
		return TotalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		TotalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "MonthSales [Month=" + Month + ", Count=" + Count + ", TotalPrice=" + TotalPrice + "]";
	}

	
	
	
	
}
