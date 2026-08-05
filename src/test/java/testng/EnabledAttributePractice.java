package testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseClass;

public class EnabledAttributePractice extends BaseClass {

	WebDriverWait wait;

	@BeforeClass
	public void setUp() {

		launchBrowser();
		navigateTo("https://www.saucedemo.com/");

	}

	@Test
	public void login() {

		WebElement username = driver.findElement(By.id("user-name"));
		username.clear();
		username.sendKeys("standard_user");

		WebElement password = driver.findElement(By.id("password"));
		password.clear();
		password.sendKeys("secret_sauce");

		driver.findElement(By.id("login-button")).click();

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Assert.assertTrue(wait.until(ExpectedConditions.urlContains("inventory")));

	}

	@Test(enabled = false)
	public void searchItem() {
		System.out.println("Feature is under development");
	}

	@Test(dependsOnMethods = "login")
	public void logout() {
		if (!driver.findElements(By.id("react-burger-menu-btn")).isEmpty()) {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			WebElement menuBtn = driver.findElement(By.id("react-burger-menu-btn"));
			menuBtn.click();
			WebElement logoutLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));

			logoutLink.click();
		}
	}

	@AfterClass
	public void tearDown() {

		closeBrowser();
	}

}
