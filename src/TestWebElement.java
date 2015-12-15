import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class TestWebElement extends AbstractDriver{
	
	
			
	private int index = 0;
	private WebElement xpath = null;
	private boolean locInputVisible;
	
	@Test
	public void testWeb(){
		List<WebElement> ele = driver.findElements(By.xpath("//div[@class='twc-search-input-wrap']/input[@name='geolocation']"));
		WebElement locationIcon = driver.findElement(By.xpath("//div[@class='section newHeaderIcons']//li[4]"));
		List<WebElement> goButton = driver.findElements(By.xpath("//div[@class='cta geoloc-btn']/button"));
		System.out.println("======== Testing ==========");
		//click on location Icon
		checkVisibilityOfInputText(ele);
		System.out.println("Size : "+ele.size());
		if(!locInputVisible){
			locationIcon.click();
			System.out.println("Click on Location Icon");
		}
		
		//Enter location code
		if(locInputVisible){
			xpath.clear();
			xpath.sendKeys("10039");
			System.out.println("Inputted 10039");
		}
		
		//click on go button
		checkVisibilityOfInputText(goButton);
		xpath.click();
		System.out.println("Click on Go button");
		
		//click on location Icon
		checkVisibilityOfInputText(ele);
		if(!locInputVisible){
			locationIcon.click();
			System.out.println("Click on Location Icon");
		}
		
		//Enter location code
		if(locInputVisible){
			xpath.clear();
			xpath.sendKeys("32432");
			System.out.println("Inputted 32432");
		}
		
		//click on go button
		checkVisibilityOfInputText(goButton);
		xpath.click();
		System.out.println("Click on Go button");
		
	}
	
	public void checkVisibilityOfInputText(List<WebElement> ele){
		
		locInputVisible = false;
		System.out.println(ele.size());
		String xxx;
		
		for(WebElement element : ele){
			if(element.isDisplayed()){
				locInputVisible = true;
				xpath = element;
				xxx = element.toString();
				int ii = xxx.indexOf("xpath: ");
				System.out.println("index "+ii);
				xxx = xxx.substring(ii+7, xxx.length()-1);
				System.out.println("xxxp -> "+xxx);
			}
			System.out.println(">>>"+xpath);
		}
		
	}

}
