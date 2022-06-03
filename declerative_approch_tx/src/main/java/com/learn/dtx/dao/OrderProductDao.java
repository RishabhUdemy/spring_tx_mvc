package com.learn.dtx.dao;

import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.learn.dtx.bo.OrderProductBo;

public class OrderProductDao {

	private final String SQL_SAVE_ORDER_PRODUCT = "insert into spring_jdbc.order_product (order_no,product_no,quantity,price_per_unit,discount_amount,remark) values (?,?,?,?,?,?)";
	private JdbcTemplate jdbcTemplate;

	public OrderProductDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void saveOrderProduct(List<OrderProductBo> listOrderProductBo) {
		for(OrderProductBo orderProductBo:listOrderProductBo) {
			if(orderProductBo.getPricePerUnit() <= 0) {
				throw new IllegalArgumentException("Invalid Price Please check once.");
			}
			jdbcTemplate.update(SQL_SAVE_ORDER_PRODUCT,orderProductBo.getOrderNo(),orderProductBo.getProductNo(),orderProductBo.getQuantity(),orderProductBo.getPricePerUnit(),orderProductBo.getDiscountAmount(),orderProductBo.getRemark());
		}

	}
}
