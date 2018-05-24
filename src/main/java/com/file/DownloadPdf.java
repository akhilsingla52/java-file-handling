package com.file;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class DownloadPdf {

	/**
	 * Download PDF File
	 * @param s
	 * @throws Exception
	 */
	public static void main(String... s) throws Exception {
		ByteArrayOutputStream baos = writePDF();
		 File outFolder = new File("./pdf");
		if (!outFolder.exists())
			outFolder.mkdirs();
        OutputStream out = new FileOutputStream(new File("./pdf/new.pdf"));
        baos.writeTo(out);
		out.close();
		System.out.println("PDF written successfully..");
	}
	
	/**
	 * Write Pdf file
	 * @return
	 */
	public  static ByteArrayOutputStream writePDF() {
		Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        
        try {		    
		    PdfWriter.getInstance(document, out);
		    
		    document.open();
		    document.add(createTable());
		    document.close();
		    
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		 
        return out;
	} 
	
	/**
	 * Create Table
	 * @return
	 * @throws Exception
	 */
	public  static PdfPTable createTable() throws Exception {
		PdfPTable table = new PdfPTable(3);
		table.setWidthPercentage(60);
		table.setWidths(new int[]{1, 3, 3});
		
		Font headFont = new Font(FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.WHITE);
		
		PdfPCell hcell;
		hcell = new PdfPCell(new Phrase("Id", headFont));
		headerCellStyle(hcell);
		table.addCell(hcell);
		
		hcell = new PdfPCell(new Phrase("Name", headFont));
		headerCellStyle(hcell);
		table.addCell(hcell);
		
		hcell = new PdfPCell(new Phrase("Population", headFont));
		headerCellStyle(hcell);
	    table.addCell(hcell);        	

	   /* for (City city : cities) {
             PdfPCell cell;

             cell = new PdfPCell(new Phrase(city.getId().toString()));
             valueCellStyle(cell);
             table.addCell(cell);

             cell = new PdfPCell(new Phrase(city.getName()));
             valueCellStyle(cell);
             table.addCell(cell);

             cell = new PdfPCell(new Phrase(String.valueOf(city.getPopulation())));
             valueCellStyle(cell);
             table.addCell(cell);
         }*/
	    
	    PdfPCell cell;

        cell = new PdfPCell(new Phrase("1"));
        valueCellStyle(cell);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("HYD"));
        valueCellStyle(cell);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("1000"));
        valueCellStyle(cell);
        table.addCell(cell);
        
        return table;
	}

	/**
	 * Header Style
	 * @param cell
	 */
	public static void headerCellStyle(PdfPCell cell){
		// alignment
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		// padding
		cell.setPaddingTop(0f);
		cell.setPaddingBottom(7f);
		// background color
		cell.setBackgroundColor(BaseColor.CYAN);
		// border
		cell.setBorder(0);
		cell.setBorderWidthBottom(2f);		 
	}
	
	/**
	 * Column Style
	 * @param cell
	 */
    public static void valueCellStyle(PdfPCell cell){
	    // alignment
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		 
        // padding
        cell.setPaddingTop(0f);
        cell.setPaddingBottom(5f);
 
        // border
        cell.setBorder(0);
        cell.setBorderWidthBottom(0.5f);
 
        // height
        cell.setMinimumHeight(18f);
    }      
}