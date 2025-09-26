package com.comcast.crm.utility;

import java.io.FileInputStream;
import java.io.IOException;



import org.apache.poi.EncryptedDocumentException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelUtility {
	
	public String getDataFromExcel(String Sheetname,int rownum,int celnum) throws EncryptedDocumentException, IOException {
	ExcelUtility  elib= new ExcelUtility();
	
	FileInputStream fis = new FileInputStream("./testdata/Vorg.xlsx");
	Workbook wb = WorkbookFactory.create(fis); 
	Sheet sh= wb.getSheet("Sheetname") ;
	/*
	 * Row row = sh.getRow(rownum);
	 * 
	 * Cell cel = row.getCell(celnum);
	 */
	return null;  
	
}}
                                                                                                       