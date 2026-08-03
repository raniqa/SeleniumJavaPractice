package chromeoptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RemoveAutomationMessagePractice {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();

		// Remove "Chrome is being controlled by automated test software"
		options.setExperimentalOption("excludeSwitches",
				new String[] {"enable-automation"});

		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.get("https://www.google.com");

		System.out.println(driver.getTitle());

		driver.quit();
	}
}