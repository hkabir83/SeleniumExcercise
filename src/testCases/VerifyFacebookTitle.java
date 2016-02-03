package testCases;

import org.testng.annotations.Test;

import utility.CrossBrowserAbstractDriver;

public class VerifyFacebookTitle extends CrossBrowserAbstractDriver{

	@Test(description = "Verify Facebook Title and some Text")
	public void verifyFacebook(){
		
		homePage().getSiteTitle();
		homePage().getSomeText();
		
	}
	
}
