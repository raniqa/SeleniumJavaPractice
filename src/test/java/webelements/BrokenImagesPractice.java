package webelements;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseClass;

public class BrokenImagesPractice extends BaseClass {

	public static void main(String[] args) {

		BrokenImagesPractice obj = new BrokenImagesPractice();

		int brokenImageCount = 0;

		obj.launchBrowser();
		obj.navigateTo("https://the-internet.herokuapp.com/broken_images");

		// Locate all image elements on the webpage
		List<WebElement> imageList = obj.driver.findElements(By.tagName("img"));

		System.out.println("Number of images on the page: " + imageList.size());

		// Iterate through each image and verify whether it is broken
		for (WebElement image : imageList) {

			// Retrieve image URL from src attribute
			String imageUrl = image.getAttribute("src");

			// Proceed only if image URL is available
			if (imageUrl != null && !imageUrl.isEmpty()) {

				try {

					// Open HTTP connection to image URL
					URL imgUrl = new URL(imageUrl);

					HttpURLConnection connection = (HttpURLConnection) imgUrl.openConnection();

					// Send HEAD request
					connection.setRequestMethod("HEAD");

					connection.connect();

					// Get response code
					int responseCode = connection.getResponseCode();

					if (responseCode >= 400) {

						System.out.println(imageUrl + " --> Broken Image");

						brokenImageCount++;

					} else {

						System.out.println(imageUrl + " --> Valid Image");
					}

					connection.disconnect();

				} catch (Exception e) {

					System.out.println("Unable to verify image: " + imageUrl);
					e.printStackTrace();
				}
			}
		}

		// Display total broken images
		System.out.println("Number of broken images: " + brokenImageCount);

		obj.closeBrowser();
	}
}