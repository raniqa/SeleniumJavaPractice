package base;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ParametersBaseClass {

	protected WebDriver driver;

	public void launchBrowser(String browser) {

		switch (browser.toLowerCase()) {
		
		case "chrome":
			ChromeOptions options = new ChromeOptions();

			Map<String, Object> prefs = new HashMap<>();

			// Disable Chrome password manager
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);

			options.setExperimentalOption("prefs", prefs);

			driver = new ChromeDriver(options);

			break;

		case "firefox":
			driver = new FirefoxDriver();

			break;

		case "edge":
			driver = new EdgeDriver();

			break;

		default:
			System.out.println("Unsupported browser");

			return;

		}

		driver.manage().window().maximize();
	}

	public void navigateTo(String url) {

		driver.get(url);
	}

	public void closeBrowser() {

		if (driver != null) {
			driver.quit();
		}
	}

}
