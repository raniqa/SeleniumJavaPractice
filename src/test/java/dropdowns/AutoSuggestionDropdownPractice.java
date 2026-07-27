package dropdowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;

public class AutoSuggestionDropdownPractice extends BaseClass {

	public static void main(String[] args) {

		AutoSuggestionDropdownPractice autoSuggestion = new AutoSuggestionDropdownPractice();

		// Launch browser and navigate to the application
		autoSuggestion.launchBrowser();
		autoSuggestion.navigateTo("https://rahulshettyacademy.com/dropdownsPractise/#search.aspx?mode=search");

		// Locate the Auto Suggestion Country field
		WebElement countryField = autoSuggestion.driver.findElement(By.id("autosuggest"));
		countryField.sendKeys("Be");

		// Wait for the country suggestions to appear
		WebDriverWait wait = new WebDriverWait(autoSuggestion.driver, Duration.ofSeconds(10));

		List<WebElement> countryOptions = wait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("li.ui-menu-item a")));

		// Select Belgium from the suggestions
		for (WebElement country : countryOptions) {

			if (country.getText().equalsIgnoreCase("Belgium")) {
				country.click();
				break;
			}
		}
		
		// Close the browser
		autoSuggestion.closeBrowser();
	}
}