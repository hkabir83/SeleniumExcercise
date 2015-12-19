import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DataProviderExampleUsingExcelSheet extends AbstractDriver{
	/*
	 * www.facebook.com
	 * Read some instructions written in GetDataFromExcelSheet.java
	 */
	
	@Test(dataProvider = "getExcelData")
	public void dataFromExcelSheet(String firstname, String lastname) throws InterruptedException{
		
		WebElement firstName = driver.findElement(By.xpath("//input[@id='u_0_b']"));
		WebElement lastName = driver.findElement(By.xpath("//input[@id='u_0_d']"));
		
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		
		System.out.println("You entered First name : "+firstname+" and Last Name : "+lastname);
		
		String firstNameValue = firstName.getAttribute("value");
		String lastNameValue = lastName.getAttribute("value");
		
		System.out.println(firstNameValue+"<==>"+firstname);
		System.out.println(lastNameValue+"<==>"+lastname);
		
		Thread.sleep(8000);
		
		firstName.clear();
		lastName.clear();
	}
	
	@DataProvider
	public Object[][] getExcelData(){
		
		Object[][] data = getDataFromExcelSheet();
		
		return data;
		
	}
	
	public String[][] getDataFromExcelSheet() {

		String[][] excelData = null;
		//file name with path
		String fileName = new File("").getAbsoluteFile() + "/loginInfo.xlsx";

		try {

			FileInputStream file = new FileInputStream(fileName);
			Workbook workbook = new XSSFWorkbook(file);
			Sheet sheet = workbook.getSheet("Sheet1");

			int noOfRows = sheet.getLastRowNum();
			int noOfCols = sheet.getRow(noOfRows).getLastCellNum();
			//Initialize array
			excelData = new String[noOfRows][noOfCols];

			//Get cell value from excel sheet and store it into excelData array
			for (int i = 1; i <= noOfRows; i++) {
				for (int j = 0; j < noOfCols; j++) {
					excelData[i - 1][j] = sheet.getRow(i).getCell(j)
							.getStringCellValue();
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("IO Exception");
		}

		return excelData;
	}
		

}
