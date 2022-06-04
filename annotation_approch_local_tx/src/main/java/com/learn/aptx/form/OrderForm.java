package com.learn.aptx.form;

import java.util.Arrays;

public class OrderForm {

	private String customerName;
	private String emailAddress;
	private String mobileNo;
	private OrderProductForm[] orderProductForm;
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public OrderProductForm[] getOrderProductForm() {
		return orderProductForm;
	}
	public void setOrderProductForm(OrderProductForm[] orderProductForm) {
		this.orderProductForm = orderProductForm;
	}
	@Override
	public String toString() {
		return "OrderForm [customerName=" + customerName + ", emailAddress=" + emailAddress + ", mobileNo=" + mobileNo
				+ ", orderProductForm=" + Arrays.toString(orderProductForm) + "]";
	}
	
}
