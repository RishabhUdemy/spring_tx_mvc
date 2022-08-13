package com.learn.mvc.vxpv.bo;

import java.util.Date;

import lombok.Data;

@Data
public class CustomerBo {

	private int customerNo;
	private String fullName;
	private String mobileNo;
	private String gender;
	private String emailAddress;
	private String drivingLicenseNo;
	private Date dob;
}
