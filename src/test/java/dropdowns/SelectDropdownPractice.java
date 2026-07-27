package dropdowns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import base.BaseClass;

public class SelectDropdownPractice extends BaseClass {

	public static void main(String[] args) {

		SelectDropdownPractice dropdown = new SelectDropdownPractice();

		// Launch browser and navigate to the application
		dropdown.launchBrowser();
		dropdown.navigateTo("https://rahulshettyacademy.com/dropdownsPractise/#search.aspx?mode=search");

		// Locate the Currency dropdown
		WebElement currencyDropdown = dropdown.driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

		// Create Select object
		Select currencySelect = new Select(currencyDropdown);

		// Get all available options
		List<WebElement> currencyOptions = currencySelect.getOptions();

		System.out.println("Total Currency Options: " + currencyOptions.size());

		// Print all available options
		for (WebElement option : currencyOptions) {
			System.out.println(option.getText());
		}

		// Select by Value
		currencySelect.selectByValue("AED");

		// Print selected option
		System.out.println("Selected Currency: " + currencySelect.getFirstSelectedOption().getText());

		// Close browser
		dropdown.closeBrowser();
	}
}