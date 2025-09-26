package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String  getDataFromExcel(String sheetname,int rownum, int celnum) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./testdata/Vdata2.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetname).getRow(rownum).getCell(celnum).toString();
		wb.close();
		return data;
		 
	}

	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./testdata/Vdata2.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowcount =wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return rowcount;
		}
	
	public void setDatainExcel(String SheetName, int rowNum, int CelNum, String data) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./testdata/Vdata2.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		wb.getSheet(SheetName).getRow(rowNum).createCell(CelNum);
		
		
		FileOutputStream fos = new FileOutputStream("./testdata/Vdata2.xlsx");
		wb.write(fos);
		wb.close();
		
			
	}
	
	
	
	
}
