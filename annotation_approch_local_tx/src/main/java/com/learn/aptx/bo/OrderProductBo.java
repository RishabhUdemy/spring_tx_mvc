package com.learn.aptx.bo;

import java.io.Serializable;

public class OrderProductBo implements Serializable{

	protected int orderNo;
	protected int productNo;
	protected int quantity;
	protected float pricePerUnit;
	protected float discountAmt;
	protected String remark;
	
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
	public float getDiscountAmt() {
		return discountAmt;
	}
	public void setDiscountAmt(float discountAmt) {
		this.discountAmt = discountAmt;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "OrderBo [orderNo=" + orderNo + ", productNo=" + productNo + ", quantity=" + quantity + ", pricePerUnit="
				+ pricePerUnit + ", discountAmt=" + discountAmt + ", remark=" + remark + "]";
	}
	
	
	
}
