package windowhandling;

import base.BaseClass;

public class SingleWindowPractice extends BaseClass {

	public static void main(String[] args) {

		SingleWindowPractice window = new SingleWindowPractice();

		window.launchBrowser();
		window.navigateTo("https://www.saucedemo.com/");

		// Get the current window handle
		String windowHandle = window.driver.getWindowHandle();

		//windowHandle is unique ID of the currently opened window 
		System.out.println("Current Window Handle:");
		System.out.println(windowHandle);

		System.out.println("Page Title: " + window.driver.getTitle());
		System.out.println("Current URL: " + window.driver.getCurrentUrl());

		window.closeBrowser();
	}
}