package testng;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.ParametersBaseClass;

public class TestNGParameterPractice extends ParametersBaseClass{
	
	
	@BeforeClass
	@Parameters("browser")
	public void setup(String browser) {
		
		launchBrowser(browser);
		navigateTo("https://www.google.com");	
		
	}
	
	@Test
	public void verifyURL() {
		
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.google.com/");
	}
	
	@Test
	public void verifyPageTitle() {
		
		Assert.assertEquals(driver.getTitle(),"Google");
		
	}
	
	@AfterClass
	public void tearDown() {
		closeBrowser();
	}
}
