package dropdowns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import base.BaseClass;

public class MultiSelectDropdownPractice extends BaseClass {

	public static void main(String[] args) {

		MultiSelectDropdownPractice multiSelect = new MultiSelectDropdownPractice();

		// Launch browser and navigate to the application
		multiSelect.launchBrowser();
		multiSelect.navigateTo("https://vinothqaacademy.com/drop-down/");

		// Locate the Programming Languages multi-select dropdown
		WebElement programmingDropdown = multiSelect.driver.findElement(By.name("programming"));

		// Create Select object
		Select programmingSelect = new Select(programmingDropdown);

		// Verify whether the dropdown supports multiple selections
		if (programmingSelect.isMultiple()) {
			System.out.println("The dropdown supports multiple selections.");
		} else {
			System.out.println("The dropdown does not support multiple selections.");
			multiSelect.closeBrowser();
			return;
		}

		// Select multiple programming languages
		programmingSelect.selectByValue("PYTHON");
		programmingSelect.selectByVisibleText("JavaScript");
		programmingSelect.selectByIndex(5);

		// Get all selected options
		List<WebElement> selectedLanguages = programmingSelect.getAllSelectedOptions();

		System.out.println("Selected Programming Languages:");

		for (WebElement language : selectedLanguages) {
			System.out.println(language.getText());
		}

		// Close browser
		multiSelect.closeBrowser();
	}
}