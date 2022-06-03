package com.learn.dtx.controller;

import com.learn.dtx.form.OrderForm;
import com.learn.dtx.services.ManageOrderProductService;

public class PlaceOrderController {

	private ManageOrderProductService manageOrderProductService;
	
	public int placeOrder(OrderForm orderForm) {
		int orderNo = 0;
		
		orderNo = manageOrderProductService.newOrder(orderForm);
		return orderNo;
	}

	public void setManageOrderProductService(ManageOrderProductService manageOrderProductService) {
		this.manageOrderProductService = manageOrderProductService;
	}
	
	
}
