package dropdowns;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;

public class DynamicDropdownPractice extends BaseClass {

	public static void main(String[] args) {

		DynamicDropdownPractice dynamicDropdown = new DynamicDropdownPractice();

		// Launch browser and navigate to the application
		dynamicDropdown.launchBrowser();
		dynamicDropdown.navigateTo("https://rahulshettyacademy.com/dropdownsPractise/#search.aspx?mode=search");

		WebDriverWait wait = new WebDriverWait(dynamicDropdown.driver, Duration.ofSeconds(10));

		// Open the Departure City dropdown
		WebElement departureDropdown = dynamicDropdown.driver
				.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));
		departureDropdown.click();

		// Select Departure City
		WebElement departureCity = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//a[text()=' Chennai (MAA)']")));
		departureCity.click();

		// Select Arrival City
		WebElement arrivalCity = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//a[text()=' Hyderabad (HYD)'])[2]")));
		arrivalCity.click();

		// Close browser
		dynamicDropdown.closeBrowser();
	}
}