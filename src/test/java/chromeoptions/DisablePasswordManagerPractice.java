package chromeoptions;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DisablePasswordManagerPractice {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();

		Map<String, Object> prefs = new HashMap<>();

		// Disable password saving popup
		prefs.put("credentials_enable_service", false);

		// Disable Chrome password manager
		prefs.put("profile.password_manager_enabled", false);

		options.setExperimentalOption("prefs", prefs);

		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.get("https://www.saucedemo.com/");

		System.out.println("Title: " + driver.getTitle());

		driver.quit();
	}
}