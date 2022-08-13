package com.learn.mvc.vxpv.view;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.learn.mvc.vxpv.dto.BikeRentalDto;
import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

public class BikeRentalPdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<BikeRentalDto> listBikeRentalDtos = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Table table = new Table(6);
		
		table.addCell("Rented Date");
		table.addCell("Customer Name");
		table.addCell("Bike Model Name");
		table.addCell("Rta Registation No");
		table.addCell("Duration");
		table.addCell("Rented Amount");
		
		listBikeRentalDtos = (List<BikeRentalDto>) model.get("bikeRental");
		
		for(BikeRentalDto dtos:listBikeRentalDtos) {
			table.addCell(sdf.format(dtos.getRentedDate()));
			table.addCell(dtos.getCustomerName());
			table.addCell(dtos.getBikeModelName());
			table.addCell(dtos.getRtaRegistationNo());
			table.addCell(String.valueOf(dtos.getDuration()));
			table.addCell(String.valueOf(dtos.getAmountPaid()));
		}
		
		document.add(table);
	}

	
}
