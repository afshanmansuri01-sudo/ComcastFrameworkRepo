package automationPractice.framework.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromExcel(String SheetName,int rownum,int celnum) throws EncryptedDocumentException, IOException {
	FileInputStream fis = new FileInputStream("./TestData/VtTestData.xlsx");
	 Workbook wb=WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(SheetName);
	String data = sh.getRow(rownum).getCell(celnum).toString();
	
	
	 return data;

}
	@SuppressWarnings("deprecation")
	public void writeDataBackIntoExcel(String SheetName,int rownum,int celnum,String Data) throws EncryptedDocumentException, IOException
{
		FileInputStream fis = new FileInputStream("./TestData/vtTestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Cell cel = wb.getSheet(SheetName).createRow(rownum).createCell(celnum);

        cel.setCellType(CellType.STRING);
        cel.setCellValue(Data);
        
        FileOutputStream fos= new FileOutputStream("./TestData/VtTestData.xlsx");
        wb.write(fos);
        wb.close();
        }
	
	public int getRowCount(String Sheet,int roenum,int celnum) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("././TestData/VtTestData.xlsx");
		 Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(Sheet);
		int rowcount = sh.getLastRowNum();
		
		return  rowcount; 
	}
	






}
