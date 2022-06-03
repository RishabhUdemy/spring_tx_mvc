package com.learn.dtx.form;

public class OrderForm {

	private String customerName;
	private String mobileNo;
	private String emailAddress;
	private OrderProduct[] orderProducts;
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public OrderProduct[] getOrderProducts() {
		return orderProducts;
	}
	public void setOrderProducts(OrderProduct[] orderProducts) {
		this.orderProducts = orderProducts;
	}
	
}
