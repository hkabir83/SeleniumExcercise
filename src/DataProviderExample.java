import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class DataProviderExample extends AbstractDriver{
	
	@Test(enabled = false)
	@Parameters({"author","searchKey"})
	public void testParameterWithXml(@Optional("hkabir") String author,@Optional("UK") String searchKey) throws InterruptedException{
		
		//WebElement searchText = driver.findElement(By.xpath("//div[@id='sb_ifc0']"));
		WebElement firstname = driver.findElement(By.xpath("//input[@id='u_0_b']"));
		
		firstname.sendKeys(searchKey);
		
		System.out.println("Welcome -> "+author+" Your search key is "+searchKey);
		Thread.sleep(5000);
		
		String testValue = firstname.getAttribute("value");
		System.out.println(testValue+"::::"+searchKey);
		
		Assert.assertTrue(testValue.equalsIgnoreCase(searchKey));
	
	}
	
	@Test(dataProvider = "dataProviderInside" , enabled = false)
	public void dataProviderInsideClass(String firstname, String lastname) throws InterruptedException{
		
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
	
	@Test(dataProvider = "getDataFromOutside" ,dataProviderClass = DataproviderClass.class , enabled = true)
	public void dataProviderOutsideClass(String firstname, String lastname) throws InterruptedException{
		
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
	
	@DataProvider(name="dataProviderInside")
	public Object[][] getData(){
		Object[][] data = new Object[2][2];
		
		data[0][0] = "Humayun";
		data[0][1] = "Kabir";
		
		data[1][0] = "Tasnuba";
		data[1][1] = "Kabir";
		
		return data;
		
	}

}
