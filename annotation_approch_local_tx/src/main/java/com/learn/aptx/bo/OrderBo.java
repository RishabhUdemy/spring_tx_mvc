package com.learn.aptx.bo;

import java.io.Serializable;
import java.util.Date;

public class OrderBo implements Serializable{
	
	protected int orderNo;
	protected Date orderPlacedDate;
	protected String customerName;
	protected String mobileNo;
	protected String emailAddress;
	protected Date exptectedDeliveryDate;
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public Date getOrderPlacedDate() {
		return orderPlacedDate;
	}
	public void setOrderPlacedDate(Date orderPlacedDate) {
		this.orderPlacedDate = orderPlacedDate;
	}
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
	public Date getExptectedDeliveryDate() {
		return exptectedDeliveryDate;
	}
	public void setExptectedDeliveryDate(Date exptectedDeliveryDate) {
		this.exptectedDeliveryDate = exptectedDeliveryDate;
	}
	@Override
	public String toString() {
		return "OrderBo [orderNo=" + orderNo + ", orderPlacedDate=" + orderPlacedDate + ", customerName=" + customerName
				+ ", mobileNo=" + mobileNo + ", emailAddress=" + emailAddress + ", exptectedDeliveryDate="
				+ exptectedDeliveryDate + "]";
	}
	
	
}