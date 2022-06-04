package com.learn.aptx.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.learn.aptx.bo.OrderBo;

@Repository
public class OrderDao {

	private final String SQL_SAVE_ORDER = "insert into spring_jdbc.order(order_placed_date,customer_name,mobile_no,email_address,expected_delivery_date) values(?,?,?,?,?)";
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int saveOrder(OrderBo orderBo) {
		int orderNo = 0;
		KeyHolder keyHolder =null;
		
		keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update((con)->{
			PreparedStatement pst = null;
			Calendar cal = null;
			
			cal = Calendar.getInstance();
			
			pst = con.prepareStatement(SQL_SAVE_ORDER,new String[] {"order_no"});
			pst.setDate(1, new Date(orderBo.getOrderPlacedDate().getTime()));
			pst.setString(2, orderBo.getCustomerName());
			pst.setString(3, orderBo.getMobileNo());
			pst.setString(4, orderBo.getEmailAddress());
			pst.setDate(5, new Date(orderBo.getExptectedDeliveryDate().getTime()));
			return pst;
		},keyHolder);
		
		orderNo = keyHolder.getKey().intValue();
		return orderNo;
	}
}
