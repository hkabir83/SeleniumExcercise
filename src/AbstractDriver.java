import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class AbstractDriver {
	
	public static WebDriver driver = null;
	private String twc = "http://www.timewarnercable.com";
	private String google = "http://www.google.com";
	private String facebook = "http://www.facebook.com";
	private String w3schoolAlert = "http://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm";
	private String fileUploadUrl ="www.w3schools.com/jsref/tryit.asp?filename=tryjsref_fileupload_get";
	
	@BeforeSuite
	public void setUP(){
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to(twc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	
	@AfterSuite
	public void tearDown(){
		//driver.close();
	}

}
