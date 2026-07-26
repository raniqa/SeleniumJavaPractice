package webelements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseClass;

public class RadioButtonPractice extends BaseClass {

	public static void main(String[] args) {

		RadioButtonPractice obj = new RadioButtonPractice();

		obj.launchBrowser();
		obj.navigateTo("https://rahulshettyacademy.com/AutomationPractice/");

		// Find all radio buttons
		List<WebElement> radioButtons = obj.driver.findElements(By.xpath("//input[@type='radio']"));

		System.out.println("Number of radio buttons present: " + radioButtons.size());

		// Verify radio buttons are displayed
		for (WebElement radioButton : radioButtons) {

			if (radioButton.isDisplayed()) {
				System.out.println("Radio button is displayed");
			} else {
				System.out.println("Radio button is not displayed");
			}
		}

		// Select Radio Button 2
		WebElement radio2 = obj.driver.findElement(By.xpath("//input[@value='radio2']"));

		if (!radio2.isSelected()) {

			radio2.click();
			System.out.println("Radio Button 2 selected");
		}

		// Select Radio Button 1
		WebElement radio1 = obj.driver.findElement(By.xpath("//input[@value='radio1']"));

		radio1.click();

		System.out.println("Radio Button 1 selected");

		// Verify Radio Button 2 is deselected
		if (!radio2.isSelected()) {

			System.out.println("Radio Button 2 is deselected successfully");

		} else {

			System.out.println("Radio Button 2 is still selected");
		}

		obj.closeBrowser();
	}
}