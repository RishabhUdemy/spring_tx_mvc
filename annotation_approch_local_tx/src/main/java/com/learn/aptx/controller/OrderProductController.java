package com.learn.aptx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.learn.aptx.form.OrderForm;
import com.learn.aptx.service.ManageOrderProductService;

@Controller
public class OrderProductController {

	@Autowired
	private ManageOrderProductService manageOrderProductService;
	
	public int getOrderProductInfo(OrderForm orderForm) {
		return manageOrderProductService.getOrderInfo(orderForm);
	}
}
