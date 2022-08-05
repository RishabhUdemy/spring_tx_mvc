package com.vogobike.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.vogobike.dto.BikeDto;
import com.vogobike.service.BikeManageService;

public class BikeController implements Controller{

	private BikeManageService bikeManageService;
	
	public void setBikeManageService(BikeManageService bikeManageService) {
		this.bikeManageService = bikeManageService;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = null;
		List<BikeDto> listBikeDto = null;
		
		listBikeDto = bikeManageService.getBikeDetail();
		mav = new ModelAndView();
		mav.setViewName("bikedetails");
		mav.addObject("bikes",listBikeDto);
		return mav;
	}

	
}
