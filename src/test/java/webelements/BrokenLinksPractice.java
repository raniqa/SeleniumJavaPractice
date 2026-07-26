package webelements;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseClass;

public class BrokenLinksPractice extends BaseClass {

	public static void main(String[] args) {

		BrokenLinksPractice obj = new BrokenLinksPractice();

		obj.launchBrowser();
		obj.navigateTo("https://practice-automation.com/broken-links/");

		// Identify all links on the webpage
		List<WebElement> links = obj.driver.findElements(By.tagName("a"));

		System.out.println("Number of links on the page: " + links.size());

		// Verify each link
		for (WebElement link : links) {

			String hrefValue = link.getAttribute("href");

			// Ignore links which cannot be verified
			if (hrefValue == null || hrefValue.isEmpty() || hrefValue.startsWith("mailto")
					|| hrefValue.startsWith("javascript")) {

				System.out.println("This link cannot be verified: " + hrefValue);
				continue;
			}

			try {

				URL websiteUrl = new URL(hrefValue);

				HttpURLConnection connection = (HttpURLConnection) websiteUrl.openConnection();

				connection.setRequestMethod("HEAD");
				connection.connect();

				int responseCode = connection.getResponseCode();

				if (responseCode >= 400) {

					System.out.println(hrefValue + " --> Broken link");
					System.out.println("Response Code: " + responseCode);

				} else if (responseCode >= 300) {

					System.out.println(hrefValue + " --> Redirected link");
					System.out.println("Response Code: " + responseCode);

				} else {

					System.out.println(hrefValue + " --> Valid link");
					System.out.println("Response Code: " + responseCode);
				}

				connection.disconnect();

			} catch (Exception e) {

				System.out.println("Unable to validate link: " + hrefValue);
				System.out.println(e.getMessage());
			}
		}

		obj.closeBrowser();
	}
}