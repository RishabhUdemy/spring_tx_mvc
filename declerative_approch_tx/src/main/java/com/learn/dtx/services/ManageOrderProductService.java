package com.learn.dtx.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.learn.dtx.bo.OrderBo;
import com.learn.dtx.bo.OrderProductBo;
import com.learn.dtx.dao.OrderDao;
import com.learn.dtx.dao.OrderProductDao;
import com.learn.dtx.form.OrderForm;
import com.learn.dtx.form.OrderProduct;

public class ManageOrderProductService {

	private OrderDao orderDao;
	private OrderProductDao orderProductDao;
	
	public int newOrder(OrderForm orderForm) {
		int orderNo = 0;
		Calendar cal = null;
		List<OrderProductBo> listOrderProduct;
		
		listOrderProduct = new ArrayList<OrderProductBo>();
		cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH)+3);
		OrderBo orderBo = new OrderBo();
		orderBo.setCustomerName(orderForm.getCustomerName());
		orderBo.setEmailAddress(orderForm.getEmailAddress());
		orderBo.setMobileNo(orderForm.getMobileNo());
		orderBo.setOrderPlacedDate(new Date());
		orderBo.setExpectedDeliveryDate(cal.getTime());
		
		orderNo = orderDao.saveOrderDetail(orderBo);
		for(OrderProduct orderProduct:orderForm.getOrderProducts()) {
			OrderProductBo orderProductBo = new OrderProductBo();
			orderProductBo.setOrderNo(orderNo);
			orderProductBo.setDiscountAmount(orderProduct.getDiscountAmount());
			orderProductBo.setPricePerUnit(orderProduct.getPricePerUnit());
			orderProductBo.setProductNo(orderProduct.getProductNo());
			orderProductBo.setQuantity(orderProduct.getQuantity());
			orderProductBo.setRemark(orderProduct.getRemark());
			listOrderProduct.add(orderProductBo);
		}
		
		orderProductDao.saveOrderProduct(listOrderProduct);
		return orderNo;
	}
	
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	public void setOrderProductDao(OrderProductDao orderProductDao) {
		this.orderProductDao = orderProductDao;
	}
	
	
}
