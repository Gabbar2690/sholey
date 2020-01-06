package com.CRMVtiger.genericLib;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {
	public String getPropertyKeyValue(String key) throws IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/Commondata.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String value=pobj.getProperty(key);
		return value;
		}
	/**
	 * It is used to read the data from testscriptdata.xlsx file based on user arguments
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 * @throws Throwable 
	 */
		public String getExcelData(String sheetName,int rowNum,int cellNum) throws Throwable {
			FileInputStream fis=new FileInputStream("./src/test/resources/TestScriptData.xlsx");
			Workbook wb=WorkbookFactory.create(fis);
			Sheet sh=wb.getSheet(sheetName);
			Row row=sh.getRow(rowNum);
			String data=row.getCell(cellNum).getStringCellValue();
			wb.close();
			return data;
			
		}
		/*public void setExcelData(String sheetName,int rowNum,int cellNum,String data) throws Throwable {
			FileInputStream fis=new FileInputStream("./Data/TestScriptData.xlsx");
			Workbook wb=WorkbookFactory.create(fis);
			Sheet sh=wb.getSheet(sheetName);
			Row row=sh.getRow(rowNum);
			Cell cell=row.createCell(cellNum);
			cell.setCellValue(data);
			FileOutputStream fos=new FileOutputStream("./Data/TestScriptData.xlsx");
			wb.write(fos);
			wb.close();
		}*/
		
	}



