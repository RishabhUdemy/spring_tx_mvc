package com.learn.aptx.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.learn.aptx.config.RootConfig;
import com.learn.aptx.controller.OrderProductController;
import com.learn.aptx.form.OrderForm;
import com.learn.aptx.form.OrderProductForm;

public class AnnotationLocalTranscationTest {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(RootConfig.class);
		
		OrderForm orderForm = new OrderForm();
		orderForm.setCustomerName("Mike");
		orderForm.setEmailAddress("James@gmail.com");
		orderForm.setMobileNo("+9184712458639");
		
		OrderProductForm orderProduct = new OrderProductForm();
		orderProduct.setDiscountAmount(23.56f);
		orderProduct.setPricePerUnit(223.56f);
		orderProduct.setProductNo(1);
		orderProduct.setQuantity(10);
		orderProduct.setRemark("Organic");
		
		OrderProductForm orderProduct1 = new OrderProductForm();
		orderProduct1.setDiscountAmount(23.56f);
		orderProduct1.setPricePerUnit(0);
		orderProduct1.setProductNo(3);
		orderProduct1.setQuantity(10);
		orderProduct1.setRemark("n/a");
		
		OrderProductForm[] orderProductFormArray = new OrderProductForm[] {orderProduct,orderProduct1};
		orderForm.setOrderProductForm(orderProductFormArray);
		
		OrderProductController controller = context.getBean(OrderProductController.class);
		int orderNo = controller.getOrderProductInfo(orderForm);
		
		System.out.println("The Order No Detail:"+orderNo);
	}
}
