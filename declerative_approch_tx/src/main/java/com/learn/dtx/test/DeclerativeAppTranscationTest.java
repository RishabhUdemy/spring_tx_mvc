package com.learn.dtx.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.learn.dtx.controller.PlaceOrderController;
import com.learn.dtx.form.OrderForm;
import com.learn.dtx.form.OrderProduct;

public class DeclerativeAppTranscationTest {

	public static void main(String[] args) {
	
		ApplicationContext context = new ClassPathXmlApplicationContext("com/learn/common/root-application.xml");
		PlaceOrderController placeOrderController = context.getBean(PlaceOrderController.class);
		
		OrderForm orderForm = new OrderForm();
		orderForm.setCustomerName("Mike");
		orderForm.setEmailAddress("James@gmail.com");
		orderForm.setMobileNo("+9184712458639");
		
		OrderProduct orderProduct = new OrderProduct();
		orderProduct.setDiscountAmount(23.56f);
		orderProduct.setPricePerUnit(223.56f);
		orderProduct.setProductNo(1);
		orderProduct.setQuantity(10);
		orderProduct.setRemark("Organic");
		
		OrderProduct orderProduct1 = new OrderProduct();
		orderProduct1.setDiscountAmount(23.56f);
		orderProduct1.setPricePerUnit(0);
		orderProduct1.setProductNo(3);
		orderProduct1.setQuantity(10);
		orderProduct1.setRemark("n/a");
		
		
		OrderProduct[] orderprodArray = new OrderProduct[] {orderProduct,orderProduct1};
		
		orderForm.setOrderProducts(orderprodArray);
		
		int orderNo = placeOrderController.placeOrder(orderForm);
		System.out.println("Getting the total orderNo:"+orderNo);
	}
}
