package com.odoo.generic;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtilities {
	
	String filePath;
	
	public ExcelUtilities(String filePath)
	{
		this.filePath = filePath;
	}
	
	public String[] readData(String sheetName, String testCaseId)
	{
		String[] data = null;
		
		try
		{
			File file = new File(filePath);
			FileInputStream fileInputStream = new FileInputStream(file);
			Workbook workbook = WorkbookFactory.create(fileInputStream);
			
			Sheet sheet = workbook.getSheet(sheetName);
			
			int rowCount = sheet.getLastRowNum();
			
			for(int i = 1 ; i <= rowCount ; i++)
			{
				Row row = sheet.getRow(i);
				
				Cell cell = row.getCell(0);
				
				if(cell.getStringCellValue().equalsIgnoreCase(testCaseId))
				{
					int cellCount = row.getLastCellNum();
					data = new String[cellCount];
					
					for(int j = 0 ; j < cellCount ; j++)
					{
						cell = row.getCell(j);
						CellType cellType = cell.getCellType();
						
						switch(cellType)
						{
						case STRING:
							data[j] = cell.getStringCellValue();
							break;
							
						case NUMERIC:
							if(DateUtil.isCellDateFormatted(cell))
							{
								SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
								data[j] = simpleDateFormat.format(cell.getDateCellValue());
							}
							else
							{
								long longValue = (long)cell.getNumericCellValue();
								data[j] = "" + longValue;
							}
							break;
							
						case BOOLEAN:
							boolean booleanValue = cell.getBooleanCellValue();
							data[j] = "" + booleanValue;
							break;
						}
						
					}
					
					break;
				}
				
			}
			
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		
		return data;
	}
	
	public void writeData(String testCaseId, String[] data)
	{
		
	}
	
}
