package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public static XSSFWorkbook wb;//wb object it will get access to work book
	public static XSSFSheet sh;//sh object it will get access to sheet
	public static FileInputStream f;//f object it will get access to path

	//to get string value
	//int i is row
	//int j is column
	public static String getString(int i,int j,String filepath,String sheet) throws IOException {
		f=new FileInputStream(System.getProperty("user.dir")+filepath);//+is concatenate to get files from our path
		wb=new XSSFWorkbook(f);
		sh=wb.getSheet(sheet);
		Row r=sh.getRow(i);
		Cell c=r.getCell(j);
		return c.getStringCellValue();
	}	
  public static String getNumeric(int i,int j,String filepath,String sheet) throws IOException {
			f=new FileInputStream(System.getProperty("user.dir")+filepath);//+is concatenate to get files from our path
			wb=new XSSFWorkbook(f);
			sh=wb.getSheet(sheet);
			Row r=sh.getRow(i);
			Cell c=r.getCell(j);
			int value= (int)c.getNumericCellValue();
			return String.valueOf(value);
}
  public static ArrayList<String> getString(String filepath,String sheet,int rowno) throws IOException 
  {
	  f=new FileInputStream(System.getProperty("user.dir")+filepath);//+is concatenate to get files from our path
	  wb=new XSSFWorkbook(f);
	  sh=wb.getSheet(sheet);
	  ArrayList<String> excelRows=new ArrayList<String>();
	  Row r=sh.getRow(rowno);
	  int cellcount=r.getLastCellNum();
	  for(int j=0;j<cellcount; j++) {
		  excelRows.add(r.getCell(j).getStringCellValue());
	  }
	  return excelRows;
  }
}