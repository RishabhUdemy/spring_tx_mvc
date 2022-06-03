package com.learn.dtx.dao;

import java.sql.Date;
import java.sql.PreparedStatement;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.learn.dtx.bo.OrderBo;

public class OrderDao {

	private final String SQL_SAVE_ORDER = "insert into spring_jdbc.order(order_placed_date,customer_name,mobile_no,email_address,expected_delivery_date) values(?,?,?,?,?)";
	private JdbcTemplate jdbcTemplate;

	public OrderDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	public int saveOrderDetail(OrderBo orderBo) {
		KeyHolder keyHolder = null;
		int orderNo = 0;
		keyHolder = new GeneratedKeyHolder();
		
		jdbcTemplate.update((con)->{
			PreparedStatement pst = con.prepareStatement(SQL_SAVE_ORDER,new String[] {"order_no"});
			pst.setDate(1,new Date(orderBo.getOrderPlacedDate().getTime()));
			pst.setString(2, orderBo.getCustomerName());
			pst.setString(3, orderBo.getMobileNo());
			pst.setString(4, orderBo.getEmailAddress());
			pst.setDate(5, new Date(orderBo.getExpectedDeliveryDate().getTime()));
			
			return pst;
		},keyHolder);
		
		
		orderNo = keyHolder.getKey().intValue();
		return orderNo;
	}
}
