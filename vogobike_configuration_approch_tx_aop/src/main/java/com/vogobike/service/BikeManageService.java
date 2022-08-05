package com.vogobike.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.vogobike.bo.BikeBo;
import com.vogobike.dao.BikeDao;
import com.vogobike.dto.BikeDto;

public class BikeManageService {

	private BikeDao bikeDao;

	public void setBikeDao(BikeDao bikeDao) {
		this.bikeDao = bikeDao;
	}
	
	public List<BikeDto> getBikeDetail() {
		List<BikeDto> listBikeDto = null;
		List<BikeBo> listBikeBo = null;
		
		listBikeBo = bikeDao.getBikeDetail();
		listBikeDto = new ArrayList<>();
		
		listBikeDto = listBikeBo.stream().map((bo) ->{
			BikeDto dto = new BikeDto();
			dto.setBikeModelName(bo.getBikeModelName());
			dto.setManufacturer(bo.getManufacturer());
			dto.setPrice(bo.getPrice());
			return dto;
		}).collect(Collectors.toList());
		
		return listBikeDto;
	}
}
