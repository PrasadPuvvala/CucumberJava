package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel 
{

	public String[][] readExcel() throws IOException 
	
	{
		// TODO Auto-generated constructor stub
		
		//Path of the excel file
		FileInputStream fs = new FileInputStream("E:\\SeleniumAutomation\\CucumberJava\\src\\test\\resources\\DemoFile.xlsx");
		//Creating a workbook
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		String str[][] = new String[sheet.getPhysicalNumberOfRows()][sheet.getRow(0).getLastCellNum()];

		
		for(int i=0;i<sheet.getPhysicalNumberOfRows();i++)
		{
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
			{
				
				str[i][j]= (sheet.getRow(i).getCell(j)).toString();
				
				
				System.out.println("Row"+i+"Column"+j+"is"+str[i][j]);
				
//				Row row1 = sheet.getRow(1);
//				Cell cell1 = row1.getCell(1);
//				System.out.println(sheet.getRow(0).getCell(1));
//				Row row2 = sheet.getRow(1);
//				Cell cell2 = row2.getCell(1);
//				System.out.println(sheet.getRow(1).getCell(0));
//				Row row3 = sheet.getRow(1);
//				Cell cell3 = row3.getCell(1);
//				System.out.println(sheet.getRow(1).getCell(1));
				
			}
			
			
			
		}
		
		return str;
		
		//String cellval = cell.getStringCellValue();
		//System.out.println(cellval);
		
		
	}

}
