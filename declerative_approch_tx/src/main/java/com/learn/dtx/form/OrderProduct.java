package com.learn.dtx.form;

public class OrderProduct {

	private int orderNo;
	private int productNo;
	private int quantity;
	private float pricePerUnit;
	private float discountAmount;
	private String remark;
	
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPricePerUnit() {
		return pricePerUnit;
	}
	public void setPricePerUnit(float pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
	public float getDiscountAmount() {
		return discountAmount;
	}
	public void setDiscountAmount(float discountAmount) {
		this.discountAmount = discountAmount;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Override
	public String toString() {
		return "OrderProduct [orderNo=" + orderNo + ", productNo=" + productNo + ", quantity=" + quantity
				+ ", pricePerUnit=" + pricePerUnit + ", discountAmount=" + discountAmount + ", remark=" + remark + "]";
	}
	
	
}
