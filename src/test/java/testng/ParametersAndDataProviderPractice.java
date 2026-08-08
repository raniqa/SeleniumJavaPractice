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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.ParametersBaseClass;

public class ParametersAndDataProviderPractice extends ParametersBaseClass {

	WebDriverWait wait;

	@BeforeClass
	@Parameters("browser")
	public void setUp(String br) {

		launchBrowser(br);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@BeforeMethod
	@Parameters("url")
	public void navigateToPage(String url) {

		navigateTo(url);

	}

	@Test(dataProvider = "dp")
	public void login(String username, String password, boolean expectedStatus) throws InterruptedException {

		WebElement loginLink = driver.findElement(By.xpath("//a[normalize-space()='Log in']"));
		loginLink.click();

		WebElement userNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Email")));
		userNameField.sendKeys(username);

		WebElement passwordField = driver.findElement(By.id("Password"));
		passwordField.sendKeys(password);

		driver.findElement(By.xpath("//input[@value='Log in']")).click();

		List<WebElement> logoutLink = driver.findElements(By.xpath("//a[@class='ico-logout']"));
		boolean actualStatus = !logoutLink.isEmpty();

		Assert.assertEquals(actualStatus, expectedStatus, "Login result did not match expected result for user");

		if (actualStatus) {

			logoutLink.get(0).click();
		}

	}

	@AfterClass
	public void tearDown() {
		closeBrowser();
	}

	@DataProvider(name = "dp")
	public Object[][] loginData() {

		Object[][] data = { { "ranii@gmail.com", "Rani@123#", true }, { "ran@gmail.com", "Rani3#", false },
				{ "", "", false }, { "", "Rani@123#", false } };
		return data;
	}
}