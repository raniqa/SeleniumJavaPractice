package testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;

public class AlwaysRunAttributePractice extends BaseClass {

	WebDriverWait wait;

	@BeforeMethod
	public void setUp() {

		launchBrowser();
		navigateTo("https://www.saucedemo.com/");

	}

	@Test(invocationCount = 3)
	public void login() {

		WebElement username = driver.findElement(By.id("user-name"));
		username.clear();
		username.sendKeys("standard_user");

		WebElement password = driver.findElement(By.id("password"));
		password.clear();
		password.sendKeys("secret_sauce");

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.findElement(By.id("login-button")).click();

		Assert.assertTrue(wait.until(ExpectedConditions.urlContains("inventory")),
				"Login failed - User was not navigated to inventory page");

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {

		closeBrowser();

	}
}
