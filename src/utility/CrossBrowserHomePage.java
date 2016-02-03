package utility;

import org.openqa.selenium.WebDriver;

public class CrossBrowserHomePage extends CrossBrowserBaseClass{
	
	public static WebDriver driver = null;
	
	public CrossBrowserHomePage(WebDriver driver) {
		this.driver = driver;
	}

	private String someText = "//div[@class='_7d _6_ _76']/h2";
	
	public void getSiteTitle(){
		getPageTitle();
	}
	
	public void getSomeText(){
		getTextFromPage(getXpath(), someText);
	}

}
