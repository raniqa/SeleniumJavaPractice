package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseClass;

public class SoftAssertPractice extends BaseClass{
	
	@BeforeClass
	public void setup() {

		launchBrowser();

	}

	@Test
	public void invalidCredentials() {

		navigateTo("https://www.saucedemo.com/");

		SoftAssert softassert = new SoftAssert();

		driver.findElement(By.id("user-name")).sendKeys("standard");
		driver.findElement(By.id("password")).sendKeys("secret");
		driver.findElement(By.id("login-button")).click();

		WebElement errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']"));

		// Assertion 1
		softassert.assertTrue(errorMessage.isDisplayed(), "Error message is not displayed");

		// Assertion 2
		softassert.assertEquals(errorMessage.getText(),
				"Epic sadface: Username and password do not match any user in this service",
				"Wrong error message displayed on login attempt with invalid credentials");
		
		// Assertion 3 (Intentionally Wrong to Show Use of Soft Assert and assertAll ) 
		softassert.assertTrue(driver.getTitle().contains("Amazon"), "Title verification failed");
		
		System.out.println("Invalid Login Credentials Test Completed");
		
		softassert.assertAll();

	}
	
	@Test
	public void usernameEmptyLogin() {

		SoftAssert softAssert = new SoftAssert();

		driver.get("https://www.saucedemo.com/");

		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();

		WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']"));

		// Assertion 1
		softAssert.assertTrue(errorMessage.isDisplayed(),
				"Error message is not displayed.");

		// Assertion 2 (Correct)
		softAssert.assertEquals(errorMessage.getText(),
				"Epic sadface: Username is required",
				"Incorrect error message displayed when username field is left blank.");

		// Assertion 3 (Intentionally Wrong to Show Use of Soft Assert and assertAll ) 
		softAssert.assertTrue(driver.getCurrentUrl().contains("inventory"),
				"User should not be navigated to Inventory page.");

		System.out.println("Empty Username Test Completed");

		softAssert.assertAll();
	}

	@AfterClass
	public void tearDown() {

		closeBrowser();

	}	


}
