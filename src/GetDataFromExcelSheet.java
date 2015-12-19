import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetDataFromExcelSheet {
	/*
	 * This program retrieve data from excel sheet and print the value
	 * on the Console
	 * 
	 * Library files need to add:
	 * => commons-codec-1.9.jar
	 * => poi-3.13-20150929.jar
	 * => poi-ooxml-3.13-20150929.jar
	 * => poi-ooxml-schemas-3.13-20150929.jar
	 * => xmlbeans-2.6.0.jar
	 * 
	 * OR
	 * For maven project add the following dependency instead of jars
	 * 
	 * <dependency>
	 * <groupId>org.apache.poi</groupId>
	 * <artifactId>poi</artifactId>
	 * <version>3.13</version>
	 * </dependency>
	 *
	 * <dependency>
	 * <groupId>org.apache.poi</groupId>
	 * <artifactId>poi-ooxml</artifactId>
	 * <version>3.13</version>
	 * </dependency>
	 * 
	 */
	
	public static void main(String[] args) {

	//Declare String array to hold excel data
	String[][] excelData = null;
	
	//Excel file path
	String fileName = new File("").getAbsoluteFile()+"/loginInfo.xlsx";

	try {
		//Declare and initialize FileInputStream with file path
		FileInputStream file = new FileInputStream(fileName);
		
		//Create object of workbook -- <XSSFWorkbook for xlsx file>
		Workbook workbook = new XSSFWorkbook(file);
		
		//Get sheet 
		Sheet sheet = workbook.getSheet("Sheet1");
		
		//Get no Of rows and columns
		int noOfRows = sheet.getLastRowNum();
		int noOfCols = sheet.getRow(noOfRows).getLastCellNum();
		
		//initialize String array
		excelData = new String[noOfRows][noOfCols];
		
		//Get cell value from excel and store it in the array
		//Here i (row) starts from 1 because of excel sheet contain first
		//row header (label-username and password)
		for(int i=1; i<=noOfRows; i++){
			for(int j=0; j<noOfCols; j++){
				excelData[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		
		//Length of the array
		int excelDataSize = excelData.length;
		
		System.out.println("====== Excel Sheet Data =======");
		System.out.println("User Name ------------ Password");
		
		//Print excel data into console
		for(int i=0; i<excelDataSize; i++){
			for(int j=0; j<excelDataSize; j++){
				System.out.print(excelData[i][j]+"\t\t\t");
			}
			System.out.println();
		}
		
	} catch (FileNotFoundException e) {
		System.out.println("File not found");
	} catch (IOException e) {
		System.out.println("IO Exception");
	}
	}
}
