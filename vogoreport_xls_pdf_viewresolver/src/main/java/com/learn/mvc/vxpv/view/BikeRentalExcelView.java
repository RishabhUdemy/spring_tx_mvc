package com.learn.mvc.vxpv.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.learn.mvc.vxpv.dto.BikeRentalDto;

public class BikeRentalExcelView extends AbstractXlsView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Sheet sheet = null;
		BikeRentalDto bikeRentalDto = null;
		List<BikeRentalDto> listBikeRentalDtos = null;
		Row row = null;
		Row headerRow = null;
		Cell cell1 = null;
		Cell cell2 = null;
		Cell cell3 = null;
		Cell cell4 = null;
		Cell cell5 = null;
		Cell cell6 = null;

		listBikeRentalDtos = (List<BikeRentalDto>) model.get("bikeRental");
		sheet = workbook.createSheet("bike-rental");
		headerRow = sheet.createRow(0);
		
		cell1 = headerRow.createCell(0);
		cell2 = headerRow.createCell(1);
		cell3 = headerRow.createCell(2);
		cell4 = headerRow.createCell(3);
		cell5 = headerRow.createCell(4);
		cell6 = headerRow.createCell(5);

		cell1.setCellValue("Rented Date");
		cell2.setCellValue("Customer Name");
		cell3.setCellValue("Bike Model Name");
		cell4.setCellValue("Rta Registation No");
		cell5.setCellValue("Duration");
		cell6.setCellValue("Rented Amount");

		for(int i = 0;i<listBikeRentalDtos.size();i++) {
			bikeRentalDto = listBikeRentalDtos.get(i);
			row = sheet.createRow(i+1);
			
			cell1 = row.createCell(0);
			cell2 = row.createCell(1);
			cell3 = row.createCell(2);
			cell4 = row.createCell(3);
			cell5 = row.createCell(4);
			cell6 = row.createCell(5);
			
			cell1.setCellValue(bikeRentalDto.getRentedDate());
			cell2.setCellValue(bikeRentalDto.getCustomerName());
			cell3.setCellValue(bikeRentalDto.getBikeModelName());
			cell4.setCellValue(bikeRentalDto.getRtaRegistationNo());
			cell5.setCellValue(bikeRentalDto.getDuration());
			cell6.setCellValue(bikeRentalDto.getAmountPaid());

		}
	}

}





