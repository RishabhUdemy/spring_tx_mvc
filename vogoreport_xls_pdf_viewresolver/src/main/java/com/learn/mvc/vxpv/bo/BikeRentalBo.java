package com.learn.mvc.vxpv.bo;

import java.util.Date;

import lombok.Data;

@Data
public class BikeRentalBo {

	private int bikeRentalNo;
	private int duration;
	private double amountPaid;
	private Date rentedDate;
	private CustomerBo customerBo;
	private BikeBo bikeBo;
}
