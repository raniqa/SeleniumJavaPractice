package chromeoptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserWindowOptionsPractice {

	public static void main(String[] args) {

		// Create ChromeOptions object
		ChromeOptions options = new ChromeOptions();

		// Launch Chrome in maximized mode
		options.addArguments("--start-maximized");

		// Launch Chrome in Incognito mode
		options.addArguments("--incognito");

		// Uncomment to run Chrome in Headless mode
		 options.addArguments("--headless=new");

		// Launch browser with ChromeOptions
		WebDriver driver = new ChromeDriver(options);

		// Open application
		driver.get("https://www.saucedemo.com/");

		// Print page title
		System.out.println("Page Title: " + driver.getTitle());

		// Close browser
		driver.quit();
	}
}