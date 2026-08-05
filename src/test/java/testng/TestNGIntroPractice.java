package testng;

import org.testng.annotations.Test;

import base.BaseClass;

public class TestNGIntroPractice extends BaseClass {

	@Test
	public void launchAmazon() {

		launchBrowser();

		navigateTo("https://www.amazon.in");

		System.out.println("Title of the Page: " + driver.getTitle());

		closeBrowser();
	}
}