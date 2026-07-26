package webelements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseClass;

public class LinksPractice extends BaseClass {

	public static void main(String[] args) {

		LinksPractice obj = new LinksPractice();

		obj.launchBrowser();
		obj.navigateTo("https://www.tutorialspoint.com/selenium/practice/links.php");

		// Identifying the links on the page
		List<WebElement> links = obj.driver.findElements(By.tagName("a"));

		// Finding the number of links on the page
		System.out.println("Number of links on the webpage: " + links.size());

		// Finding the href attribute
		for (WebElement link : links) {
			System.out.println("URL: " + link.getAttribute("href"));
			System.out.println("-------------------------");
		}

		obj.closeBrowser();

	}

}
