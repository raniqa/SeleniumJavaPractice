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

public class DescriptionAttributePractice extends BaseClass{
	
	@BeforeClass
	public void setUp() {

		launchBrowser();
		navigateTo("https://rahulshettyacademy.com/seleniumPractise/");

	}
	
	@Test (description ="Searching for an item by entering the keyword in the searchbox")
	public void searchItem() {
		
		String itemNeeded = "beetroot";
		
		WebElement searchField = driver.findElement(By.cssSelector("input.search-keyword"));
		
		searchField.sendKeys(itemNeeded);
		
		WebElement searchButton = driver.findElement(By.cssSelector("button.search-button"));
		
		searchButton.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement productCard =
		wait.until(ExpectedConditions.visibilityOfElementLocated(
		By.xpath("//div[@class='products']/div")));
		
		String productName = productCard.findElement(By.xpath(".//h4")).getText();
		
		productName = productName.toLowerCase();
		
		Assert.assertTrue(productName.contains(itemNeeded), "Product displayed is incorrect");
		
	
	}
	
	@AfterClass
	public void tearDown() {
		
		closeBrowser();
	}
	
	

}
