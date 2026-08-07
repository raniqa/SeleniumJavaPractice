package testng;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;

public class DataProviderSearchProductPractice extends BaseClass {

	WebDriverWait wait;

	@BeforeClass
	public void setUp() {
		launchBrowser();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Open the application before every DataProvider iteration
	@BeforeMethod
	public void launchWebsite() {

		navigateTo("https://automationexercise.com/");
	}

	// Data-driven test method
	@Test(dataProvider = "searchitemlist")
	public void searchProduct(String item, boolean expectedFound) {

		WebElement productLink = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/products']")));
		productLink.click();

		// Handling the google-vignette
		if (driver.getCurrentUrl().contains("google_vignette")) {
			driver.navigate().to("https://automationexercise.com/products");
		}

		wait.until(ExpectedConditions.urlContains("/products"));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0, 500);");

		WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_product")));

		searchBox.clear();
		searchBox.sendKeys(item);

		WebElement searchBtn = driver.findElement(By.id("submit_search"));

		searchBtn.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Searched Products']")));

		boolean productFound = !driver
				.findElements(By.xpath("//div[@class='features_items']//div[@class='single-products']")).isEmpty();

		Assert.assertEquals(productFound, expectedFound);

	}

	@AfterClass
	public void tearDown() {
		closeBrowser();

	}

	// Test data for DataProvider
	@DataProvider(name = "searchitemlist")

	public Object[][] searchData() {

		Object[][] productList = { { "shirt", true }, { "jeans", true }, { "skirt", false }

		};
		return productList;
	}

}
