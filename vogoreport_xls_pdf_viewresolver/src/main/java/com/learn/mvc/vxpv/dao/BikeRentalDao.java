package com.learn.mvc.vxpv.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.learn.mvc.vxpv.bo.BikeBo;
import com.learn.mvc.vxpv.bo.BikeRentalBo;
import com.learn.mvc.vxpv.bo.CustomerBo;

public class BikeRentalDao {

	private static final String SQL_QUERY_BIKE_RENTAL_DETAIL = "select b.*,c.*,br.* from bike_rental br inner join bike b on br.bike_no = b.bike_no inner join customer c on br.customer_no = c.customer_no where rented_dt between ? and ?";
	
	private JdbcTemplate jdbcTemplate;

	public BikeRentalDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	public List<BikeRentalBo> getBikeRentalDetail(Date fromDate,Date toDate){
		
		return jdbcTemplate.query(SQL_QUERY_BIKE_RENTAL_DETAIL, (rs)->{
			List<BikeRentalBo> listBikeRentalBo = null;
			BikeRentalBo bikeRentalBo = null;
			Map<Integer, BikeBo> mapBikeBo = null;
			Map<Integer, CustomerBo> mapCustomerBo = null;
			int bikeNo = 0;
			int customerNo = 0;
			BikeBo bikeBo = null;
			CustomerBo customerBo = null;
			
			listBikeRentalBo = new ArrayList<>();
			while(rs.next()) {
				
				bikeRentalBo = new BikeRentalBo();
				bikeRentalBo.setBikeRentalNo(rs.getInt("br.bike_rental_no"));
				bikeRentalBo.setRentedDate(rs.getDate("br.rented_dt"));
				bikeRentalBo.setAmountPaid(rs.getDouble("br.amount_paid"));
				bikeRentalBo.setDuration(rs.getInt("br.duration"));
				
				bikeNo = rs.getInt("b.bike_no");
				mapBikeBo = new HashMap<>();
				if(mapBikeBo.containsKey(bikeNo) == false) {
					bikeBo = new BikeBo();
					bikeBo.setBikeNo(bikeNo);
					bikeBo.setManufacturer(rs.getString("b.manufacturer"));
					bikeBo.setRtaRegistationNo(rs.getString("b.rta_registation_no"));
					bikeBo.setAmount(rs.getDouble("b.price"));
					bikeBo.setBikeModelName(rs.getString("b.bike_model_nm"));
					mapBikeBo.put(bikeNo, bikeBo);
				}
				bikeRentalBo.setBikeBo(mapBikeBo.get(bikeNo));
				mapCustomerBo = new HashMap<>();
				if(mapCustomerBo.containsKey(customerNo) == false) {
					customerBo = new CustomerBo();
					customerBo.setCustomerNo(customerNo);
					customerBo.setDob(rs.getDate("c.dob"));
					customerBo.setDrivingLicenseNo(rs.getString("c.driving_license_no"));
					customerBo.setEmailAddress(rs.getString("c.email_address"));
					customerBo.setFullName(rs.getString("c.full_nm"));
					customerBo.setGender(rs.getString("c.gender"));
					customerBo.setMobileNo(rs.getString("c.mobile_no"));
					mapCustomerBo.put(customerNo, customerBo);
				}
				bikeRentalBo.setCustomerBo(mapCustomerBo.get(customerNo));
				listBikeRentalBo.add(bikeRentalBo);
			}
			return listBikeRentalBo;
		},fromDate,toDate);
		
	}
}
