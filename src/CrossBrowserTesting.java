import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class CrossBrowserTesting {
	
	WebDriver driver;
	String facebook = "http://facebook.com";
	
	@Test(description = "Verify Title")
	@Parameters("browser")
	public void verifyFacebookTitle(String browserName){
		
		if(browserName.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", new File("chromedriver32").getAbsolutePath()+"/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.ie.driver", new File("IEDriverServer_x64").getAbsolutePath()+"/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		driver.navigate().to(facebook);
		System.out.println(driver.getTitle());
		driver.close();
	}

}
