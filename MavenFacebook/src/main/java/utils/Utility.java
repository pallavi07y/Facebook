package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	public static void captureScreenshot(WebDriver driver, int testId ) throws IOException
	{ 
//		DateTimeFormatter dtf= DateTimeFormatter.ofPattern("dd.MM.yyyy HH.mm.ss");
//		LocalDateTime now= LocalDateTime.now();
//		String date1=dtf.format(now);
		DateFormat dateformat= new SimpleDateFormat("dd.MM.yyyy HH.mm.ss");
		Date date= new Date();
		String date1=dateformat.format(date);
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest= new File("F:\\velocity\\screenshot\\Test "+testId+" "+ date1+".jpg");
		FileHandler.copy(src, dest);
	}
	
	public static String fetchDataFromExcelSheet(String sheetname, int rowno, int cellno) throws IOException
	{
	String path= "F:\\velocity\\demo.xlsx";
	FileInputStream file= new FileInputStream(path);
	String data;
	//data=WorkbookFactory.create(file).getSheet(sheetname).getRow(rowno).getCell(cellno).getStringCellValue();
	Workbook wb= WorkbookFactory.create(file);
	Sheet sheet= wb.getSheet(sheetname); // sheet name of excel file
	Row row=sheet.getRow(rowno);
	Cell cell=row.getCell(cellno);
	try{
		data=cell.getStringCellValue();	
		System.out.println(data);
		return data;
	}
	catch(Exception e)
	{
		long data1;
		double d= cell.getNumericCellValue(); 
		data1=(long)d;
		data = String.valueOf(data1);
		System.out.println(data);
		return data;
	}
	}
	

}
