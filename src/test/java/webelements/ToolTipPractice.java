package webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import base.BaseClass;

public class ToolTipPractice extends BaseClass {

	public static void main(String[] args) {

		ToolTipPractice obj = new ToolTipPractice();

		// Launch browser and navigate to tooltip practice page
		obj.launchBrowser();
		obj.navigateTo("https://seleniumpractise.blogspot.com/2019/08/tooltip-in-selenium-or-help-text-example.html");

		// Locate the element which displays the tooltip
		WebElement tooltipElement = obj.driver.findElement(By.cssSelector("div.tooltip"));

		// Create Actions class object to perform mouse actions
		Actions actions = new Actions(obj.driver);

		// Move mouse pointer over the element to display tooltip
		actions.moveToElement(tooltipElement).perform();

		// Locate the tooltip text after hovering
		WebElement tooltipText = obj.driver.findElement(By.cssSelector("span.tooltiptext"));

		// Retrieve the text displayed in tooltip
		String infoText = tooltipText.getText();

		System.out.println("Text on tooltip: " + infoText);

		// Verify tooltip text using normal Java validation
		if (infoText.equals("Tooltip text")) {

			System.out.println("Tooltip text verification passed");

		} else {

			System.out.println("Tooltip text verification failed");
		}

		// Close browser
		obj.closeBrowser();
	}
}