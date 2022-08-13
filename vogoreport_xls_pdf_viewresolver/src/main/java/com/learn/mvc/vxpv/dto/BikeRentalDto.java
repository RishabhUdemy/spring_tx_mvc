package com.learn.mvc.vxpv.dto;

import java.util.Date;

import lombok.Data;

@Data
public class BikeRentalDto {

	private String customerName;
	private String bikeModelName;
	private Date rentedDate;
	private String rtaRegistationNo;
	private int duration;
	private double amountPaid;
}
