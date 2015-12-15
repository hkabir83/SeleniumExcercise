import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class AllSeleniumTest extends AbstractDriver{
	
	
	@Test(enabled = true)
	public void googleSearch(){
		WebElement searchText = driver.findElement(By.xpath("//div[@id='sb_ifc0']"));
		searchText.sendKeys("test");
	}
	
	@Test(enabled = false)
	public void alertTest(){
		
	//Swith to iframe
		driver.switchTo().frame(driver.findElement(By.id("iframeResult")));
	//Click on Try it button
		driver.findElement(By.xpath("html/body/button")).click();
		System.out.println("Try it button clicked");
		
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.dismiss();
		System.out.println("Cancel button clicked");
		
		//Click on Try it button
		driver.findElement(By.xpath("html/body/button")).click();
		System.out.println("Try it button clicked");
		alert.accept();
		System.out.println("Ok button clicked");
		
		
	}
	
	@Test(enabled = false)
	public void fileUploadTest(){
		
		driver.switchTo().frame(driver.findElement(By.id("iframeResult")));
		//xpath for browse
		driver.findElement(By.xpath("//*[@id='myFile']")).sendKeys("C:\\Users\\hkabir\\Desktop\\testpic.jpg");
	}
	
	@Test(enabled = false)
	public void mouseAndKeyboardAction(){
		
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		WebElement firstname = driver.findElement(By.xpath("//input[@id='u_0_b']"));
		WebElement lastname = driver.findElement(By.xpath("//input[@id='u_0_d']"));
		String selectAll = Keys.chord(Keys.CONTROL,"a");
		String copy = Keys.chord(Keys.CONTROL,"c");
		String paste = Keys.chord(Keys.CONTROL,"v");
		
		Actions build = new Actions(driver);
		Action action = build
				.moveToElement(email)
				.keyDown(Keys.SHIFT)
				.sendKeys(email,"hello")
				.keyUp(Keys.SHIFT)
				.sendKeys(Keys.chord(Keys.CONTROL,"a"))
				.contextClick()
				.sendKeys(Keys.ARROW_DOWN)
				.sendKeys(Keys.ARROW_DOWN)
				.sendKeys(Keys.RETURN)
				.moveToElement(firstname)
				.contextClick(firstname)
				.sendKeys(Keys.ARROW_DOWN)
				.sendKeys(Keys.ARROW_DOWN)
				.sendKeys(Keys.ARROW_DOWN)
				.sendKeys(Keys.ARROW_DOWN)
				.sendKeys(Keys.RETURN)
				.sendKeys(selectAll)
				.sendKeys(copy)
				.moveToElement(lastname).click()
				.sendKeys(paste)
				.build();
		action.perform();
		
		
		
	}
	
	@Test(enabled = false)
	public void selectOptionTest(){
		//facebook month
		Select select = new Select(driver.findElement(By.xpath("//*[@id='month']")));
		List<WebElement> options = select.getOptions();
		for(WebElement option : options)
		System.out.println(option.getText());
	}

}
