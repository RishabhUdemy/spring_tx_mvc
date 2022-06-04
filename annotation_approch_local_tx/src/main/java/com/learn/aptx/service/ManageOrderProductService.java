package com.learn.aptx.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learn.aptx.bo.OrderBo;
import com.learn.aptx.bo.OrderProductBo;
import com.learn.aptx.dao.OrderDao;
import com.learn.aptx.dao.OrderProductDao;
import com.learn.aptx.form.OrderForm;
import com.learn.aptx.form.OrderProductForm;

@Service
public class ManageOrderProductService {

	@Autowired
	private OrderDao orderDao;
	@Autowired
	private OrderProductDao orderProductDao;
	
	@Transactional(readOnly = false)
	public int getOrderInfo(OrderForm orderForm) {
		int orderNo = 0;
		OrderBo orderBo = null;
		Calendar cal = null;
		List<OrderProductBo> listOrderProductBo = null;
		
		cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH)+3 );
		orderBo = new OrderBo();
		orderBo.setCustomerName(orderForm.getCustomerName());
		orderBo.setEmailAddress(orderForm.getEmailAddress());
		orderBo.setMobileNo(orderForm.getMobileNo());
		orderBo.setOrderPlacedDate(new Date());
		orderBo.setExptectedDeliveryDate(cal.getTime());
		
		orderNo = orderDao.saveOrder(orderBo);
		for(OrderProductForm orderProductForm:orderForm.getOrderProductForm()) {
			listOrderProductBo = new ArrayList<>();
			OrderProductBo orderProductBo = new OrderProductBo();
			orderProductBo.setOrderNo(orderNo);
			orderProductBo.setProductNo(orderProductForm.getProductNo());
			orderProductBo.setQuantity(orderProductForm.getQuantity());
			orderProductBo.setPricePerUnit(orderProductForm.getPricePerUnit());
			orderProductBo.setDiscountAmt(orderProductForm.getDiscountAmount());
			orderProductBo.setRemark(orderProductForm.getRemark());
			listOrderProductBo.add(orderProductBo);
		}
		orderProductDao.saveOrderProduct(listOrderProductBo);
		return orderNo;
	}
}
