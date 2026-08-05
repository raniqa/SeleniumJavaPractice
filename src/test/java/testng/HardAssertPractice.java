package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseClass;

public class HardAssertPractice extends BaseClass{
	
	@BeforeClass
	public void launchApplication() {

		launchBrowser();
		navigateTo("https://www.saucedemo.com/");

	}

	@Test
	public void validLogin() {

		// Enter username
		driver.findElement(By.id("user-name")).sendKeys("standard_user");

		// Enter password
		driver.findElement(By.id("password")).sendKeys("secret_sauce");

		// Click Login
		driver.findElement(By.id("login-button")).click();

		// Verify current URL
		Assert.assertEquals(driver.getCurrentUrl(),
				"https://www.saucedemo.com/inventory.html",
				"URL verification failed.");

		// Verify page title
		Assert.assertEquals(driver.getTitle(),
				"Swag Labs",
				"Page title verification failed.");

		// Verify Products heading is displayed
		WebElement productsHeading = driver.findElement(By.className("title"));

		Assert.assertTrue(productsHeading.isDisplayed(),
				"Products heading is not displayed.");

		// Verify heading text
		Assert.assertEquals(productsHeading.getText(),
				"Products",
				"Heading text verification failed.");

		System.out.println("All hard assertions passed.");

	}

	@AfterClass
	public void tearDown() {

		closeBrowser();

	}

}
