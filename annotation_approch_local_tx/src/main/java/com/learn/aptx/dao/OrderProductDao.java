package com.learn.aptx.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.learn.aptx.bo.OrderProductBo;

@Repository
public class OrderProductDao {

	private final String SQL_ORDERPRODCUT_SAVE = "insert into order_product(order_no,product_no,quantity,price_per_unit,discount_amount,remark) values(?,?,?,?,?,?)";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void saveOrderProduct(List<OrderProductBo> listOrderProductBo) {
		for (OrderProductBo orderProductBo : listOrderProductBo) {
			if (orderProductBo.getPricePerUnit() <= 0) {
				throw new IllegalArgumentException(
						"Please Provide Proper Input. Value should not be less then Zero or equal to zero.");
			}
			jdbcTemplate.update(SQL_ORDERPRODCUT_SAVE, orderProductBo.getOrderNo(), orderProductBo.getProductNo(),
					orderProductBo.getQuantity(), orderProductBo.getPricePerUnit(), orderProductBo.getDiscountAmt(),
					orderProductBo.getRemark());
		}
	}
}
