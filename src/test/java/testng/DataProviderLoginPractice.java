package testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;

public class DataProviderLoginPractice extends BaseClass {
	
		WebDriverWait wait;
	
	@BeforeClass
	public void setUp() {
		
		launchBrowser();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
	
	@Test(dataProvider="logindata")
	public void login(String userName, String password) {
		
		navigateTo("https://practicetestautomation.com/practice-test-login/");
		
		WebElement username = driver.findElement(By.id("username"));
    	username.clear();
    	username.sendKeys(userName);
    	
		WebElement pass = driver.findElement(By.id("password"));
		pass.clear();
		pass.sendKeys(password);
		driver.findElement(By.id("submit")).click();
		
		if(driver.getCurrentUrl().contains("logged-in-successfully")) {			
			
			WebElement logoutBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Log out']")));
			logoutBtn.click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));

			System.out.println(driver.getCurrentUrl());
		
		}
		
		
		else {
			
			WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='error']")));
			Assert.assertTrue(errorMessage.getText().contains("invalid"));
		
		}
		
	}
	
	@AfterClass
	public void tearDown() {
		
		closeBrowser();
	}
	
	@DataProvider(name="logindata")
	public Object[][] loginData(){
		
		Object[][] data = {
				{"student","Password123"},
				{"student","Password"},
    			{"","Password123"},
    			{"sudent",""},
    			{"",""},
		};
		return data;
	}
	

}
