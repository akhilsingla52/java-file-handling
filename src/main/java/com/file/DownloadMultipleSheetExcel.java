package com.file;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class DownloadMultipleSheetExcel {
	
	public static void main(String[] args) {
		try {
			createMultipleSheet();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void createMultipleSheet() throws Exception {
		Workbook workbook = new HSSFWorkbook();

		Sheet sheet1 = workbook.createSheet("First Sheet");
		Row excelRow = sheet1.createRow(0);
        excelRow.createCell(0).setCellValue("1");
        excelRow.createCell(1).setCellValue("2");
        excelRow.createCell(2).setCellValue("3");
		
		Sheet sheet2 = workbook.createSheet("Second Sheet");
		excelRow = sheet2.createRow(0);
        excelRow.createCell(0).setCellValue("4");
        excelRow.createCell(1).setCellValue("5");
        excelRow.createCell(2).setCellValue("6");
		
		Sheet sheet3 = workbook.createSheet("Third Sheet");
		excelRow = sheet3.createRow(0);
        excelRow.createCell(0).setCellValue("7");
        excelRow.createCell(1).setCellValue("8");
        excelRow.createCell(2).setCellValue("9");
        
        File outFolder = new File("./excel");
		if (!outFolder.exists())
			outFolder.mkdirs();
        FileOutputStream out = new FileOutputStream(new File("./excel/new.xls"));
		workbook.write(out);
		workbook.close();
		out.close();
		System.out.println("Excel written successfully..");
	}
}

