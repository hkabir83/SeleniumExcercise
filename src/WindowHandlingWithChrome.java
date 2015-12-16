import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class WindowHandlingWithChrome extends AbstractDriver{
	
	@Test(description = "Window handles in Chrome browser")
	public void WindowHandlingInChrome() throws InterruptedException{
		// Website url = www.timewarnercable.com
		String searchIcon = "//div[@class='section newHeaderIcons']//li[5]//a";
		String clickOnEmail = "//div[@class='section newHeaderIcons']/descendant::li[3]//a";
		String enterEmailInputField = "//table[@class='mainPanelInBodyTableFormatting']/descendant::td[@class='mainPanelComposeMailPadding3'][1]/input";
		String emailLogin = "//input[@id='loginButton']";
		String enterEmailPassInputField = "//table[@class='mainPanelInBodyTableFormatting']/descendant::td[@class='mainPanelComposeMailPadding3'][2]/input";
		driver.findElement(By.xpath(clickOnEmail)).click();
		
		Thread.sleep(5000);
		//We have to wait for a few seconds to get all the windows open in chrome browser
		String parent = driver.getWindowHandle();
		Set<String> listOfWindow = driver.getWindowHandles();
		System.out.println("List of Windows : "+listOfWindow.size());
		
		//Switch to the child window
		for(String child : listOfWindow ){
			if(!child.equals(parent)){
				driver.switchTo().window(child);
				break;
			}
		}
		
		driver.findElement(By.xpath(enterEmailInputField)).sendKeys("technosoft@gmail.com");
		driver.findElement(By.xpath(enterEmailPassInputField)).sendKeys("test1234");
		driver.findElement(By.xpath(emailLogin)).click();
		
		Thread.sleep(10000);
		//Closing the child window
		for(String child : listOfWindow ){
			if(!child.equals(parent)){
				driver.switchTo().window(child);
				driver.close();
			}
		}
		// Switch to the parent window
		driver.switchTo().window(parent);
		driver.findElement(By.xpath(searchIcon)).click();
	}

}
