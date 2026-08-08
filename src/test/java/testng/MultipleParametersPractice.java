package testng;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.ParametersBaseClass;

public class MultipleParametersPractice extends ParametersBaseClass {

	WebDriverWait wait;

	@BeforeClass
	@Parameters({ "browser", "url" })
	public void setup(String browser, String url) {

		launchBrowser(browser);
		navigateTo(url);

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@Test(priority = 0)
	@Parameters({ "username", "password" })
	public void login(String name, String pswrd) {

		WebElement userNameField = driver.findElement(By.id("user-name"));
		userNameField.sendKeys(name);

		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys(pswrd);

		driver.findElement(By.id("login-button")).click();

		Assert.assertTrue(wait.until(ExpectedConditions.urlContains("inventory")));

	}

	@Test(dependsOnMethods = "login")
	@Parameters("product")
	public void searchItem(String item) {

		List<WebElement> listedItems = driver.findElements(By.xpath("//div[@class='inventory_list']/div"));

		boolean productFound = false;

		for (WebElement listedItem : listedItems) {
			String itemName = listedItem.findElement(By.xpath(".//div[@class='inventory_item_name ']")).getText();

			if (itemName.equals(item)) {

				productFound = true;

				WebElement addToCartBtn = driver.findElement(By.xpath(".//button[text()='Add to cart']"));
				addToCartBtn.click();

				break;

			}
		}

		Assert.assertTrue(productFound, "Item not listed");

		WebElement cartBadge = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='shopping_cart_container']")));

		Assert.assertEquals(cartBadge.getText(), "1", "Product was not added to the cart");

	}

	@AfterClass
	public void tearDown() {

		closeBrowser();

	}
}
