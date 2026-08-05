package testng;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseClass;

public class TimeoutAttributePractice extends BaseClass{
	
	@BeforeClass
	public void setUp() {

		launchBrowser();
		navigateTo("https://www.saucedemo.com/");

	}
	
	@Test(timeOut = 5000)
	public void userLogin() throws InterruptedException {

		driver.findElement(By.id("user-name")).sendKeys("standard_user");

		Thread.sleep(6000); // Simulating a slow response to show how timeOut attribute works

		driver.findElement(By.id("password")).sendKeys("secret_sauce");

		driver.findElement(By.id("login-button")).click();
	}

	@AfterClass
	public void tearDown() {
		
		closeBrowser();
	}
}
