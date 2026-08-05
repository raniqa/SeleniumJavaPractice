package testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;

public class TestNGAnnotationsPractice extends BaseClass {
	
	
	@BeforeSuite
	public void setupTestSuite() {

		System.out.println("===== Test Suite Execution Started =====");

	}


	@BeforeTest
	public void setupTestEnvironment() {

		System.out.println("Setting up Test Environment");
		

	}


	@BeforeClass
	public void setupTestClass() {

		launchBrowser();

	}


	@BeforeMethod
	public void navigateToPage() {

		navigateTo("https://www.saucedemo.com/");

	}


	@Test 
	public void validLogin() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
	}
	@Test
	public void wrongLogin() {
		driver.findElement(By.id("user-name")).sendKeys("standard");
		driver.findElement(By.id("password")).sendKeys("secret");
		driver.findElement(By.id("login-button")).click();
		
	}


	@AfterMethod
	public void logout() {
		
		if (!driver.findElements(By.id("react-burger-menu-btn")).isEmpty()) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement menuBtn =  driver.findElement(By.id("react-burger-menu-btn"));
		menuBtn.click();   
		WebElement logoutLink = wait.until(
			    ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link"))
			);
		
		logoutLink.click();
		}	

	}


	@AfterClass
	public void cleanUpTestClass() {

		closeBrowser();

	}


	@AfterTest
	public void completeTestExecution() {

		System.out.println("Test Execution Completed");

	}


	@AfterSuite
	public void generateTestReport() {

		System.out.println("===== Test Suite Execution Finished =====");

	}

}
