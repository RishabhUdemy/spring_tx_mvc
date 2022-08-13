package com.learn.mvc.vxpv.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.learn.mvc.vxpv.bo.BikeRentalBo;
import com.learn.mvc.vxpv.dao.BikeRentalDao;
import com.learn.mvc.vxpv.dto.BikeRentalDto;

public class BikeRentalService {

	BikeRentalDao bikeRentalDao;

	public BikeRentalService(BikeRentalDao bikeRentalDao) {
		this.bikeRentalDao = bikeRentalDao;
	}
	

	public List<BikeRentalDto> getBikeRentalDetail(Date fromDate,Date toDate) throws ParseException{
		List<BikeRentalBo> listBikeRentalBos = null;
		List<BikeRentalDto> listBikeRentalDtos = null;
		BikeRentalDto bikeRentalDto = null;
		
		
		listBikeRentalBos = bikeRentalDao.getBikeRentalDetail(fromDate, toDate);
		listBikeRentalDtos = new ArrayList<>();
		for(BikeRentalBo bikeRentalBo:listBikeRentalBos) {
			bikeRentalDto = new BikeRentalDto();
			bikeRentalDto.setAmountPaid(bikeRentalBo.getAmountPaid());
			bikeRentalDto.setBikeModelName(bikeRentalBo.getBikeBo().getBikeModelName());
			bikeRentalDto.setCustomerName(bikeRentalBo.getCustomerBo().getFullName());
			bikeRentalDto.setDuration(bikeRentalBo.getDuration());
			bikeRentalDto.setRentedDate(bikeRentalBo.getRentedDate());
			bikeRentalDto.setRtaRegistationNo(bikeRentalBo.getBikeBo().getRtaRegistationNo());
			listBikeRentalDtos.add(bikeRentalDto);
		}
		return listBikeRentalDtos;
	}
}








