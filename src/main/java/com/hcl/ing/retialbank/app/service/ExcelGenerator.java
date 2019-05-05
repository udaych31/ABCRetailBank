package com.hcl.ing.retialbank.app.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.hcl.ing.retialbank.app.dto.TransactionDto;

public class ExcelGenerator {
	public static ByteArrayInputStream customersToExcel(List<TransactionDto> transasctions) throws IOException {
	    String[] COLUMNs = {"Transaction Id", "To account no", "transaction type","closing balance"};
	    try(
	        Workbook workbook = new XSSFWorkbook();
	        ByteArrayOutputStream out = new ByteArrayOutputStream();
	    ){
	      CreationHelper createHelper = workbook.getCreationHelper();
	   
	      org.apache.poi.ss.usermodel.Sheet sheet =  workbook.createSheet("transactions");
	   
	      Font headerFont = workbook.createFont();
	      headerFont.setBold(true);
	      headerFont.setColor(IndexedColors.BLUE.getIndex());
	   
	      CellStyle headerCellStyle = workbook.createCellStyle();
	      headerCellStyle.setFont(headerFont);
	   
	      // Row for Header
	      Row headerRow = ((org.apache.poi.ss.usermodel.Sheet) sheet).createRow(0);
	   
	      // Header
	      for (int col = 0; col < COLUMNs.length; col++) {
	        Cell cell = headerRow.createCell(col);
	        cell.setCellValue(COLUMNs[col]);
	        cell.setCellStyle(headerCellStyle);
	      }
	   
	      // CellStyle for Age
	      CellStyle ageCellStyle = workbook.createCellStyle();
	      ageCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("#"));
	   
	      int rowIdx = 1;
	      for (TransactionDto trans : transasctions) {
	        Row row = ((org.apache.poi.ss.usermodel.Sheet) sheet).createRow(rowIdx++);
	   
	        row.createCell(0).setCellValue(trans.getTransactionId());
	        //row.createCell(1).setCellValue("dsa");
	        row.createCell(2).setCellValue(trans.getAccountNumber());
	        row.createCell(3).setCellValue(trans.getTransactionType());
	        row.createCell(4).setCellValue(trans.getClosingBalance());
	   
	      }
	   
	      workbook.write(out);
	      return new ByteArrayInputStream(out.toByteArray());
	    }
	  }
}
