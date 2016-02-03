package utility;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class CrossBrowserAbstractDriver {
	
	public static WebDriver driver = null;
	public static String facebook = "http://www.facebook.com";
	
	@BeforeClass(alwaysRun=true)
	@Parameters({"browser","flatform"})
	public void setUp(String browserName, String flatform){
		
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
		
		System.out.println("Flatform : "+flatform);
		
		driver.navigate().to(facebook);
	}
	
	@AfterClass(alwaysRun=true)
	public void tearDown() throws InterruptedException{
		
		Thread.sleep(2000);
		
		try {
			driver.close();
		} catch (Exception e) {
			
			driver = null;
		}
	}

	public CrossBrowserHomePage homePage(){
		return new CrossBrowserHomePage(driver);
	}
	
}
