package testng;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseClass;

public class DependsOnMethodsPractice extends BaseClass {

	@BeforeClass
	public void launchTheBrowser() {

		launchBrowser();
		navigateTo("https://www.saucedemo.com/");

	}

	@Test(priority = 0)
	public void validLogin() {

		WebElement username = driver.findElement(By.id("user-name"));
		username.clear();
		username.sendKeys("standard_user");

		WebElement password = driver.findElement(By.id("password"));
		password.clear();
		password.sendKeys("secret_sauce");

		driver.findElement(By.id("login-button")).click();
	}

	@Test(dependsOnMethods = { "validLogin" })
	public void addItemToCart() {
		
		String requiredProduct = "Sauce Labs Bike Light";

		List<WebElement> productCards = driver
				.findElements(By.xpath("//div[@class='inventory_list']//div[@class='inventory_item']"));

		for (WebElement card : productCards) {
			WebElement itemName = card.findElement(
					By.xpath(".//div[contains(@class,'item_description')]//div[@class='inventory_item_name ']"));

			if (itemName.getText().equals(requiredProduct)) {
				WebElement addToCartBtn = card.findElement(By.xpath(".//button[starts-with(@id,'add-to-cart')]"));
				addToCartBtn.click();

				// Locate the updated button again
				WebElement removeButton = card.findElement(By.tagName("button"));

				Assert.assertEquals(removeButton.getText(), "Remove", "Button text didn't change properly");
				
				break;

			}
		}
	}

	@Test(dependsOnMethods = { "addItemToCart" })
	public void verifyItemAdded() {
		WebElement itemcount = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']"));
		int count = Integer.parseInt(itemcount.getText());
		Assert.assertEquals(count, 1, "Number of items in the cart is incorrect");

	}

	@AfterClass
	public void tearDown() {

		closeBrowser();
	}

}
