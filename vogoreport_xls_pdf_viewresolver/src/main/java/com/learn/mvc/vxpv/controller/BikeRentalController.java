package com.learn.mvc.vxpv.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.learn.mvc.vxpv.dto.BikeRentalDto;
import com.learn.mvc.vxpv.service.BikeRentalService;

public class BikeRentalController extends AbstractController{

	private BikeRentalService bikeRentalService;
	
	public void setBikeRentalService(BikeRentalService bikeRentalService) {
		this.bikeRentalService = bikeRentalService;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String fromDate = request.getParameter("formDate");
		String toDate = request.getParameter("toDate");
		String view = request.getParameter("view");
		String lvn = "bike-rental";
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dateFrom = dateFormat.parse(fromDate);
		Date toDateForm = dateFormat.parse(toDate);
		
		if(view != null) {
			if(view.equalsIgnoreCase("xls")) {
				lvn = "bike-rental-xls";
			}else if(view.equalsIgnoreCase("pdf")) {
				lvn = "bike-rental-pdf";
			}
		}
		List<BikeRentalDto> bikeRental = bikeRentalService.getBikeRentalDetail(dateFrom, toDateForm);
		ModelAndView mav = new ModelAndView();
		mav.addObject("bikeRental", bikeRental);
		mav.addObject("fromDateValue", dateFrom);
		mav.addObject("toDateValue", toDateForm);
		mav.setViewName(lvn);
		return mav;
	}

}
