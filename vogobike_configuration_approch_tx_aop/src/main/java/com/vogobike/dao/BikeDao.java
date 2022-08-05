package com.vogobike.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.vogobike.bo.BikeBo;
import com.vogobike.dto.BikeDto;

public class BikeDao {

	private JdbcTemplate jdbcTemplate;
	private final String SQL_QUERY_BIKE_DETAIL = "Select bike_no,bike_model_nm,manufacturer,rta_registation_no,price from bike";
	
	public BikeDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<BikeBo> getBikeDetail(){
		return jdbcTemplate.query(SQL_QUERY_BIKE_DETAIL, (rs,rowNum) ->{
			BikeBo bo = new BikeBo();
			bo.setBikeNo(rs.getInt(1));
			bo.setBikeModelName(rs.getString(2));
			bo.setManufacturer(rs.getString(3));
			bo.setRtaRegistrationNo(rs.getString(4));
			bo.setPrice(rs.getDouble(5));
			return bo;
		});
	}
}
