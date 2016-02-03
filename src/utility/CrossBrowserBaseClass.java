package utility;

import org.openqa.selenium.By;

public class CrossBrowserBaseClass extends CrossBrowserAbstractDriver{

	private String xpath = "xpath";
	
	public String getXpath(){
		return xpath;
	}
	
	public void getPageTitle(){
		String pageTitle = driver.getTitle();
		System.out.println("Page Title : "+pageTitle);
	}
	
	public void getTextFromPage(String locator, String path){
		
		
		if(locator.equalsIgnoreCase("xpath")){
			
			String pageText = driver.findElement(By.xpath(path)).getText();
			System.out.println("Some Text : "+pageText);
			
		}
	}
	
}
